package com.example.eagle_parent.webhelpers;

import android.app.Activity;

import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.webservices.WebService;
import com.example.eagle_parent.webservices.WebServiceFactory;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class WebApiRequest {

    private static WebService apiService;
    private static Activity currentActivity;
    private static WebApiRequest ourInstance = new WebApiRequest();


    public static WebApiRequest getInstance(Activity activity, boolean isShow) {

        apiService = WebServiceFactory.getInstance(activity);
        currentActivity = activity;
        if (isShow) {
            if (currentActivity instanceof BaseActivity) {


                //   ((BaseActivity) currentActivity).onLoadingStarted();
                //   KeyboardHelper.hideSoftKeyboard((currentActivity));


            }
        }
        return ourInstance;
    }

    private void showErrorMessage(String parseErrorMessage) {
       /* Utils.showSnackBar(currentActivity, currentActivity.getCurrentFocus(),
                parseErrorMessage, ContextCompat.getColor(currentActivity, R.color.red));*/

        Utils.showToast(currentActivity, parseErrorMessage, AppConstant.TOAST_TYPES.ERROR);


    }


    private String parseErrorMessage(JSONObject jsonObject) {

        for (Iterator<String> iter = jsonObject.keys(); iter.hasNext(); ) {
            String key = iter.next();
            JSONArray parentArray = null;
            try {
                parentArray = jsonObject.getJSONArray(key);

                return parentArray.get(0).toString();

                //  Utils.showToast(currentActivity,parentArray.get(0).toString(),AppConstant.TOAST_TYPES.ERROR);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        return currentActivity.getString(Integer.parseInt("Something wrong"));
    }


    public interface APIRequestDataCallBack {
        void onSuccess(JsonElement response);

        void onError(JsonElement response);

        void onNoNetwork();
    }




}