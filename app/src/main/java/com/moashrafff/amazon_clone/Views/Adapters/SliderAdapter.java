package com.moashrafff.amazon_clone.Views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.amazon_clone.Data.Model.DealsBoarding;
import com.moashrafff.amazon_clone.Data.Source.Local.DealsSliderData;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.DealsBoardItemBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.MyHolder> {

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_board_item,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder viewHolder, int position) {
        DealsBoarding slide = DealsSliderData.slides[position];
        viewHolder.bind(slide);
    }

    @Override
    public int getCount() {
        return DealsSliderData.slides.length;
    }


    public class MyHolder extends SliderViewAdapter.ViewHolder {

        DealsBoardItemBinding binding;
        DealsBoarding slide;
        public MyHolder(View itemView) {
            super(itemView);
            binding = DealsBoardItemBinding.bind(itemView);
        }
        public void bind(DealsBoarding slide) {
            this.slide = slide;
            binding.boardImg.setImageResource(slide.getBoarding_img());
        }
    }
}
