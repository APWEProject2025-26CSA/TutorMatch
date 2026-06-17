//Main Terminal UI - Aaditya

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TutorMatch{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to TutorMatch");
        System.out.println("Are you logging into an existing account (y/n)");
        String inpt1 = scan.nextLine();
        
        Student s = null;
        Tutor t = null;
        
        if (inpt1.equals("y")){
            System.out.println("Are you logging into a tutor or student account (s/t)");
            String inpt2 = scan.nextLine();
            if (inpt2.equals("s")){
                System.out.println("Please enter your username.");
                String un = scan.nextLine();
                System.out.println("Please enter your password.");
                String pwdAuth = scan.nextLine();
                Student s1 = Student.getStudent(un, pwdAuth);
                s=s1;
                System.out.println("Student logged in");
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
                
                Student s2 = new Student(fn, ln, a, g, pwd);
                System.out.println("Your Username Is: "+s.getUname());
                s = s2;
            }
        } else {
            //End program
            System.exit(0);
        }
        
        if (s==null && t!=null){
            //Tutor actions
        } else if (s!=null && t==null){
            //Student actions
            
            System.out.println("Type \"-1\" to exit the program");
            while (true){
                System.out.println("1: Add subject to requested subjects list");
                System.out.println("2: Remove subject");
                System.out.println("3: Match");
                System.out.println("4: Request Session");
                System.out.println("5: Cancel Next Session");
                System.out.println("6: Request Tutor");
                System.out.println("7: Review Tutor");
                
                int response = Integer.parseInt(scan.nextLine());
                
                switch (response){
                    case 1:
                        System.out.println("Enter subject");
                        String aSubject = scan.nextLine();
                        s.addSubject(aSubject);
                    case 2:
                        System.out.println("Enter subject");
                        String rSubject = scan.nextLine();
                        s.removeSubject(rSubject);   
                    case 3:
                        System.out.println("Enter subject");
                        String mSubject = scan.nextLine();
                        s.matchSingular(rSubject); 
                    case 4:
                        System.out.println("Enter Tutor username");
                        String sTUname = scan.nextLine();
                        s.requestSession(sTUname);
                    case 5:
                        s.cancelNextSession();
                        System.out.println("Session canceled");
                    case 6:
                        System.out.println("Enter subject");
                        String rTSubject = scan.nextLine();
                        s.requestTutor(rTSubject, scan);
                    case 7:
                        //Tutor Method Required
                    case -1:
                        break;
                        System.exit(0);
                }
            }
        } else {
            //End program
            System.exit(0);
        }
    }
}
