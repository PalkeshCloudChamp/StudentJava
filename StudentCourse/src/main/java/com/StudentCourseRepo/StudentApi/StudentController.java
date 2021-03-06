package com.StudentCourseRepo.StudentApi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCourseRepo.Entity.Users;
import com.StudentCourseRepo.Repository.StudentRepository;

@RestController
public class StudentController {
	
//	private EntityManager entityManager;
//	CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//	CriteriaQuery cq = cb.createQuery();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private StudentRepository studentRepo;
	private String baseDir = "C:/blazeclan/FormsExpress/DB-testing/Tables/";
	@GetMapping("/users")
	public String getAllUsers() {
		System.out.println(studentRepo.findAll());
		return studentRepo.findAll().toString();
	}
	
	@GetMapping("/student/{userid}")
	public List<Users> OneUser(@PathVariable("userid") int userid) {
		List<Users> obj = studentRepo.getOneUser(userid);
		return obj;
	}
	
	@GetMapping("/user/{cid}")
	public void GetUserByStatus(@PathVariable("cid") int cid) {
		try {
			File dirObj = new File(baseDir+"/"+cid);
			if(!dirObj.exists()) {
				dirObj.mkdir();
			}
			studentRepo.getAllUserFromFeLocal(cid);
			studentRepo.DeleteFeLocalData(cid);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		
		
		
//		
//		List<Users> obj = studentRepo.getUserByStatus(status);
//		try {
//			String dirPath = baseDir + "Users";
//			File dirObj = new File(dirPath);
//			if(!dirObj.exists()) {
//				dirObj.mkdirs();
//			}
//			else {
//				System.out.println("File Already Exist");
//			}
//			String filePath = dirPath+"\\"+status;
//			File fileObj = new File(filePath);
//			if(!fileObj.exists()) {
//				fileObj.createNewFile();
//			}else {
//				System.out.println("File Already Exists.");
//			}
//			
//			obj.forEach(e->{
//				System.out.println(e.toString());
//				String temp = e.toString();
//				System.out.println(temp.indexOf("[") + "  " + temp.indexOf("]"));
//				System.out.println(temp.substring(temp.indexOf("[")+1, temp.indexOf("]")));
//			});
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return obj;
	}
	
	
	@GetMapping("/delete/{cid}")
	public void DeleteUserByStatus(@PathVariable("cid") int cid) {
		try {
			studentRepo.DeleteFeLocalData(cid);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	
	@Transactional
	@GetMapping("/restore/{cid}")
	public void RestoreData(@PathVariable("cid") int cid) {
		System.out.println("Status Value:- " + baseDir +cid);
		String[] table_names = new String[]{
				"payment_transaction","payment_method","user_account","user_additional_emails","cached_notice"
				,"user_notices","email_log","account_logs","user_request_permission", "customer_request_permission","customer_notice_permission"
				,"customer_product","customer_report","request",
//				"user_sites_config_list_view",
				"list_report","job_proof_details","job_xref_files"
				,"job_xref_message",
//				"job_xref_instruction",
				"job_xref_extraction","job_xref_email","job_xref_proofs_specific","job_detail","enotices_job",
				"enotices_document","email_job_queue","customer","user","payment_schedule","payment_history"
		};
		System.out.println(table_names.length);
//		LOAD DATA INFILE 'C:/blazeclan/FormsExpress/DB-testing/Tables/Users/status' into table users fields terminated by ',';
		String starting_of_query = "LOAD DATA INFILE ";
		String end_of_query = " fields terminated by ',';";
		for(String table : table_names) {
			String table_file_path = baseDir+cid+"/"+table+".csv";
			String final_query = starting_of_query+"'"+table_file_path+"' into table `fe-local`." + table+end_of_query;
			System.out.println("Query for table "+table+":- "+final_query);
			entityManager.createNativeQuery(final_query).executeUpdate();
		}
//		entityManager.createNativeQuery(baseDir);
//		try {
//			studentRepo.RestoreFeLocalData(cid);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
		
	}
	
	@PostMapping("/student")
	public void AddUser(@RequestBody Users user) {
		System.out.println("The user body:-"+user);	
		Users us = new Users();
		Users us2 = new Users(user);
		us.setuserid(102);
		us.setusername("Monu");
		us.setPasword("Sarcastic");
		us.setRole("Student");
		us.setStatus("Active");
//		studentRepo.save(us);	
		System.out.println(us.getPasword() + us.getStatus() + us.getRole());
		System.out.println(us);
//		studentRepo.save(us);
		System.out.println(us2);
	}
	
	@GetMapping("/bucket/{cid}")
	public String BucketInfo(@PathVariable("cid") int cid) {
		ExportInformation ei = new ExportInformation();
		return ei.UploadToS3(cid);
	}
	
	
	@GetMapping("/presignedBucket/{cid}")
	public void UploadUsingPresigned(@PathVariable("cid") int cid) {
		PresignedUrlUpload ei = new PresignedUrlUpload();
//		return ei.UploadToS3(cid);
	}
	
	
	
//	Calling all the queries of fe-local database from here.
	
	
	
	
	
	
	
	
	
	
}
