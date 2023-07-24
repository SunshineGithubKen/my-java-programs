import java.sql.SQLOutput;
import java.util.Scanner;

public class Student {

    /// Fields
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String ID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;  // static means variable is true for the class, not specific objects or instance
    private static int id = 1000;

    /// Constructor
                /// ask user to enter student's name and year
    public Student () {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    /// Generate ID
    private void setStudentID() {
        // Grade Level + ID
        id++;   // increment id when adding one student
        this.ID = gradeYear + "" + id;
    }

    /// Enroll in courses
    public void enroll (){
        // Get inside a loop,  user hits 0
        do {
            System.out.print("Enter course to enroll (Q to quit); ");
            Scanner in = new Scanner (System.in);
            String course = in.nextLine();
            if (!course.equals ("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break; }
            } while (1 != 0);
    }

    /// view balance
    public void viewBalance() {
        System.out.println ("Your balance is: $" + tuitionBalance);
    }

    /// Pay tuition
    public void payTuition ( ){
        viewBalance();
        System.out.print ("Enter your payment: $");
        Scanner in = new Scanner (System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        viewBalance();
    }

    /// Show status
    public String toString () {     // toString is to override, parents class
                                    // public String showInfo () too correct
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + ID +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
