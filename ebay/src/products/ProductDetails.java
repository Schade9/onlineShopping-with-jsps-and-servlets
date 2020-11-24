package products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import products.ProductsDAO;


public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("productId"));
		
		try {
			Product product = new Product();
			product = ProductsDAO.selectProduct(id);
			
			String name = product.getName();
			String price = product.getPrice();
			String description = product.getDescription();
			String fileName = product.getFileName();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("price", price);
			session.setAttribute("description", description);
			session.setAttribute("fileName", fileName);
			
			response.sendRedirect("productdetails.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
