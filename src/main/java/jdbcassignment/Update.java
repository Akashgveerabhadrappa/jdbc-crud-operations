package jdbcassignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

    public void updateRow(Connection connect, Scanner sc) throws SQLException {

        if (connect != null) {

            System.out.println("What do you want to update?");
            System.out.println("1. Name\n2. Age\n3. City");

            int choice = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student ID:");
            int id = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    String query = "UPDATE studentinfo SET sname=? WHERE id=?";
                    try (PreparedStatement pstmt = connect.prepareStatement(query)) {

                        System.out.println("Enter new name:");
                        String name = sc.nextLine();

                        pstmt.setString(1, name);
                        pstmt.setInt(2, id);

                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Updated successfully!" : "Update failed!");
                    }
                    break;
                }

                case 2: {
                    String query = "UPDATE studentinfo SET sage=? WHERE id=?";
                    try (PreparedStatement pstmt = connect.prepareStatement(query)) {

                        System.out.println("Enter new age:");
                        int age = sc.nextInt();

                        pstmt.setInt(1, age);
                        pstmt.setInt(2, id);

                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Updated successfully!" : "Update failed!");
                    }
                    break;
                }

                case 3: {
                    String query = "UPDATE studentinfo SET scity=? WHERE id=?";
                    try (PreparedStatement pstmt = connect.prepareStatement(query)) {

                        System.out.println("Enter new city:");
                        String city = sc.nextLine();

                        pstmt.setString(1, city);
                        pstmt.setInt(2, id);

                        int rows = pstmt.executeUpdate();
                        System.out.println(rows > 0 ? "Updated successfully!" : "Update failed!");
                    }
                    break;
                }

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}