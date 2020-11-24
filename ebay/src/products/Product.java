package products;

import java.io.InputStream;

public class Product {
	private int id;
	private String name;
	private String price;
	private String description;
	private InputStream img;
	private String fileName;
	
	
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
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public InputStream getImg() {
		return img;
	}
	
	public void setImg(InputStream img ) {
		this.img = img;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName ) {
		this.fileName = fileName;
	}
}

