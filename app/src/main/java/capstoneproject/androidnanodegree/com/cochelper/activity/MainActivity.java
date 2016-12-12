package capstoneproject.androidnanodegree.com.cochelper.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import capstoneproject.androidnanodegree.com.cochelper.R;
import capstoneproject.androidnanodegree.com.cochelper.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        // key=AIzaSyAsKOFTWUN1yRGJ3Bd0SoRWCzSNWkybFoU

    }
}
