package com.connect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.connect.ui.calendar.CalendarFragment;
import com.connect.ui.home.HomeFragment;
import com.connect.ui.profile.ProfileFragment;

public class SlideAdapter extends FragmentPagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    private Fragment[] fragments;

    public SlideAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[] {
                new ProfileFragment(),
                new HomeFragment(),
                new CalendarFragment()
        };
    }



    @Override
    public int getCount() {
        return 3;
    }

//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (RelativeLayout) object;
//    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(fragments[position], container, false);
//
//        container.addView(view);
//        return view;
//    }

//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((Fragment) object);
//    }
}

