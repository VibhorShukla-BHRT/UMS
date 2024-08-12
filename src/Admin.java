package src;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Scheme {
    ArrayList<String> roles;
    String[] users;
    static Scanner sc = new Scanner(System.in);
    public Admin(String name, String address, long mob){
        super(name, address, mob);
    }
    void setRoles(ArrayList<String> roles){ this.roles = roles; }
    //other functions
    public Teacher addFaculty(String name, String address, long mob, String dept, String subjectT){
        //add faculty to the database
        System.out.println("Faculty added!");
        return new Teacher(name, address, mob, dept, subjectT);

    }
    public Student addStudent(String name, String address, long mob, String fname,String mname,String grade, String dept){
        System.out.println("Student added!");
    return new Student(name, address, mob, fname, mname, grade, dept);
    }
    void addCourse(Connection conn){
    //add a course to the db

        System.out.println("Give following details about the course : ");
        System.out.println("Name of subject : ");
        String name = sc.next();
        System.out.println("Name of Faculty assigned to it : ");
        String fac = sc.next();
        String query = "INSERT INTO courses (name, faculty) VALUES ('"+name+"','"+fac+"')";
        DB.insertData(query,conn);//using database utilities
    }
    void feeCollection(Connection conn){
        System.out.println("Add fee structure : ");
        System.out.println("How many semester's fee do you wanna add?(out of 8)");
        int s = sc.nextInt();
        while(s>8 || s<1){
            System.out.println("Semester "+ s+" does not exist! Try again!");
            System.out.println("How many semester's fee do you wanna add?(out of 8)");
            s = sc.nextInt();
        }
        String query = "INSERT INTO feestructure (";
        for(int i=1;i<=s;i++){
            if(i==s){
                query+="sem"+i;
            }
            else {
                query+="sem"+i+",";
            }
        }
        query+=") VALUES (";
        for(int i=1;i<=s;i++){
            System.out.println("Enter fee for sem "+i+" : ");
            long f = sc.nextLong();
            if(i==s){
                query+=f;
            }
            else {
                query+=f+",";
            }
        }
        query  += ");";
        DB.insertData(query, conn);
    }
    //Initially there would be only 3 admins(people with special authorities)
    public static Admin a1 = new Admin("a1","Broklin",123);
    public static Admin a2 = new Admin("a2","Broklin",32165823);
    public static Admin a3 = new Admin("a3","Broklin",32165889);
}
