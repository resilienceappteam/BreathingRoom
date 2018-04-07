package com.gmail.resilianceappteam.village;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

/**
 * Created by callie on 3/30/18.
 */

class TeacherProfilePresenter {
    TeacherProfileView view;


    public interface TeacherProfileView{
        void setData(ArrayList<Student> students);
    }

    public void setView(TeacherProfileView view){
        this.view = view;
    }

    public void getData(){
         getFirestoreStudents();
    }

    public void getFirestoreStudents(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("students")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Student> students = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Student student = document.toObject(Student.class);
                                students.add(student);
                                view.setData(students);
                            }
                        } else {
                            Log.w("TPP", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
