package StudentManage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;
    public static Connection createC(){ // Connection.createC se use ho jayega directly
        //load driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection
            String user= "root";
            String password= "sonu14300";
            String url= "jdbc:mysql://localhost:3306/bhupi";
            con= DriverManager.getConnection(url,user,password);


        } catch (Exception e){
            e.printStackTrace();
        }
        return con;

    }
}
