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
//        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        slideAdapter = new SlideAdapter(this);
        slideViewPager.setAdapter(slideAdapter);

        // Bottom Navigation View
        bottomNavView = (BottomNavigationView) findViewById(R.id.bottomNavView);
//        appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_profile, R.id.navigation_home, R.id.navigation_calendar
//        ).build();
//        NavController navController = Navigation.findNavController(this, R.id.slideViewPager);
////        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(bottomNavView, navController);

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