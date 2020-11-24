package cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.Cart;
import cart.CartDAO;
import users.model.User;


public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		int user_id = user.getId();
		
		int subTotal = 0;
		
		try {
			
			List<Cart> listCart = CartDAO.displayProducts(user_id);
			List<Cart> checkout = CartDAO.checkOut(user_id);
			
			for(int i = 0; i < checkout.size(); i++) {
				subTotal = subTotal + checkout.get(i).getTotal();
			}
			
			double tax = 0.05 * subTotal;
			double grandTotal = tax + subTotal;
			
			if(listCart.isEmpty()) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("EmptyCart.jsp");
				dispatcher.forward(request, response);
				
			} else {
				
				HttpSession session = request.getSession();
				
				request.setAttribute("listCart", listCart);
				session.setAttribute("tax", tax);
				session.setAttribute("subTotal", subTotal);
				session.setAttribute("grandTotal", grandTotal);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
