package capstoneproject.androidnanodegree.com.cochelper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import capstoneproject.androidnanodegree.com.cochelper.fragments.FileFragment;
import capstoneproject.androidnanodegree.com.cochelper.fragments.VideoFragment;

/**
 * Created by dell on 12/12/2016.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    public static final int NUM_COUNT=2;

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "Videos";
            default: return "Search";
        }
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VideoFragment();
            case 1:
                return new VideoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_COUNT;
    }
}
