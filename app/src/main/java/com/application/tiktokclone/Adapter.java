package com.application.tiktokclone;

import android.content.Context;
import android.media.MediaPlayer;
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
    boolean isPlaying=false;

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
        holder.binding.profileVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        holder.binding.profileVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });

        holder.binding.profileVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                isPlaying=true;
            }
        });
        holder.binding.profileVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    holder.binding.profileVideo.pause();
                    isPlaying=false;
                }else{
                    holder.binding.profileVideo.resume();
                    isPlaying=true;
                }
            }
        });
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
