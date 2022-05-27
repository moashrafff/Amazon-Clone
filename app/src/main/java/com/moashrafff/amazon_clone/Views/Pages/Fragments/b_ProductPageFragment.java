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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.ViewModel.ProductViewModel;
import com.moashrafff.amazon_clone.Views.Dialogs.CustomToast;
import com.moashrafff.amazon_clone.databinding.FragmentProductPageBinding;

import java.util.ArrayList;

public class b_ProductPageFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    FragmentProductPageBinding binding;
    String[] spinner = { " 1 "," 2 "," 3 "," 4 "," 5 "," 6 "};
    private ProductViewModel viewModel;
    ArrayAdapter aa;
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
        binding.qtySpinner.setOnItemSelectedListener(this);
        binding.addToCartBtn.setOnClickListener(this);
        binding.butNow.setOnClickListener(this);
        aa = new ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,spinner);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.qtySpinner.setAdapter(aa);
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
                binding.productPrice.setText(product.getPrice()+"");
                binding.categoryyTv.setText(product.getCategory());
                binding.descriptionTv.setText(product.getDescription());
            }
        });





    }

    @Override
    public void onClick(View view) {
        CustomToast toast = null;
        switch (view.getId()){
            case R.id.like_btn:
                if (flag) {
                    binding.likeBtn.setImageResource(R.drawable.like_red_icon);
                     toast = new CustomToast(requireContext(),"Item Saved to \nMobile Wishlist");
                    toast.show();
                }else if (flag == false){
                    binding.likeBtn.setImageResource(R.drawable.like_icon);
                     toast = new CustomToast(requireContext(),"Item removed from \nMobile Wishlist");
                    toast.show();
                }
                break;

            case R.id.add_to_cart_btn:
                 toast = new CustomToast(requireContext(),"Added to Cart");
                toast.show();
                break;
            case R.id.but_now:
                toast = new CustomToast(requireContext(),"Buy it Now");
                toast.show();
                break;
        }
        flag = !flag;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(requireContext(),"You picked "+spinner[i] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}