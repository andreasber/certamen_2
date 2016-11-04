package cl.usm.certamen2.fragments;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import cl.usm.certamen2.R;
import cl.usm.certamen2.presenters.MainPresenterImpl;
import cl.usm.certamen2.presenters.contracts.MainPresenter;
import cl.usm.certamen2.views.MainView;


public class MainFragment extends Fragment implements MainView {

    //public final static String EXTRA_USERNAME = "cl.usm.certamen2.USERNAME";


    EditText editTextUsername;
    Button buttonSearch;


    private MainPresenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        buttonSearch = (Button)rootView.findViewById(R.id.button_search);
        editTextUsername = (EditText)rootView.findViewById(R.id.edittxt_username);

        this.mPresenter = new MainPresenterImpl(getActivity(), this);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPresenter.onClicked();
            }
        });
        return rootView;
    }

    @Override
    public String getText(){
        return editTextUsername.getText().toString();
    }


}
