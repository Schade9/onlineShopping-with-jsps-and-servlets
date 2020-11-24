package users.web;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.model.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password1 = request.getParameter("password");
		byte[] salt = getSalt();
		String password = get_SHA_1_SecurePassword(password1, salt);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay","root","");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from users where username = '"+username+"' ");
			
			if(rs.next()) {
				if(rs.getString(4).equals(password)) {
					int id = rs.getInt("id");
					String email = rs.getString("email");
					request.getSession().setAttribute("user", new User(id,username,email,password));
					response.sendRedirect("index.jsp");
				} else {
					System.out.println("invalid password try again");
					response.sendRedirect("login.jsp");
				}
			} else {
				System.out.println("Invalid password try agin");
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println("error");
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
