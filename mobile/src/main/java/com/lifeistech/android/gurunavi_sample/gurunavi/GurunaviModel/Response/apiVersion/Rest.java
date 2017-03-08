package com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion;

import com.google.gson.annotations.SerializedName;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.Access;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.Code;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.CouponURL;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.Flags;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.ImageURL;
import com.lifeistech.android.gurunavi_sample.gurunavi.GurunaviModel.Response.apiVersion.rest.PR;

import java.io.Serializable;


/**
 * Created by Masashi Hamaguchi on 2017/02/28.
 */

public class Rest implements Serializable {

    @SerializedName("@attributes")
    public Order attributes;
    public String id;
    @SerializedName("update_date")
    public String updateDate;
    public String name;
    @SerializedName("name_kana")
    public String nameKana;
    public String latitude;

    public String longitude;
    public String category;
    public String url;
    @SerializedName("url_mobile")
    public String urlMobile;
    @SerializedName("coupon_url")
    public CouponURL couponURL;

    @SerializedName("image_url")
    public ImageURL imageURL;
    public String address;
    public String tel;
    @SerializedName("tel_sub")
    public String telSub;
    public String fax;

    public String opentime;
    public String holiday;
    public Access access;
    @SerializedName("parking_lots")
    public String parkingLots;
    public PR pr;

    public Code code;
    public String budget;
    public String party;
    public String lunch;
    @SerializedName("credit_card")
    public String creditCard;

    @SerializedName("e_money")
    public String eMoney;
    public Flags flags;


    public Rest(Order attributes, String id, String updateDate, String name, String nameKana, String latitude, String longitude, String category, String url, String urlMobile, CouponURL couponURL, ImageURL imageURL, String address, String tel, String telSub, String fax, String opentime, String holiday, Access access, String parkingLots, PR pr, Code code, String budget, String party, String lunch, String creditCard, String eMoney, Flags flags) {
        this.attributes = attributes;
        this.id = id;
        this.updateDate = updateDate;
        this.name = name;
        this.nameKana = nameKana;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.url = url;
        this.urlMobile = urlMobile;
        this.couponURL = couponURL;
        this.imageURL = imageURL;
        this.address = address;
        this.tel = tel;
        this.telSub = telSub;
        this.fax = fax;
        this.opentime = opentime;
        this.holiday = holiday;
        this.access = access;
        this.parkingLots = parkingLots;
        this.pr = pr;
        this.code = code;
        this.budget = budget;
        this.party = party;
        this.lunch = lunch;
        this.creditCard = creditCard;
        this.eMoney = eMoney;
        this.flags = flags;
    }


    public Order getAttributes() {
        return attributes;
    }

    public void setAttributes(Order attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlMobile() {
        return urlMobile;
    }

    public void setUrlMobile(String urlMobile) {
        this.urlMobile = urlMobile;
    }

    public CouponURL getCouponURL() {
        return couponURL;
    }

    public void setCouponURL(CouponURL couponURL) {
        this.couponURL = couponURL;
    }

    public ImageURL getImageURL() {
        return imageURL;
    }

    public void setImageURL(ImageURL imageURL) {
        this.imageURL = imageURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTelSub() {
        return telSub;
    }

    public void setTelSub(String telSub) {
        this.telSub = telSub;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(String parkingLots) {
        this.parkingLots = parkingLots;
    }

    public PR getPr() {
        return pr;
    }

    public void setPr(PR pr) {
        this.pr = pr;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String geteMoney() {
        return eMoney;
    }

    public void seteMoney(String eMoney) {
        this.eMoney = eMoney;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }


}

