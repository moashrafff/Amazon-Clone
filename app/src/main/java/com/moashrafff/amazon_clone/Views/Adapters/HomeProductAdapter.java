package com.moashrafff.amazon_clone.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moashrafff.amazon_clone.Data.Model.Deal;
import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.DealItemBinding;
import com.moashrafff.amazon_clone.databinding.ProductItemBinding;

import java.util.ArrayList;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public HomeProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductViewHolder holder = new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product model = products.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        ProductItemBinding binding;
        Product model;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ProductItemBinding.bind(itemView);
        }

        public void bind(Product model) {
            this.model = model;
            binding.productTitle.setText(model.getTitle());
            binding.productPriceTv.setText(model.getPrice()+"");
            Glide.with(context).load(model.getImage()).into(binding.productImageView);

        }
    }


}
