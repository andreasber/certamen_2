package cl.usm.certamen2.presenters.contracts;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Andreas on 04.11.2016.
 */

public interface ListPresenter {
    public void inflateList(final RecyclerView recyclerView, final String userName);
}
