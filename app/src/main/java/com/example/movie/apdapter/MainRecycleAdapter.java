package com.example.movie.apdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.R;
import com.example.movie.model.AllCategory;
import com.example.movie.model.CategoryItemList;
import com.example.movie.model.CategoryItemList;

import java.util.List;

public class MainRecycleAdapter extends RecyclerView.Adapter<MainRecycleAdapter.MainViewHoder> {
    Context context;
    List<AllCategory> allCategories;

    public MainRecycleAdapter(Context context, List<AllCategory> allCategories) {
        this.context = context;
        this.allCategories = allCategories;
    }

    @NonNull
    @Override
    public MainViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHoder(LayoutInflater.from(context).inflate(R.layout.main_recycle_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHoder holder, int position) {
        holder.categoryname.setText(allCategories.get(position).getCategoryTitle());
        setItemRecycler(holder.itemRecycler,allCategories.get(position).getCategoryItemList());

    }

    @Override
    public int getItemCount() {
        return allCategories.size();
    }

    public static final class MainViewHoder extends RecyclerView.ViewHolder {
        TextView categoryname;
        RecyclerView itemRecycler ;

        public MainViewHoder(@NonNull View itemView) {
            super(itemView);
            categoryname = itemView.findViewById(R.id.item_category);
            itemRecycler = itemView.findViewById(R.id.item_recycle);
        }
    }
    private void setItemRecycler(RecyclerView recyclerView, List<CategoryItemList> categoryItemsList){
        itemRecycleAdapter itemRecycleAdapter = new itemRecycleAdapter(context,categoryItemsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemRecycleAdapter);
    }
}
