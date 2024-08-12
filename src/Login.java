package src;

import java.util.ArrayList;

import static src.Admin.*;

public class Login {
    static UMS ums = new UMS();
    public static Student studentLogin(){
        ArrayList<Student> teachers = ums.st;
        System.out.println("Please login: ");
        System.out.print("Enter your name: ");
        String name = sc.next();
        boolean loggedIN;

        for (Student teacher : teachers) {
            if(teacher.name.equals(name)){
                Student t = teacher;
                loggedIN = ums.login(t);
                if(loggedIN) {
                    return t;
                }
                break;
            }
        }
        System.out.println("Login failed. Teacher not found.");
        return null;
    }
    public static Teacher facultyLogin(){
        ArrayList<Teacher> teachers = ums.teachers;
        System.out.println("Please login: ");
        System.out.print("Enter your name: ");
        String name = sc.next();
        boolean loggedIN;

        for (Teacher teacher : teachers) {
            if(teacher.name.equals(name)){
                Teacher t = teacher;
                loggedIN = ums.login(t);
                if(loggedIN) {
                    return t;
                }
                break;
            }
        }
        System.out.println("Login failed. Teacher not found.");
        return null;
    }
    public static Admin adminLogin(){
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(a1);
        admins.add(a2);
        admins.add(a3);
        boolean loggedin=false;
        System.out.println("Do you wanna continue? [Y/N] ");
        String ans = sc.next();
        while(ans.charAt(0)=='y'|| ans.charAt(0)=='Y' && !(loggedin) ){
            System.out.println("Please login : ");
            System.out.println("Enter user serial :");//private to the admin, 1 for a1, 2 for a2 and 3 for a3
            int un = sc.nextInt();
            loggedin = ums.login(admins.get(un-1));
            if(loggedin){
                return admins.get(un-1);
            }
            System.out.println("do you wanna try again? [Y/N]");
            ans = sc.next();
        }
        return  null;
    }
}
