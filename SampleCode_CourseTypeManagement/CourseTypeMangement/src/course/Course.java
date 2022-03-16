package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Course {
	private int id;
	private String code;
	private String name;
	private int credit;
	private int courseTypeID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCourseTypeID() {
		return courseTypeID;
	}
	public void setCourseTypeID(int courseTypeID) {
		this.courseTypeID = courseTypeID;
	}
	public Course() {
		super();
	}
	
	public Course(int id) {
		super();
		this.id = id;
	}
	public Course(String code, String name, int credit, int courseTypeID) {
		super();
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.courseTypeID = courseTypeID;
	}
	
	public void insert()
	{
		try{
			String sql = "insert into course(code, name, credit, courseTypeID) " +
						 "values(?,?,?,?) ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.code);
			psta.setString(2, this.name);
			psta.setInt(3, this.credit);
			psta.setInt(4, this.courseTypeID);
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
			String sql = "update course set code = ?,  name = ?, credit = ?, courseTypeID = ? " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.code);
			psta.setString(2, this.name);
			psta.setInt(3, this.credit);
			psta.setInt(4, this.courseTypeID);
			psta.setInt(5, this.id);
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
			String sql = "delete from course " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			psta.execute();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public Course(int id, String code, String name, int credit, int courseTypeID) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.credit = credit;
		this.courseTypeID = courseTypeID;
	}
	public void getCourseByID()
	{
		try{
			String sql = "select code, name, credit, courseTypeID from course " +
						 "where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.code = rs.getString("code");
				this.name = rs.getString("name");
				this.credit = rs.getInt("credit");
				this.courseTypeID = rs.getInt("courseTypeID");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
}
