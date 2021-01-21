package com.hr190005.kursat_uysal_final.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hr190005.kursat_uysal_final.model.GithubModel;
import com.hr190005.kursat_uysal_final.retrofit.APIService;
import com.hr190005.kursat_uysal_final.retrofit.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubViewModel extends ViewModel {
   private MutableLiveData<List<GithubModel>> githubList;

   public GithubViewModel()  {
           githubList = new MutableLiveData<>();
   }

   public MutableLiveData<List<GithubModel>> getGithubListObserver(){
       return githubList;
   }

   public void makeApiCall(){
       APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
       Call<List<GithubModel>> call  = apiService.getGithubList();
       call.enqueue(new Callback<List<GithubModel>>() {
           @Override
           public void onResponse(Call<List<GithubModel>> call, Response<List<GithubModel>> response) {
               githubList.postValue(response.body());
           }

           @Override
           public void onFailure(Call<List<GithubModel>> call, Throwable t) {
               githubList.postValue(null);
           }
       });
   }

}
