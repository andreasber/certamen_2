package cl.usm.certamen2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_USERNAME = "cl.usm.certamen2.USERNAME";


    EditText editTextUsername;
    Button buttonSearch;
    public String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextUsername = (EditText) findViewById(R.id.edittxt_username);
        buttonSearch = (Button) findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button_search:


                Intent intent = new Intent(this, ListView.class);
                username = editTextUsername.getText().toString();
                intent.putExtra(EXTRA_USERNAME, username);
                startActivity(intent);


        }

    }

}
