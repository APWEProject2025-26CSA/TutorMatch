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
    private String pwd;
    private boolean isMatched;
    
    private ArrayList<Tutor> matches;
    
    public static ArrayList<String> sUnames;
    public static ArrayList<Student> students;
    
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
            this.bRating = 0;
        }
    }
    
    private String getPwd(String un){
        return this.pwd;
    }
    
    public static boolean checkPwd(String un, String pwd){
        String cPwd = null;
        for (Student s : students){
            if (s.getUname().equals(un)){
                cPwd = s.getPwd(un);
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
    
    public void matchSingular(String subject){
        ArrayList<Tutor> m1 = TutorMatcher.matchStudents(this, subject);
        m1.add(0, "Matches for: "+subject);
        this.matches.add(m1);
    }
    
}
