import java.util.ArrayList;

/**
 * The subjects which contain the id, specialism and duration of each of the subjects.
 */

public class Subject {
    //each id is specific to one subject.
    private int id;
    //tells the level of specialisation of each subject.
    private int specialism;
    //tells the length of a subject, numbered in days.
    private int duration;
    private String description;

    /**
     * Creates the Subject objects, asking for the id, level of specialism and duration of it.

     */
    public Subject ( int id, int specialism, int duration ) {
        this.id = id;
        this.duration = duration;
        this.specialism = specialism;
    }

    /**
     * Sets a new description, taking a string as parameter.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the ID.
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the specialism.
     */
    public int getSpecialism() {
        return specialism;
    }

    /**
     * Returns the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns whether the Subject is alocated to a course.
     */
    public boolean hasCourse ( ArrayList<Course> courses ) {
        for ( Course i : courses ) {
            if (i.getSubject() == this ) return true;
        }
        return false;
    }
}