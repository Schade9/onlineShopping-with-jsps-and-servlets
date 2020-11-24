package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartDAO {
	
	public static List<Cart> displayProducts(int ID) throws ClassNotFoundException {
		
		List<Cart> cart_products = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = connection.prepareStatement("select * from cart where user_id = " + ID);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String pdt_name = rs.getString("pdt_name");
				int pdt_price = rs.getInt("pdt_price");
				int pdt_quantity = rs.getInt("pdt_quantity");
				String pdt_fileName = rs.getString("pdt_fileName");
				int total = pdt_quantity * pdt_price;
				
				cart_products.add(new Cart(id, pdt_name, pdt_price, pdt_quantity, pdt_fileName, total));
			}

		} catch(SQLException e) {
			
			System.out.println(e);
		}
		
		return cart_products;
	}
	
	public static List<Cart> checkOut(int userID) throws ClassNotFoundException {
		
		List<Cart> totals = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = connection.prepareStatement("select total from cart where user_id = " + userID);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				int total = rs.getInt("total");
				
				totals.add(new Cart(total));
			}

		} catch(SQLException e) {
			System.out.println(e);
		}
		
		return totals;
	}
}
