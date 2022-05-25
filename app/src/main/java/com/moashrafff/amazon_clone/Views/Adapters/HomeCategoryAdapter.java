package com.moashrafff.amazon_clone.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.CategoryItemBinding;

import java.util.ArrayList;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder> {


    private ArrayList<String> categoriesNames = new ArrayList<>();
    private ArrayList<Integer> categoriesImages = new ArrayList<>();
    Context context;

    public HomeCategoryAdapter(Context context) {
        this.context = context;
    }

    public void setCategoriesNames(ArrayList<String> categoriesNames) {
        this.categoriesNames = categoriesNames;
        notifyDataSetChanged();
    }

    public void setCategoriesImages(ArrayList<Integer> categoriesImages) {
        this.categoriesImages = categoriesImages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HomeCategoryViewHolder holder = new HomeCategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCategoryViewHolder holder, int position) {
        String categoryName = categoriesNames.get(position);

        holder.bind(categoryName);
    }

    @Override
    public int getItemCount() {
        return categoriesNames.size();
    }

    public class HomeCategoryViewHolder extends RecyclerView.ViewHolder {

        CategoryItemBinding binding;

        public HomeCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CategoryItemBinding.bind(itemView);
        }

        public void bind(String categoryName) {

            binding.categoryNameTv.setText(categoryName);


        }
    }


}
