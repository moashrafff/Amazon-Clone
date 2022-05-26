package com.moashrafff.amazon_clone.Views.Pages.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.ViewModel.ProductViewModel;
import com.moashrafff.amazon_clone.Views.Dialogs.CustomToast;
import com.moashrafff.amazon_clone.databinding.FragmentProductPageBinding;

import java.util.ArrayList;

public class b_ProductPageFragment extends Fragment implements View.OnClickListener {


    FragmentProductPageBinding binding;
    private ProductViewModel viewModel;
    boolean flag = true ;

    public b_ProductPageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductPageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.likeBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewModel.getProducts();
        viewModel.productsLiveData.observe(requireActivity(), new Observer<Product>() {
            @Override
            public void onChanged(Product product) {
                Glide.with(requireContext()).load(product.getImage()).into(binding.PRODUCTImage);
                binding.productTitle.setText(product.getTitle());
                binding.ratingNumberTv.setText(product.getRating().getCount()+"");
                binding.ratingBar.setMax(5);
                binding.ratingBar.setRating((float)product.getRating().getRate());
            }
        });





    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.like_btn:
                if (flag) {
                    binding.likeBtn.setImageResource(R.drawable.like_red_icon);
                    CustomToast toast = new CustomToast(requireContext(),"Item Saved to \nMobile Wishlist");
                    toast.show();
                }else if (flag == false){
                    binding.likeBtn.setImageResource(R.drawable.like_icon);
                    CustomToast toast = new CustomToast(requireContext(),"Item removed from \nMobile Wishlist");
                    toast.show();
                }
                break;
        }
        flag = !flag;
    }
}