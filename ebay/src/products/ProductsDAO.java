package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import products.Product;

public class ProductsDAO {
	
	public static Product selectProduct(int id) throws ClassNotFoundException {
		
		Product product = new Product();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = connection.prepareStatement("select * from products where id = " + id);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setDescription(rs.getString("description"));
				product.setFileName(rs.getString("fileName"));
			}
			return product;
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return product;
	}
	
}
