package com.tindia.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Destination implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("dest_name")
    private String destName;
    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("dest_desc")
    private String destDesc;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDestDesc() {
        return destDesc;
    }

    public void setDestDesc(String destDesc) {
        this.destDesc = destDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.destName);
        dest.writeString(this.imageUrl);
        dest.writeString(this.destDesc);
    }

    public Destination() {
    }

    protected Destination(Parcel in) {
        this.id = in.readInt();
        this.destName = in.readString();
        this.imageUrl = in.readString();
        this.destDesc = in.readString();
    }

    public static final Parcelable.Creator<Destination> CREATOR = new Parcelable.Creator<Destination>() {
        @Override
        public Destination createFromParcel(Parcel source) {
            return new Destination(source);
        }

        @Override
        public Destination[] newArray(int size) {
            return new Destination[size];
        }
    };
}
