import java.util.ArrayList;

/**
 * Student, subclass to the Person class. It also contains a list of certificates which is defined by an arraylist.
 */
public class Student extends Person {

    //Boolean for whether the current is currently studying or not.
    private Course assignedCourse;

    //A list of subject IDs that the student currently has.
    private ArrayList<Integer> certificates = new ArrayList<>();

    /**
     * Creates the student object, asks for the same input as the person class along with a list of IDs.
     */
    public Student ( String name, char gender, int age ) {
        super (name, gender, age);
    }

    /**
     * Adds the ID of the subject to the collections of certificates.
     */
    public void graduate ( Subject subject ) {
        certificates.add(subject.getID());
    }

    /**
     *  Returns the ArrayList of certificates obtained by the students.
     */
    public ArrayList<Integer> getCertificates() {
        return this.certificates;
    }

    /**
     * Checks whether or not the student has already obtained the certificate for the input subject.
     * Returns true if it does, otherwise it returns false.
     */
    public boolean hasCertificate( Subject subject ) {

        for (int ID : this.certificates) {
            if (ID == subject.getID()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether the student is free to study a course or not
     */
    public boolean isFree() {
        return this.assignedCourse == null;
    }

    /**
     * Assigns the course to the student.
     */
    public void assignCourse (Course course) {
        this.assignedCourse = course;
    }

    /**
     * Unassigns the course to the student.
     */
    public void unassignCourse() {
        this.assignedCourse = null;
    }

    /**
     * Returns whether the student has all the certificates needed to complete the course, taking its prerequisites as
     * a parameter.
     */
    public boolean hasAllPrerequisites( ArrayList<Integer> prerequisites ) {
        for ( int ID : prerequisites ) {
            if ( !this.certificates.contains( ID ) ) return false;
        }
        return true;
    }
}
