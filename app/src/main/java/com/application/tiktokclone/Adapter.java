package com.application.tiktokclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.tiktokclone.databinding.ReeelDesignBinding;

import java.util.ArrayList;

public class Adapter extends  RecyclerView.Adapter<Adapter.VideoHolder>{

    Context context;
    ArrayList<Model> arrayList=new ArrayList<>();

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reeel_design,parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        holder.binding.profileVideo.setVideoPath(arrayList.get(position).getVideoUrl());
        holder.binding.profileName.setText(arrayList.get(position).getName());
        holder.binding.profileImage.setImageResource(arrayList.get(position).getProfile());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        ReeelDesignBinding binding;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReeelDesignBinding.bind(itemView);
        }
    }
}
