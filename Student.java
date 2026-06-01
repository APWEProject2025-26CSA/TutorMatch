
//Aaditya
//Student Class
import java.util.ArrayList;

public class Student{
    
    private int age;
    private String fname;
    private String lname;
    private ArrayList<String> subjects;
    private String uname;
    private double aRating;
    private double bRating;
    private int gradeLevel;
    public boolean isMatched; // Rithvik - Checks if he is matched with a tutor at the moment for a session or not
    
    public static ArrayList<String> sUnames;
    public static ArrayList<Student> students;
    
    public Student(String fname, String lname, int age, int gradeLevel){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.aRating = 0.5;
        this.bRating = 0.5;
        this.gradeLevel = gradeLevel;
        this.subjects = new ArrayList<>();
        
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
    
    public String getUname(){
        return this.uname;
    }

    public double getAcademicRating(){ // Rithvik
        return this.aRating;
    }
    
    public void increment(){
    this.age++;
    this.gradeLevel++;
    }
    
    /*
    public void review(double b, double a){
        this.aRating+=a*0.1;
        this.bRating+=b*0.1;	
    }
    */

    //Patched review method
    public void review(double b, double a){
        this.aRating+=a*0.1;
        this.bRating+=b*0.1;
        
        if (this.aRating>1){
            this.aRating = 1;
        } else if (this.aRating<0){
            this.aRating = 0;
        }
        
        if (this.bRating>1){
            this.bRating = 1;
        } else if (this.bRating<0){
            this.bRating = 0;}
        }
}
