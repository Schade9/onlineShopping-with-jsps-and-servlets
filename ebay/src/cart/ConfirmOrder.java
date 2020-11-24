package cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.Product;
import products.ProductsDAO;
import users.model.User;


public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("pdtId"));
		
		try {
			Product product = new Product();
			product = ProductsDAO.selectProduct(id);
			int pdt_id = product.getId();
			String pdt_name = product.getName();
			String pdt_price = product.getPrice();
			String pdt_fileName = product.getFileName();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("pdt_id", pdt_id);
			session.setAttribute("pdt_name", pdt_name);
			session.setAttribute("pdt_price", pdt_price);
			session.setAttribute("pdt_fileName", pdt_fileName);
			
			response.sendRedirect("confirmOrder.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		int user_id = user.getId();
		
		String pdt_name = request.getParameter("pdt_name");
		String pdt_fileName = request.getParameter("pdt_fileName");
		int pdt_price = Integer.parseInt(request.getParameter("pdt_price"));
		int pdt_quantity = Integer.parseInt(request.getParameter("pdt_quantity"));
		int total = pdt_price * pdt_quantity;
		int pdt_id = Integer.parseInt(request.getParameter("pdt_id"));
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO cart(pdt_name, pdt_price, pdt_quantity, pdt_fileName, total, pdt_id, user_id) VALUES (?,?,?,?,?,?,?)");
			
			ps.setString(1, pdt_name);
			ps.setInt(2, pdt_price);
			ps.setInt(3, pdt_quantity);
			ps.setString(4, pdt_fileName);
			ps.setInt(5, total);
			ps.setInt(6, pdt_id);
			ps.setInt(7, user_id);
			
			ps.executeUpdate();
			ps.close();
				
		} catch(Exception ex) {
			System.out.println(ex);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
