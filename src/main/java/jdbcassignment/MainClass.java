package jdbcassignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        try (Connection connect = JdbcUtil.getConnection();
             Scanner sc = new Scanner(System.in)) {

            Insert insert = new Insert();
            Update update = new Update();
            Delete delete = new Delete();
            PrintRows print = new PrintRows();

            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Display");
                System.out.println("5. Exit");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        insert.insertRow(connect, sc);
                        break;

                    case 2:
                        update.updateRow(connect, sc);
                        break;

                    case 3:
                        delete.deleteRow(connect, sc);
                        break;

                    case 4:
                        print.printAllRows(connect);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}