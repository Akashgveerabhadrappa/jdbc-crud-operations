package jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

    public void deleteRow(Connection connect, Scanner sc) throws SQLException {
        if (connect != null) {

            String query = "DELETE FROM studentinfo WHERE id = ?";

            System.out.println("How many students do you want to delete:");
            int count = sc.nextInt();

            try (PreparedStatement pstmt = connect.prepareStatement(query)) {

                while (count > 0) {
                    System.out.println("Enter Student ID:");
                    int id = sc.nextInt();

                    pstmt.setInt(1, id);
                    int rows = pstmt.executeUpdate();

                    System.out.println(rows > 0 ? "Deleted Successfully!" : "Delete Failed!");
                    count--;
                }
            }
        }
    }
}