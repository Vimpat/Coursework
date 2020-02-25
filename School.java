import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * The school. It holds several methods to help manipulating objects. It can also simulate a typical day at school.
 * Finally, it prints the current state of the school, meaning information about its students and instructors, about
 * subjects and courses.
 */
public class School {
    String name;
    //list of students currently attending the school.
    ArrayList<Student> students = new ArrayList<>();
    //list of courses the school teaches.
    ArrayList<Course> courses = new ArrayList<>();
    //list of instructors the school has
    ArrayList<Instructor> instructors = new ArrayList<>();
    //list of subjects the school can teach
    ArrayList<Subject> subjects = new ArrayList<>();

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
     * Adds the subject to the subject list.
     */
    public void add ( Subject subject ) {
        this.subjects.add( subject );
    }

    /**
     * Removes the subject from the subject list.
     */
    public void remove ( Subject subject ) {
        this.subjects.remove( subject );
    }

    /**
     * Returns the list of subjects given by the school.
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Returns the list of courses the school teaches.
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
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
     * Returns the list of instructors the school has
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
            if (!subject.hasCourse( this.courses ) ) {
                Course course = new Course (subject, 2);
                course.setPrerequisites( subject.getPrerequisites() );
                this.courses.add( course );
            }
        }

        //For all the courses that are no longer open for registration create a new course.
        ListIterator<Course> courseIt = courses.listIterator();
        while (courseIt.hasNext()) {
            Course course = courseIt.next();
            if (course.getSize() == 3 || course.getStatus() > 0) {
                Course course1 = new Course (course.getSubject(), 2);
                course1.setPrerequisites(course.getPrerequisites());
                courseIt.add( course1 );
            }
        }

        //If the course doesn't have an instructor then assigns an instructor to the course if one is available.
        for ( Course course : this.courses ) {
            if ( !course.hasInstructor() ) {
                for ( Instructor instructor : this.instructors ) {
                    if ( course.setInstructor( instructor ) ) {
                        break;
                    }
                }
            }
            //assigns any free student to the course if he is eligible.
            for ( Student student : this.students ) {
                course.enrolStudent( student );
            }

            course.aDayPasses();
        }


        // Remove the course from the list of courses if it is cancelled or finished.
        courses.removeIf( course -> course.isCancelled() || course.getStatus() == 0 );
    }

    /**
     * Prints out the current state of the school, along with the courses, teachers, students and the likes.
     */
    public String toString() {
        System.out.println();
        System.out.println( "The list of students is:" );
        for ( Student student : students ) {
            System.out.println(student.getName() + ' ' + student.getGender() + ' ' + student.getAge() + ' ' +
                    "which has certificates: ");
            for ( int certificate : student.getCertificates() ) System.out.println( certificate );
        }
        System.out.println();
        System.out.println("The list of instructors is:");
        for (Instructor instructor : instructors) {
            System.out.println( instructor.getName() + ' ' + instructor.getGender() + ' ' + instructor.getAge() );
        }
        System.out.println();
        System.out.println("The list of subjects is:");
        for (Subject subject : subjects) {
            System.out.println( subject.getDescription() + " with ID " + subject.getID() + " which has course:" +
                    subject.hasCourse(courses) + ' ' );
        }
        System.out.println();
        System.out.println("The list of courses is:");
        for (Course course : courses) {
            System.out.println( course.getSubject().getDescription() + ' ' + "which has students: ");
            for (Student student : course.getStudents() ) {
                System.out.println( student.getName() );
            }
            System.out.println(course.getSize());
        }
        System.out.println();
        System.out.println("The list of courses which have an instructor");
        for( Course course : courses ) {
            if ( course.hasInstructor() ) System.out.println( course.getSubject().getDescription() );
        }

        return "The day is finished";
    }

}
