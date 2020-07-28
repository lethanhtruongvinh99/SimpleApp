package com.example.reviseapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//update by use Cursor as ArrayList

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<Student> dataSet, filer;
    private Context context;
    private LayoutInflater inflater;

    public StudentAdapter(Context context, ArrayList<Student> obj){
        this.context = context;
        this.dataSet = obj;
        this.filer = obj;
        this.inflater = LayoutInflater.from(context);
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        public TextView name, mssv, nClass, faculty;
        public CardView cardView;
        public StudentViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.name);
            mssv = v.findViewById(R.id.mssv);
            nClass = v.findViewById(R.id.nameofclass);
            faculty = v.findViewById(R.id.faculty);
            cardView = v.findViewById(R.id.card_view);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student st = dataSet.get(position);
        holder.name.setText(st.getName());
        holder.mssv.setText(st.getId());
        holder.nClass.setText(st.getNClass());
        holder.faculty.setText(st.getFaculty());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Click on: " + st.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.item, parent, false);
        return new StudentViewHolder(view);
    }
}
