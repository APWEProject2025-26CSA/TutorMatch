public class Appointment {
    // Appointment Maker
    public static final int STATUS_REQUESTED = 0;
    public static final int STATUS_CONFIRMED = 1;
    public static final int STATUS_CANCELED = 2;
    private static int nextId = 1;
    private final int id;
    private final Student student;
    private final Tutor tutor;
    private final int period;
    private final int startMinute;
    private final int duration;
    private final String subject;
    private int status;

    public Appointment(Student student, Tutor tutor, int period, int startMinute, int duration, String subject) {
        this.id = nextId++;
        this.student = student;
        this.tutor = tutor;
        this.period = period;
        this.startMinute = startMinute;
        this.duration = duration;
        this.subject = subject;
        this.status = STATUS_REQUESTED;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public int getPeriod() {
        return period;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getDuration() {
        return duration;
    }

    public int getEndMinute() {
        return startMinute + duration;
    }

    public String getSubject() {
        return subject;
    }

    public int getStatus() {
        return status;
    }

    public boolean isConfirmed() {
        return status == STATUS_CONFIRMED;
    }

    public boolean isCanceled() {
        return status == STATUS_CANCELED;
    }

    public void confirm() {
        if (status != STATUS_CANCELED) {
            status = STATUS_CONFIRMED;
        }
    }

    public void cancel() {
        status = STATUS_CANCELED;
    }

    private String statusName() {
        if (status == STATUS_CONFIRMED) {
            return "CONFIRMED";
        } else if (status == STATUS_CANCELED) {
            return "CANCELED";
        } else {
            return "REQUESTED";
        }
    }
    public String toString() {
        String studentName = (student != null) ? student.getUname() : "Unknown Student";
        String tutorName = (tutor != null) ? tutor.getFname() + " " + tutor.getLname() : "Unknown Tutor";
        String subjectText = (subject != null && !subject.isEmpty()) ? subject : "General";
        return "Appointment #" + id + " [" + statusName() + "] "
                + "Student=" + studentName + ", Tutor=" + tutorName
                + ", Period=" + period + ", StartMinute=" + startMinute
                + ", Duration=" + duration + " min"
                + ", Subject=" + subjectText;
    }
}

