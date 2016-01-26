package com.minras.android.eohpoc.thepoc.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    TabFragmentTrip tabFragmentTrip = new TabFragmentTrip();
    TabFragmentHistory tabFragmentHistory = new TabFragmentHistory();
    TabFragmentSettings tabFragmentSettings = new TabFragmentSettings();
    TabFragmentLogs tabFragmentLogs = new TabFragmentLogs();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return tabFragmentTrip;
            case 1:
                return tabFragmentHistory;
            case 2:
                return tabFragmentSettings;
            case 3:
                return tabFragmentLogs;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Current Trip";
            case 1:
                return "History";
            case 2:
                return "Settings";
            case 3:
                return "Logs";
        }
        return null;
    }
}