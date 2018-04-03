package com.example.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.StudentModel;
import com.example.model.ProgramStudiModel;
import com.example.model.FakultasModel;
import com.example.model.UniversitasModel;

import com.example.service.StudentService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StudentController
{
    @Autowired
    StudentService studentDAO;
    @RequestMapping("/")
    public String index ()
    {
        return "home";
    }

    @RequestMapping("/student/add")
    public String add ()
    {
        return "form-add";
    }

    @RequestMapping("/student/add/submit")
    public String addSubmit (
    		@RequestParam(value = "id", required = false) int id,
    		@RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "nama", required = false) String nama,
    		@RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
    		@RequestParam(value = "tanggal_lahir", required = false) Date tanggal_lahir,
    		@RequestParam(value = "jenis_kelamin", required = false) int jenis_kelamin,
    		@RequestParam(value = "agama", required = false) String agama,
    		@RequestParam(value = "golongan_darah", required = false) String golongan_darah,
    		@RequestParam(value = "status", required = false) String status,
    		@RequestParam(value = "tahun_masuk", required = false) String tahun_masuk,
    		@RequestParam(value = "jalur_masuk", required = false) String jalur_masuk,
            @RequestParam(value = "id_prodi", required = false) int id_prodi)
    
    {
        StudentModel student = new StudentModel (id, npm, nama, tempat_lahir,tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi);
        studentDAO.addStudent (student);
        return "success-add";
    }

    @RequestMapping("/student/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);
        if (student != null) {
            model.addAttribute ("student", student);
            return "viewStudent";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/viewall")
    public String view (Model model)
    {
    	log.info("Test");
        List<StudentModel> students = studentDAO.selectAllStudents();
        model.addAttribute ("students", students);
        return "viewall";
    }

    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
        studentDAO.deleteStudent (npm);
        StudentModel student = studentDAO.selectStudent(npm);
        if (student != null) {
        	model.addAttribute("student",student);
        	return "not-found";
        }else {
        	model.addAttribute("npm", npm);
        	return "delete";
        }
    }
    @RequestMapping("/student/update/{npm}")
    public String UpdateSubmit (Model model, @PathVariable (value="npm")String npm){
    	StudentModel student = studentDAO.selectStudent(npm);
    	if (student != null) {
    		//StudentModel student = new StudentModel (npm, name, gpa);
    		model.addAttribute("student", student);
    		return "form-update";
    		}else {
    			model.addAttribute("npm", npm);
    			return "not-found";
    		}
    }
    
    @RequestMapping(value="/student/update/submit", method = RequestMethod.POST)
    public String updateSubmit(
    		@RequestParam(value = "id", required = false) int id,
    		@RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "nama", required = false) String nama,
    		@RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
    		@RequestParam(value = "tanggal_lahir", required = false) Date tanggal_lahir,
    		@RequestParam(value = "jenis_kelamin", required = false) int jenis_kelamin,
    		@RequestParam(value = "agama", required = false) String agama,
    		@RequestParam(value = "golongan_darah", required = false) String golongan_darah,
    		@RequestParam(value = "status", required = false) String status,
    		@RequestParam(value = "tahun_masuk", required = false) String tahun_masuk,
    		@RequestParam(value = "jalur_masuk", required = false) String jalur_masuk,
            @RequestParam(value = "id_prodi", required = false) int id_prodi)
    {
    	StudentModel student = new StudentModel (id, npm, nama, tempat_lahir,tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi);
    	studentDAO.updateStudent(student);
    	return "success-update";
    }
}
