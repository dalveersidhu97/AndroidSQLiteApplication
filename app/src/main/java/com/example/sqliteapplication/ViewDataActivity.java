package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {

    RecyclerView studentRecycler;
    TextView heading;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        heading = findViewById(R.id.view_data_heading);

        ArrayList<StudentModel> studentsList = getStudentList();

        if(studentsList.size() == 0)
            heading.setText("No data!");
        else{
            // Recycler view
            studentRecycler = findViewById(R.id.student_recycler);
            StudentAdapter studentAdapter = new StudentAdapter(this, studentsList);
            studentRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            studentRecycler.setAdapter(studentAdapter);
        }

    }

    public ArrayList<StudentModel> getStudentList(){

        Cursor res = new DBHelper(this).getdata();
        ArrayList<StudentModel> studentsList = new ArrayList<>();

        while(res.moveToNext()){
            StudentModel student = new StudentModel();
            student.setName(res.getString(0));
            student.setAddress(res.getString(1));
            student.setAge(res.getString(2));
            studentsList.add(student);
        }
        return studentsList;
    }

}