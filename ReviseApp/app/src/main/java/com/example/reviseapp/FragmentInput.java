package com.example.reviseapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

public class FragmentInput extends Fragment {
    private AppDatabase db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        final EditText name = v.findViewById(R.id.input_name_box);
        final EditText id = v.findViewById(R.id.input_id_box);
        final EditText nClass = v.findViewById(R.id.input_class_box);
        final EditText faculty = v.findViewById(R.id.input_faculty_box);

        db = Room.databaseBuilder(getActivity(), AppDatabase.class, "StudentDataBase")
                .allowMainThreadQueries()
                .build();

        Button confirm_button = v.findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addItem();
                boolean flag = true;
                if (name.getText().toString().trim().length() == 0 || id.getText().toString().trim().length() ==0
                || nClass.getText().toString().trim().length() == 0 || faculty.getText().toString().trim().length() == 0){
                    flag = false;
                    Toast.makeText(getContext(), "Pleae fill in all row", Toast.LENGTH_SHORT).show();
                }
                if (flag){
                    Student tmp = new Student(id.getText().toString(), name.getText().toString(),
                            nClass.getText().toString(), faculty.getText().toString());
                    MainActivity.dataSet.add(tmp);
                    name.getText().clear();
                    id.getText().clear();
                    nClass.getText().clear();
                    faculty.getText().clear();
                    db.studentDAO().insertAll(tmp);
                    Toast.makeText(getContext(), "Succesfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
