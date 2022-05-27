package com.moashrafff.amazon_clone.Views.Pages.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.moashrafff.amazon_clone.R;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.BuyFragment;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.MenuFragment;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.ProfileFragment;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.a_LandingPageFragment;
import com.moashrafff.amazon_clone.Views.Pages.Fragments.b_ProductPageFragment;
import com.moashrafff.amazon_clone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private ActivityMainBinding binding;
    private Fragment landingPageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        landingPageFragment = new a_LandingPageFragment();
        showFragment(landingPageFragment);
        binding.bottomNavView.setOnItemSelectedListener(this);

    }
    private void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.profileFragment:
                showFragment(new ProfileFragment());
                break;
            case R.id.homeFragment:
                showFragment(new a_LandingPageFragment());
                break;
            case R.id.buyFragment:
                showFragment(new BuyFragment());
                break;
            case R.id.menuFragment:
                showFragment(new MenuFragment());
                break;
        }

        return true;
    }
}