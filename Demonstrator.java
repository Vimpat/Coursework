/**
 * Demonstrator for the school. Can only teach subjects with a level 2 in specialism.
 */
public class Demonstrator extends Instructor {


    /**
     * Initializes the Demonstrator, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     * Returns whether the Demonstrator can teach the given subject, depending on the subject's level of specialism.
     */
    public Boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 2;
    }
}
