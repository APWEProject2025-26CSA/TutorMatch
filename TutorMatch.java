//Aaditya - Terminal UI, Main Class

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TutorMatch{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to TutorMatch");
        System.out.println("Are you logging into an existing account (y/n)");
        String inpt1 = scan.nextLine();
        if (inpt1.equals("y")){
            System.out.println("Are you logging into a tutor or student account (s/t)");
            String inpt2 = scan.nextLine();
            if (inpt2.equals("s")){
                System.out.println("Please enter your username.");
                String un = scan.nextLine();
                System.out.println("Please enter your password.");
                String pwdAuth = scan.nextLine();
                Student s = Student.getStudent(un, pwdAuth);
                if (s==null){
                    System.out.println("Wrong Credentials Entered, Please Try Again Later");
                    //Exit program
                }
            } else if (inpt2.equals("t")){
                
            }
            //Once tutor class is ready, implement login process
        } else if (inpt1.equals("n")){
            System.out.println("Would you like to create a new student or tutor account (s/t)");
            String inpt2 = scan.nextLine();
            if (inpt2.equals("s")){
                System.out.println("Please enter your first name");
                String fn = scan.nextLine();
                
                System.out.println("Please enter your last name");
                String ln = scan.nextLine();
                
                System.out.println("Please enter your age");
                int a = Integer.parseInt(scan.nextLine());
                
                System.out.println("Please enter your grade level");
                int g = Integer.parseInt(scan.nextLine()); 
                
                System.out.println("Please enter a password");
                String pwd = scan.nextLine();
                
                Student s = new Student(fn, ln, a, g, pwd);
                System.out.println("Your Username Is: "+s.getUname());
            }
        } else {
            //End program
        }
    }
}
