import java.util.Scanner;

public class Email {
    /// Create fields (elements) required
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int passwordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    /// Constructor to receive  firstname, lastname

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
 //  \\     System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        // \Call a method asking for the department - return the department
        this.department = setDepartment();
 //  \\        System.out.println("Department: " + this.department);

        // \Call a method to return a random password
        this.password = randomPassword(passwordLength);
     System.out.println("Your password is: " + this.password);

        // \Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//  \\       System.out.println("Your email is: " + email);

    }

    /// Ask for department
    private String setDepartment() {
        // unwant to use println
        System.out.print("Department Codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) return "sales";
        else if (depChoice == 2) return "dev";
        else if (depChoice == 3) return "acct";
        else return "";

        }




    /// Generate a random password
    private String randomPassword(int length){  // setting password char length
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; // treat them as charactors, not array
        char[] password = new char [length];   // charactor with length to be set
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand); // to equal passwordset from ABC character at random number, length
        }
        return new String(password);  // if wo new String, it appoint above variable passwor
    }

    /// Set the mailbox capacity
    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }
    /// Set the alternate email
    public void setAlternateEmail (String altEmail){
        this.alternateEmail = altEmail;
    }

    /// change password
    public void changePassword (String password) {
        this.password = password;
    }

    // \ create these methods, so it will not access to the fields directly
    public int getMailboxCapacity() { return  mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    // \ Have get methods, to display the name, email, and mailbox capacity
    public String showInfo() {
        return "Display name " + firstName + " " 
    	+ lastName + " " + "\nCompany Email: " + email + "" 
    	+ "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}


