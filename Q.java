package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import java.util.*;

public class Q {

    public static void takeQuiz(int quizId, int userId) {
        Connection con = connection.getConnection();
        String sql = "Select * from questions where quiz_id=?";
        int score = 0;
        int wrongScore = 0;
        int totalQuestions =0;
        Scanner sc = new Scanner(System.in);

        // To store wrong answers and correct answers
        List<String> wrongQuestions = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, quizId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                totalQuestions++;
                System.out.println();
                System.out.println(rs.getString("question_text"));
                System.out.println("1." + rs.getString("option1"));
                System.out.println("2." + rs.getString("option2"));
                System.out.println("3." + rs.getString("option3"));
                System.out.println("4." + rs.getString("option4"));
                // System.out.println("Enter your answer (1-4):");
                // int userAnswer = sc.nextInt();

                int userAnswer = -1;
                boolean validInput = false;

                while(!validInput){
                 System.out.println("Enter your answer(1-4)");
                 try{
                 userAnswer=sc.nextInt();
                 if(userAnswer>=1 && userAnswer<=4){
                 validInput = true;
                 }
                 else{
                 System.out.println("\nInvalid option, please enter a number betweem 1 and 4.");
                 }
                 }
                 catch(InputMismatchException e){
                 System.out.println("\nInvalid input, please enter a valid number(1-4).");
                 sc.nextLine();
                 }
                }

                int correctOption = rs.getInt("correct_option");
                if (userAnswer == correctOption) {
                    score++;
                } else {
                    wrongScore++;
                    // Store the wrong question and the correct answer
                    wrongQuestions.add(rs.getString("question_text"));
                    correctAnswers.add(rs.getString("option" + correctOption));
                }
            }


            System.out.println("\nper questions have 10 marks:");
            System.out.println("Your marks are: " + score * 10);
            System.out.println("Total questions are:"+totalQuestions);
            System.out.println("Your correct answers: " + score);
            System.out.println("Your wrong answers: " + wrongScore);
            System.out.println("your percentage is : "+(score/(double)totalQuestions)*100);

            if (!wrongQuestions.isEmpty()) {
                System.out.println("\nQuestions you got wrong along with correct answers:");
                for (int i = 0; i < wrongQuestions.size(); i++) {
                    System.out.println("Question: " + wrongQuestions.get(i));
                    System.out.println("Correct Answer: " + correctAnswers.get(i));
                }
            }


            String resultSql = "INSERT INTO results(user_id, quiz_id, score) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(resultSql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, quizId);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
}
}