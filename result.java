import java.sql.*;
public class result {
    public static void saveResult(String username, int score) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO results(username,score) VALUES(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        pst.setInt(2, score);
        int result = pst.executeUpdate();
        if(result > 0){
            System.out.println("Result Saved Successfully");
        }

        pst.close();
        con.close();
    }
}
