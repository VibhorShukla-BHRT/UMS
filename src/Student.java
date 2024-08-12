package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student extends Scheme {
    private final String fname,mname;
    private ArrayList<String> courses = new ArrayList<>();
    HashMap<String,Character> marks = new HashMap<>();
    private String grade,dept;
    Student(String name, String address, long mob, String fname, String mname, String grade, String dept) {
        super(name, address, mob);
        this.fname = fname;
        this.mname = mname;
        this.grade = grade;
        this.dept = dept;
    }
    //getters
    public String getFatherName(){
        return this.fname;
    }
    public String getMotherName(){
        return this.mname;
    }
    public String getDepartment(){
        return  this.dept;
    }
    public String getGrade() {
        return this.grade;
    }
    private String getAddress() {
        return this.address;
    }

     void getDetails(){
        System.out.println("src.Student's ID : "+ this.getId());
        System.out.println("Name : "+ this.name);
        System.out.println("Address : "+ this.getAddress());
        System.out.println("Mobile Number : "+ this.mob);
        System.out.println("Father's name : "+ this.getFatherName());
        System.out.println("Mother's name : "+ this.getMotherName());
        System.out.println("Grade : "+ this.getDepartment());
        System.out.println("Department : "+ this.getGrade());
    }


    //other functions
    void GiveExam(String courseName){
        //access the couse db and get the paperurl
        System.out.println("Following is paper url(you can paste it in browser and give exam, Good luck!)");
        String query = "SELECT paperUrl from courses where name='"+courseName+"'";
        DB.readData(query,DB.getConn());
        //after assessment of student's paper, appropriate marks can be assigned
    }
    void TakeCourses(){
    //printing courses available from db "course"
        System.out.println("Courses available : ");
        String query = "SELECT name from courses";
        DB.readData(query,DB.getConn());
        System.out.println("How many courses do you wanna take? ");
        Scanner sc = new Scanner(System.in);
        try{
            int n = sc.nextInt();
            while((n--)>0){
                System.out.println("Please enter the name of the subject : ");
                String s = sc.next();
                this.courses.add(s);
            }
            System.out.println("Selected Courses : ");
            for (String cours : this.courses) {
                System.out.println(cours);
            }
        }catch (Exception e){
            System.out.println("Error : "+ e.getMessage());
        }
    }


}
