package com.example.eagle_parent.constant;

public class AppConstant {

    public static int MIN_TIME_INTERVAL_FOR_SPLASH = 3000; // in millis
    public static int MIN_TIME_VERIFY_CODE = 6000; // in  public static final int SELECT_IMAGE_COUNT = 1; millis
    public static final int SELECT_IMAGE_COUNT = 1;
    public static final String PhonePattern = "^(?:\\+971|00971|0)?(?:50|51|52|55|56|2|3|4|6|7|9)\\d{7}$";
    public static final String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        public class TRANSITION_TYPES {
            public static final int NONE = 2000;
            public static final int FADE = 20001;
            public static final int SLIDE = 20002;
        }



        public class TOAST_TYPES {
        public static final int INFO = 1101;
        public static final int SUCCESS = 1102;
        public static final int ERROR = 1103;

    }



    public class ServerAPICalls {



        public static final String BASE_URL =  "https://mip-api-2.herokuapp.com/";



        //For Auth APi
        public static final String REGISTER_USER = "users"; // Register User

        public static final String LOGIN_USER = "users/login"; // Login User

        public static final String RESEND_CODE = "users/sendcode"; // Re-Send Code to User


        //For Custom Form Api
        public static final String CUSTOM_FORM_FIELD = "forms/{slug}"; // Dynamic form

        //For Custom Document Form Api
        public static final String CUSTOM_DOCUMENT_FIELD = "forms/document-{slug}"; //  Custom Document Form

        //All Policies Api
        public static final String GET_QUOTES = "quotes";

        //All Policies Api
        public static final String POST_QUOTES = "quotes";

        //My Active Policy Api
        public static final String GET_MY_QUOTES = "users/{id}/policy";

        //Comparision Api
        public static final String GET_COMPARISON = "compare";


        //profile Api
        public static final String UPDATE_PROFILE = "users/{id}";

        // upload avatar
        public static final String UPLOAD_IMAGE = "users/avatar"; // upload avatar

        //faqs Api
        public static final String GET_FAQS = "faqs";

        //Buy Policy Api
        public static final String BUY_POLICY = "users/{id}/policy";


        //Dynamic Policy Category Dashboard
        public static final String GET_CATEGORY = "insurancetypes";

        //slider Api
        public static final String GET_SLIDER = "slider";

        //contact us Api
        public static final String ADD_CONTACT_US  = "contact";


        //coupon discount Api
        public static final String GET_COUPON  = "coupon/{id}";


    }



}
