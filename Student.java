//Aaditya - Student Class

import java.util.ArrayList;
import java.util.Scanner;

public class Student{
    
    private int age;
    private String fname;
    private String lname;
    private ArrayList<String> subjects;
    private String uname;
    private double aRating;
    private double bRating;
    private int gradeLevel;
    private String pwd;
    private boolean isMatched;
    private ArrayList<Tutor> tutors;
    
    private ArrayList<Tutor> matches;
    private ArrayList<String> subjectMatches;
    
    private ArrayList<Tutor> myTutors;
    private ArrayList<Tutor> requestedTutors;
    private ArrayList<String> sessions;
    private ArrayList<Tutor> requestedSessions;
    private StudentSession nextSession;
    
    public static ArrayList<String> sUnames = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    
    public Student(String fname, String lname, int age, int gradeLevel, String pwd){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.aRating = 0.5;
        this.bRating = 0.5;
        this.gradeLevel = gradeLevel;
        this.subjects = new ArrayList<>();
        this.pwd = pwd;
        this.isMatched = false;
        this.matches = new ArrayList<>();
        this.myTutors = new ArrayList<>();
        this.requestedTutors = new ArrayList<>();
        this.sessions = new ArrayList<>();
        this.requestedSessions = new ArrayList<>();
        this.nextSession = null;
        
        String un = fname+lname;
        if (!unameAvail(un)){
            int count = 1;
            String check = un+count;
            while (!unameAvail(check)){
                count++;
                check = un+count; 
            }
            this.uname = check;
        } else {
            this.uname = un;
        }
        
        sUnames.add(this.uname);
        students.add(this);
    }
    
    public boolean unameAvail(String in){
        for (String un : sUnames){
            if (un.equals(in)){
                return false;
            }
        }
        return true;
    }
    
    public void addSubject(String sub){
        this.subjects.add(sub);
    }
    
    public void removeSubject(String sub){
        for (int i=0; i<this.subjects.size(); i++){
            if (sub.equals(this.subjects.get(i))){
                subjects.remove(i);
            }
        }
    }
    
    public void match(){
        this.isMatched = true;
    }
    
    public void unMatch(){
        this.isMatched = false;
    }
    
    public boolean getMatched(){
        return this.isMatched;
    }
    
    public String getUname(){
        return this.uname;
    }
    
    public void increment(){
        this.age++;
        this.gradeLevel++;
    }
    
    public static void review(String sUname, Tutor t, double b, double a){
        //Ensure tutor is logged in, and has sUname in their students list
        
        Student rs = getStudentBypassPwd(sUname); 
        
        rs.aRating+=a*0.1;
        rs.bRating+=b*0.1;
        
        if (rs.aRating>1){
            rs.aRating = 1;
        } else if (rs.aRating<0){
            rs.aRating = 0;
        }
        
        if (rs.bRating>1){
            rs.bRating = 1;
        } else if (rs.bRating<0){
            rs.bRating = 0;
        }
    }
    
    private String getPwd(){
        return this.pwd;
    }
    
    public static boolean checkPwd(String un, String pwd){
        String cPwd = null;
        for (Student s : students){
            if (s.getUname().equals(un)){
                cPwd = s.getPwd();
            }
        }
        if (cPwd == null){
            return false;
        }
        if (cPwd.equals(pwd)){
            return true; 
        } else {
            return false;
        }
    }
    
    public static Student getStudent(String uname, String pwd){
        Student st = null;
        for (Student s : students){
            if (s.getUname().equals(uname)){
                st = s;
            }
        }
        if (st!=null){
            if (st.getPwd().equals(pwd)){
                return st;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    private static Student getStudentBypassPwd(String uname){
        Student st = null;
        for (Student s : students){
            if (s.getUname().equals(uname)){
                st = s;
            }
        }
        if (st!=null){
            return st;
        } else {
            return null;
        }
    }
    
    public void requestTutor(String subject, Scanner scan){
        
        int ind = -1;
        
        for (int i=0; i<this.subjectMatches.size(); i++){
            if (this.subjectMatches.get(i).equals(subject)){
                ind = i;
            }
        }
        
        if (ind==-1){
            System.out.println("Match doesn't exist");
        } else {
            ArrayList<Tutor> options = this.matches.get(ind);
            System.out.println("Here are your options: ");
            
            for (int j=0; j<this.options.size(); j++){
                Tutor opt = options.get(j);
                System.out.print(""+j+": ");
                //Print key info about each tutor
                System.out.println();
            }
            
            System.out.println("Please select a tutor");
            
            int picked = Integer.parseInt(scan.nextLine());
            
            Tutor pt = options.get(picked);
            
            this.requestedTutors.add(pt);
            
        }
    }
    
    //Invoked by tutor class
    public void addTutor(Tutor tut){
        this.myTutors.add(tut);
    }
  
    public void matchSingular(String subject){
        ArrayList<Tutor> m1 = TutorMatcher.matchStudents(this, subject);
        this.matches.add(m1);
        this.subjectMatches.add(subject);
    }
    
    public boolean requestSession(String tUName){
        
        boolean found = false;
        Tutor st = null;
        for (Tutor tut : this.myTutors){
            if (tut.getUname().equals(tUName)){
                found = true;
                st = tut;
            }
        }
        if (found){
            //Invoke method in tutor class to request session and from there the tutor checks and schedules
            this.requestedSessions.add(st);
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<StudentSession> getPossSessions(String tUname){
        
        Tutor ps = null;
        for (Tutor tut : this.requestedSessions){
            if (tut.getUname.equals(tUname)){
                ps = tut;
            }
        }
        
        if (ps!=null){
            
            //Get session times from tutor class
            
        } else {
            System.out.println("None");
            return new ArrayList<StudentSession>();
        }
    }
    
    public void acceptSession(ArrayList<StudentSession> ss, Scanner scan){
        for (int i=0; i<ss.size(); i++){
            System.out.print(""+i+": "+ss.get(i).toString());
            System.out.println();
        }
        System.out.println("Pick a session");
        int ind = Integer.parseInt(scan.nextLine());
        
        this.nextSession = ss.get(ind);
        
        //Call tutor class method to confirm session
        
        
    }
    
    public void cancelNextSession(){
        //Notify tutor via tutor method
        this.nextSession = null;
    }
}
