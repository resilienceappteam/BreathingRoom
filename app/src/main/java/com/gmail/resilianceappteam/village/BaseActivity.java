package com.gmail.resilianceappteam.village;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent nextIntent = new Intent();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    nextIntent.setClass(getApplicationContext(), TeacherProfileActivity.class);
                    startActivity(nextIntent);
                    Log.d("cew", "home");
                    return true;
                case R.id.navigation_profile:

                    Log.d("cew", "profile");
                    return true;
                case R.id.navigation_roster:
                    nextIntent.setClass(getApplicationContext(), StudentActivity.class);
                    startActivity(nextIntent);
                    Log.d("cew", "roster");
                    return true;
                case R.id.navigation_incident_report:
                    nextIntent.setClass(getApplicationContext(), TeacherProfileActivity.class);
                    startActivity(nextIntent);
                    Log.d("cew", "ir");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
