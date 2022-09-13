package com.example.eagle_parent.webservices;


import com.example.eagle_parent.constant.AppConstant;
import com.google.gson.JsonElement;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface WebService {

    // REGISTER USER
    @POST(AppConstant.ServerAPICalls.REGISTER_USER)
    Call<JsonElement> registerUser(
            @Body Map<String,Object> body
    );

    // LOGIN USER
    @POST(AppConstant.ServerAPICalls.LOGIN_USER)
    Call<JsonElement> loginUser(
            @Body Map<String,Object> body
    );

    // RE-SEND CODE
    @POST(AppConstant.ServerAPICalls.RESEND_CODE)
    Call<JsonElement> resendCodeUser(
            @Body Map<String,Object> body
    );

    //For Custom Form
    @GET(AppConstant.ServerAPICalls.CUSTOM_FORM_FIELD)
    Call<JsonElement> customField(
            @Path("slug") String slug
    );

    //For Document Form
    @GET(AppConstant.ServerAPICalls.CUSTOM_DOCUMENT_FIELD)
    Call<JsonElement> customDocument(
            @Path("slug") String slug
    );



    //Get All Policies
    @POST(AppConstant.ServerAPICalls.GET_QUOTES)
    Call<JsonElement> getQuotes(
    );

    //Get Form Quotes
    @POST(AppConstant.ServerAPICalls.POST_QUOTES)
    Call<JsonElement> getFormQuotes(
            @Body Map<String, String> body

    );


    //Get My Active policies
    @GET(AppConstant.ServerAPICalls.GET_MY_QUOTES)
    Call<JsonElement> getMyQuotes(
            @Path("id") String id
    );


    //Get Coupon
    @GET(AppConstant.ServerAPICalls.GET_COUPON)
    Call<JsonElement> getCoupon(
            @Path("id") String id
    );


    //Get dashboard category
    @GET(AppConstant.ServerAPICalls.GET_CATEGORY)
    Call<JsonElement> getAllCategory(
    );


    //Get dashboard category
    @GET(AppConstant.ServerAPICalls.GET_SLIDER)
    Call<JsonElement> getSlider(
    );



    //For Comparision
    @POST(AppConstant.ServerAPICalls.GET_COMPARISON)
    Call<JsonElement> getComparison(
    );



    //For Contact us
    @POST(AppConstant.ServerAPICalls.ADD_CONTACT_US)
    Call<JsonElement> addContactUs(
            @Body Map<String,Object> body
    );

    //For FAQ's
    @GET(AppConstant.ServerAPICalls.GET_FAQS)
    Call<JsonElement> getFaq(
    );


    // For image upload to server
    @Multipart
    @POST(AppConstant.ServerAPICalls.UPLOAD_IMAGE)
    Call<JsonElement> uploadImageToServer(
            @Part MultipartBody.Part image
    );

    //For Profile
    @POST(AppConstant.ServerAPICalls.UPDATE_PROFILE)
    Call<JsonElement> updateProfile(
            @Path("id") String id,
            @Body Map<String,Object> body

    );


    //For Buy Policy
    @POST(AppConstant.ServerAPICalls.BUY_POLICY)
    Call<JsonElement> buyPolicy(
            @Path("id") String id,
            @Body Map<String, Object> body

    );









}
