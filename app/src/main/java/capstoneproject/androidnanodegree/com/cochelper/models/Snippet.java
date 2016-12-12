package capstoneproject.androidnanodegree.com.cochelper.models;

/**
 * Created by dell on 12/12/2016.
 */

public class Snippet {
    private String title;
    private String description;
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public String getDescription() {
        return description;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    private Thumbnails thumbnails;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
