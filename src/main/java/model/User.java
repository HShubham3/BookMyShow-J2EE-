package model;

public class User {
	
	private String id;
	private String fname;
	private String uname;
	private String email;
	private String phone;
	private String date;
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
//		System.out.println(fname+"fname");
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getUname() {
//		System.out.println(uname+"uname");
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getEmail() {
//		System.out.println(email+"email");
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
//		System.out.println(phone+"phone");
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

}
