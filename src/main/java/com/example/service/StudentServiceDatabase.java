package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProgramStudiMapper;
import com.example.dao.StudentMapper;
import com.example.model.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;
    private ProgramStudiMapper prodiMapper;
    

    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("select student with npm {}", npm);
        return studentMapper.selectStudent (npm);
    }


    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("select all students");
        return studentMapper.selectAllStudents ();
    }
    
    @Override
    public void addStudent (StudentModel mahasiswa)
    {
        studentMapper.addStudent (mahasiswa);
    }

    @Override
    public ProgramStudiModel selectProdiNama(Integer id_prodi)
    {
    	log.info ("select prodi_name with id_prodi {}", id_prodi);
        return prodiMapper.selectProdiNama(id_prodi);
    }

    @Override
    public void deleteStudent (String npm)
    {
    	log.info("student "+npm+" deleted");
    	studentMapper.deleteStudent(npm);
    }
    
    @Override
    public void updateStudent (StudentModel student)
    {
    	log.info("update student");
    	studentMapper.updateStudent(student);
    }


	@Override
	public ProgramStudiModel selectProdi(Integer id_prodi) {
		// TODO Auto-generated method stub
        log.info ("select prodi name with id {}", id_prodi);
        return studentMapper.selectProdi(id_prodi);
	}
	


	@Override
	public FakultasModel selectFak(Integer id_fakultas) {
		// TODO Auto-generated method stub
    	log.info ("select fakultas with id {}", id_fakultas);
        return studentMapper.selectFak(id_fakultas);
	}

}