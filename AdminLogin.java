package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdminLogin {

    public static boolean loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin password: ");
        String password = scanner.nextLine();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn =connection.getConnection();
            String query = "SELECT id FROM admins WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int adminId = rs.getInt("id");
                System.out.println("\nAdmin login successful! \nYour admin ID is: " + adminId);
                return true; 
            } else {
                System.out.println("\nInvalid admin credentials. Try again.");
                return false; 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
 }
}
}