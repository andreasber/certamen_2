package cl.usm.certamen2;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cl.usm.certamen2.fragments.MainFragment;

/**
 * Created by Andreas on 04.11.2016.
 */

public class MFragmentManager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.activity_main, mainFragment).commit();
    }
}
