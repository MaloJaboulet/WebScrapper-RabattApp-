package com.example.WebScrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.checkerframework.checker.units.qual.C;

import java.io.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    private String filePath = "";
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(0%3==0);
        String temp = "[Industriestrasse 22=Cazis 7408]\n" +
                "[Pass. rue de Romont 23=Fribourg 1700, Steinbockstrasse 8=Chur 7000, Bahnhofstrasse 50=Buchs SG 9470, Rue Saint Honoré 7-9=Neuchâtel 2000, Rue de l'Ale 31=Lausanne 1003, Shoppi Tivoli=Spreitenbach 8957, Rue du Lac 6=Yverdon-les-Bains 1400, Stalden 8=Solothurn 4500, Marktgasse 2-4=Winterthur 8400, Industriestrasse 10=Schönbühl Einkaufszentrum 3321, Mall of Switzerland=Ebikon 6030, Kasinostrasse 33-37=Aarau 5000, Rue de la Molière 22=Delémont 2800, Gerbergasse 12=Basel 4001, Multergasse 1-3=St. Gallen 9000, Av. Paul-Cérésole 7-9=Vevey 1800, Marktgasse 17=Biel/Bienne 2502, Marktgasse 59=Bern 3011, Bronschhoferstrasse 2a=Wil SG 9500, Rue de Lausanne 29=Sion 1950, Avenue Léopold-Robert 19=La Chaux-de-Fonds 2300, Im Bälliz 62=Thun 3600]\n" +
                "[Online=Online]\n" +
                "[Online=Online]\n" +
                "[Online=Online]\n" +
                "[Online=Online]\n" +
                "[Monbijoustrasse 14=Bern 3011, Pfistergasse 23=Luzern 6003, Josefstrasse 59=Zürich 8005, Kesselhof; Zürcherstrasse 7=Winterthur 8400, Kletterhalle 6a plus Klosterstrasse 17=Winterthur 8406, Aarbergergasse 21=Bern 3011, Bahnhofstrasse 10=St. Gallen 9000, Lagerstrasse 4=Zürich 8004, Aeschengraben 9 und 13=Basel 4051]\n" +
                "[Online=Online]\n" +
                "[Online=Online]\n" +
                "[Online=Online]";

        String temp1 = "[Monbijoustrasse 14=Bern 3011, Pfistergasse 23=Luzern 6003, Josefstrasse 59=Zürich 8005, Kesselhof; Zürcherstrasse 7=Winterthur 8400, Kletterhalle 6a plus Klosterstrasse 17=Winterthur 8406, Aarbergergasse 21=Bern 3011, Bahnhofstrasse 10=St. Gallen 9000, Lagerstrasse 4=Zürich 8004, Aeschengraben 9 und 13=Basel 4051]";

        temp1 = temp1.substring(1);
        temp1 = temp1.substring(0,temp1.indexOf("]"));


        String[] adressenArr = temp1.split(",");

        for (Object adresse:adressenArr) {
            String adresse1 = adresse.toString().substring(0,adresse.toString().indexOf("="));
            String adresse2 = adresse.toString().substring(adresse.toString().indexOf("=")+1);
            System.out.println(adresse1 + " "+ adresse2);
        }

        Geocoder geocoder = new Geocoder();
        try {
            String response = geocoder.GeocodeSync("Bahnhofstrasse 28, Sins 5643");
            System.out.println(geocoder.getCoordinates(response));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //saveJSON();
        /*try {
            byte[] jsonDeals = Files.readAllBytes(Paths.get("testDataSmall.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Deal[] deals = objectMapper.readValue(jsonDeals, Deal[].class);

            //System.out.println(Arrays.toString(deals));
            String testString = "[10%,20%]";
            testString = testString.substring(1);
            testString = testString.substring(0,testString.indexOf("]"));

            String[] arr = testString.split(",");
            System.out.println(Arrays.toString(arr));

            Vector<Deal> dealsVec = new Vector<>();
            dealsVec.addAll(Arrays.asList(deals));

            //System.out.println(dealsVec.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /*Vector<String> testVec = new Vector<>();
        testVec.add("10%");
        testVec.add("20%");

        String[] stringArr = testVec.toArray(new String[testVec.size()]);

        Vector<String> vec2 = new Vector<>();

        Collections.addAll(vec2,stringArr);
        System.out.println(vec2.toString());*/


        /*HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("bla","bla1234567");
        hashMap.put("bla2","bla209");

        Object[] map = hashMap.entrySet().toArray();
        System.out.println(Arrays.toString(map));

        HashMap<String,String> hashMap1 = new HashMap<>();
        for (Object deal:map) {
            String adresse1 = deal.toString().substring(0,deal.toString().indexOf("="));
            String adresse2 = deal.toString().substring(deal.toString().indexOf("=")+1);
            hashMap1.put(adresse1,adresse2);
        }
        System.out.println(hashMap1);*/


        /*test.filePath = "LogoDrivingGraubuenden2.png";
        try {
            test.createImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            // Use this to Read a Local Path
            // String svgUriImputLocation = Paths.get("https://www.contradodigital.com/logo.svg").toUri().toURL().toString();
            // Read Remote Location for SVG
            String svgUriImputLocation = "https://www.stucard.ch/data/img/big/191104_Logo_FcSG1879-SVG-5639.svg";
            TranscoderInput transcoderInput = new TranscoderInput(svgUriImputLocation);

            // Define OutputStream Location
            OutputStream outputStream = new FileOutputStream("LogoDrivingGraubuenden2.png");
            TranscoderOutput transcoderOutput = new TranscoderOutput(outputStream);

            // Convert SVG to PNG and Save to File System
            PNGTranscoder pngTranscoder = new PNGTranscoder();
            pngTranscoder.transcode(transcoderInput, transcoderOutput);

            // Clean Up
            outputStream.flush();
            outputStream.close();

        } catch (IOException | TranscoderException ex) {
            System.out.println("Exception Thrown: " + ex);
        }*/
    }

    public void createImage() throws Exception{
        String svg_URI_input = new File("./src/main/java/com/example/Webscrapper/LogoDrivingGraubuenden.svg").toURL().toString();
        TranscoderInput input_svg_image = new TranscoderInput(svg_URI_input);
        //Step-2: Define OutputStream to PNG Image and attach to TranscoderOutput
        OutputStream png_ostream = new FileOutputStream(filePath);
        TranscoderOutput output_png_image = new TranscoderOutput(png_ostream);
        // Step-3: Create PNGTranscoder and define hints if required
        PNGTranscoder my_converter = new PNGTranscoder();
        // Step-4: Convert and Write output
        System.out.println("It will print");
        my_converter.transcode(input_svg_image, output_png_image);
        System.out.println("It will not print");
        png_ostream.flush();
        png_ostream.close();
    }

    public static String saveJSON() {
        try {
            File file = new File("./Files/testData.txt");

            Scanner scanner = new Scanner(file).useDelimiter(";");
            Vector<Deal> deals = new Vector<>();
            for (int i = 0; i < 2; i++) {

                String name = scanner.next();
                String beschreibung = scanner.next();
                String rabatt = scanner.next();
                String addresse = scanner.next();
                HashMap<String, String> addressen = new HashMap<>();
                addresse = addresse.substring(addresse.indexOf("[") + 1, addresse.indexOf("]"));



                addresse = addresse.trim();
                String array[] = addresse.split(",");


                String url = scanner.next();
                String imageEncoded = scanner.next();

                //Deal deal = new Deal(name, beschreibung, rabatt, addresse, addressen, url, imageEncoded);
                // deals.add(deal);

                String testArr[] = {"Ryffligässchen 13", "3011 Bern", "Pfluggässlein 1", "4001 Basel", "Löwengraben 15", "6004 Luzern", "Preyergasse 6", "8001 Zürich", "Schmiedgasse 16", "9000 St. Gallen"};

                for (int j = 0; j < testArr.length; j=j+2) {
                    System.out.println(testArr[j]+" "+testArr[j+1]);
                }
                System.out.println("-------------------------------------------------");
            }

            //String jsonInputString = new ObjectMapper().writeValueAsString(map.entrySet().toArray());



            /*try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }*/
            System.out.println("Daten wurden exportiert");
            return "";
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }
}
