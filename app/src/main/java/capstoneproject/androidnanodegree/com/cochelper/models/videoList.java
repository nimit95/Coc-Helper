package capstoneproject.androidnanodegree.com.cochelper.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dell on 12/12/2016.
 */

public class VideoList {
    @SerializedName("items")
    private List<Video> vidList;

    public List<Video> getVidList() {
        return vidList;
    }
}
