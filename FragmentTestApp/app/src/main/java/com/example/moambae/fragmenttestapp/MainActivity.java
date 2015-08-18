package com.example.moambae.fragmenttestapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout top = (LinearLayout) findViewById(R.id.top);
        LinearLayout lb = (LinearLayout) findViewById(R.id.bottom_left);
        LinearLayout rb = (LinearLayout) findViewById(R.id.bottom_right);
        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fTran = fManager.beginTransaction();
        fTran.replace(R.id.top, new MainActivityFragment());
        fTran.replace(R.id.bottom_left, new MainActivityFragmentLB());
        fTran.replace(R.id.bottom_right, new MainActivityFragmentRB());
        fTran.commit();


       /* fTran = fManager.beginTransaction();
        fTran.addToBackStack(null);
        fTran.add(R.id.frame, new MainActivityFragment());
        fTran.commit();*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
