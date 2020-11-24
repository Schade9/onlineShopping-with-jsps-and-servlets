package users.dao;

import java.sql.*;

public class UserDAO {
	private static final String name = "root";
	private static final String pass = "";
	private static final String url = "jdbc:mysql://localhost:3306/ebay";
	
	private static Connection conn;
	private static Statement statement;
	private ResultSet result;
	
	private static void establishConnectionWithMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // establish connection with MySQL DB
            conn = DriverManager.getConnection(url,name,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement connectDB() throws SQLException {
        establishConnectionWithMySQL();
        statement = conn.createStatement();
        return statement;
    }

    public static void disconnectDB() throws SQLException {
        conn.close();
    }
    
    

    public String addNewUser(String username, String password, String email) {
        try {
            statement = connectDB();

            result = statement.executeQuery("Select username from users where email = '"+email+"'");

            if (!result.next()) {
                result = statement.executeQuery("select username from users");
                while (result.next()) {
                    if(result.getString("username").equals(username.toLowerCase())){
                        System.out.println("USERNAME not AVAILABLE!!!");
                        return "USERNAME NOT AVAILABLE :( TRY AGAIN.";
                    }
                }
                statement.execute("Insert into users(username,password,email) values('"+username+"', '"+password+"', '"+email+"')");
                return "Successfully Signed Up. Now LogIn again";
            }

            System.out.println("Already registered!!");
            return "User Already Registered!!";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Some error occured while adding user. Try later.";
    }
    
}
