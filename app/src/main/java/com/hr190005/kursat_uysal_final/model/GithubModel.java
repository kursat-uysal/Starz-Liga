package com.hr190005.kursat_uysal_final.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubModel implements Parcelable{
////Versiyonlar için model dosyası


    @SerializedName("index")
    @Expose
    private String index;

    @SerializedName("takim_adi")
    @Expose
    private String takim_adi;

    @SerializedName("kurulus_tarih")
    @Expose
    private String kurulus_tarih;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("detay")
    @Expose
    private String detay;

    @SerializedName("city")
    @Expose
    private String city;

    public GithubModel(String index, String takim_adi, String kurulus_tarih, String logo, String detay, String city) {
        this.index = index;
        this.takim_adi = takim_adi;
        this.kurulus_tarih = kurulus_tarih;
        this.logo = logo;
        this.detay = detay;
        this.city = city;
    }

    protected GithubModel(Parcel in) {
        index = in.readString();
        takim_adi = in.readString();
        kurulus_tarih = in.readString();
        logo = in.readString();
        detay = in.readString();
        city = in.readString();
    }

    public static final Creator<GithubModel> CREATOR = new Creator<GithubModel>() {
        @Override
        public GithubModel createFromParcel(Parcel in) {
            return new GithubModel(in);
        }

        @Override
        public GithubModel[] newArray(int size) {
            return new GithubModel[size];
        }
    };

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTakim_adi() {
        return takim_adi;
    }

    public void setTakim_adi(String takim_adi) {
        this.takim_adi = takim_adi;
    }

    public String getKurulus_tarih() {
        return kurulus_tarih;
    }

    public void setKurulus_tarih(String kurulus_tarih) {
        this.kurulus_tarih = kurulus_tarih;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(index);
        dest.writeString(takim_adi);
        dest.writeString(kurulus_tarih);
        dest.writeString(logo);
        dest.writeString(detay);
        dest.writeString(city);
    }
}
