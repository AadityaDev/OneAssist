package com.technawabs.oneassist.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.technawabs.oneassist.constants.AppConstants;
import com.technawabs.oneassist.modal.UserDetails;

public class UserStore {

    private static final String PREF_NAME = "UserDetailsSharedPreference";
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String CONTACTS_UPLOADED_ON_SERVER = "ContactsUploadedOnServer";
    private static final String DATE_FOR_CONTACT_UPLOAD = "DateForContactUpload";
    private static final String IS_TOUR_TAKEN = "IsTourTaken";
    private static final int PRIVATE_MODE = 0;

    public UserStore(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
    }

    public UserDetails getUserDetails() {
        UserDetails user = new UserDetails();
        user.setName(pref.getString(UserDetails.Name, AppConstants.EMPTY));
        user.setEmail(pref.getString(UserDetails.Email, AppConstants.EMPTY));
        user.setUserImageUrl(pref.getString(UserDetails.UserImageUrl, AppConstants.EMPTY));
        user.setSkills(pref.getString(UserDetails.Skills, AppConstants.EMPTY));
        return user;
    }

    public void saveName(@NonNull String name) {
        editor = pref.edit();
        editor.putString(UserDetails.Name, name);
        editor.apply();
    }

    public void saveEmail(@NonNull String email) {
        editor = pref.edit();
        editor.putString(UserDetails.Email, email);
        editor.apply();
    }

    public void saveImage(@NonNull String image) {
        editor = pref.edit();
        editor.putString(UserDetails.UserImageUrl, image);
        editor.apply();
    }

    public void saveSkills(@NonNull String skills) {
        editor = pref.edit();
        editor.putString(UserDetails.Skills, skills);
        editor.apply();
    }

    public String getImage() {
        return pref.getString(UserDetails.UserImageUrl, "");
    }

    public void logoutUser(Context context) {
        editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public void setContactsUploadedOnServer() {
        editor = pref.edit();
        editor.putBoolean(CONTACTS_UPLOADED_ON_SERVER, true);
        editor.apply();
    }

    public boolean getContactsUploadedOnServer() {
        return pref.getBoolean(CONTACTS_UPLOADED_ON_SERVER, false);
    }

    public void setDateForContactUpload(long timeInMilliSeconds) {
        editor = pref.edit();
        editor.putLong(DATE_FOR_CONTACT_UPLOAD, timeInMilliSeconds);
        editor.apply();
    }

    public Long getDateForContactUpload() {
        return pref.getLong(DATE_FOR_CONTACT_UPLOAD, 0L);
    }

    public void setIsTourTaken() {
        editor = pref.edit();
        editor.putBoolean(IS_TOUR_TAKEN, true);
        editor.apply();
    }

    public boolean isTourTaken() {
        return pref.getBoolean(IS_TOUR_TAKEN, false);
    }

    public void setLatitude(double latitude) {
        editor = pref.edit();
        putDouble(editor,UserDetails.Latitude, latitude);
        editor.apply();
    }

    public Double getLatitude() {
        return getDouble(pref,UserDetails.Latitude, 0.0d);
    }

    public void setLongitude(double longitude) {
        editor = pref.edit();
        putDouble(editor,UserDetails.Longitude, longitude);
        editor.apply();
    }

    public Double getLongitude() {
        return getDouble(pref,UserDetails.Longitude, 0.0d);
    }


    SharedPreferences.Editor putDouble(final SharedPreferences.Editor edit, final String key, final double value) {
        return edit.putLong(key, Double.doubleToRawLongBits(value));
    }

    double getDouble(final SharedPreferences prefs, final String key, final double defaultValue) {
        return Double.longBitsToDouble(prefs.getLong(key, Double.doubleToLongBits(defaultValue)));
    }
}
