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
import java.util.List;

import capstoneproject.androidnanodegree.com.cochelper.R;


public class VideoListCursorAdapter extends CursorRecyclerViewAdapter<VideoListCursorAdapter.ViewHolder>{

    public VideoListCursorAdapter(Context context,Cursor cursor){
        super(context,cursor);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(View view) {
            super(view);
           // mTextView = view.findViewById(R.id.text);
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
        //viewHolder.mTextView.setText(myListItem.getName());
    }
}