// Matching Class
//Rithvik

//Simple First Draft: 

public class TutorMatcher{
// Main Matching Method

    public List<Tutor> findBestTutors(Student student, List<Tutor> tutors) {
        List<Tutor> matches = new ArrayList<>();
        for (Tutor tutor : tutors) {
            // Check subject match
            if (tutor.subject.equals(student.subjectNeeded)) {
                // Check tutor rating
                if (tutor.rating >= 4.5) {
                    matches.add(tutor);
                    if(student.needLevel > 0.5){
                        student.isMatched = true;
		matches = {tutor};
                    }
                }
            }
        }
        return matches;
}




}
