package com.hr190005.kursat_uysal_final.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String BASE_URL = "https://raw.githubusercontent.com/";

    private static Retrofit retrofit;



    public static Retrofit getRetroClient() {
        OkHttpClient okClient = new OkHttpClient.Builder()
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().client(okClient).baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
