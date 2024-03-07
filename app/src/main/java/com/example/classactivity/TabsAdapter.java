package com.example.classactivity;

//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;

//import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.Nullable;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 :
                ChatFragment cf = new ChatFragment();
                return cf;

            case 1 :
                UpdateFragment uf = new UpdateFragment();
                return uf;

            case 2 :
                CallsFragment caf = new CallsFragment();
                return caf;

            default :
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @androidx.annotation.Nullable
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Chats";
            case 1:
                return "Updates";
            case 2:
                return "Calls";
            default:
                return null;
        }
    }
}
