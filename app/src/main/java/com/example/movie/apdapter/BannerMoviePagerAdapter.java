package com.example.movie.apdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.movie.MovieDetail;
import com.example.movie.R;
import com.example.movie.model.MovieBanner;

import java.util.List;

public class BannerMoviePagerAdapter extends PagerAdapter {
    Context context;
    List<MovieBanner> bannerMovielist;

    public BannerMoviePagerAdapter(Context context, List<MovieBanner> bannerMovielist) {
        this.context = context;
        this.bannerMovielist = bannerMovielist;
    }

    @Override
    public int getCount() {
        return bannerMovielist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view  = LayoutInflater.from(context).inflate(R.layout.banner_movie_layout,null);
        ImageView bannerImage = (ImageView) view.findViewById(R.id.banner_image);
        Glide.with(context).load(bannerMovielist.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);
        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MovieDetail.class);
                i.putExtra("id",bannerMovielist.get(position).getId());
                i.putExtra("movieName",bannerMovielist.get(position).getMovieName());
                i.putExtra("imageUrl",bannerMovielist.get(position).getImageUrl());
                i.putExtra("fileUrl",bannerMovielist.get(position).getFileUrl());
                context.startActivity(i);

            }
        });
        return view;
    }
}
