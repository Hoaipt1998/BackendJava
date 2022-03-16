package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.MyConnection;

public class Student {
	
	private int ID;
	private String lastName;
	private String firstName;
	private String gender;
	private String email;
	private String phoneNumber;
	
	public Student() {
		super();
	}
	
	
	
	
	public Student(String lastName, String firstName, String gender, String email, String phoneNumber) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}




	public Student(int iD, String lastName, String firstName, String gender, String email, String phoneNumber) {
		super();
		ID = iD;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}




	public Student(int id) {
		super();
		ID = id;
	}
	
	
	
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void insert()
	{
		try{
			String sql = "insert into student(lastName, firstName, gender, email, phoneNumber) " +
						 "values(?,?,?,?,?) ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.lastName);
			psta.setString(2, this.firstName);
			psta.setString(3, this.gender);
			psta.setString(4, this.email);
			psta.setString(5, this.phoneNumber);
			psta.execute();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public void update()
	{
		try{
			String sql = "update student set lastName = ?, firstName = ? , gender =? , email =?, phoneNumber = ? " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.lastName);
			psta.setString(2, this.firstName);
			psta.setString(3, this.gender);
			psta.setString(4, this.email);
			psta.setString(5, this.phoneNumber);
			psta.setInt(6, this.ID);
			psta.execute();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public void delete()
	{
		try{
			String sql = "delete from student " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.ID);
			psta.execute();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	public static List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = MyConnection.getConnection();
			if(conn != null)
			{
				String sql = "select id, lastName, firstName, gender, email, phoneNumber " +
				 			 "from student " +
				 			 "order by firstName ";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int no = 0;
				while(rs.next())
				{
					list.add(new Student(rs.getInt("id"),rs.getString("last Name"), rs.getString("firstName"), rs.getString("gender"), rs.getString("email"), rs.getString("phoneNumber")));
				}
				rs.close();
				stmt.close();
				conn.close();
			}
		}catch(Exception e) {
			
		}
		return list;
	}
	
	public void getStudentByID()
	{
		try{
			String sql = "select lastName, firstName, gender, email, phoneNumber from student " +
						 "where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.ID);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				
				this.lastName = rs.getString("lastName");
				this.firstName = rs.getString("firstName");
				this.gender = rs.getString("gender");
				this.email = rs.getString("email");
				this.phoneNumber = rs.getString("phoneNumber");

			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
}
