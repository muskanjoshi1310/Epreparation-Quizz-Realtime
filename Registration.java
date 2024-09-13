package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
// import java.sql.PreparedStatement;
public class Registration {
    public static void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n"+"Enter your name: ");
        String username=sc.nextLine();
        System.out.println("\n"+"Enter your password: ");
        String password=sc.nextLine();

        if(password.length()>8){
            System.out.println("\n"+"password must be at least 8 characters long! Try again");
            return;
        }

        Connection con=connection.getConnection();
        String sql="insert into users(username,password) values(?,?)";

        try{


        PreparedStatement pstmt=con.prepareStatement(sql);
        // ResultSet rs=pstmt.executeQuery();
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.executeUpdate();
        System.out.println("\n"+"Registration successfully");

    }
    catch(SQLException e){
        e.printStackTrace();
    }
}
}