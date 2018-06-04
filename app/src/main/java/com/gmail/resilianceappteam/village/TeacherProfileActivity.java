package com.gmail.resilianceappteam.village;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class TeacherProfileActivity extends AppCompatActivity implements TeacherProfilePresenter.TeacherProfileView{

    RecyclerView teacherProfile_rv;
    StudentsAdapter adapter;
    TeacherProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        teacherProfile_rv = findViewById(R.id.teacher_profile_rv);
        presenter = new TeacherProfilePresenter();
        presenter.setView(this);
        adapter = new StudentsAdapter(this);
        teacherProfile_rv.setLayoutManager(new LinearLayoutManager(this));
        teacherProfile_rv.setAdapter(adapter);
        presenter.getData();
    }

    @Override
    public void setData(ArrayList<Student> students) {
        adapter.setData(students);
    }

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
//                    nextIntent.setClass(getApplicationContext(), StudentActivity.class);
//                    startActivity(nextIntent);
                    Log.d("cew", "profile");
                    return true;
                case R.id.navigation_roster:
//                    nextIntent.setClass(getApplicationContext(), StudentActivity.class);
//                    startActivity(nextIntent);
                    Log.d("cew", "roster");
                    return true;
                case R.id.navigation_incident_report:
                    nextIntent.setClass(getApplicationContext(), StudentActivity.class);
                    startActivity(nextIntent);
                    Log.d("cew", "ir");
                    return true;
            }
            return false;
        }
    };


}
