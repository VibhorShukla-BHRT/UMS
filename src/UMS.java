package src;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static src.Admin.*;

public class UMS {
    static ArrayList<Teacher> teachers = new ArrayList<>();
    static ArrayList<Student> st = new ArrayList<>();
    static ArrayList<Admin> ad = new ArrayList<>();
    public UMS(){
        ad.add(a1);
        ad.add(a2);
        ad.add(a3);
    }

    //login
    public boolean login(Scheme st){
        String name, pass;
        System.out.println("Enter your name : ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        if(name.equals(st.name)){
            System.out.println("Enter your mobile number : ");
            pass = sc.nextLine();
            if(Objects.equals(pass, String.valueOf(st.mob))){
                System.out.println("Logged In!");
                st.isLoggedIN = true;
                return true;
            }
            else {
                System.out.println("Incorrect mobile number!");
                return false;
            }
        }
        System.out.println("Invalid username!");
        return  false;
    }
    public void studentDetails(Student st){st.getDetails();}
    public void facultyDetails(Teacher t){t.getFacultyDetails();}

}







//    public static void main(String[] args) {
//
//        try(Connection con = DriverManager.getConnection(DB_URL,USR,PASS)){
//            if(con != null){
////                System.out.println("Connected!");
////                Statement st = con.createStatement();
////                ResultSet rs = st.executeQuery(query);
////                while (rs.next()) {
////                    String dbName = rs.getString(1);
////                    System.out.println("Database: " + dbName);
//                System.out.println("connected");
//            } else{
//                System.out.println("Not connected!");
//            }
//        } catch (Exception e){
//            System.out.println("error : "+e);
//        }
//    }
