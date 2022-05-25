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

import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.ViewModel.ProductViewModel;
import com.moashrafff.amazon_clone.Views.Adapters.HomeCategoryAdapter;
import com.moashrafff.amazon_clone.databinding.FragmentLandingPageBinding;

import java.util.ArrayList;


public class a_LandingPageFragment extends Fragment {

    private FragmentLandingPageBinding binding;
    private HomeCategoryAdapter adapter;
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
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewModel.getCategories();
        viewModel.categories.observe(requireActivity(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                adapter.setCategoriesNames(strings);

            }
        });
    }
}