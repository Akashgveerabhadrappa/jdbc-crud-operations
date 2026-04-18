package jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintRows {

    public void printAllRows(Connection connect) throws SQLException {

        if (connect != null) {

            String query = "SELECT * FROM studentinfo";

            try (PreparedStatement pstmt = connect.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {

                System.out.println("\n===== STUDENT DATA =====");

                while (rs.next()) {
                    System.out.println(
                            "ID: " + rs.getInt("id") +
                                    " | Name: " + rs.getString("sname") +
                                    " | Age: " + rs.getInt("sage") +
                                    " | City: " + rs.getString("scity")
                    );
                }
            }
        }
    }
}