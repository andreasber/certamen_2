package cl.usm.certamen2.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.usm.certamen2.R;
import cl.usm.certamen2.adapters.UIAdapter;
import cl.usm.certamen2.connection.HttpServerConnection;
import cl.usm.certamen2.models.Entry;
import cl.usm.certamen2.presenters.ListPresenterImpl;
import cl.usm.certamen2.presenters.contracts.ListPresenter;
import cl.usm.certamen2.views.ListView;

public class ListViewFragment extends Fragment implements ListView {

    private String username;
    //String notfound = "Not Found";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ListPresenter mListPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mListPresenter = new ListPresenterImpl(getActivity(), mLayoutManager, this);
        mListPresenter.inflateList(mRecyclerView, username);

        return rootView;
    }


    public void setUsername(String username) {
        this.username = username;
    }

}