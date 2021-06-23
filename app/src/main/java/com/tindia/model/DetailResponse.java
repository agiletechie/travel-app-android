package com.tindia.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DetailResponse implements Parcelable {

    private List<DetailPlace> place;
    private List<Hotel> hotel;
    private List<Transport> transport;
    private List<Food> food;

    public List<DetailPlace> getPlace() {
        return place;
    }

    public void setPlace(List<DetailPlace> place) {
        this.place = place;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public static Creator<DetailResponse> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.place);
        dest.writeList(this.hotel);
        dest.writeList(this.transport);
        dest.writeList(this.food);
    }

    public DetailResponse() {
    }

    protected DetailResponse(Parcel in) {
        this.place = new ArrayList<DetailPlace>();
        in.readList(this.place, DetailPlace.class.getClassLoader());
        this.hotel = new ArrayList<Hotel>();
        in.readList(this.hotel, Hotel.class.getClassLoader());
        this.transport = new ArrayList<Transport>();
        in.readList(this.transport, Transport.class.getClassLoader());
        this.food = new ArrayList<Food>();
        in.readList(this.food, Food.class.getClassLoader());
    }

    public static final Parcelable.Creator<DetailResponse> CREATOR = new Parcelable.Creator<DetailResponse>() {
        @Override
        public DetailResponse createFromParcel(Parcel source) {
            return new DetailResponse(source);
        }

        @Override
        public DetailResponse[] newArray(int size) {
            return new DetailResponse[size];
        }
    };
}
