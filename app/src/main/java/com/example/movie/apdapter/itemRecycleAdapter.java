package com.example.movie.apdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.MovieDetail;
import com.example.movie.R;
import com.example.movie.model.CategoryItemList;

import java.util.List;

public class itemRecycleAdapter extends RecyclerView.Adapter<itemRecycleAdapter.ItemViewHoder> {
    Context context;
    List<CategoryItemList> allCategoryItemList;

    public itemRecycleAdapter(Context context, List<CategoryItemList> allCategoryItemList) {
        this.context = context;
        this.allCategoryItemList = allCategoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHoder(LayoutInflater.from(context).inflate(R.layout.cat_recycle_row_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHoder holder, int position) {
        //su dung thu vien glide de flecht anh vao
        Glide.with(context).load(allCategoryItemList.get(position).getImageUrl()).into(holder.itemImage);
        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MovieDetail.class);
                i.putExtra("id",allCategoryItemList.get(position).getId());
                i.putExtra("movieName",allCategoryItemList.get(position).getMovieName());
                i.putExtra("imageUrl",allCategoryItemList.get(position).getImageUrl());
                i.putExtra("fileUrl",allCategoryItemList.get(position).getFileUrl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allCategoryItemList.size();
    }

    public static final class ItemViewHoder extends RecyclerView.ViewHolder{
ImageView itemImage;
        public ItemViewHoder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
