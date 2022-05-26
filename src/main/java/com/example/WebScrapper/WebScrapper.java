package com.example.WebScrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdurmont.emoji.EmojiParser;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.batik.transcoder.*;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.*;

import java.net.URL;
import java.util.*;


public class WebScrapper {

    public static void main(String[] args) throws TranscoderException, IOException, InterruptedException {
        WebScrapper webScrapper = new WebScrapper();
        webScrapper.getStucardDeals();
        webScrapper.getCashYouDeals();
    }

    public void getCashYouDeals() throws IOException, InterruptedException {
        HttpResponse<String> response = Unirest.get("https://fly.cashyou.ch/api/v2/partners/nearby")
                .header("Accept-Language", "de")
                .asString();
        String responseJSON = response.getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        CashyouResponse cashyouResponse = mapper.readValue(responseJSON, CashyouResponse.class);


        int[] dealIds = cashyouResponse.getIds();
        Vector<Deal> deals = new Vector<>();
        for (int i = 0; i < dealIds.length; i++) {
            HttpResponse<String> responseDeal = Unirest.get("https://api.cashyou.ch/api/v1/partners/" + dealIds[i])
                    .header("Accept-Language", "de")
                    .asString();
            String responseJSONDeal = responseDeal.getBody().toString();

            CashyouResponse2 cashyouResponse2 = mapper.readValue(responseJSONDeal, CashyouResponse2.class);

            //System.out.println(dealIds[i]);
            Deal deal = new Deal();

            String beschreibung = cashyouResponse2.getAbout_us();
            beschreibung = EmojiParser.removeAllEmojis(beschreibung);
            deal.setBeschreibung(beschreibung);
            deal.setCategory(cashyouResponse2.getCategory().getName());
            deal.setCity(cashyouResponse2.getCity_name());

            //Adressen holen
            if (cashyouResponse2.getStreet().equals("")) {
                Vector<Double> lat_lng = new Vector<>();
                lat_lng.add(0.0);
                deal.setLat(lat_lng);
                deal.setLon(lat_lng);
                HashMap<String, String> map = new HashMap<>();
                map.put("online", "online");
                deal.setAddressen(map);

            } else {
                Vector<Double> lat_lng = new Vector<>();
                lat_lng.add((double) cashyouResponse2.getLatitude());
                deal.setLat(lat_lng);
                lat_lng = new Vector<>();
                lat_lng.add((double) cashyouResponse2.getLongitude());
                deal.setLon(lat_lng);

                HashMap<String, String> map = new HashMap<>();
                if (cashyouResponse2.getStreet() != null && cashyouResponse2.getStreet_number() != null && cashyouResponse2.getCity_name()!= null) {
                    String adresse = cashyouResponse2.getStreet() + " " + cashyouResponse2.getStreet_number();
                    adresse = adresse.replaceAll(","," ");
                    map.put(adresse, cashyouResponse2.getCity_name());

                }else {
                    map.put("Musterstrasse 10", "Musterdorf");
                }
                deal.setAddressen(map);
            }

            //Name anpassen
            String name = cashyouResponse2.getName();
            if (!deal.getAddressen().containsKey("online") && cashyouResponse2.getCity_name() != null) {
                if (name.contains("-") || name.contains("|")) {
                    int index = 0;
                    if (name.contains("-")) {
                        index = name.indexOf("-");
                    } else {
                        index = name.indexOf("|");
                    }
                    String temp = name.substring(index).toLowerCase(Locale.ROOT);
                    if (temp.contains("strasse") || temp.contains("str") || temp.contains("hof") || temp.contains("platz") || temp.contains("gasse")
                            || temp.contains("brücke") || temp.contains("park") || temp.contains("dorf")
                            || temp.contains(cashyouResponse2.getCity_name()) || temp.contains("st.") || temp.contains("wil")) {
                        name = name.substring(0, index - 1);
                        name = name.trim();
                    }
                }
            }

            deal.setName(name);

            //Rabatte holen
            Vector<String> rabatte = new Vector<>();
            for (int j = 0; j < cashyouResponse2.getPromotional_offers_count(); j++) {
                Promotional_offers promotional_offer = cashyouResponse2.getPromotional_offers().get(j);
                rabatte.add(promotional_offer.getDiscount_label());
            }
            deal.setRabatt(rabatte);
            deal.setUrl(cashyouResponse2.getLogo());
            deal.setAppName("cashyou");

            deals.add(deal);

        }

        for (int i = 0; i < deals.size(); i++) {
            Deal deal = deals.get(i);

            for (Iterator<Deal> iterator = deals.iterator(); iterator.hasNext();) {
                Deal deal2 = iterator.next();

                if (deal.equals(deal2)) {
                    continue;
                }
                if (deal.getBeschreibung().contains(deal2.getBeschreibung())) {
                    if (!deal.getAddressen().containsKey("online") && deal.getName().contains(deal.getCity())) {
                        deal.setName(deal.getName().replace(deal.getCity(), "").trim());
                    }
                    Vector<Double> tempVec = new Vector<>();
                    tempVec = deal.getLat();
                    tempVec.addAll(deal2.getLat());
                    deal.setLat(tempVec);

                    Vector<Double> tempVec2 = new Vector<>();
                    tempVec2 = deal.getLon();
                    tempVec2.addAll(deal2.getLon());
                    deal.setLon(tempVec2);


                    HashMap<String, String> tempMap = new HashMap<>();
                    tempMap.putAll(deal.getAddressen());
                    tempMap.putAll(deal2.getAddressen());
                    deal.setAddressen(tempMap);
                    tempMap = null;

                    iterator.remove();
                }
            }
        }

        System.out.println("Send Deals");
        int index = 0;
        for (Deal deal:deals) {
            if (deal.getRabatt().size()<1){
                continue;
            }
            sendRequest(deal);
            index++;

            System.out.println(index);
            System.out.println(deal.getName());
            System.out.println(deal.getBeschreibung());
            System.out.println(Arrays.toString(deal.getAddressen().entrySet().toArray()));
            System.out.println(Arrays.toString(deal.getLat().toArray()));
            System.out.println(Arrays.toString(deal.getLon().toArray()));
            System.out.println(deal.getUrl());
            System.out.println(deal.getAppName());
            System.out.println(deal.getCategory());
            System.out.println(Arrays.toString(deal.getRabatt().toArray()));
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }


    }

