package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import database.ConnectionDB;
public class ProductType {
	
	private int id;
	private String name;
	private double price;
	private String description;
	private String status;
	public ProductType(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		
	}
	public ProductType()
	{
		
	}
	public int getId() {
		return id;
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

	public String getDescreption() {
		return description;
	}
	public void setDescreption(String descreption) {
		this.description = descreption;
	}

	
	
	public void insert() {
		try {
			
			String sql = "insert into productype(id, name, price, descreption,status)" + "values(?,?,?,?,?)";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.setString(2,this.name);
			pts.setString(3,this.description);
			pts.setString(4,this.status);
			pts.setDouble(5,this.price);
			pts.execute();
			pts.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	public void getProductTypeByID()
	{
		try{
			String sql = "select name from producttype " +
						 "where id = ? ";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.name = rs.getString("name");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			
		}
	}
	public void delete() {
		try {
			String sql = "detele from productype"+"where id = ?";
			Connection conn = database.ConnectionDB.getConnection();
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
			String sql = "update productype set name =?, descreption = ?, id= ?, price =?, status=? "+ "where id = ?";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.setString(2,this.name);
			pts.setString(3,this.description);
			pts.setString(4,this.status);
			pts.setDouble(5,this.price);
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
			String sql = " select name, descreption, id, price, status from productype"+"where id =?";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			ResultSet rs = pts.executeQuery();
			if(rs.next())
			{
				this.description = rs.getString("descreption");
				this.name = rs.getString("name");
				this.id = rs.getInt("id");
				this.price = rs.getDouble("price");
				this.status = rs.getString("status");
			}
			rs.close();
			pts.close();
			conn.close();
	}catch(Exception e) {
		}
	}
	
	
	public static List<ProductType> getAllProductTypes(){
		List<ProductType> list = new ArrayList<ProductType>();
		try {
			Connection conn = ConnectionDB.getConnection();
			if(conn != null)
			{
				String sql = "select id, name, description " +
				 			 "from producttype ";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int no = 0;
				while(rs.next())
				{
					list.add(new ProductType(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
				}
				rs.close();
				stmt.close();
				conn.close();
			}
		}catch(Exception e) {
			System.out.print(e.getStackTrace());
		}
		return list;
	}
	
	
	
	
}
