package com.example.WebScrapper;

public class CashyouResponse {
    private int count;
    private Items[] items;
    private int[] ids;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public int[] getIds() {
        return ids;
    }
}

class Items{
    private int id;
    private String name;
    private String first_offer_description;
    private String latitude;
    private String longitude;
    private boolean relates_to_collection;
    private Category category;
    private int freemium_promotional_offers_count;
    private int promotional_offers_count;
    private int children;
    private boolean collection_partner;
    private String cover;
    private Merchant merchant;
    private boolean liked;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirst_offer_description() {
        return first_offer_description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public boolean isRelates_to_collection() {
        return relates_to_collection;
    }

    public Category getCategory() {
        return category;
    }

    public int getFreemium_promotional_offers_count() {
        return freemium_promotional_offers_count;
    }

    public int getPromotional_offers_count() {
        return promotional_offers_count;
    }

    public int getChildren() {
        return children;
    }

    public boolean isCollection_partner() {
        return collection_partner;
    }

    public String getCover() {
        return cover;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst_offer_description(String first_offer_description) {
        this.first_offer_description = first_offer_description;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setRelates_to_collection(boolean relates_to_collection) {
        this.relates_to_collection = relates_to_collection;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFreemium_promotional_offers_count(int freemium_promotional_offers_count) {
        this.freemium_promotional_offers_count = freemium_promotional_offers_count;
    }

    public void setPromotional_offers_count(int promotional_offers_count) {
        this.promotional_offers_count = promotional_offers_count;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setCollection_partner(boolean collection_partner) {
        this.collection_partner = collection_partner;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
class Category{
    private String name;
    private String title;
    private boolean online;
    private boolean national;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean isOnline() {
        return online;
    }

    public boolean isNational() {
        return national;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void setNational(boolean national) {
        this.national = national;
    }
}
class Merchant{
    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