    public void getStucardDeals() throws IOException, InterruptedException, TranscoderException {


        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        Document doc = Jsoup.connect("https://www.stucard.ch/de/rabatte/").get();
        System.out.println(doc.title());
        Elements newsHeadlines = doc.getElementsByClass("displayDealBlock overview");
        System.out.println(newsHeadlines.size());

        int zaehler = 0;
        String rabattNameUrl[] = {"online", "nightlife", "winter", "shopping", "food", "outdoor", "lifestyle"};


        File storeFile = new File("storeFile.txt");
        FileWriter fileWriter = new FileWriter(storeFile);
        WebDriver driver = new ChromeDriver();
        Vector<Deal> deals = new Vector<>();
        Vector<String> vecNames = new Vector<>();


        for (String rabattNameLink : rabattNameUrl) {

            driver.get("https://www.stucard.ch/de/rabatte/" + rabattNameLink);

            List<WebElement> links = driver.findElements(By.className("dealBlockTease"));
            String url = "https://www.stucard.ch";
            Vector<String> dataUrl = new Vector<>();
            Vector<String> imageUrls = new Vector<>();


            for (WebElement data : links) {
                dataUrl.add(data.getAttribute("data-url"));
                imageUrls.add(data.findElement(By.tagName("img")).getAttribute("src"));
            }

            for (int i = 0; i < dataUrl.size(); i++) {


                String destinationTo = dataUrl.get(i);
                driver.navigate().to(url + destinationTo);

                String name = "";
                String beschreibung = "";
                Vector<String> rabatt = new Vector<>();
                String imageUrl = "";
                Vector<String> adressen = new Vector<>();
                List<WebElement> tdList;
                List<WebElement> rabatte;
                try {
                    name = driver.findElement(By.tagName("h1")).getText();

                    beschreibung = driver.findElement(By.className("partnerBeschreibung")).getText();
                    rabatte = driver.findElements(By.className("dealWert"));
                    for (WebElement rabattWert : rabatte) {
                        rabatt.add(rabattWert.getText());
                    }
                    imageUrl = imageUrls.get(i);


                    tdList = driver.findElements(By.className("left"));
                } catch (Exception e) {
                    continue;
                }


                if (name.equals("Paragliding Lake Lucerne") || vecNames.contains(name)) {
                    System.out.println("skipped");
                    continue;
                } else {
                    vecNames.add(name);
                }
                zaehler++;

                int index = 0;
                for (WebElement td : tdList) {

                    String adresse = td.getAttribute("innerHTML");
                    adresse = adresse.replaceAll("&amp;", "&");
                    adresse = adresse.replaceAll(",", ";");

                    if (index % 3 != 0 && tdList.size() > 2) {
                        adressen.add(adresse);
                    }
                    index++;
                }


                HashMap<String, String> adressenHashmap = new HashMap<>();
                Vector<Double> latVec = new Vector<>();
                Vector<Double> lonVec = new Vector<>();
                Geocoder geocoder = new Geocoder();
                if (adressen.size() > 0) {

                    for (int j = 0; j < adressen.size(); j = j + 2) {
                        String[] temp = adressen.get(j + 1).split("(?<=[0-9])(?= )");
                        if (temp[1].trim().contains("Einkaufszentrum")) {
                            temp[1] = temp[1].substring(temp[1].indexOf("S"), temp[1].indexOf("E") - 1);
                        }

                        String kanton = temp[1].trim() + " " + temp[0].trim();
                        String adresse = adressen.get(j);

                        if (adresse.trim().contains("Einkaufszenter")) {
                            adresse = adresse.substring(adresse.indexOf("L"));
                        }

                        String response = geocoder.GeocodeSync(adresse + ", " + kanton);
                        Vector<Double> resultat = geocoder.getCoordinates(response);

                        try {
                            latVec.add(resultat.get(0));
                            lonVec.add(resultat.get(1));
                        } catch (Exception e) {
                            System.out.println(resultat.toArray().toString());
                        }
                        if (adressenHashmap.containsKey(adressen.get(j))) {
                            adressenHashmap.put(adressen.get(j) + " ", kanton);
                        } else {
                            adressenHashmap.put(adressen.get(j), kanton);
                        }
                    }
                } else {
                    adressenHashmap.put("Online", "Online");
                    latVec.add(0.0);
                    lonVec.add(0.0);
                }

                name = name.replaceAll("[<,>,:,\",/,\\,|,?,*,.]*", "");
                File file = new File(name);

                FileUtils.copyURLToFile(new URL(imageUrl), file);


                byte[] fileContent = FileUtils.readFileToByteArray(file);
                String encodedString = Base64.getEncoder().encodeToString(fileContent);

                file.delete();


                driver.navigate().back();

                fileWriter.write(name + ";" + beschreibung + ";" + rabatt + ";" + adressenHashmap + ";" + encodedString + ";" + rabattNameLink + ";" + "stucard" + "\n");

                Deal deal = new Deal(name, beschreibung, rabatt, adressenHashmap, imageUrl, rabattNameLink, "stucard", latVec, lonVec);

                deals.add(deal);


                sendRequest(deal);
            }

        }

        String jsonInputString = new ObjectMapper().writeValueAsString(deals.toArray());

        FileWriter myWriter = new FileWriter("testData.json");
        myWriter.write(jsonInputString);
        myWriter.close();

        driver.quit();

        fileWriter.close();

        System.out.println(zaehler);
    }

