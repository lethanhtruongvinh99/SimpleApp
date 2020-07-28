package com.example.reviseapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int i;

    @ColumnInfo(name = "col_id")
    private String id;

    @ColumnInfo(name = "col_name")
    private String name;

    @ColumnInfo(name = "col_class")
    private String nClass;

    @ColumnInfo(name = "col_faculty")
    private String faculty;

    public Student(String id, String name, String nClass, String faculty){
        this.id = id;
        this.name = name;
        this.nClass = nClass;
        this.faculty = faculty;
    }

    public int getI(){
        return i;
    }

    public void setI(int ia){
        this.i = ia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNClass() {
        return nClass;
    }

    public void setNClass(String nClass) {
        this.nClass = nClass;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
