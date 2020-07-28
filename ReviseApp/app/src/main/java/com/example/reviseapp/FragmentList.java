package com.example.reviseapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {
    private ArrayList<Student> dataSet = new ArrayList<>();
    private RecyclerView recyclerView;
    private StudentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        AppDatabase db = Room.databaseBuilder(getActivity(), AppDatabase.class, "StudentDataBase")
                .allowMainThreadQueries()
                .build();
        List<Student> students = db.studentDAO().getAllStudent();
        Toast.makeText(getActivity(), "size of DB: " + students.size(), Toast.LENGTH_SHORT).show();

        ArrayList<Student> dataSet = converToArrList(students);

        recyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        adapter = new StudentAdapter(getActivity(), dataSet);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }
    public ArrayList<Student> converToArrList(List<Student> src){
        ArrayList<Student> res = new ArrayList<>();
        for (int i = 0; i < src.size(); i++){
            Student tmp = new Student(src.get(i).getId(), src.get(i).getName(),
                    src.get(i).getNClass(), src.get(i).getFaculty());
            res.add(tmp);
        }
        return res;
    }
}
