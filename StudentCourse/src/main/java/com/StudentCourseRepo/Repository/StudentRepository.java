package com.StudentCourseRepo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.StudentCourseRepo.Entity.Users;

@Repository
public interface StudentRepository extends JpaRepository<Users, Integer>{
	String basePath = "C:/blazeclan/Spring/StudentCourse/target/TestTables/";
	@Query(value = "select * from users where userid=:uid", nativeQuery = true)
	public List<Users> getOneUser(@Param("uid") int UserId);
	
//	For Creating the file.
	@Query(value = "select * from users where status= :status into outfile 'C:/blazeclan/FormsExpress/DB-testing/Tables/Users/status' FIELDS TERMINATED BY ','", nativeQuery = true)
//	@Query(value="select * from users where status=:status",nativeQuery = true)
	public List<Users> getUserByStatus(@Param("status") String Status);
	
//	Loading file and restoring into database.
//	@Query(value="LOAD data infile '"+filePath+":cid' into table user field terminated by ',';",nativeQuery = true)
//	
//	Earlier directory path:-  C:/blazeclan/Spring/StudentCourse/target/TestTables/status
//	
//	
	@Query(value = "call `fe-local`.`EN-5723-Backup`(:cid)", nativeQuery = true)
	public void getAllUserFromFeLocal(@Param("cid") int cid);


    @Modifying
//    @Transactional
	@Query(value = "call `fe-local`.`EN-5723-Restore`(:cid)", nativeQuery = true)
	public void RestoreFeLocalData(@Param("cid") int cid);
    


    @Modifying
    @Transactional
	@Query(value = "call `fe-local`.`EN-5723-Delete`(:cid)", nativeQuery = true)
	public void DeleteFeLocalData(@Param("cid") int cid);
    
    
    
	
    @Modifying
    @Transactional
	@Query(value="LOAD DATA INFILE 'C:/blazeclan/FormsExpress/DB-testing/Tables/Users/status' into table users fields terminated by ','",nativeQuery = true)
	public void RestoreData(@Param("status") String Status);
}
//@Query(value = "Select * from User where Customer_Id = :cid INTO OUTFILE '"+filePath+":cid' FIELDS TERMINATED BY ',';", nativeQuery = true)