package com.example.root.surfaceviewdemo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


     VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoview.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();videoview.resume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        videoview.pause();
    }
}
