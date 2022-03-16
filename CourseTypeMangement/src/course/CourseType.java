package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.MyConnection;

public class CourseType {
	private int ID;
	private String name;
	private String description;
	public CourseType()
	{
		
	}
	
	public CourseType(int iD) {
		super();
		ID = iD;
	}

	public CourseType(int id, String name, String description) {
		ID = id;
		this.name = name;
		this.description = description;
	}
	public CourseType(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void setID(int id) {
		ID = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void insert()
	{
		try{
			String sql = "insert into coursetype(name, description) " +
						 "values(?,?) ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.name);
			psta.setString(2, this.description);
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
			String sql = "update coursetype set name = ?,  description = ? " +
						 " where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setString(1, this.name);
			psta.setString(2, this.description);
			psta.setInt(3, this.ID);
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
			String sql = "delete from coursetype " +
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
	public void getCourseTypeByID()
	{
		try{
			String sql = "select name, description from coursetype " +
						 "where id = ? ";
			Connection conn = database.MyConnection.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.ID);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.name = rs.getString("name");
				this.description = rs.getString("description");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	public static List<CourseType> getAllCourseTypes(){
		List<CourseType> list = new ArrayList<CourseType>();
		try {
			Connection conn = MyConnection.getConnection();
			if(conn != null)
			{
				String sql = "select id, name, description " +
				 			 "from coursetype " +
				 			 "order by name ";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int no = 0;
				while(rs.next())
				{
					list.add(new CourseType(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
				}
				rs.close();
				stmt.close();
				conn.close();
			}
		}catch(Exception e) {
			
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
