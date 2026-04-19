package jdbcassignment;
import java.sql.*;
public class JdbcUtil {
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String username = "root";
        String password = "Your Password";
        return DriverManager.getConnection(url,username,password);
    }
    public static void closeConnection(Statement stmt, Connection conn) throws SQLException{
        if(stmt!=null){
            stmt.close();
        }
        if(conn!=null){
            conn.close();
        }
    }

}
