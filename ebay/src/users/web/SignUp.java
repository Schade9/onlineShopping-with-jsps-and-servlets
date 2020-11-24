package users.web;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.dao.UserDAO;


public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO signup_services = new UserDAO();
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password");
		byte[] salt = getSalt();
		String password = get_SHA_1_SecurePassword(password1, salt);
		
		String status = signup_services.addNewUser(username.toLowerCase(), password, email);
		
		if(status.equals("Successfully Signed Up. Now LogIn again")) {
			System.out.println("Successfully added");
			request.setAttribute("Error", status);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("Error", status);
			System.out.println("Error while adding user");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}
	
	public byte[] getSalt() {
    	byte[] salt = new byte[8];
    	return salt;
    }
    
    public static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt) {
    	String generatedPassword = null;
    	try {
    		MessageDigest md = MessageDigest.getInstance("SHA-1");
    		md.update(salt);
    		byte[] bytes = md.digest(passwordToHash.getBytes());
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < bytes.length; i++) {
    			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    			generatedPassword = sb.toString();
    		}
    	} catch(NoSuchAlgorithmException e) {
    		e.printStackTrace();
    	}
    	return generatedPassword;
    }

}
