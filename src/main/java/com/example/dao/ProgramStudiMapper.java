package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.example.model.StudentModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

@Mapper
public class ProgramStudiMapper {
//	@Select("select * from mahasiswa where kode_prodi = #{kode_prodi}")
//    List<StudentModel> selectProdiByStudent (@Param("kode_prodi") String kode_prodi);
//	
//	@Select("select * from program_studi where id_prodi = #{id_prodi}")
//	@Results(value = {
//			@Result(property="kode_univ", column="kode_univ"),
//			@Result(property="kode_prodi", column="kode_prodi"),
//			@Result(property="nama_prodi", column="nama_prodi"),
//			@Result(property="univ", column="kode_univ",
//				javaType = UniversitasModel.class,
//				many=@Many(select="searchUniversitas")),
//			@Result(property="Dosen", column="kode_prodi",
//				javaType = List.class,
//				many=@Many(select="selectProdiByDosen"))
//	}) ProgramStudiModel searchProgramStudi (@Param("id_prodi") String kode_prodi);

}
