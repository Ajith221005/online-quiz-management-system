public class Main {
    public static void main(String[] args) throws Exception {
        if(DBConnection.getConnection() != null){
            System.out.println("Database Connected Successfully");
        }

    }
}
