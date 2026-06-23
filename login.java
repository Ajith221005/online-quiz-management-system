import java.sql.*;
import java.util.Scanner;
public class login {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            System.out.println("Login Successful 🎉");
        } else {
            System.out.println("Invalid Email or Password ❌");
        }
        rs.close();
        pst.close();
        con.close();
    }
}
