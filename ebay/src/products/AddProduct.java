package products;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
			maxFileSize = 1024 * 1024 * 10,
			maxRequestSize = 1024 * 1024 * 50)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		InputStream img = null;
		
		Part filePart = request.getPart("img");
		if(filePart != null) {
			img = filePart.getInputStream();
		}
		String fileName = extractFileName(filePart);
		String savePath = "C:\\Users\\5CHAD3\\eclipse-workspace\\myServlet\\ebay\\WebContent\\images" + File.separator + fileName;
		File fileSaveDir = new File(savePath);
		filePart.write(savePath + File.separator); 
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebay", "root", "");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO products(name,price,description,img,fileName)  VALUES (?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, description);
			if(img != null) {
				ps.setBlob(4, img);
			}
			ps.setString(5, fileName);
			
			ps.executeUpdate();
			ps.close();
				
		} catch(Exception ex) {
			System.out.println(ex);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
