package capstoneproject.androidnanodegree.com.cochelper.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nimit Agg on 12-12-2016.
 */

public class Badge {
    private String id;
    private String name;
    private ImageUrl iconUrls;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImageUrl getIconUrls() {
        return iconUrls;
    }

}
