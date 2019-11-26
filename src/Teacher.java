public class Teacher extends Instructor {


    /**
     * Initializes the Instructor, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }

    /**
     *Returns whether the Teacher can teach the given subject, depending on the subject's level of specialism.
     */
    public Boolean canTeach(Subject subject) {
        return subject.getSpecialism() <= 2;
    }
}
