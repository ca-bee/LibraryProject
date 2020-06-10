package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 * Patron.java
 * @author Natasha
 * **/
public class Patron {

    private String name;
    private String phoneNumber;
    private final int patronNumber;
    private static int last_patronNumber = 0;
    private final static int maxCheckOut = 3;//the maximum number of books that can be checked out at one time


    /**
     * Creates patrons of the library with their name, phone number, list of books checked out under their name. Each patron
     * has a unique ID.
     * @param name the patron's name
     * @param phoneNumber the patron's phone #
     * **/
   

    public Patron(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        patronNumber = last_patronNumber;
        last_patronNumber++;
    }

    /**
     * Gets name.
     * @return name of the patron
     * **/
    public String getName(){return name;}

    /**
     * Gets phone number.
     * @return phone number of patron
     * **/
    public String getPhoneNumber(){return phoneNumber;}

    /**
     * Gets patron number
     * @return unique ID of the patron
     * **/
    public int getPatronNumber(){return patronNumber;}

  


}
