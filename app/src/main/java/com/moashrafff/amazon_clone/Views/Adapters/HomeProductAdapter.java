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
import com.moashrafff.amazon_clone.Interfaces.OnItemClickListener;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.DealItemBinding;
import com.moashrafff.amazon_clone.databinding.ProductItemBinding;

import java.util.ArrayList;

public class HomeProductAdapter extends RecyclerView.Adapter<HomeProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products = new ArrayList<>();
    private OnItemClickListener listener;

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    public HomeProductAdapter(Context context,OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductViewHolder holder = new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false),listener);
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

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ProductItemBinding binding;
        Product model;
        OnItemClickListener listener;
        public ProductViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            binding = ProductItemBinding.bind(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(Product model) {
            this.model = model;
            binding.productTitle.setText(model.getTitle());
            binding.productPriceTv.setText(model.getPrice()+"");
            Glide.with(context).load(model.getImage()).into(binding.productImageView);

        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(products.get(getAdapterPosition()));
        }
    }


}
