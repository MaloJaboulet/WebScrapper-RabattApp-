package com.example.WebScrapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Geocoder {

    private static final String GEOCODING_RESOURCE = "https://geocode.search.hereapi.com/v1/geocode";
    private static final String API_KEY = "NjKRXuQrSryIkFenIgbR8iDesrfr4CI-5w-8mMcmnK0";

    public String GeocodeSync(String query) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        String requestUri = GEOCODING_RESOURCE + "?apiKey=" + API_KEY + "&q=" + encodedQuery;

        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return geocodingResponse.body().toString();
    }

    public Vector<Double> getCoordinates(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJsonNode = mapper.readTree(response);

        JsonNode items = responseJsonNode.get("items");
        Vector<Double> result = new Vector<>();

        for (JsonNode item : items) {
            JsonNode address = item.get("address");
            String label = address.get("label").asText();
            JsonNode position = item.get("position");

            String lat = position.get("lat").asText();
            String lng = position.get("lng").asText();
            System.out.println(label + " is located at " + lat + "," + lng + ".");
            result.add(0, Double.valueOf(lat));
            result.add(1, Double.valueOf(lng));

        }
        return result;
    }

   /* public String addresses(double lat, double lng) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();


        String url = "https://reverse.geocoder.ls.hereapi.com/6.2/reversegeocode.json?prox=";
        String requestUri = url + lat + "," + lng + ",500&mode=retrieveAddresses&maxresults=1&gen=9&&apiKey=" + API_KEY;

        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return geocodingResponse.body().toString();
    }

    public HashMap<String,String> getAddresses(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJsonNode = mapper.readTree(response);


        HashMap<String,String> result = new HashMap<>();

        try {
            JsonNode response2 = responseJsonNode.get("Response");
            JsonNode view = response2.get("View");
            for (JsonNode node : view) {
                JsonNode resultJ = node.get("Result");
                for (JsonNode node2 : resultJ) {
                    JsonNode location = node2.get("Location");
                    JsonNode address = location.get("Address");
                    String street = address.get("Street").asText();
                    String number = address.get("HouseNumber").asText();
                    String county = address.get("County").asText();

                    System.out.println(street + " " + number + ", " + county);
                    result.put(street + " " + number, county);
                }
            }
        }catch (NullPointerException nullPointerException){
            result.put("unknown","unknown");
        }
        return result;
    }*/

}

