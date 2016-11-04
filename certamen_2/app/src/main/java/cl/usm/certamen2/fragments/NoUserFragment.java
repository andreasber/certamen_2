package cl.usm.certamen2.fragments;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.usm.certamen2.R;
import cl.usm.certamen2.views.NoUserView;

public class NoUserFragment extends Fragment implements NoUserView {

    public NoUserFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_no_user, container, false);
        return rootView;
    }
}
