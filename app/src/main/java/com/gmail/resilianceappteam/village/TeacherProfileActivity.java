package com.gmail.resilianceappteam.village;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class TeacherProfileActivity extends AppCompatActivity implements TeacherProfilePresenter.TeacherProfileView{

    RecyclerView teacherProfile_rv;
    StudentsAdapter adapter;
    TeacherProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        teacherProfile_rv = findViewById(R.id.teacher_profile_rv);
        presenter = new TeacherProfilePresenter();
        presenter.setView(this);
        adapter = new StudentsAdapter(this);
        presenter.getData();

        teacherProfile_rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setData(ArrayList<Student> students) {
        adapter.setData(students);
        teacherProfile_rv.setAdapter(adapter);

    }
}
