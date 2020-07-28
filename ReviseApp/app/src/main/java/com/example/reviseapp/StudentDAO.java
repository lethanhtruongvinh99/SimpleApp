package com.example.reviseapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDAO {
    @Query("SELECT * FROM student")
    List<Student> getAllStudent();

    @Query("SELECT col_id FROM student")
    List<String> getListID();

    @Insert
    void insertAll(Student... students);

}
