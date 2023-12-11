package StudentManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st){
        //jdbc code
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "insert into student(sname,sphone,scity) values(?,?,?)";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3,st.getStudentCity());
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteId(int id) {
        //jdbc code
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "delete from student where sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setInt(1, id);
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void display() {
        //jdbc code

        try{
            Connection con=CP.createC();
            String q = "select * from student";
            // Statement
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);//where we retrive data from database
            while(set.next()){
                int id= set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString("scity");

                System.out.println("ID : "+ id);
                System.out.println("NAME : "+ name);
                System.out.println("PHONE : "+ phone);
                System.out.println("CITY : "+ city);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            }

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static boolean update(int id, String name) {
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "UPDATE student SET sname = ? WHERE sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setString(1,name);
            pstmt.setInt(2, id);
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean update(int id, int number) {
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "UPDATE student SET sphone = ? WHERE sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setInt(1,number);
            pstmt.setInt(2, id);
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updatecity(int id, String city) {
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "UPDATE student SET scity = ? WHERE sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setString(1,city);
            pstmt.setInt(2, id);
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean update(int id, String name, int number, String city) {
        boolean f = false;
        try{
            Connection con=CP.createC();
            String q = "UPDATE student SET sname = ?,sphone = ?,scity=? WHERE sid = ?";
            //Prepared Statement
            PreparedStatement pstmt = con.prepareStatement(q);
            //set values of parameters
            pstmt.setString(1,name);
            pstmt.setInt(2,number);
            pstmt.setString(3,city);
            pstmt.setInt(4, id);
            // execute
            pstmt.executeUpdate();
            f=true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }
}
