package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.CourseType;
import database.MyConnection;

public class Student {
	
	private int ID;
	private String code;
	private String lastName;
	private String firstName;
	
	public Student() {
		super();
	}
	
	
	public Student(int id) {
		super();
		ID = id;
	}
	
	

	public Student(int iD, String code, String lastName, String firstName) {
		super();
		ID = iD;
		this.code = code;
		this.lastName = lastName;
		this.firstName = firstName;
	}


	public Student(String code, String lastName, String firstName) {
		super();
		this.code = code;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		ID = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	public void insert()
	{
		try{
			String sql = "insert into student(code, firstName, lastName) " +
						 "values(?,?,?) ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.code);
			psta.setString(2, this.lastName);
			psta.setString(3, this.firstName);
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
			String sql = "update student set code = ?,  firstName = ?, lastName = ? " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.code);
			psta.setString(2, this.lastName);
			psta.setString(3, this.firstName);
			psta.setInt(4, this.ID);
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
				String sql = "select id, code, firstName, lastName " +
				 			 "from student " +
				 			 "order by firstName ";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int no = 0;
				while(rs.next())
				{
					list.add(new Student(rs.getInt("id"),rs.getString("code"), rs.getString("firstName"), rs.getString("lastName")));
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
			String sql = "select code, firstName, lastName from student " +
						 "where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.ID);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.code = rs.getString("code");
				this.firstName = rs.getString("firstName");
				this.lastName = rs.getString("lastName");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
}
