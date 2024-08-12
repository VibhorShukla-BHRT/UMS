package src;

import static src.Login.*;
import static src.Signup.*;
import static src.Utilities.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    //main driver method
    public static void main(String[] args) {
        char repeat = 'y';
        while(repeat=='y') {
            System.out.println("Choose : ");
            System.out.println("1: Login");
            System.out.println("2: Signup");
            int c = sc.nextInt();
            //login Section
            if (c == 1) {
                System.out.println("Log in Section!");
                System.out.println("Select a serial number based on who you wanna log in as(For instance type 1 to log in as admin) : ");
                System.out.println("1 : Admin");
                System.out.println("2: Faculty");
                System.out.println("3: Student");
                int choice = sc.nextInt();

                //admin section

                if (choice == 1) {
                    Admin temp = adminLogin();
                    char loop = 'y';
                    while (temp != null && loop == 'y') {
                        adminUtils(temp);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    if (temp != null) {
                        System.out.println("Logging out");
                        temp.isLoggedIN = false;
                    }
                }

                //teacher section
                else if (choice == 2) {
                    Teacher t = facultyLogin();
                    char loop = 'y';
                    while (t != null && loop == 'y') {
                        facultyUtils(t);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    if (t != null) {
                        System.out.println("Logging out");
                        t.isLoggedIN = false;
                    }
                }
                //student section
                else if (choice == 3) {
                    Student s = studentLogin();
                    char loop = 'y';
                    while (s != null && loop == 'y') {
                        studentUtils(s);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    if (s != null) {
                        System.out.println("Logging out");
                        s.isLoggedIN = false;
                    }
                } else System.out.println("Invalid choice");
            }

            //Signup Section
            else if (c == 2) {
                System.out.println("Sign up Section!");
                System.out.println("Select a serial number based on who you wanna log in as(For instance type 1 to Sign-up as admin) : ");
                System.out.println("1 : Admin");
                System.out.println("2: Faculty");
                System.out.println("3: Student");
                int choice = sc.nextInt();

                //admin section

                if (choice == 1) {
                    Admin temp = signupAsAdmin();
                    char loop = 'y';
                    while (loop == 'y') {
                        adminUtils(temp);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    System.out.println("Logging out");
                    temp.isLoggedIN = false;
                }

                //teacher section
                else if (choice == 2) {
                    Teacher t = signupAsTeacher();
                    char loop = 'y';
                    while (loop == 'y') {
                        facultyUtils(t);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    System.out.println("Logging out");
                    t.isLoggedIN = false;
                }
                //student section
                else if (choice == 3) {
                    Student s = signupAsStudent();
                    char loop = 'y';
                    while (loop == 'y') {
                        studentUtils(s);
                        System.out.println("Press y to continue and any other character to logout");
                        loop = sc.next().toLowerCase().charAt(0);
                    }
                    System.out.println("Logging out");
                    s.isLoggedIN = false;
                } else System.out.println("Invalid choice");

            } else System.out.println("Invalid choice!");
            System.out.println("Do you wanna repeat or quit? press any character except 'y' to quit : ");
            repeat = sc.next().charAt(0);
        }
    }

}
