//Tutor Class
//Anjana

import java.util.ArrayList;
public class Tutor {
    private String fname;
    private String lname;
    private String uname;
    private String password;
    private int age;
    private ArrayList<String> subjects; 
    private double rating;             
    private double hourlyRate; 
    private int experienceYears;        
    private boolean isVerified; // Rithvik
    
    public static ArrayList<String> tUnames = new ArrayList<>();
    public static ArrayList<Tutor> tutors = new ArrayList<>();
    
    public String getUname(){
        return uname;
    }
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
    // Rithvik - Bottom 3 Methods
    public int getExperienceYears(){
        return experienceYears;
    }
    public double getRating(){
        return this.rating;
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
    public void setVerify(boolean val){this.isVerified=val;} // Rithvik
    public Tutor(String fname, String lname, int age, int experienceYears, String password) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.experienceYears = experienceYears;
        this.password = password;
        this.rating = 0.5;
        this.subjects = new ArrayList<>();
        
        String un = fname + lname;
        if (!unameAvail(un)) {
            int count = 1;
            String check = un + count;
            while (!unameAvail(check)) {
                count++;
                check = un + count;
            }
            this.uname = check;
        }
        else {
            this.uname = un;
        }
        //Aaditya logic from student class
        tUnames.add(this.uname);
        tutors.add(this);
    }
        
    public static Tutor getTutor(String username, String password) {
        for (Tutor t : tutors) {
            if (t.getUname().equals(username) && t.password.equals(password)) {
                return t;
            }
        }
        return null;
    }

    public void addSubject(String sub) {
        if (!this.subjects.contains(sub)) {
            this.subjects.add(sub);
        }
    }
    
    public boolean unameAvail(String in){
        for (String un: tUnames){
            if (un.equals(in)){
                return false;
            }
        }
        return true;
    }
    
    public void removeSubject(String sub){
        for (int i=0; i<this.subjects.size(); i++){
            if (sub.equals(this.subjects.get(i))){
                subjects.remove(i);
            }
        }
    }
}
