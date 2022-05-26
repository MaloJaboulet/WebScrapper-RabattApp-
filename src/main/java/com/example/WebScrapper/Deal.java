package com.example.WebScrapper;

import java.util.HashMap;
import java.util.Vector;

public class Deal {
    private String name;
    private String beschreibung;
    private Vector<String> rabatt;
    private HashMap<String, String> addressen;

    private String url;
    private String imageEncoded;
    private String category;
    private boolean newDeal;
    private String appName;
    private Vector<Double> lat;
    private Vector<Double> lon;
    private String city;

    public Deal() {
    }

    public Deal(String name, String beschreibung, Vector<String> rabatt, HashMap<String, String> addressen, String url, String category, String appName, Vector<Double> lat, Vector<Double> lon) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.rabatt = rabatt;
        this.addressen = addressen;
        this.url = url;
        this.category = category;
        this.newDeal = false;
        this.appName = appName;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Vector<String> getRabatt() {
        return rabatt;
    }

    public void setRabatt(Vector<String> rabatt) {
        this.rabatt = rabatt;
    }

    public HashMap<String, String> getAddressen() {
        return addressen;
    }

    public void setAddressen(HashMap<String, String> addressen) {
        this.addressen = addressen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageEncoded() {
        return imageEncoded;
    }

    public void setImageEncoded(String imageEncoded) {
        this.imageEncoded = imageEncoded;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isNewDeal() {
        return newDeal;
    }

    public void setNewDeal(boolean newDeal) {
        this.newDeal = newDeal;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Vector<Double> getLat() {
        return lat;
    }

    public void setLat(Vector<Double> lat) {
        this.lat = lat;
    }

    public Vector<Double> getLon() {
        return lon;
    }

    public void setLon(Vector<Double> lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "name='" + name + '\n' +
                ", beschreibung='" + beschreibung + '\n' +
                ", rabatt='" + rabatt + '\n' +
                ", addressen=" + addressen +
                '}';
    }
}