    public static void sendRequest(Deal deal) {
        HttpResponse<String> response = Unirest.post("https://api.cojabou.com/RabattApi/data/rabatt/save")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("name", deal.getName())
                .field("beschreibung", deal.getBeschreibung())
                .field("rabatte", Arrays.toString(deal.getRabatt().toArray()))
                .field("adressen", Arrays.toString(deal.getAddressen().entrySet().toArray()))
                .field("url", deal.getUrl())
                .field("kategorie", deal.getCategory())
                .field("neuerDeal", "false")
                .field("appName", deal.getAppName())
                .field("lat", Arrays.toString(deal.getLat().toArray()))
                .field("lng", Arrays.toString(deal.getLon().toArray()))
                .asString();

        System.out.println(Arrays.toString(deal.getLat().toArray()));
        System.out.println(Arrays.toString(deal.getLon().toArray()));


        System.out.println("Send");
    }

        /*public static void convertSvg2Png(File svg, File png) throws IOException, TranscoderException {

        InputStream in = new FileInputStream(svg);
        OutputStream out = new FileOutputStream(png);
        out = new BufferedOutputStream(out);

        Transcoder transcoder = new PNGTranscoder();
        try {
            TranscoderInput input = new TranscoderInput(in);
            try {
                TranscoderOutput output = new TranscoderOutput(out);
                transcoder.transcode(input, output);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }*/
}
