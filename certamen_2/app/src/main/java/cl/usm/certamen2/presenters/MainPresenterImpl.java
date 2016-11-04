package cl.usm.certamen2.presenters;

import android.app.Activity;
import android.app.FragmentManager;

import cl.usm.certamen2.R;
import cl.usm.certamen2.fragments.ListViewFragment;
import cl.usm.certamen2.presenters.contracts.MainPresenter;
import cl.usm.certamen2.views.MainView;

/**
 * Created by Andreas on 04.11.2016.
 */

public class MainPresenterImpl implements MainPresenter {

    private Activity mContext;
    private MainView mMainView;

    public MainPresenterImpl(Activity mContext, MainView mMainView){
        this.mContext = mContext;
        this.mMainView = mMainView;
    }

    public void onClicked(){
        ListViewFragment listFragment = new ListViewFragment();
        listFragment.setUsername(mMainView.getText());
        FragmentManager fragmentManager = mContext.getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_main, listFragment).commit();
    }

}
