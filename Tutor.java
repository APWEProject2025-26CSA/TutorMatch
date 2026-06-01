//Tutor Class
//Anjana

import java.util.ArrayList;

public class Tutor {
    private String fname;
    private String lname;
    private String uname;
    private int age;
    private ArrayList<String> tSubjects; 
    private double rating;             
    private int experienceYears;        
    
    public static ArrayList<String> tUnames = new ArrayList<>();
    public static ArrayList<Tutor> tutors = new ArrayList<>();

    
public String getFname() { 
        return fname; 
    }
    public String getLname() { 
        return lname; 
    }
    public int getAge() { 
        return age; 
    }
    public ArrayList<String> getSubjects() { 
        return subjects; 
    }





public void setFname(String fname) { 
        this.fname = fname; 
    }
    public void setLname(String lname) { 
        this.lname = lname; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }
    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects; 
    }



}





