package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    //º”‘ÿ«˝∂Ø¿‡
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/weight?useUnicode=true&characterEncoding=utf8","root","root"); 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	

}
