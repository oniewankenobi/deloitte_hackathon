package com.connect;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private SlideAdapter slideAdapter;
    private BottomNavigationView bottomNavView;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        slideAdapter = new SlideAdapter(this);
        slideViewPager.setAdapter(slideAdapter);
        // Sets first page we see to be the home page.
        slideViewPager.setCurrentItem(1);

        // Bottom Navigation View
        bottomNavView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        // Highlights the home page button in nav bar.
        bottomNavView.getMenu().getItem(1).setChecked(true);
        bottomNavView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            // add all the possible navigations.
                            case R.id.navigation_profile:
                                slideViewPager.setCurrentItem(0);
                                item.setChecked(true);
                                break;
                            case R.id.navigation_home:
                                slideViewPager.setCurrentItem(1);
                                item.setChecked(true);
                                break;
                            case R.id.navigation_calendar:
                                slideViewPager.setCurrentItem(2);
                                item.setChecked(true);
                                break;
                        }
                        return false;
                    }
                }
        );


    }

}