package com.moashrafff.amazon_clone.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moashrafff.amazon_clone.Data.Model.Deal;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.DealItemBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeDealsAdapter extends RecyclerView.Adapter<HomeDealsAdapter.DealsViewHolder> {

    private List<Deal> deals = new ArrayList<>();
    Context context;

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DealsViewHolder holder = new DealsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DealsViewHolder holder, int position) {
        Deal model = deals.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

    public class DealsViewHolder extends RecyclerView.ViewHolder {

        DealItemBinding binding;
        Deal model;
        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DealItemBinding.bind(itemView);
        }

        public void bind(Deal model) {
            this.model = model;
            binding.dealTextTv.setText(model.getDealText());
            binding.dealImageIv.setImageResource(model.getDealImage());

        }
    }
}
