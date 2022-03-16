package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.ConnectionDB;
public class Product {
	private int id;
	public Product(int id, String name, double price,String description, String status, int productType) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.productType = productType;
	}
	public Product(int id) {
		super();
		this.id = id;
		
	}
	private String name;
	private String description;
	private double price;
	private String status;
	private int productType;
	
	public Product() {}
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
	public void setDescreption(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public Product( String name, double price,String description, String status, int productType) {
		super();
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.productType = productType;
	}

	public void insert() {
		try {
			
			String sql = "insert into product(name, price, description,status, productType)" + "values(?,?,?,?,?)";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
	
			pts.setString(1,this.name);
			pts.setDouble(2,this.price);
			pts.setString(3,this.description);
			pts.setString(4,this.status);	
			pts.setInt(5,this.productType);
			pts.execute();
			pts.close();
			conn.close();
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	public void delete() {
		try {
			String sql = "delete from product"+" where id = ?";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setInt(1,this.id);
			pts.execute();
			pts.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void update() {
		try {
			String sql = "update product set name =?, price=?, description = ?, status = ?, productType= ? "+ "where id = ?";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement pts = conn.prepareStatement(sql);
			pts.setString(1,this.name);
			pts.setDouble(2,this.price);
			pts.setString(3,this.description);
			pts.setString(4,this.status);
			pts.setInt(5,this.productType);
			pts.setInt(6,this.id);
			pts.execute();
			pts.close();
			conn.close();
		}
	catch(Exception e) {
		System.out.print(e.getMessage());
			}
	}
	public void getProductTypeID()
	{
		try{
			String sql = "select name, price, description, status, productType from product " +
						 "where id = ? ";
			Connection conn = database.ConnectionDB.getConnection();
			PreparedStatement psta = conn.prepareStatement(sql);
			psta.setInt(1, this.id);
			ResultSet rs = psta.executeQuery();
			if(rs.next())
			{
				this.name = rs.getString("name");
				this.description = rs.getString("description");
				this.price = rs.getDouble("price");
				this.status = rs.getString("status");
				this.productType = rs.getInt("productType");
			}
			rs.close();
			psta.close();
			conn.close();
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
}

