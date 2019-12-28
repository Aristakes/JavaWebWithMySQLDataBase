import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnect {



    public static boolean validate(String name , String pass){
        boolean status = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                    "root" , "aris");

            String query = "select * from schema_users.table_user where userName=? and userPassword=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1 , name);
            statement.setString(2 , pass);

            ResultSet rs = statement.executeQuery();
            status = rs.next();


        }catch(Exception e){
            System.out.println("Error DbConnect class validate method " + e);
            return status;
        }


        return status;
    }//end method validate

}
