package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentMapper;
import com.example.model.FakultasModel;
import com.example.model.ProgramStudiModel;
import com.example.model.StudentModel;
import com.example.model.UniversitasModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceDatabase implements StudentService
{
    @Autowired
    private StudentMapper studentMapper;


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
    public void addStudent (StudentModel student)
    {
        studentMapper.addStudent (student);
    }


    @Override
    public void deleteStudent (String npm)
    {
    	log.info("student" + npm+ "deleted");
    	studentMapper.deleteStudent(npm);

    }

	@Override
	public void updateStudent(StudentModel student) {
		// TODO Auto-generated method stub
		log.info("student" +student.getNpm()+ "updated");
		studentMapper.updateStudent(student);
	}


//	@Override
//	public FakultasModel selectFakultas(int id) {
//		// TODO Auto-generated method stub
//		log.info ("select fakultas with id {}", id);
//        return studentMapper.searchFakultas(id);
//	}


	@Override
	public ProgramStudiModel selectProdi(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UniversitasModel selectUniv(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FakultasModel selectFakultas(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
