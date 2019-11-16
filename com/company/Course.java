package com.company;

/**
 * The course which is specific to only one subject.
 * It also contains when it starts and its duration.
 */

public class Course {
    private Subject subject;
    private int daysUntilStarts, daysToRun;

    /**
     * Creates the Course object, asking for the subject it is associated with, along with the date it starts.
     */
    public Course( Subject subject, int daysUntilStarts ) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        this.daysToRun = this.subject.getDuration();
    }

    /**
     * Accesor method for subject, gets and returns it.
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Method which calculates the status of the course.
     * If the course hasn't started yet it returns how many days until it starts (in negative numbers);
     * Else if the it is currently running then it returns how many days until it is finished;
     * Else if it is done then it returns 0.
     */
    public int getStatus() {
        if ( this.daysUntilStarts != 0 ) {
            return -this.daysUntilStarts;
        } else if ( this.daysToRun != 0 ) {
            return this.daysToRun;
        } else {
            return 0;
        }
    }

    /**
     * A day passes, modifying either how many days until the course starts or until it is finished.
     */
    public void aDayPasses() {
        if ( this.daysUntilStarts != 0 ) {
            this.daysUntilStarts--;
        } else if ( this.daysToRun != 0 ) {
            this.daysToRun--;
        }
    }
}
