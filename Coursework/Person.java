
/**
 * A person which can be either a student or an Instructor (defined by their respective classes).
 */
public class Person {

    private String name;
    private char gender;
    private int age;

    /**
     * Initializes the Person, takes a string, char and int as parameter which will be the name, gender and age.
     */
    public Person( String name, char gender, int age ) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * Sets the age of the person. Takes an int as parameter which will be the new age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the gender of the person.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Returns the age of the person.
     */
    public int getAge() {
        return age;
    }
}
