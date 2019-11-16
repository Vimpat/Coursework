package com.company;

public class Main {

    public static void main(String[] args) {

        Subject basics = new Subject(1, 1, 5);
        Subject arrays = new Subject(2,1,4);
        Course cs50 = new Course(basics, 4);
        Course programming101 = new Course(arrays, 0);

        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
        cs50.aDayPasses();
        System.out.println(cs50.getStatus());
    }
}
