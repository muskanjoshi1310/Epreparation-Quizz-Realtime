package project;
import java.util.Scanner;

public class Final{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the E-Preparation System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Panel");
            System.out.println("4. Exit");

            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                Registration .register();//registration.
                    System.out.println("-----------------------------------------");
                    break;

                case 2:
                    boolean isUserLoggedIn = Login1.loginuser();
                    if (isUserLoggedIn) {
                        boolean quizloop=true;
                        while(quizloop){
                        System.out.println("\n1. Take a Quiz");
                        System.out.print("Choose an option: ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        if (option == 1) {
                            System.out.println("\nquiz id = 1 for SQL" + "\n" + "quiz id = 2 for JAVA" +
                                    "\n" + "quiz id =3 for C");
                            System.out.print("Enter quiz ID: ");
                            int quizId = scanner.nextInt();

                            if(quizId>=1 && quizId<=5){
                                System.out.print("Enter your user ID: ");
                                int userId = scanner.nextInt();
                                Q.takeQuiz(quizId, userId);
                                System.out.println("-----------------------------------------");

                                System.out.println("Do you want to take another quize()yes/no?");
                                String continueQuiz = scanner.next();
                                if(continueQuiz.equalsIgnoreCase("yes\n")){
                                quizloop = false;
                                }
                                else{
                                    System.out.println("thankyou");
                                    quizloop=false;
                                    System.exit(0);
                                }
                            }
                    else{
                        System.out.println("\nInvalid quiz id, please choose a correct answer 1 for SQL, 2 for java, 4for C");
                    }

                }         
                        } 
                        break;
                     }
                    break;

                case 3:
                    boolean isAdmin = AdminLogin.loginAdmin(); // Use separate admin login
                    if (isAdmin) {
                        System.out.println("\nAdmin Panel:");
                        System.out.println("1. Create Quiz");
                        System.out.println("2. Add Question to Quiz");
                        System.out.print("Choose an option: ");
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("-----------------------------------------");

                        if (adminChoice == 1) {
                            Admin.createQuiz();
                        } else if (adminChoice == 2) {
                            System.out.print("Enter quiz ID to add a question to: ");
                            int quizId = scanner.nextInt();
                            Admin.addQuestion(quizId);
                        }
                    } else {
                        System.out.println("Admin access denied.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }
}
}
}