package cl.usm.certamen2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {

    String username = "xkiver";
    String notfound = "Not Found";
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view);

            Intent intent = getIntent();
            final String username = intent.getStringExtra(MainActivity.EXTRA_USERNAME);


            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);



            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(mLayoutManager);

            ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    switch (v.getId()) {

                        //TODO

                    }
                }
            });


            AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

                @Override
                protected void onPreExecute(){

                }

                @Override
                protected String doInBackground(Void... params) {
                    //String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202", 15000);

                    String resultado = new HttpServerConnection().connectToServer("https://api.github.com/users/"+username+"/repos", 15000);
                    return resultado;
                }

                @Override
                protected void onPostExecute(String result) {
                    if(result != null){
                        System.out.println(result);

                        // specify an adapter (see also next example)
                        mAdapter = new UIAdapter(getLista(result));
                        mRecyclerView.setAdapter(mAdapter);


                    }
                }
            };

            task.execute();




    }






    private List<Entry> getLista(String result){
        List<Entry> listaEntries = new ArrayList<Entry>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for(int i = 0; i < size; i++){
                Entry entry = new Entry();
                JSONObject objeto = lista.getJSONObject(i);


                entry.setiD(i);
                entry.setNotfound("message");
                entry.setTitle(objeto.getString("name"));
                entry.setDescription(objeto.getString("description"));
                entry.setUpdate_date(objeto.getString("updated_at"));
                entry.setUrladdress(objeto.getString("html_url"));

                if (entry.getNotfound().isEmpty()){
                    listaEntries.add(entry);
                } else {
                    Intent intent = new Intent(this, NoUserActivity.class);
                    startActivity(intent);
                }


            }
            return listaEntries;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaEntries;
        }
    }
}
