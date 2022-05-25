package com.moashrafff.amazon_clone.Views.Pages.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.a_LandingPageFragment;
import com.moashrafff.amazon_clone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment landingPageFragment = new a_LandingPageFragment();
        showFragment(landingPageFragment);
    }
    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }
}