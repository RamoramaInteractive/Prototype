package com.example.fdai3744.t_online20;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageView;

/**
 * Created by fdai3744 on 07.09.2017.
 */

/*
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    Drawable myDrawable;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                HomeActivity home = new HomeActivity();
                return home;
            case 1:
                PayActivity pay = new PayActivity();
                return pay;
            case 2:
                VideoActivity video = new VideoActivity();
                return video;
            case 3:
                BillActivity bill = new BillActivity();
                return bill;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Pay";
            case 2:
                return "Video";
            case 3:
                return "Bill";
            default:
                return null;
        }
      return "";
    }
}
*/

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                HomeActivity home = new HomeActivity();
                return home;
            case 1:
                PayActivity pay = new PayActivity();
                return pay;
            case 2:
                    RootActivity video = new RootActivity();
                    return video;
            case 3:
                BillActivity bill = new BillActivity();
                return bill;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ""; // This removes the title, as you wish
    }
}