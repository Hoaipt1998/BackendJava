package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	
	


	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Boolean status;
	private String username;
	private String password;
	
	
	public Admin() {
		super();
	}
	public Admin(String firstName, String lastName, String email, String phone, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public Admin(String firstName, String lastName, String email, String phone, Boolean status, String username,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.username = username;
		this.password = password;
	}
	public Admin(int id, String firstName, String lastName, String email, String phone, Boolean status, String username,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void insert() {
		try {
			
			String sql = "insert into admin (firtName, lastname, email,phone, username,password)" + "values(?,?,?,?,?,?)";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
	
			pts.setString(1,this.firstName);
			pts.setString(2,this.lastName);
			pts.setString(3,this.email);
			pts.setString(4,this.phone);
			pts.setString(5,this.username);
			pts.setString(6,this.password);
			pts.execute();
			pts.close();
			conn.close();
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}


	public static boolean Login(String username, String password) {
		try {
			String sql = "select password from admin " +
					 "where username = ? ";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			ResultSet rs = psta.executeQuery();
			String passwordSaved = "";
			if(rs.next()) {
				passwordSaved = rs.getString("password");
			}
			System.out.print(passwordSaved);
			if(passwordSaved!="" && password.equals(passwordSaved)) {
				return true;
			}
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return false;
	}
}
