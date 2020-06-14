package com.company;

import java.time.LocalDate;


/**
 * Patron.java
 * @author Natasha
 * **/
public class Patron {

    private String name;
    private String phoneNumber;
    private final int patronNumber;
    private static int last_patronNumber = 0;
    private static final int maxCheckOut = 3;
    private int indexOfCheckout = 0;
    private Book[] checkedOut = new Book[2];
    private LocalDate[] dueDates = new LocalDate[2];

    /**
     * Creates patrons of the library with their name, phone number, list of books checked out under their name. Each patron
     * has a unique ID.
     * @param name the patron's name
     * @param phoneNumber the patron's phone number
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
     * Changes the patron's name to a new name.
     * @param newName the patron's new name.
     * **/
    public void changeName(String newName){
        name = newName;
    }

    /**
     * Gets phone number.
     * @return phone number of patron
     * **/
    public String getPhoneNumber(){return phoneNumber;}

    /**
     * Changes the patron's phone number into a new phone number.
     * @param newPhoneNumber the patron's phone number.
     * **/
    public void changePhoneNumber(String newPhoneNumber){
        phoneNumber = newPhoneNumber;
    }

    /**
     * Gets patron number
     * @return unique ID of the patron
     * **/
    public int getPatronNumber(){return patronNumber;}


    /**
     * Adds a certain book and its due date to the list of books that the patron has checked out. It also checks to see
     * if the patron has taken out the maximum number of books which is three. It also makes sure that the status is
     * checked out.
     * @param b the book that the patron wants taken out
     * @return true if the book was successfully checked out and false if the book is not successfully checked out.
     * **/
    public boolean checkOutPatron(Book b){
        if((indexOfCheckout < maxCheckOut) && (b.getCheckOut()==false)){//patron hasn't taken out max number of books
            checkedOut[indexOfCheckout] = b; //adds certain book to list of checkout
            LocalDate today = LocalDate.now();
            LocalDate due = today.plusWeeks(3);
            dueDates[indexOfCheckout] = due;
            b.changeCheckOut();//book now has status of checked out
            indexOfCheckout++;
            return true;
        }
        else {return false;}
    }

    /**
     *Removes the book from the list of books that the patron has checked out. Makes sure that the status is checked in.
     * @param b the book that is being checked in.
     * @return true if the book has been successfully checked in and false if the book was not successfully checked in.

     * **/
    public boolean checkInPatron(Book b){
        for(int i = 0; i < checkedOut.length; i++){
            if((b.getBookNumber())==(checkedOut[i].getBookNumber()) && (b.getCheckOut())) {
                /*Checks if IDs match and if that book can be checked in before checking it in*/
                checkedOut[i] = checkedOut[i + 1];//shift everything over
                dueDates[i] = dueDates[i + 1];
                b.changeCheckOut();//book now has status of checked in
                indexOfCheckout--;
                return true;
            }
        }
        return false;
    }

    

}



