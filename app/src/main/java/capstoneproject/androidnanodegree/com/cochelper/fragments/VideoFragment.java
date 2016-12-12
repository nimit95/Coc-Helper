package capstoneproject.androidnanodegree.com.cochelper.fragments;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import capstoneproject.androidnanodegree.com.cochelper.R;
import capstoneproject.androidnanodegree.com.cochelper.database.DatabseColumns;
import capstoneproject.androidnanodegree.com.cochelper.database.QuoteProvider;
import capstoneproject.androidnanodegree.com.cochelper.models.Profile;
import capstoneproject.androidnanodegree.com.cochelper.models.Video;
import capstoneproject.androidnanodegree.com.cochelper.models.VideoList;
import capstoneproject.androidnanodegree.com.cochelper.network.YoutubeAPIResponse;
import capstoneproject.androidnanodegree.com.cochelper.utils.Constants;


public class VideoFragment extends Fragment {
    //public final String TAG=getContext().getClass().getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        new ShowList().execute();
        return view;
    }

   public class ShowList extends AsyncTask<Object, Object, String>
   {

       @Override
       protected String doInBackground(Object... voids) {
           YoutubeAPIResponse obj=new YoutubeAPIResponse();
           try {
               String x=obj.run(Constants.YOUTUBE_QUERY_URL);
               //Log.e("doInBackground:", x );
               return x;
           } catch (IOException e) {
               e.printStackTrace();
           }

           return null;
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);
           Gson gson = new GsonBuilder().create();

           VideoList videoList = gson.fromJson(s, VideoList.class);

           ArrayList<ContentProviderOperation> batchOperations = new ArrayList<>(videoList.getVidList().size());

           for (Video planet : videoList.getVidList()){
               ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(
                       QuoteProvider.Quotes.CONTENT_URI);
               builder.withValue(DatabseColumns.VIDEOID, planet.getId().getVideoId());
               builder.withValue(DatabseColumns.DESCRIPTION, planet.getSnippet().getDescription());
               builder.withValue(DatabseColumns.TITLE, planet.getSnippet().getTitle());
               builder.withValue(DatabseColumns.URL, planet.getSnippet().getThumbnails().getDef().getUrl());
               batchOperations.add(builder.build());
           }

           try{
               getActivity().getContentResolver().applyBatch(QuoteProvider.AUTHORITY, batchOperations);
           } catch(RemoteException | OperationApplicationException e){
               Log.d("database", "Error applying batch insert", e);
           }
           //Log.d("uhuh", "onPostExecute: " + videoList.getVidList().get(0).getSnippet().getTitle());
       }
   }
}
