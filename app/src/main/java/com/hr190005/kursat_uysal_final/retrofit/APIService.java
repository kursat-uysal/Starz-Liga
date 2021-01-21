package com.hr190005.kursat_uysal_final.retrofit;


//hangi endpoint hangi fonksiyon onu ayarlıyoruz



import com.hr190005.kursat_uysal_final.model.GithubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("kursat-uysal/hr190005kursatuysal/master/teams_last.json")
    Call<List<GithubModel>> getGithubList();

}
