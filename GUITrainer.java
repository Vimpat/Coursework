/**
 * GUITrainer for the school. Can only teach subjects with a level of specialism that is less than 3 or equal to 4.
 */
public class GUITrainer extends Teacher {

    /**
     * Initializes the Instructor, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     *Returns whether the GUITrainer can teach the given subject, depending on the subject's level of specialism.
     */
    public Boolean canTeach(Subject subject) {
        return subject.getSpecialism() <= 2 || subject.getSpecialism() == 4;
    }
}
