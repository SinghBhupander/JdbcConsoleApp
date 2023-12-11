import StudentManage.Student;
import StudentManage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("This is a CURD Based Console Jdbc Application");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Press 1 to ADD student");
            System.out.println("Press 2 to Delete student");
            System.out.println("Press 3 to Display student");
            System.out.println("Press 4 to Update Entries");
            System.out.println("Press 5 to exit App");
            int c = Integer.parseInt( br.readLine());
            if(c==1){
                // Add
                System.out.println("Enter Student-Name : ");
                String name= br.readLine();

                System.out.println("Enter Student-Phone : ");
                String number= br.readLine();

                System.out.println("Enter Student-City");
                String city= br.readLine();

                Student st= new Student(name,number,city);
                boolean ans= StudentDao.insertStudentToDB(st);
                if(ans){
                    System.out.println("Added to db");
                }
                else{
                    System.out.println("not added");
                }
            } else if (c==2) {
                //Delete
                System.out.println("Enter Student ID to Delete");
                int Id = Integer.parseInt(br.readLine());

                boolean answer = StudentDao.deleteId(Id);
                if(answer){
                    System.out.println("Sucessfully Deleted");
                }
                else{
                    System.out.println("Unable to Deleted Kindly Check Your Id");
                }
            } else if (c==3) {
                //Display
                StudentDao.display();
            } else if (c==4) {
                while(true){
                    System.out.println("Press 1 to update only name");
                    System.out.println("press 2 to update only number");
                    System.out.println("press 3 to update only city");
                    System.out.println("press 4 to update all");
                    System.out.println("press 5 to complete update");
                    int a= Integer.parseInt(br.readLine());
                    if(a==1){
                        System.out.println("Provide Id to update");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Provide name to update");
                        String name = br.readLine();
                        boolean ans = StudentDao.update(id,name);
                        if(ans){
                            System.out.println("Name updated successfully");
                        }
                        else{
                            System.out.println("Error in updating name kindly try again");
                        }
                    } else if (a==2) {
                        // only number
                        System.out.println("Provide Id to update");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Provide number to update");
                        int number = Integer.parseInt(br.readLine());
                        boolean ans = StudentDao.update(id,number);
                        if(ans){
                            System.out.println("Number updated successfully");
                        }
                        else{
                            System.out.println("Error in updating name kindly try again");
                        }
                    } else if (a==3) {
                        // only city
                        System.out.println("Provide Id to update");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Provide city to update");
                        String city = br.readLine();
                        boolean ans =StudentDao.updatecity(id , city);
                        if(ans){
                            System.out.println("city updated successfully");
                        }
                        else{
                            System.out.println("Error in updating name kindly try again");
                        }

                    } else if (a==4) {
                        // update all
                        System.out.println("Provide Id to update");
                        int id = Integer.parseInt(br.readLine());
                        System.out.println("Provide name to update");
                        String name = br.readLine();
                        System.out.println("Provide number to update");
                        int number = Integer.parseInt(br.readLine());
                        System.out.println("Provide city to update");
                        String city = br.readLine();
                        boolean ans=StudentDao.update(id,name,number,city);
                        if(ans){
                            System.out.println("all info updated successfully");
                        }
                        else{
                            System.out.println("Error in updating name kindly try again");
                        }

                    } else if (a==5) {
                        System.out.println("Updation process completed");
                        break;
                    }else {
                        System.out.println("Kindly enter Amongst above shown");
                    }
                }

            } else if (c==5) {
                // Exit
                System.out.println("Connection Closed Successfully");
                break;
            }else {
                System.out.println("*********** Please Select Amongst Above Shown Options ************");
            }
        }
    }
}
