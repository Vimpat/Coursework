import java.util.ArrayList;

/**
 * Student, subclass to the Person class. It also contains a list of certificates which is defined by an arraylist.
 */
public class Student extends Person {

    boolean isStudying = false;
    //Boolean for whether the current is currently studying or not.
    boolean free = true;

    //A list of subject IDs that the student currently has.
    private ArrayList<Integer> certificates = new ArrayList<Integer>();

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
        return certificates;
    }

    /**
     * Checks whether or not the student has already obtained the certificate for the input subject.
     * Returns true if it does, otherwise it returns false.
     */
    public boolean hasCertificate( Subject subject ) {

        for (int ID : certificates) {
            if (ID == subject.getID()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Makes the student either free to study a course or not.
     */
    public void becomeFree (boolean free) {
        this.free = free;
    }

    /**
     * Returns whether the student studies or not
     */
    public boolean isFree() {
        return this.free;
    }
}
