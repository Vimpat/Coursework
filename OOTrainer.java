/**
 * The OOTrainer of the school. Can only teach subjects which have a level of specialism that is less than or equal to 3
 */
public class OOTrainer extends Teacher {

    /**
     * Initializes the Instructor, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public OOTrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     *Returns whether the OOTrainer can teach the given subject, depending on the subject's level of specialism.
     */
    public Boolean canTeach(Subject subject) {
        return subject.getSpecialism() <= 3;
    }
}
