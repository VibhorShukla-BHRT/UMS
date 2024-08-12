package src;

import java.util.Scanner;

public class Signup {
    static Scanner sc = new Scanner(System.in);
    static Teacher signupAsTeacher(){
        System.out.println("Signup as a faculty: ");
        System.out.print("name : ");
        String name = sc.next();
        System.out.println();
        System.out.print("Address : ");
        String address = sc.next();
        System.out.println();
        System.out.println("Mobile number (without +91 or any other prefix.Also do not include spaces or dash) : ");
        long mob = sc.nextLong();
        System.out.println();
        System.out.println("Department : ");
        String dept = sc.next();
        System.out.println();
        System.out.println("Subject they will be teaching : ");
        String subjectT = sc.next();
        Teacher t =  new Teacher(name,address,mob,dept,subjectT);
        t.isLoggedIN = true;
        UMS.teachers.add(t);
        return t;
    }
    static Student signupAsStudent(){
        System.out.println("Signup as a Student: ");
        System.out.print("name : ");
        String name = sc.next();
        System.out.println();
        System.out.print("Address : ");
        String address = sc.next();
        System.out.println();
        System.out.println("Mobile number (without +91 or any other prefix.Also do not include spaces or dash) : ");
        long mob = sc.nextLong();
        System.out.println();
        System.out.println("Father's name : ");
        String fname = sc.next();
        System.out.println("Mother's name : ");
        String mname = sc.next();
        System.out.println("Grade : ");
        String grade = sc.next();
        System.out.println("Department : ");
        String dept = sc.next();
        Student s = new Student(name,address,mob,fname,mname, grade,dept);
        s.isLoggedIN = true;
        UMS.st.add(s);
        return s;
    }
    static Admin signupAsAdmin(){
        System.out.println("Signup as a Admin: ");
        System.out.print("name : ");
        String name = sc.next();
        System.out.println();
        System.out.print("Address : ");
        String address = sc.next();
        System.out.println();
        System.out.println("Mobile number (without +91 or any other prefix.Also do not include spaces or dash) : ");
        long mob = sc.nextLong();
        Admin admin = new Admin(name,address,mob);
        admin.isLoggedIN = true;
        UMS.ad.add(admin);
        return admin;
    }
}
