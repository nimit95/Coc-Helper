package capstoneproject.androidnanodegree.com.cochelper.fragments;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import capstoneproject.androidnanodegree.com.cochelper.models.Profile;
import capstoneproject.androidnanodegree.com.cochelper.network.GetResponse;
import capstoneproject.androidnanodegree.com.cochelper.R;
import capstoneproject.androidnanodegree.com.cochelper.utils.Constants;

/**
 * Created by dell on 12/12/2016.
 */

public class FileFragment extends Fragment {
    private String result;

    private ImageView leagueBadge;
    private TextView name;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.file_fragment, container, false);
        leagueBadge = (ImageView) view.findViewById(R.id.league_badge);
        name= (TextView) view.findViewById(R.id.name);
        Asy a=new Asy();
        a.execute();
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
            //super.onPostExecute(s);
           // Log.e("ijujnj",s);
            Gson gson = new GsonBuilder().create();
            Profile profile = gson.fromJson(s, Profile.class);

            name.setText(profile.getName());
            Picasso.with(getActivity())
                    .load(profile.getBadge().getIconUrls().getMedium())
                    .into(leagueBadge);
        }
    }
}

