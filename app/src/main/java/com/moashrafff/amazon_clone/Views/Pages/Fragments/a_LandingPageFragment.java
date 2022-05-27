package com.moashrafff.amazon_clone.Views.Pages.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.moashrafff.amazon_clone.Data.Model.Deal;
import com.moashrafff.amazon_clone.Data.Model.Product;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.ViewModel.ProductViewModel;
import com.moashrafff.amazon_clone.Views.Adapters.HomeCategoryAdapter;
import com.moashrafff.amazon_clone.Views.Adapters.HomeDealsAdapter;
import com.moashrafff.amazon_clone.Views.Adapters.HomeProductAdapter;
import com.moashrafff.amazon_clone.Views.Adapters.SliderAdapter;
import com.moashrafff.amazon_clone.databinding.FragmentLandingPageBinding;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;


public class a_LandingPageFragment extends Fragment {

    private FragmentLandingPageBinding binding;
    private HomeCategoryAdapter adapter;
    private SliderAdapter sliderAdapter;
    private HomeDealsAdapter dealsAdapter;
    private HomeProductAdapter productAdapter;
    private ProductViewModel viewModel;
    private ArrayList<Integer> pictures;

    public a_LandingPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLandingPageBinding.inflate(inflater, container, false);
        pictures = new ArrayList<>();
        View view = binding.getRoot();
        adapter = new HomeCategoryAdapter(requireContext());
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.categoriesRv.setAdapter(adapter);

        sliderAdapter = new SliderAdapter();
        binding.dealsImageSlider.setSliderAdapter(sliderAdapter);
        binding.dealsImageSlider.setIndicatorAnimation(IndicatorAnimationType.DROP);
        binding.dealsImageSlider.setSliderTransformAnimation(SliderAnimations.FANTRANSFORMATION);

        dealsAdapter = new HomeDealsAdapter();
        binding.dealsRv.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.dealsRv.setAdapter(dealsAdapter);
        dealsAdapter.setDeals(fillDealsList());


        productAdapter = new HomeProductAdapter(requireContext());
        binding.productsRv.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.productsRv.setAdapter(productAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewModel.getCategories();
        viewModel.getProducts();
        viewModel.categories.observe(requireActivity(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                adapter.setCategoriesNames(strings);

            }
        });

        viewModel.productsLiveData.observe(requireActivity(), new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                productAdapter.setProducts(products);
            }
        });
    }

    public ArrayList<Deal> fillDealsList(){
        ArrayList<Deal> deals = new ArrayList<>();
        deals.add(new Deal("Up to 50% off", R.drawable.deals_clearence));
        deals.add(new Deal("Kindle E-readers", R.drawable.deal_kendel));
        deals.add(new Deal("Up to 60% off", R.drawable.deals_men_shoes));
        deals.add(new Deal("Your one-stop Coffe store", R.drawable.deal_mienta));
        deals.add(new Deal("Below EGP 95 Kids & Baby", R.drawable.deal_kids));
        deals.add(new Deal("Up to 60% off Eyewear", R.drawable.deal_model));
        return deals;
    }
}