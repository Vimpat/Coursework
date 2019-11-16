package com.company;

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
     * Mutator method for description, takes a String as parameter and defines it as the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accesor method for ID, gets and returns it.
     */
    public int getID() {
        return id;
    }

    /**
     * Accesor method for duration, gets and returns it.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Accesor method for specialism, gets and returns it.
     */
    public int getSpecialism() {
        return specialism;
    }

    /**
     * Accesor method for description, gets and returns it.
     */
    public String getDescription() {
        return description;
    }
}