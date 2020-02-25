import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * The administrator of the school, controls how the school is run and contains the main method, where we specify the
 * configuration file and the duration for the school to run
 */
public class Administrator {

    School school;
    Random rand = new Random();

    /**
     * Runs the school
     */
    public void run() {

        // Each day from 0 to 2 new students join the school.
        for ( int i = 0; i <= this.rand.nextInt( 3 ); i++ ) {
            this.school.getStudents().add( new Student( "Student",'m',19 ) );
        }

        /*
         * Each day new staff joins the school. Percentages are as follows:
         * Teacher - 20%
         * Demonstrator - 10%
         * OOTrainer - 5%
         * GUITrainer - 5%
         */
        if ( this.rand.nextInt(  5 ) == 0 ) {
            this.school.getInstructors().add( new Teacher( "Teacher", 'f', 20 ) );
        }
        if ( this.rand.nextInt( 10 ) == 0 ) {
            this.school.getInstructors().add( new Demonstrator( "Demonstrator",'f',30 ) );
        }
        if ( this.rand.nextInt( 20 ) == 0 ) {
            this.school.getInstructors().add( new OOTrainer( "OOTrainer", 'm', 31 ) );
        }
        if ( this.rand.nextInt( 20 ) == 0 ) {
            this.school.getInstructors().add( new GUITrainer( "GUITrainer", 'm', 25 ) );
        }

        this.school.aDayAtSchool();


        // Any free instructor has a 5% chance of leaving the school.
        this.school.getInstructors().removeIf(instructor -> instructor.isFree() && this.rand.nextInt(5) == 0);

        // Students with all certificates will leave the school, otherwise there's just a 5% they will.
        Iterator<Student> studentIt = this.school.getStudents().iterator();
        while( studentIt.hasNext() ) {
            Student student = studentIt.next();
            // We suppose that the student has all certificates until proven otherwise.
            boolean hasAllCertificates = true;

            // Verify whether the student has all the certificates or not.
            for ( Subject subject : school.getSubjects() ) {
                if ( !student.hasCertificate( subject ) ) {
                    hasAllCertificates = false;
                    break;
                }
            }
            // Remove the student if he has all the certificates, otherwise there is a 5% change he will leave.
            if ( hasAllCertificates ) {
                studentIt.remove();
            } else if ( this.rand.nextInt( 20 ) == 0 && student.isFree() ) {
                studentIt.remove();
            }
        }
    }

    /**
     * Runs the school for a given number of days, giving an end of the day report on everything there is to know.
     */
    public void run( int numberOfDays) {
        for (int i = 1; i <= numberOfDays; i++) {
            this.run();
            System.out.println( this.school.toString() );
            System.out.println("************** End of day " + i + " **************");
        }
    }

    /**
     * Returns the next line of a given document, put as parameter.
     * Throws an exception if it can't read the next line.
     */
    public String getLine( BufferedReader schoolData ) {
        {
            try {
                return schoolData.readLine();
            } catch (Exception e) {
                System.out.println("Error: can't read the next line");
                return null;
            }
        }
    }

    /**
     * Reads the whole document and introduces the new objects in the system if they are valid.
     */
    public void setSchoolData ( BufferedReader schoolData ) {
        String line = this.getLine(schoolData);
        while (line != null) {

            String[] words = line.split("[:,]");

            /*
            Checks the first word the line to see which type of object it is.
            Gives an error message if the input is invalid in any way, either the type is not recognised or the data is
            incomplete.
             */
            switch (words[0]) {
                case "School":
                case "school":
                    if (words.length == 2) {
                        this.school = new School(words[1]);
                    } else {
                        System.out.println("Error: invalid school");
                    }
                    break;
                case "Subject":
                case "subject":
                    if (words.length >= 5) {
                        ArrayList<Integer> prerequisites = new ArrayList<>();
                        for (int i = 5; i < words.length; i++) {
                            prerequisites.add(Integer.parseInt(words[i]));
                        }
                        Subject subject = new Subject(Integer.parseInt(words[2]), Integer.parseInt(words[3]),
                                Integer.parseInt(words[4]));
                        subject.setPrerequisites(prerequisites);
                        subject.setDescription(words[1]);
                        this.school.add(subject);
                    } else {
                        System.out.println("Error: invalid subject");
                    }
                    break;
                case "Student":
                case "student":
                    if (words.length == 4) {
                        this.school.add(new Student(words[1], words[2].charAt(0), Integer.parseInt(words[3])));
                    } else {
                        System.out.println("Error: invalid student");
                    }
                    break;
                case "Teacher":
                case "teacher":
                    if (words.length == 4) {
                        this.school.add(new Teacher(words[1], words[2].charAt(0), Integer.parseInt(words[3])));
                    } else {
                        System.out.println("Error: invalid Teacher");
                    }
                    break;
                case "Demonstrator":
                case "demonstrator":
                    if (words.length == 4) {
                        this.school.add(new Demonstrator(words[1], words[2].charAt(0), Integer.parseInt(words[3])));
                    } else {
                        System.out.println("Error: invalid Demonstrator");
                    }
                    break;
                case "OOTrainer":
                case "ootrainer":
                    if (words.length == 4) {
                        school.add(new OOTrainer(words[1], words[2].charAt(0), Integer.parseInt(words[3])));
                    } else {
                        System.out.println("Error: invalid OOTrainer");
                    }
                    break;
                case "GUITrainer":
                case "guitrainer":
                    if (words.length == 4) {
                        this.school.add(new GUITrainer(words[1], words[2].charAt(0), Integer.parseInt(words[3])));
                    } else {
                        System.out.println("Error: invalid GUITrainer");
                    }
                    break;
                default:
                    System.out.println("Error: object type not recognised");
                    break;
            }

            line = this.getLine(schoolData);
        }
    }

    /**
     * The main method. It reads a configuration file provided in the parameters, along with the number of days.
     * If the file cannot be found then it throws an exception.
     */
    public static void main (String[] args) {

        int numberOfDays = 0;
        BufferedReader schoolData = null;
        Administrator administrator = new Administrator();

        try {
            numberOfDays = Integer.parseInt(args[1]);
            schoolData = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found");
        }

        // Reads the school data and sets the school accordingly.
        administrator.setSchoolData(schoolData);
        administrator.run(numberOfDays);
    }

}
