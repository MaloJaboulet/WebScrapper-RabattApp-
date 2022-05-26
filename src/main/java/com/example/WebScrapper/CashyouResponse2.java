package com.example.WebScrapper;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CashyouResponse2 {
    private float id;
    private String name;
    private String street;
    private String street_number;
    private float zip_code;
    private String phone;
    private float latitude;
    private float longitude;
    private String about_us;
    private String website_url;
    private String share_url;
    private String url_segment;
    private String first_offer_description;
    private String logo;
    private String cover;
    private boolean collection_partner;
    ArrayList<Childern> children = new ArrayList<>();
    private float promotional_offers_count;
    private float freemium_promotional_offers_count;
    ArrayList<Promotional_offers> promotional_offers = new ArrayList<Promotional_offers>();
    Category2 CategoryObject;
    City CityObject;
    private String city_name;
    Merchant2 MerchantObject;
    ArrayList<Covers> covers = new ArrayList<Covers>();
    private float likes_count;


    // Getter Methods


    public ArrayList<Covers> getCovers() {
        return covers;
    }

    public void setCovers(ArrayList<Covers> covers) {
        this.covers = covers;
    }

    public ArrayList<Promotional_offers> getPromotional_offers() {
        return promotional_offers;
    }

    public void setPromotional_offers(ArrayList<Promotional_offers> promotional_offers) {
        this.promotional_offers = promotional_offers;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public float getZip_code() {
        return zip_code;
    }

    public String getPhone() {
        return phone;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getAbout_us() {
        return about_us;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public String getUrl_segment() {
        return url_segment;
    }

    public String getFirst_offer_description() {
        return first_offer_description;
    }

    public String getLogo() {
        return logo;
    }

    public String getCover() {
        return cover;
    }

    public boolean getCollection_partner() {
        return collection_partner;
    }

    public ArrayList<Childern> getChildren() {
        return children;
    }

    public float getPromotional_offers_count() {
        return promotional_offers_count;
    }

    public float getFreemium_promotional_offers_count() {
        return freemium_promotional_offers_count;
    }

    public Category2 getCategory() {
        return CategoryObject;
    }

    public City getCity() {
        return CityObject;
    }

    public String getCity_name() {
        return city_name;
    }

    public Merchant2 getMerchant() {
        return MerchantObject;
    }

    public float getLikes_count() {
        return likes_count;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public void setZip_code(float zip_code) {
        this.zip_code = zip_code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setAbout_us(String about_us) {
        this.about_us = about_us;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setUrl_segment(String url_segment) {
        this.url_segment = url_segment;
    }

    public void setFirst_offer_description(String first_offer_description) {
        this.first_offer_description = first_offer_description;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setCollection_partner(boolean collection_partner) {
        this.collection_partner = collection_partner;
    }

    public void setChildren(ArrayList<Childern> children) {
        this.children = children;
    }

    public void setPromotional_offers_count(float promotional_offers_count) {
        this.promotional_offers_count = promotional_offers_count;
    }

    public void setFreemium_promotional_offers_count(float freemium_promotional_offers_count) {
        this.freemium_promotional_offers_count = freemium_promotional_offers_count;
    }

    public void setCategory(Category2 categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setCity(City cityObject) {
        this.CityObject = cityObject;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setMerchant(Merchant2 merchantObject) {
        this.MerchantObject = merchantObject;
    }

    public void setLikes_count(float likes_count) {
        this.likes_count = likes_count;
    }
}

class Promotional_offers {
    private float id;
    private String name;
    private String offer_description;
    private String condition_text = null;
    private float max_allowed_redemptions;
    private String discount_label;
    private boolean for_full_legal_age_only;
    private float redemptions_count;
    private String redemption_text;
    private String redemption_fulltext;
    private String share_url;
    private String website_url = null;
    private String type;
    Category2 CategoryObject;
    private String logo;
    private String data_matrix = null;
    private String cover;
    Merchant2 MerchantObject;
    private boolean online_offer;
    ArrayList<Recommended_offers> recommended_offers = new ArrayList<Recommended_offers>();
    private String display_voucher_code_as;


    // Getter Methods

    public ArrayList<Recommended_offers> getRecommended_offers() {
        return recommended_offers;
    }

    public void setRecommended_offers(ArrayList<Recommended_offers> recommended_offers) {
        this.recommended_offers = recommended_offers;
    }

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOffer_description() {
        return offer_description;
    }

    public String getCondition_text() {
        return condition_text;
    }

    public float getMax_allowed_redemptions() {
        return max_allowed_redemptions;
    }

    public String getDiscount_label() {
        return discount_label;
    }

    public boolean getFor_full_legal_age_only() {
        return for_full_legal_age_only;
    }

    public float getRedemptions_count() {
        return redemptions_count;
    }

    public String getRedemption_text() {
        return redemption_text;
    }

    public String getRedemption_fulltext() {
        return redemption_fulltext;
    }

    public String getShare_url() {
        return share_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getType() {
        return type;
    }

    public Category2 getCategory() {
        return CategoryObject;
    }

    public String getLogo() {
        return logo;
    }

    public String getData_matrix() {
        return data_matrix;
    }

    public String getCover() {
        return cover;
    }

    public Merchant2 getMerchant() {
        return MerchantObject;
    }

    public boolean getOnline_offer() {
        return online_offer;
    }

    public String getDisplay_voucher_code_as() {
        return display_voucher_code_as;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    public void setCondition_text(String condition_text) {
        this.condition_text = condition_text;
    }

    public void setMax_allowed_redemptions(float max_allowed_redemptions) {
        this.max_allowed_redemptions = max_allowed_redemptions;
    }

    public void setDiscount_label(String discount_label) {
        this.discount_label = discount_label;
    }

    public void setFor_full_legal_age_only(boolean for_full_legal_age_only) {
        this.for_full_legal_age_only = for_full_legal_age_only;
    }

    public void setRedemptions_count(float redemptions_count) {
        this.redemptions_count = redemptions_count;
    }

    public void setRedemption_text(String redemption_text) {
        this.redemption_text = redemption_text;
    }

    public void setRedemption_fulltext(String redemption_fulltext) {
        this.redemption_fulltext = redemption_fulltext;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(Category2 categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setData_matrix(String data_matrix) {
        this.data_matrix = data_matrix;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setMerchant(Merchant2 merchantObject) {
        this.MerchantObject = merchantObject;
    }

    public void setOnline_offer(boolean online_offer) {
        this.online_offer = online_offer;
    }

    public void setDisplay_voucher_code_as(String display_voucher_code_as) {
        this.display_voucher_code_as = display_voucher_code_as;
    }
}

class Recommended_offers {
    private float id;
    private String name;
    private String description = null;
    private String content = null;
    private String offer_description;
    private String condition_text;
    private String discount_label;
    private String share_url;
    private String logo;
    private String cover;
    Category2 CategoryObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getOffer_description() {
        return offer_description;
    }

    public String getCondition_text() {
        return condition_text;
    }

    public String getDiscount_label() {
        return discount_label;
    }

    public String getShare_url() {
        return share_url;
    }

    public String getLogo() {
        return logo;
    }

    public String getCover() {
        return cover;
    }

    public Category2 getCategory() {
        return CategoryObject;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    public void setCondition_text(String condition_text) {
        this.condition_text = condition_text;
    }

    public void setDiscount_label(String discount_label) {
        this.discount_label = discount_label;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setCategory(Category2 categoryObject) {
        this.CategoryObject = categoryObject;
    }
}

class Childern {
    private float id;
    private String name;
    private String street;
    private String street_number;
    private String zip_code = null;
    private String phone;
    private String latitude = null;
    private String longitude = null;
    private String about_us;
    private String website_url;
    private String share_url;
    private String url_segment;
    private float promotional_offers_count;
    private float freemium_promotional_offers_count;
    private String[] children = null;
    private boolean collection_partner;
    private String city_name = null;
    private float likes_count;
    private String first_offer_description;
    private String distance = null;
    Merchant MerchantObject;
    Category CategoryObject;
    private City city = null;
    private String logo;
    private String cover;
    ArrayList<Covers> covers = new ArrayList<Covers>();


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getStreet_number() {
        return street_number;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getPhone() {
        return phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAbout_us() {
        return about_us;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public String getUrl_segment() {
        return url_segment;
    }

    public float getPromotional_offers_count() {
        return promotional_offers_count;
    }

    public float getFreemium_promotional_offers_count() {
        return freemium_promotional_offers_count;
    }

    public String[] getChildren() {
        return children;
    }

    public boolean getCollection_partner() {
        return collection_partner;
    }

    public String getCity_name() {
        return city_name;
    }

    public float getLikes_count() {
        return likes_count;
    }

    public String getFirst_offer_description() {
        return first_offer_description;
    }

    public String getDistance() {
        return distance;
    }

    public Merchant getMerchant() {
        return MerchantObject;
    }

    public Category getCategory() {
        return CategoryObject;
    }

    public City getCity() {
        return city;
    }

    public String getLogo() {
        return logo;
    }

    public String getCover() {
        return cover;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setAbout_us(String about_us) {
        this.about_us = about_us;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setUrl_segment(String url_segment) {
        this.url_segment = url_segment;
    }

    public void setPromotional_offers_count(float promotional_offers_count) {
        this.promotional_offers_count = promotional_offers_count;
    }

    public void setFreemium_promotional_offers_count(float freemium_promotional_offers_count) {
        this.freemium_promotional_offers_count = freemium_promotional_offers_count;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public void setCollection_partner(boolean collection_partner) {
        this.collection_partner = collection_partner;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setLikes_count(float likes_count) {
        this.likes_count = likes_count;
    }

    public void setFirst_offer_description(String first_offer_description) {
        this.first_offer_description = first_offer_description;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setMerchant(Merchant merchantObject) {
        this.MerchantObject = merchantObject;
    }

    public void setCategory(Category categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public ArrayList<Covers> getCovers() {
        return covers;
    }

    public void setCovers(ArrayList<Covers> covers) {
        this.covers = covers;
    }
}

class Covers {
    private float id;
    private float position;
    private String created_at;
    private String updated_at;
    private String partner_id = null;
    private float merchant_id;
    private String lottery_id = null;
    private String announcement_id = null;
    private String image_url;


    // Getter Methods

    public float getId() {
        return id;
    }

    public float getPosition() {
        return position;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public float getMerchant_id() {
        return merchant_id;
    }

    public String getLottery_id() {
        return lottery_id;
    }

    public String getAnnouncement_id() {
        return announcement_id;
    }

    public String getImage_url() {
        return image_url;
    }

    // Setter Methods

    public void setId( float id ) {
        this.id = id;
    }

    public void setPosition( float position ) {
        this.position = position;
    }

    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    public void setUpdated_at( String updated_at ) {
        this.updated_at = updated_at;
    }

    public void setPartner_id( String partner_id ) {
        this.partner_id = partner_id;
    }

    public void setMerchant_id( float merchant_id ) {
        this.merchant_id = merchant_id;
    }

    public void setLottery_id( String lottery_id ) {
        this.lottery_id = lottery_id;
    }

    public void setAnnouncement_id( String announcement_id ) {
        this.announcement_id = announcement_id;
    }

    public void setImage_url( String image_url ) {
        this.image_url = image_url;
    }

}

class Merchant2 {
    private float id;
    private String name;
    private String about_us;
    private String logo;
    private String cover;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbout_us() {
        return about_us;
    }

    public String getLogo() {
        return logo;
    }

    public String getCover() {
        return cover;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbout_us(String about_us) {
        this.about_us = about_us;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}

class City {
    private float id;
    private String native_name;
    private String name;
    private float longitude;
    private float latitude;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getNative_name() {
        return native_name;
    }

    public String getName() {
        return name;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setNative_name(String native_name) {
        this.native_name = native_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}

class Category2 {
    private String name;
    private String title;
    private boolean online;
    private boolean national;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean getOnline() {
        return online;
    }

    public boolean getNational() {
        return national;
    }

    // Setter Methods

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