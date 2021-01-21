package com.hr190005.kursat_uysal_final.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.hr190005.kursat_uysal_final.MyApplication;
import com.hr190005.kursat_uysal_final.R;
import com.hr190005.kursat_uysal_final.model.GithubModel;
import com.hr190005.kursat_uysal_final.utils.Constants;
import com.hr190005.kursat_uysal_final.utils.GlideHelper;

public class TeamDetailActivity extends AppCompatActivity {
    CardView cardView_logo;
    TextView textView_kurulus_tarih, textView_detail_of_team, textView_team_name_detail;
    ImageView imageView_team_logo_detail, img_favorite_team_star;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        cardView_logo = findViewById(R.id.cardView_logo);
        imageView_team_logo_detail = findViewById(R.id.imageView_team_logo_detail);
        textView_kurulus_tarih = findViewById(R.id.textView_kurulus_tarih);
        textView_detail_of_team = findViewById(R.id.textView_detail_of_team);
        textView_team_name_detail = findViewById(R.id.textView_team_name_detail);
        img_favorite_team_star = findViewById(R.id.img_favorite_team_star);

        teamDetailActivityProcess();

        Toast.makeText(MyApplication.getAppContext(), "Desteklediğiniz takımın sayfasındasınız..", Toast.LENGTH_LONG).show();

    }
    public void teamDetailActivityProcess() {
        final GithubModel githubModel = getIntent().getExtras().getParcelable("githubModel");

        GlideHelper.useGlideWithUrl(MyApplication.getAppContext(),githubModel.getLogo(), imageView_team_logo_detail);
     /*   Glide.with(this)
                .load(githubModel.getLogo())
                .fitCenter()
                .into(imageView_team_logo_detail);*/

        textView_kurulus_tarih.setText(githubModel.getKurulus_tarih());
        textView_detail_of_team.setText(githubModel.getDetay());
        textView_team_name_detail.setText(githubModel.getTakim_adi());

        if(Constants.myFavouriteTeam.equals(githubModel.getTakim_adi())){
            img_favorite_team_star.setVisibility(View.VISIBLE);
        }
    }
}
