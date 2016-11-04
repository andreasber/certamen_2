package cl.usm.certamen2.presenters;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.usm.certamen2.R;
import cl.usm.certamen2.adapters.UIAdapter;
import cl.usm.certamen2.connection.HttpServerConnection;
import cl.usm.certamen2.fragments.NoUserFragment;
import cl.usm.certamen2.models.Entry;
import cl.usm.certamen2.presenters.contracts.ListPresenter;
import cl.usm.certamen2.views.ListView;

/**
 * Created by Andreas on 04.11.2016.
 */

public class ListPresenterImpl implements ListPresenter {


    private Activity mContext;
    private RecyclerView.LayoutManager mLayoutManager;
    private ListView mListView;

    public ListPresenterImpl(Activity mContext, RecyclerView.LayoutManager mLayoutManager, ListView mListView){
        this.mContext = mContext;
        this.mLayoutManager = mLayoutManager;
        this.mListView = mListView;
    }

    public void inflateList(final RecyclerView recyclerView, final String username) {
        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
            }

            @Override
            protected String doInBackground(Void... voids) {
                String result = new HttpServerConnection().connectToServer("https://api.github.com/users/"+username+"/repos", 15000);
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);

                    // Specify the adapter
                    RecyclerView.Adapter adapter = new UIAdapter(getLista(result), username);
                    recyclerView.setAdapter(adapter);
                }
            }
        };
        task.execute();
    }

    private List<Entry> getLista(String result) {
        List<Entry> listaEntries = new ArrayList<Entry>();
        try{
            JSONArray lista= new JSONArray(result);

            int size = lista.length();
            for (int i = 0; i < size; i++){
                Entry entry = new Entry();
                JSONObject objeto = lista.getJSONObject(i);

                entry.setiD(i);
                entry.setNotfound("message");
                entry.setTitle(objeto.getString("name"));
                entry.setDescription(objeto.getString("description"));
                entry.setUpdate_date(objeto.getString("updated_at"));
                entry.setUrladdress(objeto.getString("html_url"));
                listaEntries.add(entry);
            }
            return listaEntries;
        } catch (JSONException e) {
            System.out.println();
            // Handle if user doesn't exist.
            NoUserFragment noUserFragment = new NoUserFragment();
            FragmentManager fragmentManager = mContext.getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.activity_main, noUserFragment).commit();
            e.printStackTrace();
            return listaEntries;
        }
    }
}



