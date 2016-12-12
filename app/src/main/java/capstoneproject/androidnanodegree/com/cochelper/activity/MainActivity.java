package capstoneproject.androidnanodegree.com.cochelper.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import capstoneproject.androidnanodegree.com.cochelper.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // key=AIzaSyAsKOFTWUN1yRGJ3Bd0SoRWCzSNWkybFoU
    }
}
