package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MovieDetail extends AppCompatActivity {
    ImageView movieImage;
    TextView movieName;
    Button playButton;
    String mName,mImage,mId,mFileUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_movie_detail);
       movieImage = findViewById(R.id.movie_image);
       movieName = findViewById(R.id.movie_name);
       playButton = findViewById(R.id.play_button);
       //Lay data tu intent
        mId = getIntent().getStringExtra("id");
        mName = getIntent().getStringExtra("movieName");
        mImage = getIntent().getStringExtra("imageUrl");
        mFileUrl = getIntent().getStringExtra("fileUrl");
        //Load du lieu vao layout
        Glide.with(this).load(mImage).into(movieImage);
        movieName.setText(mName);
        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MovieDetail.this,VideoPlayerActivity.class);
                i.putExtra("fileUrl",mFileUrl);
                startActivity(i);
            }
        });

    }
}
