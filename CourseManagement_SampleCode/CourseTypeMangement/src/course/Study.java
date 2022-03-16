package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Study {
	private int id;
	private int studentID;
	private int courseID;
	private double averageScore;
	
	public Study() {
		super();
	}

	
	public Study(int studentID, int courseID) {
		super();
		this.studentID = studentID;
		this.courseID = courseID;
	}


	public Study(int studentID, int courseID, double averageScore) {
		super();
		this.studentID = studentID;
		this.courseID = courseID;
		this.averageScore = averageScore;
	}


	public Study(int id) {
		super();
		this.id = id;
	}


	public Study(int id, int studentID, int courseID, double averageScore) {
		super();
		this.id = id;
		this.studentID = studentID;
		this.courseID = courseID;
		this.averageScore = averageScore;
	}


	public void insert()
	{
		try{
			String sql = "insert into study(studentID, courseID, averageScore) " +
						 "values(?,?,?) ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.studentID);
			psta.setInt(2, this.courseID);
			psta.setDouble(3, this.averageScore);
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
			String sql = "delete from study " +
						 " where studentID = ? and courseID = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.studentID);
			psta.setInt(2, this.courseID);
			psta.execute();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	
}
