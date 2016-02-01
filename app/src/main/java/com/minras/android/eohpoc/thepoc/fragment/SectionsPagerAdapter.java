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
    TabFragmentUser tabFragmentUser = new TabFragmentUser();
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
                return tabFragmentUser;
            case 4:
                return tabFragmentLogs;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
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
                return "Account";
            case 4:
                return "Logs";
            default:
                return null;
        }
    }
}