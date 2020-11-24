package cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.model.User;


public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		int user_id = user.getId();
		
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = conn.prepareStatement("delete from cart where id = " + cartId + " and user_id = " + user_id);
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		response.sendRedirect("ShowCart");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
