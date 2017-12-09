package com.technawabs.oneassist.modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

public class UserDetails implements Parcelable{

    private String email;
    private String name;
    private String mobileNumber;
    private String userImageUrl;
    private String skills;
    private boolean isTourTaken;
    private Double latitude;
    private Double longitude;

    public UserDetails(){

    }

    protected UserDetails(Parcel in) {
        email = in.readString();
        name = in.readString();
        mobileNumber = in.readString();
        userImageUrl = in.readString();
        skills = in.readString();
        isTourTaken = in.readByte() != 0;
        if (in.readByte() == 0) {
            latitude = null;
        } else {
            latitude = in.readDouble();
        }
        if (in.readByte() == 0) {
            longitude = null;
        } else {
            longitude = in.readDouble();
        }
    }

    public static final Creator<UserDetails> CREATOR = new Creator<UserDetails>() {
        @Override
        public UserDetails createFromParcel(Parcel in) {
            return new UserDetails(in);
        }

        @Override
        public UserDetails[] newArray(int size) {
            return new UserDetails[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String user_image_url) {
        this.userImageUrl = userImageUrl;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isTourTaken() {
        return isTourTaken;
    }

    public void setTourTaken(boolean tourTaken) {
        isTourTaken = tourTaken;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static final String Email = "email";
    public static final String Name = "name";
    public static final String MobileNumber = "mobileNumber";
    public static final String UserImageUrl = "userImageUrl";
    public static final String Skills = "skills";
    public static final String IsTourTaken = "isTourTaken";
    public static final String Latitude = "latitude";
    public static final String Longitude = "longitude";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(mobileNumber);
        dest.writeString(userImageUrl);
        dest.writeString(skills);
        dest.writeByte((byte) (isTourTaken ? 1 : 0));
        if (latitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(latitude);
        }
        if (longitude == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(longitude);
        }
    }
}
