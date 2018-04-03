package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;
import com.example.model.ProgramStudiModel;
import com.example.model.StudentModel;
import com.example.model.UniversitasModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);
    FakultasModel selectFakultas (int id);
    ProgramStudiModel selectProdi(int id);
    UniversitasModel selectUniv(int id);
    
    List<StudentModel> selectAllStudents();

    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
}
