import java.util.ArrayList;

/**
 * The course which is specific to only one subject.
 * It also contains when it starts and its duration.
 */

public class Course {

    private Subject subject;

    private int daysUntilStarts, daysToRun;
    private Student[] studentGroup = new Student[3];

    /**
     * Creates the Course object, asking for the subject it is associated with, along with the date it starts.
     */
    public Course( Subject subject, int daysUntilStarts ) {

        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        this.daysToRun = this.subject.getDuration();
    }

    /**
     * Returns the name of the subject.
     */
    public Subject getSubject() {

        return subject;
    }

    /**
     * Calculates the status of the course.
     * If the course hasn't started yet it returns how many days until it starts (in negative numbers);
     * Else if the it is currently running then it returns how many days until it is finished;
     * Else if it is done then it returns 0.
     */
    public int getStatus() {

        if ( this.daysUntilStarts != 0 ) {
            return -this.daysUntilStarts;
        } else if ( this.daysToRun != 0 ) {
            return this.daysToRun;
        } else {
            return 0;
        }
    }

    /**
     * A day passes, modifying either how many days until the course starts or until it is finished.
     * If the course is finished then every student taking it will graduate.
     */
    public void aDayPasses() {

        if ( this.daysUntilStarts != 0 ) {
            this.daysUntilStarts--;
        } else if ( this.daysToRun != 0 ) {
            this.daysToRun--;
        } else {
            for (Student n : studentGroup) {
                n.graduate(subject);
            }
        }
    }

    /**
     * Enrols the student in the course. Returns true if the registration was successful, otherwise returns false.
     */
    public boolean enrolStudent( Student student) {

        if (studentGroup[2] != null) {
            System.out.println("Error: Course is full.");
            return false;
        } else if (daysUntilStarts == 0) {
            System.out.println("Error: Course has already started");
            return false;
        } else {
            int i = 0;

            //Looks for the first free place in the group for the new student to add.
            while (studentGroup[i] != null) {
                i++;
            }

            studentGroup[i] = student;
            return true;
        }
    }

    /**
     * Returns the number of students in the course.
     */
    public int getSize() {

        int number = 0;
        for ( Student n : studentGroup ) {
            if (n != null) number++;
        }
        return number;
    }

    /**
     * Returns the list of students in the course.
     */
    public Student[] getStudents() {

        return studentGroup;
    }
}
