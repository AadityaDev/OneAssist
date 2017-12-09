package com.technawabs.oneassist.modal;

import android.os.Parcel;
import android.os.Parcelable;

public class Phone implements Parcelable {

    private String home;
    private String mobile;
    private String office;

    public Phone(){}

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    private Phone(Parcel in){
        home=in.readString();
        mobile=in.readString();
        office=in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(home);
        dest.writeString(mobile);
        dest.writeString(office);
    }

    public static final Creator<Phone> CREATOR
            = new Creator<Phone>() {
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };


}
