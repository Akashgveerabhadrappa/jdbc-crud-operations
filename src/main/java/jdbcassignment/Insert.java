package jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

    public void insertRow(Connection connect, Scanner sc) throws SQLException {
        if (connect != null) {

            String query = "INSERT INTO studentinfo(id,sname,sage,scity) VALUES(?,?,?,?)";

            System.out.println("How many students do you want to insert:");
            int count = sc.nextInt();
            sc.nextLine(); // consume newline

            try (PreparedStatement pstmt = connect.prepareStatement(query)) {

                while (count > 0) {
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String sname = sc.nextLine();

                    System.out.println("Enter Age:");
                    int sage = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter City:");
                    String scity = sc.nextLine();

                    pstmt.setInt(1, id);
                    pstmt.setString(2, sname);
                    pstmt.setInt(3, sage);
                    pstmt.setString(4, scity);

                    pstmt.addBatch();
                    count--;
                }

                int[] result = pstmt.executeBatch();

                System.out.println(result.length + " Students inserted successfully!");
            }
        }
    }
}