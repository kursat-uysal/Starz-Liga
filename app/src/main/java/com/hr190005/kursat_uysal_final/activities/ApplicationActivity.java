package com.hr190005.kursat_uysal_final.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190005.kursat_uysal_final.R;
import com.hr190005.kursat_uysal_final.adapter.TeamsAdapter;
import com.hr190005.kursat_uysal_final.model.GithubModel;
import com.hr190005.kursat_uysal_final.viewModel.GithubViewModel;

import java.util.List;

public class ApplicationActivity extends AppCompatActivity {

    RecyclerView recyclerView_teams;
    TeamsAdapter teamsAdapter;
    private GithubViewModel githubViewModel;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Burada xml layout id yi bağlıyoruz
        recyclerView_teams = findViewById(R.id.recyclerView_teams);

        githubViewModel = new ViewModelProvider(this).get(GithubViewModel.class);

        linearLayoutManager =new LinearLayoutManager(this.getApplicationContext());

        mainActivityProcess();

    }

    @Override
    public void onBackPressed() {
        alertDialogExit();
    }
        //çıkış yapılsınmı diyalogu
    private void alertDialogExit(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(ApplicationActivity.this);
        dialog.setTitle(R.string.close_app);
        dialog.setMessage(R.string.close_app_question);
        dialog.setCancelable(true);



        dialog.setPositiveButton(
                R.string.exit,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int
                            id) {
                        finishAffinity();

                    }
                });


        dialog.setNegativeButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.show();
    }

    public void mainActivityProcess(){
        githubViewModel.makeApiCall();

        githubViewModel.getGithubListObserver().observe(this, new Observer<List<GithubModel>>() {
            @Override
            public void onChanged(final List<GithubModel> githubModels) {
                if(githubModels != null) {


                    teamsAdapter = new TeamsAdapter(ApplicationActivity.this, githubModels);
                    recyclerView_teams.setLayoutManager(linearLayoutManager);
                    recyclerView_teams.setAdapter(teamsAdapter);
                    teamsAdapter.notifyDataSetChanged();

                    teamsAdapter.setOnItemClickListener(new TeamsAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent intent = new Intent(ApplicationActivity.this, TeamDetailActivity.class);
                            intent.putExtra("githubModel", githubModels.get(position));
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}