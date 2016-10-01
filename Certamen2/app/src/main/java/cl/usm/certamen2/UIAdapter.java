package cl.usm.certamen2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by franciscocabezas on 11/20/15.
 */
public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    private List<Entry> mDataset;

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


    public UIAdapter(List<Entry> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public UIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
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

