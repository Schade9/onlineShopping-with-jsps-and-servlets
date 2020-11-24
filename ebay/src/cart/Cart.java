package cart;

public class Cart {

	private int id;
	private String pdt_name;
	private int pdt_price;
	private int pdt_quantity;
	private String pdt_fileName;
	private int total;
	private int pdt_id;
	private int user_id;
	
	public Cart(int id, String pdt_name, int pdt_price, int pdt_quantity, String pdt_fileName, int total) {
		super();
		this.id = id;
		this.pdt_name = pdt_name;
		this.pdt_price = pdt_price;
		this.pdt_quantity = pdt_quantity;
		this.pdt_fileName = pdt_fileName;
		this.total = total;
	}

	public Cart(int total) {
		super();
		this.total = total; 
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPdt_name() {
		return pdt_name;
	}
	
	public void setPdt_name(String pdt_name) {
		this.pdt_name = pdt_name;
	}
	
	public int getPdt_price() {
		return pdt_price;
	}
	
	public void setPdt_price(int pdt_price) {
		this.pdt_price = pdt_price;
	}
	
	public int getPdt_quantity( ) {
		return pdt_quantity;
	}
	
	public void setPdt_quantity(int pdt_quantity) {
		this.pdt_quantity = pdt_quantity;
	}
	
	public String getPdt_fileName( ) {
		return pdt_fileName;
	}
	
	public void setPdt_fileName(String pdt_fileName) {
		this.pdt_fileName = pdt_fileName;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getPdt_id() {
		return pdt_id;
	}
	
	public void setPdt_id(int pdt_id) {
		this.pdt_id = pdt_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
