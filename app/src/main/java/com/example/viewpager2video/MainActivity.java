package com.example.viewpager2video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Object VideoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 vidViewPager2=findViewById(R.id.viewPager2);
        List<VideoItem> video=new ArrayList<>();

        VideoItem celebration=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video1.mp4";
        celebration.VideoTitle="Celebration";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(celebration);

        VideoItem party=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video2.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(party);

        VideoItem video3=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video3.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(video3);


        VideoItem video4=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video4.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(party);


        VideoItem video5=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video5.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(video5);

        VideoItem video6=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video6.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(video6);

        VideoItem video7=new VideoItem();
        celebration.VideoURL="https://infinityandroid.com/videos/video7.mp4";
        celebration.VideoTitle="Party";
        celebration.VideoDescription="Celebration of making looking good things";
        video.add(video7);

        vidViewPager2.setAdapter(new VideoAdapter(video));






    }
}