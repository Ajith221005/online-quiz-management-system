import java.sql.*;
import java.util.Scanner;
public class TakeQuiz {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM questions";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        int score = 0;
        System.out.println("===== QUIZ START =====");
        while(rs.next()) {
            System.out.println("\nQ: " + rs.getString("question"));
            System.out.println("1. " + rs.getString("option1"));
            System.out.println("2. " + rs.getString("option2"));
            System.out.println("3. " + rs.getString("option3"));
            System.out.println("4. " + rs.getString("option4"));
            System.out.print("Your Answer: ");
            String userAnswer = sc.nextLine();
            String correctAnswer = rs.getString("answer");
            if(userAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }
        System.out.println("\n===== QUIZ FINISHED =====");
        System.out.println("Your Score: " + score);
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        result.saveResult(username, score);
        rs.close();
        pst.close();
        con.close();
    }
}
