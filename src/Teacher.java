package src;

public class Teacher extends Scheme {
    private String dept,subjectT;

     Teacher(String name, String address, long mob, String dept, String subjectT) {
        super(name, address, mob);
        this.dept = dept;
        this.subjectT = subjectT;
    }

    //getters
    public String getDept(){ return this.dept; }

    void getFacultyDetails(){
        System.out.println("FacID : "+this.getId());
        System.out.println("Name : "+ this.name);
        System.out.println("MobileNo : "+ this.mob);
        System.out.println("Address + "+this.address);
        System.out.println("Department : "+this.getDept());
        System.out.println("SubjectTaught : "+this.subjectT);
    }

    //other methods
    void takeExam(String paperUrl, long timeInterval){
        //create a paper table which contains subject and links column, so that students can access it during "giving exam"
        //paperUrl will be put in paperUrl field of teacher table, which will be removed after time interval, the question paper will also have a timer
        String query = "UPDATE courses SET paperUrl = '"+paperUrl+"', duration='"+timeInterval+"' WHERE name = '"+this.subjectT+"';";
        DB.updateData(query,DB.getConn());
        System.out.println("Paper url updated! Students can now give the exam!");
    }

    void assignGrade(Student st, char grade){
        st.marks.put(this.subjectT, grade);
    }

}
