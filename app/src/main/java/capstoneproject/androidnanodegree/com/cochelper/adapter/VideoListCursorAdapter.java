package capstoneproject.androidnanodegree.com.cochelper.adapter;

/**
 * Created by Nimit Agg on 12-12-2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import capstoneproject.androidnanodegree.com.cochelper.R;


public class VideoListCursorAdapter extends CursorRecyclerViewAdapter<VideoListCursorAdapter.ViewHolder>{

    private Context context;
    public VideoListCursorAdapter(Context context,Cursor cursor){
        super(context,cursor);
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView headline;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.heading);
            image = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_card, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        //MyListItem myListItem = MyListItem.fromCursor(cursor);
        viewHolder.headline.setText(cursor.getString(cursor.getColumnIndex("title")));
        Picasso.with(context)
                .load(cursor.getString(cursor.getColumnIndex("url")))
                .into(viewHolder.image);
    }
}