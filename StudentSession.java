//Aaditya - Student Session

public class StudentSession{
    
    private int sHour;
    private int sMinute;
    private int eHour;
    private int eMinute;
    
    private int m;
    private int d;
    private int y;
    
    private int id;
    
    public static int idCounter = 0;
    
    public StudentSession(int sh, int sm, int eh, int em, int m, int d, int y){
        
        this.sHour = sh;
        this.sMinute = sm;
        this.eHour = eh;
        this.eMinute = em;
        
        this.m = m;
        this.d = d;
        this.y = y;
        
        this.id = idCounter;
        idCounter++;
    }
    
    public String toString(){
        return ""+this.sHour+":"+this.sMinute+"-"+this.eHour+":"+this.eMinute+" on "+this.m+"/"+this.d+"/"+this.y+" ID: "+this.id;
    }
    
    
}
