/**
 * Instructor for the courses.
 */
public abstract class Instructor extends Person {
    private Course assignedCourse;

    /**
     * Abstract class to know whether one instructor can teach a given subject, given its level of specialism.
     */
    public abstract Boolean canTeach( Subject subject );

    /**
     * Initializes the Instructor, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Assigns the course to the instructor.
     */
    public void assignCourse (Course course) {
        this.assignedCourse = course;
    }

    /**
     * Unassigns the course to the instructor.
     */
    public void unassignCourse() {
        this.assignedCourse = null;
    }

    /**
     * Returns the course assigned to the instructor.
     */
    public Course getAssignedCourse() {
        return this.assignedCourse;
    }

    public boolean isFree() {
        return this.assignedCourse == null;
    }
}
