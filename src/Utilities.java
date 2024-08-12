package src;

import java.sql.Connection;
import java.util.Scanner;

public class Utilities {
    static Connection conn = DB.getConn();
    static Scanner sc = new Scanner(System.in);
    static UMS ums = new UMS();
    public static void  studentUtils(Student s){
        System.out.println("Welcome "+s.name+"!");
        System.out.println("You can perform the following operations: ");
        System.out.println("1: Give Exam");
        System.out.println("2: Take Courses");
        int o = sc.nextInt();
        if(o==1){
            System.out.println("Enter the name of course, you wanna give exam of: ");
            String crs = sc.next();
            s.GiveExam(crs);
        } else if (o==2) {
            s.TakeCourses();
        }
        else {
            System.out.println("Invalid input!");
        }
    }
    public static void adminUtils(Admin temp) {
        System.out.println("Welcome " + temp.name + "!");
        System.out.println("Choose a task to perform (Enter the serial number, e.g., 1 for performing task 1):");
        System.out.println("1: To add Faculty");
        System.out.println("2: To add Student");
        System.out.println("3: To add Course");
        System.out.println("4: To add Fee Structure");

        int op = sc.nextInt();

        // Validate the user's choice
        while (op > 4 || op < 1) {
            System.out.println("Invalid choice, Try again!");
            op = sc.nextInt();
        }

        sc.nextLine();  // Consume the newline character left by nextInt()

        if (op == 1) {
            // Add Faculty
            System.out.println("Provide the following details of the faculty you want to add:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Mobile number (without +91 or any other prefix. Do not include spaces or dashes): ");
            long mob = sc.nextLong();
            sc.nextLine();  // Consume newline after long
            System.out.print("Department: ");
            String dept = sc.nextLine();
            System.out.print("Subject they will be teaching: ");
            String subjectT = sc.nextLine();

            Teacher t = temp.addFaculty(name, address, mob, dept, subjectT);
            UMS.teachers.add(t);
        } else if (op == 2) {
            // Add Student
            System.out.println("Provide the following details of the student you want to add:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Mobile number (without +91 or any other prefix. Do not include spaces or dashes): ");
            long mob = sc.nextLong();
            sc.nextLine();  // Consume newline after long
            System.out.print("Father's name: ");
            String fname = sc.nextLine();
            System.out.print("Mother's name: ");
            String mname = sc.nextLine();
            System.out.print("Grade: ");
            String grade = sc.nextLine();
            System.out.print("Department: ");
            String dept = sc.nextLine();

            Student s = temp.addStudent(name, address, mob, fname, mname, grade, dept);
            if (s != null) {
                UMS.st.add(s);
            } else {
                System.out.println("Trouble adding student!");
            }
        } else if (op == 3) {
            // Add Course
            temp.addCourse(conn);
        } else {
            // Add Fee Structure
            temp.feeCollection(conn);
        }

        temp.isLoggedIN = false;
    }

    public static void facultyUtils(Teacher t){
        System.out.println("Welcome "+t.name+"!");
        System.out.println("You can perform the following operations: ");
        System.out.println("1: Take Exam");
        System.out.println("2: Assign grade");
        int i = sc.nextInt();
        if(i==1){
            System.out.println("please provide the url of the question paper : ");
            String url = sc.next();
            System.out.println("How long is the test(in mins): ");
            long timeInterval = sc.nextInt();
            t.takeExam(url,timeInterval);
        }
        else if(i==2){
            System.out.println("Please give name and mobile numeber of student you wanna grade: ");
            System.out.println(" name : ");
            String name = sc.next();
            System.out.println("Student's Mob no: ");
            long mob = sc.nextLong();
            Student s = null;
            for(Student sd: UMS.st){
                if(name.equals(sd.name) && mob==sd.mob){
                    s=sd;
                    break;
                }
            }
            if(s!=null){

                System.out.println("Their Details: ");
                ums.studentDetails(s);
                System.out.println("Assign a grade to "+ s.name);
                char grade = sc.next().charAt(0);
                t.assignGrade(s,grade);
            }else{
                System.out.println("No such student exists.");
            }
        }
    }
}
