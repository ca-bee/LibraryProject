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
    private ArrayList<CheckedOutBook> checkedOut; //number of books checked out //figure out how to only store due dates and name of book
    private final static int maxCheckOut = 3;//the maximum number of books that can be checked out at one time
//overdue fee rate is $0.10/day and $60.0 for lost books.

    /**
     * Creates patrons of the library with their name, phone number, list of books checked out under their name. Each patron
     * has a unique ID.
     * @param name the patron's name
     * @param phoneNumber the patron's phone #
     * @param checkedOut a list of the books that have been checked out by this patron with corresponding due dates.
     * **/
    public Patron(String name, String phoneNumber, ArrayList<CheckedOutBook> checkedOut){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.checkedOut = checkedOut;
        patronNumber = last_patronNumber;
        last_patronNumber++;
    }

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

    /**
     * Gets all the info about the patron in the library and formats it into String. It converts the list of checked out books into an
     * array of String that contains the title and author of the book and the date the book is due.
     * @return the name, number and phone number of the patron, and also the titles, authors, and due dates of the book borrowed by the
     * patron.
     * **/
    public String getInfo(){
        String[] Booklist = new String[checkedOut.size()];
        for (int i = 0; i < Booklist.length; i++) {
            Booklist[i] = (((checkedOut.get(i)).getBook()).getBookNumber()) + ". " + (((checkedOut.get(i)).getBook()).getTitle()) + " by " + (((checkedOut.get(i)).getBook()).getAuthor()) + ", due on " + (((checkedOut.get(i)).getDueDate()).toString()) + ",";
        }

        return patronNumber + "|" + name + "|" + Booklist.toString();
    }

    /**
     * Calculates the current amount of fees that needs to be paid by the patron. It takes the current
     * day and checks to see if it comes after the due date of the books borrowed. If it is after, it
     * adds the fee which is 10 cents per day for each late book and calculates the total fee.
     * @param today the current day used to check how much fees are currently owed.
     * @return the total amount of fees owed by the patron in dollars, which will be zero if no fees are owed.
     * **/
    public double calculateFees(LocalDate today){

        LocalDate[] dueDateList = new LocalDate[checkedOut.size()];
        double fee = 0.00;
        for(int i = 0; i < dueDateList.length; i++){//goes through list of due dates and find book that is being checked in
            dueDateList[i] = (checkedOut.get(i)).getDueDate();
            if(today.isAfter(dueDateList[i])){//check if checkInDate is after dueDate
                double noOfDaysBetween = ChronoUnit.DAYS.between(dueDateList[i], today);
                fee+= (noOfDaysBetween)*(0.10);//multiply by 0.10 and add to sum of total fees
            }
        }
        return fee;//total sum of fees
    }

}
