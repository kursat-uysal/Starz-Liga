package com.hr190005.kursat_uysal_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hr190005.kursat_uysal_final.R;
import com.hr190005.kursat_uysal_final.model.GithubModel;


import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsAdapterJavaViewHolder> {

    public OnItemClickListener mListener;
    private List<GithubModel> lists;
    private Context context;

    public interface OnItemClickListener {
        public void onItemClick(int position);

    }

    public class TeamsAdapterJavaViewHolder extends RecyclerView.ViewHolder {

        TextView textView_team_name, textView_team_detail_info;
        ImageView imageView_team_logo;


        public TeamsAdapterJavaViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            textView_team_name = itemView.findViewById(R.id.textView_team_name);
            textView_team_detail_info = itemView.findViewById(R.id.textView_team_detail_info);
            imageView_team_logo = itemView.findViewById(R.id.imageView_team_logo);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null) {
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION) {
                            listener.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener ) {
        mListener = listener;
    }

    public TeamsAdapter(Context context, List<GithubModel> repoList){
        this.lists=repoList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamsAdapterJavaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
        TeamsAdapterJavaViewHolder teamsAdapterJavaViewHolder= new TeamsAdapterJavaViewHolder(view, mListener);
        return teamsAdapterJavaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsAdapter.TeamsAdapterJavaViewHolder holder, int position) {
        holder.textView_team_name.setText(lists.get(position).getTakim_adi());
        holder.textView_team_detail_info.setText((lists.get(position).getDetay()));
        Glide.with(context)
                .load(lists.get(position).getLogo())
                .fitCenter()
                .into(holder.imageView_team_logo);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }



}
