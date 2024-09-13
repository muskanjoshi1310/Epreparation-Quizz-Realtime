package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {
  public static void createQuiz(){
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter your subject:  ");
    String subject=sc.nextLine();

    Connection con= connection.getConnection();
    String sql ="insert into quizzes(subject) values(?)";
    try{
      PreparedStatement pstmt=con.prepareStatement(sql);
      pstmt.setString(1,subject);
      pstmt.executeUpdate();
      System.out.println("\nquiz created successfully!");
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  } 
  public static void addQuestion(int quiz_id){
    Scanner sc=new Scanner(System.in);
    System.out.println("\n\nEnter question text");
    String question_text=sc.nextLine();
    System.out.println("Enter option 1:");
    String option1=sc.nextLine();
    System.out.println("Enter option 2:");
    String option2=sc.nextLine();
    System.out.println("Enter option 3:");
    String option3=sc.nextLine();
    System.out.println("Enter option 4:");
    String option4=sc.nextLine();
    System.out.println("\nEnter correct oprion(1-4):");
    int correctOption=sc.nextInt();

    Connection con=connection.getConnection();
    String sql="insert into questions(Quiz_id,question_text,option1,option2,option3,option4,correct_option)"
    +"values(?,?,?,?,?,?,?)";
    try{
      PreparedStatement pstmt=con.prepareStatement(sql);
      pstmt.setInt(1, quiz_id);
      pstmt.setString(2, question_text);
      pstmt.setString(3, option1);
      pstmt.setString(4, option2);
      pstmt.setString(5, option3);
      pstmt.setString(6, option4);
      pstmt.setInt(7, correctOption);
      pstmt.executeUpdate();
      System.out.println("\n\nQuestion added successfully");
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  } 
}