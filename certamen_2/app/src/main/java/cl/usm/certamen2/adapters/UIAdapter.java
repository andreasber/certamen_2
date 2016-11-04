package cl.usm.certamen2.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.usm.certamen2.R;
import cl.usm.certamen2.models.Entry;


/**
 * Created by franciscocabezas on 11/20/15.
 */
public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    private List<Entry> mDataset;
    private String username;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mDescription;
        public TextView mUpdatedAt;

        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.txt_repo_title);
            mDescription = (TextView) v.findViewById(R.id.txt_description);
            mUpdatedAt = (TextView) v.findViewById(R.id.txt_update_date);
        }

    }


    public UIAdapter(List<Entry> myDataset, String username) {
        this.mDataset = myDataset;
        this.username = username;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"+username+""));
                v.getContext().startActivity(browserIntent);
            }
        });
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entry libro = mDataset.get(position);

        holder.mTitle.setText(libro.getTitle());
        holder.mDescription.setText(libro.getDescription());
        holder.mUpdatedAt.setText(libro.getUpdate_date());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }





}

