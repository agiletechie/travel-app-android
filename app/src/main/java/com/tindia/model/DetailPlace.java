package com.tindia.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class DetailPlace implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("place_image")
    private String place_image;
    @SerializedName("place_name")
    private String place_name;
    @SerializedName("place_desc")
    private String place_desc;
    @SerializedName("belongs_to")
    private int belongs_to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_desc() {
        return place_desc;
    }

    public void setPlace_desc(String place_desc) {
        this.place_desc = place_desc;
    }

    public int getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(int belongs_to) {
        this.belongs_to = belongs_to;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.place_image);
        dest.writeString(this.place_name);
        dest.writeString(this.place_desc);
        dest.writeInt(this.belongs_to);
    }

    public DetailPlace() {
    }

    protected DetailPlace(Parcel in) {
        this.id = in.readInt();
        this.place_image = in.readString();
        this.place_name = in.readString();
        this.place_desc = in.readString();
        this.belongs_to = in.readInt();
    }

    public static final Parcelable.Creator<DetailPlace> CREATOR = new Parcelable.Creator<DetailPlace>() {
        @Override
        public DetailPlace createFromParcel(Parcel source) {
            return new DetailPlace(source);
        }

        @Override
        public DetailPlace[] newArray(int size) {
            return new DetailPlace[size];
        }
    };
}
