package project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Login1 {

    public static boolean loginuser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n"+"Enter username");
        String username=sc.nextLine();
        int attemts=0;

        while (attemts<3) {
            System.out.println("\n"+"Enter password");
            String password=sc.nextLine();

            if(password.length()<8){
                System.out.println("\n"+"password must be at least 8 charecters long ! try again");
                continue;
            }

            Connection con=connection.getConnection();
            String sql="select*from users where username=?";

            try{
                PreparedStatement pstmt=con.prepareStatement(sql);
                pstmt.setString(1, username);
                ResultSet rs=pstmt.executeQuery();

                if(rs.next()){
                    String correctPassword=rs.getString("password");

                    if(correctPassword.equals(password)){
                        System.out.println("\n"+"Login successfully\n");
                        int userId=rs.getInt("user_id");
                        System.out.println("\nyour user id is :"+userId);
                        return true;
                    }
                    else{
                        attemts++;
                        System.out.println("\n"+"Incorrect password");
                        System.out.println("\n"+"hint: Last two characters of password are:"
                        +correctPassword.substring(correctPassword.length()-2));

                        if(attemts==3){
                            System.out.println("\n"+"To many feild attempts,our Account locked. try again some time");
                            return false;
                        }
                    }
                }
                    else{
                        System.out.println("\n"+"username not found");
                        return false;
                    }
                }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
return false;
    }
}