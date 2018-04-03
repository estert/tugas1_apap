package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;

import com.example.model.FakultasModel;
import com.example.model.StudentModel;
import com.example.model.ProgramStudiModel;
import com.example.model.UniversitasModel;

@Mapper
public interface StudentMapper
{
	@Select ("select * from mahasiswa where npm = #{npm}")
	@Results (value= {
		@Result(property="npm", column="npm"),
		@Result(property="nama",column="nama"),
		@Result(property="tempat_lahir",column="tempat_lahir"),
		@Result(property="tanggal_lahir",column="tanggal_lahir"),
		@Result(property="jenis_kelamin",column="jenis_kelamin"),
		@Result(property="agama",column="agama"),
		@Result(property="golongan_darah",column="golongan_darah"),
		@Result(property="tahun_masuk",column="tahun_masuk"),
		@Result(property="jalur_masuk",column="jalur_masuk"),
		@Result(property="status",column="status"),
		@Result(property="prodi",column="id_prodi", one = @One(select="selectProdi"))}) 
	StudentModel selectStudent (@Param("npm") String npm);
	
    @Select("select * from mahasiswa")
    List<StudentModel> selectAllStudents ();

    @Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk, jalur_masuk, id_prodi) "
    		+ "VALUES (#{npm}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{agama}, #{golongan_darah}, #{status}, #{tahun_masuk}, #{jalur_masuk}, #{id_prodi})")
    void addStudent (@Param("student") StudentModel student);
    
    @Delete("Delete from mahasiswa where npm = #{npm}")
    void deleteStudent (String npm);
    
    @Update("Update mahasiswa set nama=#{nama},npm=#{npm} where npm =#{npm}")
    void updateStudent (StudentModel student);

    @Select("select * from program_studi where id = #{id_prodi}")
    @Results( value = {
    		@Result(property = "id", column = "id"),
            @Result(property = "kode_prodi", column = "kode_prodi"),
            @Result(property = "nama_prodi", column = "nama_prodi"),
            @Result(property = "fakultas", column = "id_fakultas", one = @One(select = "selectFak"))
    })
    ProgramStudiModel selectProdi (@Param("id_prodi") Integer id_prodi);
   
   @Select("select * from fakultas where id = #{id_fakultas}")
   @Results(value = {
		   @Result(property = "id", column ="id"),
		   @Result(property = "kode_fakultas", column ="kode_fakultas"),
		   @Result(property = "nama_fakultas", column ="nama_fakultas"),
			@Result(property="universitas",column="id_univ", one = @One(select="selectUniv"))}) 
		FakultasModel selectFak(@Param("id_fakultas") int id_fakultas);
   
   @Select("select * from universitas where id = #{id_universitas}")
   @Results( value = {
   		@Result(property = "id", column = "id"),
           @Result(property = "kode_univ", column = "kode_univ"),
           @Result(property = "nama_univ", column = "nama_univ")
   })
   UniversitasModel selectUniv (@Param("id_universitas") Integer id_universitas);
}