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
    //public static final int NUM_COUNT=2;
    int tabCount;
    public MyPagerAdapter(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VideoFragment();
            case 1:
                return new FileFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
