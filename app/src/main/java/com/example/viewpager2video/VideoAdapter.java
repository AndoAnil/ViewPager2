package com.example.viewpager2video;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoItem> list;

    public VideoAdapter(List<VideoItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
      holder.setVideoData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder
    {
       VideoView videoView;
       TextView title,description;
       ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView=(VideoView)itemView.findViewById(R.id.videoView);
            title=(TextView)itemView.findViewById(R.id.textVideoTitle);
            description=(TextView)itemView.findViewById(R.id.videoDescription);
            progressBar=(ProgressBar)itemView.findViewById(R.id.videoProgressBar);
        }

        void setVideoData(VideoItem videoitem)
        {
            title.setText(videoitem.VideoTitle);
            description.setText(videoitem.VideoDescription);
            videoView.setVideoPath(videoitem.VideoURL);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRation=mp.getVideoWidth()/(float)mp.getVideoHeight();
                    float screenRation=videoView.getWidth()/(float)videoView.getHeight();
                    float scale=videoRation/screenRation;
                    if(scale>=1f)
                    {
                        videoView.setScaleX(scale);
                    }
                    else
                    {
                        videoView.setScaleY(1f/scale);
                    }
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
