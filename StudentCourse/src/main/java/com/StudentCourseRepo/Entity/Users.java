package com.StudentCourseRepo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String Pasword;
	private String Role;
	private String Status;
	public Users() {}
	public Users(int userid, String username, String pasword, String role, String status) {
		super();
		this.userid = userid;
		this.username = username;
		Pasword = pasword;
		Role = role;
		Status = status;
	}
	public Users(Users obj) {
		this.userid = obj.userid;
		this.username = obj.username;
		this.Pasword = obj.Pasword;
		this.Role = obj.Role;
		this.Status = obj.Status;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", Pasword=" + Pasword + ", Role=" + Role
				+ ", Status=" + Status + "]";
	}
	public int getuserid() {
		return userid;
	}
	public void setuserid(int userid) {
		this.userid = userid;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return Pasword;
	}
	public void setPasword(String pasword) {
		Pasword = pasword;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
}
