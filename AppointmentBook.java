import java.util.ArrayList;

public class AppointmentBook
{   /**
    * Returns true if minute in period is available for an appointment and returns
    * false otherwise
    * Preconditions: 0 <= period <= 8; 0 <= minute <= 101
    */
// Set up a schedule facing for teachers and students
// Firstly, we need availability blocks for teachers. 
// Availability blocks are ingrained in the school schedule: Advisory, A, B, C, D, E, F, G, H
// We will represent these 8 blocks with numbers instead:          0,  1, 2, 3, 4, 5, 6, 7, 8

private ArrayList<String> availBlocks;
private int[][] availableTimings; // Instance variable to store the entered timings
private boolean[][] minuteAvailability; // Saves whether each minute is available or not
public final int[][] schedule = { // Block by Block Schedule for AAE
    {1, 2, 3, 4, 5}, // Monday
    {6, 7, 8, 1, 2}, // Tuesday
    {0, 3, 4, 5, 6}, // Wednesday
    {7, 8, 1, 2, 3}, // Thursday
    {4, 5, 6, 7, 8} // Friday
};
public final int[] timings = {70, 68, 68, 101, 69}; // Timings per block per regular class day

public AppointmentBook(ArrayList<String> availBlock, int[][] availableTimings,int[][] unavailableBlocks){
    this.availBlocks = availBlock;
    this.availableTimings = availableTimings; // Saves the entered daily timings
    // 1. Initialize the matrix (9 periods total, max 102 minutes)
        this.minuteAvailability = new boolean[9][102];
        // 2. Set all minutes to true (available) by default
        for (int r = 0; r < minuteAvailability.length; r++) {
            for (int c = 0; c < minuteAvailability[0].length; c++) {
                minuteAvailability[r][c] = true; 
            }
        }
        // 3. Process any pre-existing unavailable timings
        if (unavailableBlocks != null) {
            for (int[] booked : unavailableBlocks) {
                int p = booked[0];       
                int start = booked[1];   
                int dur = booked[2];    
                for (int m = start; m < start + dur; m++) {
                    minuteAvailability[p][m] = false;
                }
            }
    }
}
public AppointmentBook(ArrayList<String> availBlock, int[][] availableTimings){
    this.availBlocks = availBlock;
    this.availableTimings = availableTimings;
        this.minuteAvailability = new boolean[9][102];
        for (int r = 0; r < minuteAvailability.length; r++) {
            for (int c = 0; c < minuteAvailability[0].length; c++) {
                minuteAvailability[r][c] = true; 
            }
        }
}

private boolean isMinuteFree(int period, int minute){
return minuteAvailability[period][minute];
}

/**
* Marks the block of minutes that starts at startMinute in period and
* is duration minutes long as reserved for an appointment
*/

private void reserveBlock(int period, int startMinute, int duration)
{for (int i = startMinute; i < startMinute + duration; i++) {minuteAvailability[period][i] = false;}}

/**
* Searches for the first block of duration free minutes during period, as described in
* part (a). Returns the first minute in the block if such a block is found or returns -1 if no
* such block is found.
* Preconditions: 1 <= period <= 8;
*/

public int findFreeBlock(int period, int duration)
{int blockLength = 0;
for (int minute = 0; minute < minuteAvailability[period].length; minute++) {
    if (isMinuteFree(period, minute)) {
    blockLength++;
    if (blockLength == duration) {return minute - blockLength + 1;}
    } else {blockLength = 0;}
}
return -1;}

public boolean makeAppointment(int startPeriod, int endPeriod,int duration){
for (int period = startPeriod;period <= endPeriod; period++)
{int minute = findFreeBlock(period, duration);
if (minute != -1)
{reserveBlock(period, minute, duration);
return true;}}
return false;}
}

/* TODO:

//Add method in ApptBook class to schedule based on lunch blocks for grade, first & second, or MS grade lunches, student should be able to choose if they want first or second based on the day if in HS

In Student Class:
These methods let a student request and manage tutoring time during the school day:

//Timing will be based on tutor, student will be able to select one out of the preferred times (this method isn't required)
public void addPreferredTime(int startPeriod, int endPeriod)
- can store the student’s available school-day windows.

//Already integrated/integrating in a different method
public boolean requestSession(Tutor tutor, int duration)
- Sends a session request to a tutor.

//Unecessary
public void confirmSession(int sessionId)
- Marks a requested session as accepted/confirmed.

public ArrayList<Appointment> getScheduledSessions()
- Returns the student’s upcoming tutoring appointments.

public void cancelSession(int sessionId)
- Lets the student cancel a booked session.

In Tutor Class:
These methods let a tutor manage their availability and actually reserve tutoring blocks:

public void addAvailability(int startPeriod, int endPeriod)
- Defines when the tutor is free during the school day.

public boolean isAvailable(int period, int duration)
- Uses the existing scheduling logic from AppointmentBook.java to check whether a block is free.

public boolean scheduleSession(Student student, int startPeriod, int duration)
- Reserves a tutoring block and links it to a student.

public ArrayList<Appointment> getBookedSessions()
- Returns all appointments already assigned to that tutor.

public void cancelSession(int sessionId)
- Removes a reserved session if needed.

*/
