package capstoneproject.androidnanodegree.com.cochelper.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import capstoneproject.androidnanodegree.com.cochelper.network.GetResponse;
import capstoneproject.androidnanodegree.com.cochelper.R;
import capstoneproject.androidnanodegree.com.cochelper.utils.Constants;

/**
 * Created by dell on 12/12/2016.
 */

public class FileFragment extends Fragment {
    private String result;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.file_fragment, container, false);


//        Log.e("dd",result);
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public class Asy extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            GetResponse res= new GetResponse();
            try {
                return res.run(Constants.BASE_URL_PROFILE);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("ijujnj",s);
        }
    }
}

