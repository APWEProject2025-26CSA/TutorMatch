// Rithvik Suren - Matching Class Draft (Core Matching Proces Complete)

// Use Java ArrayList
import java.util.ArrayList;

// Matching Class
public class TutorMatcher{
    // Main Matching Method
    public ArrayList<Tutor> matchStudents(Student student, String subjectNeeded){

        ArrayList<Tutor> matches = new ArrayList<>();
        for (Tutor tutor : Tutor.tutors) {
            // Check subject match
             if(tutor.getSubjects().contains(subjectNeeded)) {
                // Check tutor rating
                if (tutor.getRating() >= 4.5) {              // Solid rating
                    matches.add(tutor);
                    if(student.getAcademicRating() <= 0.5) {        
                        student.isMatched = true;
                    }
                } else if (tutor.getRating() >= 3.5 && tutor.getExperienceYears() > 3) {
                    // Borderline rating, but experienced = might be good with struggling students
                    matches.add(tutor);
                    if(student.getAcademicRating() <= 0.5) {        
                        student.isMatched = true;             // Good match
                    }
                }
            }  
        }
        return matches;
    }
}
