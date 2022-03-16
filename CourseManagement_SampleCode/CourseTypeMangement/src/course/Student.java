package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String code;
	private String lastName;
	private String firstName;

	public Student() {
		super();
	}

	public Student(int id, String code, String lastName, String firstName) {
		super();
		this.id = id;
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

	public Student(int id) {
		super();
		this.id = id;
	}

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
			String sql = "insert into student(code, lastName, firstName) " +
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
	
	public void delete()
	{
		try{
			String sql = "delete from student " +
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
	
	public void getStudentByID()
	{
		try{
			String sql = "select code, lastName, firstName from Student " +
						 "where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.code = rs.getString("code");
				this.lastName = rs.getString("lastName");
				this.firstName = rs.getString("firstName");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	
	public static List<Student> getAllStudents()
	{
		List<Student> listStudents = new ArrayList<Student>();
		try{
			String sql = "select id, code, lastName, firstName from Student " +
						 "order by firstName ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			ResultSet rs = psta.executeQuery();
			while(rs.next())
			{
				listStudents.add(new Student(rs.getInt(1), 
								rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
		return listStudents;
	}
	
	//get the list of registered courses 
	public List<Course> getRegisteredCourse(){
		List<Course> registerCourse = new ArrayList<Course>();;
		try{
			String sql = "select std.courseID, c.code, c.name, c.credit, c.courseTypeID " + 
					"from course c, study std " + 
					"where c.id = std.courseID " + 
					"and std.studentID = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			while(rs.next())
			{
				registerCourse.add(new Course(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
		return registerCourse;
	}
	
	//get the list of offered courses 
	public List<Course> getOfferedCourse(){
		List<Course> offerCourse = new ArrayList<Course>();;
		try{
			String sql = " select id, code, name, credit, courseTypeID from course "+
						 "where id not in (" +
						"select std.courseID " + 
						"from study std " + 
						"where std.studentID = ? )";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			while(rs.next())
			{
				offerCourse.add(new Course(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
		return offerCourse;
	}
}
