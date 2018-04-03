package com.example.service;

import java.util.List;

import com.example.model.FakultasModel;
import com.example.model.ProgramStudiModel;
import com.example.model.StudentModel;
import com.example.model.UniversitasModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);
    
    ProgramStudiModel selectProdi (Integer id_prodi);
    
    FakultasModel selectFak (Integer id_fakultas);
    
   // String selectNpm (String npm);

    List<StudentModel> selectAllStudents ();

    void addStudent (StudentModel student);

    void deleteStudent (String npm);
    
    void updateStudent (StudentModel student);
    
    ProgramStudiModel selectProdiNama (Integer id_prodi); 
    
}
