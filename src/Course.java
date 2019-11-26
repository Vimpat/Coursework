import java.util.ArrayList;

/**
 * The course which is specific to only one subject.
 * It also contains when it starts and its duration.
 */

public class Course {

    private Subject subject;
    private Instructor instructor;
    private boolean cancelled = false;

    private int daysUntilStarts, daysToRun;
    private ArrayList<Student> studentGroup = new ArrayList<>();

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
        } else {
            return this.daysToRun;
        }
    }

    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * A day passes, modifying either how many days until the course starts or until it is finished.
     */
    public void aDayPasses() {

        if ( this.daysUntilStarts != 0 ) {
            this.daysUntilStarts--;
        }

        //if the course starts then we run the course until it's done.
        else if ( this.daysToRun != 0) {
            this.daysToRun--;
        }

        // If the course is finished then every student taking it will graduate.
        if (this.daysToRun == 0) {
            for ( Student student : studentGroup ) {
                student.graduate(subject);
            }
            studentGroup.clear();
            if (this.hasInstructor() ) instructor.unassignCourse();
        }

        if ( this.daysUntilStarts == 0 ) {

            // if there is no instructor or there are no students then cancel the course.
            if (!this.hasInstructor()) {
                this.cancelled = true;
                studentGroup.clear();
                this.daysToRun = 0;
            }

            else if (studentGroup.size() == 0) {
                this.cancelled = true;
                instructor.unassignCourse();
                this.daysToRun = 0;
            }
        }
    }

    /**
     * Enrols the student in the course. Returns true if the registration was successful, otherwise returns false.
     */
    public boolean enrolStudent( Student student) {

        if ( studentGroup.size() == 3 ) {
            System.out.println("Error: Course is full.");
            return false;
        } else if ( daysUntilStarts == 0 ) {
            System.out.println("Error: Course has already started");
            return false;
        } else {
            studentGroup.add(student);
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
     * Converts the arraylist to a simple list and returns it
     */
    public Student[] getStudents() {
        return studentGroup.toArray(new Student[0]);
    }

    /**
     * Checks whether the instructor can teach the course and assigns it to him if he is able to.
     */
    public boolean setInstructor (Instructor instructor) {
        if ( instructor.canTeach(this.subject)) {
            instructor.assignCourse(this);
            this.instructor = instructor;
            return true;
        }
        return false;
    }

    /**
     * Checks whether an instructor is assigned to the course.
     */
    public boolean hasInstructor() {

        return instructor != null;
    }

}
