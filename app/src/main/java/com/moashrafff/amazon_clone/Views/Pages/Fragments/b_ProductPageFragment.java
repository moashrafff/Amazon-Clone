package com.moashrafff.amazon_clone.Views.Pages.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.databinding.FragmentProductPageBinding;

public class b_ProductPageFragment extends Fragment {


    FragmentProductPageBinding binding;

    public b_ProductPageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductPageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}