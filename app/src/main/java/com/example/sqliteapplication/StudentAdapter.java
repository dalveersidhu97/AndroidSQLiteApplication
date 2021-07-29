package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter  extends RecyclerView.Adapter<StudentAdapter.Viewholder>{

    private Context context;
    private ArrayList<StudentModel> studentModelArrayList;

    // Constructor
    public StudentAdapter(Context context, ArrayList<StudentModel> studentModelArrayList) {
        this.context = context;
        this.studentModelArrayList = studentModelArrayList;
    }

    // inner ViewHolder class
    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView name, age, contact;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.data_name);
            age = itemView.findViewById(R.id.data_age);
            contact = itemView.findViewById(R.id.data_contact);
        }
    }

    @Override
    public StudentAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card, parent, false);
        return new StudentAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.Viewholder holder, int position) {
        StudentModel model = studentModelArrayList.get(position);
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        holder.contact.setText(model.getContact());
    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }
}
