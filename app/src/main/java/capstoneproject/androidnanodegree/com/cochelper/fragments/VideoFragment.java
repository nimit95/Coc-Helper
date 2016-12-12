package capstoneproject.androidnanodegree.com.cochelper.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import capstoneproject.androidnanodegree.com.cochelper.R;
import capstoneproject.androidnanodegree.com.cochelper.models.Video;
import capstoneproject.androidnanodegree.com.cochelper.network.YoutubeAPIResponse;

/**
 * Created by dell on 12/12/2016.
 */

public class VideoFragment extends Fragment {
    //public final String TAG=getContext().getClass().getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        new ShowList().execute();
        return view;
    }

   public class ShowList extends AsyncTask<Void,Void,Void>
   {

       @Override
       protected Void doInBackground(Void... voids) {
           YoutubeAPIResponse obj=new YoutubeAPIResponse();
           try {
               String x=obj.run("https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=50&order=viewCount&q=clash of clans&type=video&key=AIzaSyAsKOFTWUN1yRGJ3Bd0SoRWCzSNWkybFoU");
               Log.e("doInBackground:", x );
           } catch (IOException e) {
               e.printStackTrace();
           }

           return null;
       }
   }
}
