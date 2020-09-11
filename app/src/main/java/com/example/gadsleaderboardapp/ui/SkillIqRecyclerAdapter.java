package com.example.gadsleaderboardapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadsleaderboardapp.Models.Hours;
import com.example.gadsleaderboardapp.Models.Skill;
import com.example.gadsleaderboardapp.R;

import java.util.ArrayList;

public class SkillIqRecyclerAdapter extends RecyclerView.Adapter<SkillIqRecyclerAdapter.ViewHolder> {

    private ArrayList<Skill> skillList = new ArrayList<>();
    public Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skilliq_single_item, parent , false);
        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleTV.setText(skillList.get(position).getUsername());
        holder.hoursTv.setText(String.valueOf(skillList.get(position).getScore()));
        holder.countryTv.setText(skillList.get(position).getCountry());
        Glide.with(context).load(skillList.get(position).getBadgeUrl()).into(holder.badgeImage);

    }

    @Override
    public int getItemCount() {
        if(skillList != null) {

            return skillList.size();

        } else {

            return 0;

        }
    }

    public void setList(ArrayList<Skill> skillList){
        this.skillList = skillList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleTV , hoursTv , countryTv;
        ImageView badgeImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTV = itemView.findViewById(R.id.name_tv);
            hoursTv = itemView.findViewById(R.id.skill_tv);
            badgeImage = itemView.findViewById(R.id.badge2_img);
            countryTv = itemView.findViewById(R.id.country_tv);
        }
    }
}
