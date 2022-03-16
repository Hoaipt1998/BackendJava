package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.connectiondb;
public class product {

	private int id;
	private String name;
	private String descreption;
	public int getId() {
		return id;
	}
	public product() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public product(int id) {
		this.id = id;
	}
	public int getProdcutTypeID() {
		return id;
	}
	public String getDescreption() {
		return descreption;
	}
	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
	public product(String name, String descreption, int id) {
		this.id=id;
		this.name=name;
		this.descreption=descreption;
	}
	
	public void insert() {
		try {
			
			String sql = "insert into product(id, name, descreption)" + "values(?,?,?)";
			Connection conn = database.connectiondb.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.setString(2,this.name);
			pts.setString(3,this.descreption);
			pts.execute();
			pts.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	public void delete() {
		try {
			String sql = "detele from product"+"where id = ?";
			Connection conn = database.connectiondb.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.execute();
			pts.close();
			conn.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void update() {
		try {
			String sql = "update product set name =?, descreption = ?, id= ? "+ "where id = ?";
			Connection conn = database.connectiondb.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.setString(2,this.name);
			pts.setString(3,this.descreption);
			pts.execute();
			pts.close();
			conn.close();
		}
	catch(Exception e) {
	
			}
	}
	public void GetProductbyID()
	{
		try {
			String sql = " select name, descreption, id from product"+"where id =?";
			Connection conn = database.connectiondb.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			ResultSet rs = pts.executeQuery();
			if(rs.next())
			{
				this.descreption = rs.getString("descreption");
				this.name = rs.getString("name");
				this.id = rs.getInt("id");
			}
			rs.close();
			pts.close();
			conn.close();
	}catch(Exception e) {
		}
	}
}

