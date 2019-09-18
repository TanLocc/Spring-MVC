package org.o7planning.hellospringmvc.model;



import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class UserInfor {
	 private int id; 
	   
	   private String username;
       private String mail;
	   private String phone;
	   private String address;
	   private String password;
	   private String role;
	   private CommonsMultipartFile avatar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public CommonsMultipartFile getAvatar() {
		return avatar;
	}
	public void setAvatar(CommonsMultipartFile avatar) {
		this.avatar = avatar;
	}
	
}
