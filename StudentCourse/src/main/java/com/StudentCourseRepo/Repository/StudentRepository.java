package com.StudentCourseRepo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.StudentCourseRepo.Entity.Users;

@Repository
public interface StudentRepository extends JpaRepository<Users, Integer>{
	@Query(value = "select * from users where userid=:uid", nativeQuery = true)
	public List<Users> getOneUser(@Param("uid") int UserId);
	@Query(value = "select * from users where status=:status", nativeQuery = true)
	public List<Users> getUserByStatus(@Param("status") String Status);
}