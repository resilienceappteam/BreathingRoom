package com.gmail.resilianceappteam.village;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by callie on 3/30/18.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    ArrayList<Student> students;
    Context context;
    LayoutInflater inflater;

    public StudentsAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate a view
        View mItemView = inflater.inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(mItemView);
    }

    public void setData(ArrayList<Student> students){
       this.students = students;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student currentStudent = students.get(position);
        holder.setStudent(currentStudent);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button studentButton;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentButton = itemView.findViewById(R.id.student_name);
            studentButton.setText("Student Name Coming from Studen View Holder");
            studentButton.setOnClickListener(this);
        }

        public void setStudent(Student student){
            studentButton.setText(student.getName());
            studentButton.setBackgroundColor(student.getColor());
        }

        @Override
        public void onClick(View itemView) {
            Intent intent = new Intent(context, StudentActivity.class);
            context.startActivity(intent);
        }
    }
}
