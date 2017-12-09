package com.technawabs.oneassist;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.technawabs.oneassist.constants.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    private static final String TAG = "Utility";

    public static void setGothamFont(@NonNull TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "gotham-book-1361523257.ttf"));
        }
    }

    public static void setGothamBoldFont(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "GOTHAM-BOLD.TTF"));
        }
    }

    public static void setOpenSansRegularFont(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "OpenSans-Regular.ttf"));
        }
    }

    public static void setOpenSansBoldFont(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "OpenSans-Bold.ttf"));
        }
    }

    public static void setOpenSansSemiBold(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "OpenSans-Bold.ttf"));
        }
    }

    public static int getAppVersion(@NonNull Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.d("UTILITY", "Package Manage Exception in getAppVersion" + "\n" + e.getMessage());
            return -1;
        }
    }

    public static String getAppVersionName(@NonNull Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static JSONObject getResultJSONObject(@NonNull String body) throws JSONException {
        JSONObject jsonObject = new JSONObject(body);
        JSONObject result = jsonObject.getJSONObject("result");
        return result;
    }

    public static JSONArray getResultJSONArray(@NonNull String body) throws JSONException {
        JSONObject jsonObject = new JSONObject(body);
        JSONArray result = new JSONArray();
        if (jsonObject.get("result") != null && !jsonObject.isNull("result")) {
            result = jsonObject.getJSONArray("result");
        }
        return result;
    }

    public static String getResultString(@NonNull String body) throws JSONException {
        JSONObject jsonObject = new JSONObject(body);
        String s = jsonObject.getString("result");
        if (s == null) {
            s = jsonObject.getString("errors");
        }
        return s;
    }

    public static void getJSONFormat(@NonNull String key, @NonNull String value, @NonNull StringBuilder stringBuilder) {
        stringBuilder.append('"');
        stringBuilder.append(key);
        stringBuilder.append('"');
        stringBuilder.append(":");
        stringBuilder.append('"');
        stringBuilder.append(value);
        stringBuilder.append('"');
    }

    public static void startNewTaskActivity(@NonNull Context context, @NonNull Class activityClass) {
        Intent intent = new Intent(context, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    public static void setListViewHeightBasedOnChildren(@NonNull ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    /*
    *   @str1 device app version
    *   @str2 playstore app version
    *   0 if both are same
    *   + if str1 > str2
    */
    public static int versionCompare(@NonNull String str1, @NonNull String str2) {
        String[] vals1 = str1.split("\\.");
        String[] vals2 = str2.split("\\.");
        int i = 0;
        Log.d(TAG, "Device app " + vals1.toString());
        Log.d(TAG, "Playstore app " + vals2.toString());
        // set index to first non-equal ordinal or length of shortest version string
        while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
            i++;
        }
        // compare first non-equal ordinal number
        if (i < vals1.length && i < vals2.length) {
            int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
            return Integer.signum(diff);
        }
        Log.d(TAG, String.valueOf(Integer.signum(vals1.length - vals2.length)));
        // the strings are equal or one string is a substring of the other
        // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
        return Integer.signum(vals1.length - vals2.length);
    }

    public static String formatArrayListToString(@NonNull String arrayList) {
        return arrayList.replace("[", "").replace("]", "");
    }

    public static void startProgressDialog(@NonNull ProgressDialog progressDialog) {
        try {
            if (!progressDialog.isShowing()) {
                progressDialog.show();
            }
        } catch (Exception e) {
            Log.d(TAG, AppConstants.ExceptionConstant.EXCEPTION);
        }
    }

    public static void checkProgressDialog(@NonNull ProgressDialog progressDialog) {
        try {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            Log.d(TAG, AppConstants.ExceptionConstant.EXCEPTION);
        }
    }

    public static void showProgressBar(@NonNull View progressBar) {
        if (progressBar.getVisibility() == View.INVISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        }

    }

    public static void hideProgressBar(@NonNull View progressBar) {
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

}

