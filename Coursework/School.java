import java.util.ArrayList;

public class School {
    String name;
    //list of students currently attending the school.
    ArrayList<Student> students = new ArrayList<Student>();
    //list of courses the school teaches.
    ArrayList<Course> courses = new ArrayList<Course>();
    //list of instructors the school has
    ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    //list of subjects the school can teach
    ArrayList<Subject> subjects = new ArrayList<Subject>();

    /**
     * Creates the school, which has a name.
     */
    public School ( String name ) {
        this.name = name;
    }

    /**
     * Adds a new student to the school.
     */
    public void add ( Student student ) {
        this.students.add( student );
    }

    /**
     * Removes a student from the school.
     */
    public void remove ( Student student ) {
        this.students.remove( student );
    }

    /**
     * Returns the list of students currently attending the school.
     */
    public ArrayList<Student> getStudents() {
        return this.students;
    }

    /**
     * Adds the course to the school's curriculum.
     */
    public void add ( Course course ) {
        this.courses.add( course );
    }

    /**
     * Removes the course from the school's curriculum.
     */
    public void remove ( Course course ) {
        this.courses.remove( course );
    }

    /**
     * Returns the list of courses the school teaches.
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Adds an instructor to the list of instructors.
     */
    public void add ( Instructor instructor ) {
        this.instructors.add( instructor );
    }

    /**
     * Removes an instructor from the list of instructors.
     */
    public void remove ( Instructor instructor ) {
        this.instructors.remove( instructor );
    }

    /**
     * RReturns the list of instructors the school has
     */
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    /**
     * Simulates a day in the school.
     */
    public void aDayAtSchool () {
        //Makes sure that all subjects have a course assigned to it.
        for (Subject subject : this.subjects ) {
            if (subject.hasCourse( this.courses ) ) {
                courses.add( new Course( subject,2 ) );
            }
        }

        for ( Course course : this.courses ) {
            //Assigns an instructor to the course if one is available.
            if ( !course.hasInstructor() ) {
                for ( Instructor instructor : this.instructors ) {
                    if ( instructor.isFree() && instructor.canTeach( course.getSubject() ) ) {
                        course.setInstructor( instructor );
                    }
                }
            }
            //assigns any free student to the course if he is eligible.
            for ( Student student : this.students ) {
                course.enrolStudent( student );
            }

            course.aDayPasses();

            if (course.isCancelled() || course.getStatus() == 0) {
                this.courses.remove(course);
            }
        }
        }
    }
