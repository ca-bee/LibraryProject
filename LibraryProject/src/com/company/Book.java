package com.company;

import java.util.ArrayList;


/**
 * Book.java
 * @author Natasha
 * **/
public class Book {
    private String title;
    private String author;
    private final int bookNumber;//unique ID for each book
    private static int last_bookNumber = 0;//helps keep track of book ID

    //USE THIS:
    private ArrayList<Patron> patronList;//figure out a way to only store patron name and the due date
    //OR THIS(prob use this):
    //private Patron[] borrowerList=new Patron[copies];/*patrons that have taken out this book, then you can search
    // up the patron and the date this book is due back.*/

    //WITH THIS:
    //private int copies;//copies of this book in the library
    //private int available;//copies-(# of patrons that have taken this book out) = (# of )available( copies)

    //OR USE THIS:
    //private Patron borrower;//Patron that has checked out the book
    //private LocalDate dueDate;//date that patron's book is due or skip this and search up patron to find due date

    /**
     * Makes a new copy of a book with title, author and the list of patrons that have checked this book out. Also has a unique book ID.
     * @param title the title of the book
     * @param author the name of the author of the book
     * **/
    //get rid of patronList, put borrowerList and copies
    public Book(String title, String author){//, ArrayList<Patron> patronList
        this.title = title;
        this.author = author;
        //this.patronList = patronList;
        //this.borrowerList = borrowerList;
        //this.borrower = borrower;
        //this.dueDate = dueDate;
        //this.copies = copies;
        bookNumber = last_bookNumber;
        last_bookNumber++;
    }

    //make a second Book constructor without Patron or LocalDate
    /*/**
     * Makes a new copy of a book with only title and author.
     * @param title
     * @param author
     * **/
    /*public Book(String title, String author){
        this.title = title;
        this.author = author;
        bookNumber = last_bookNumber;
        last_bookNumber++;
    }*/

    /**
     * Gets title
     * @return title of the book
     * **/
    public String getTitle(){ return title; }

    /**
     * Gets author.
     * @return name of the author of the book
     * **/
    public String getAuthor(){ return author;}

    /**
     * Gets book number.
     * @return the unique book ID/number.
     * **/
    public int getBookNumber(){return bookNumber;}

    //USE
    /*/**
     * Gets number of copies.
     * @return number of copies of this book in the library
     * **/
    /*public int getCopies(){return copies;}

    /**
     * Adds a number of copies of book.
     * @param newCopies new copies that will be added to existing copies.
     * @return copies added to newCopies.
     * **/
    /*public int addCopies(int newCopies){return copies+=newCopies;}*/

    /*/**
     * Finds the available number of copies that are not being borrowed.
     * @return available copies of the book that can be taken out currently.
     * **/
    /*public int getAvailable(){return copies - (borrowerList[].length());}*/

    /**
     * Converts the information about book to String so that it is readable.
     * @return the book's number, title, author and its number of copies.
     * **/
    public String toString(){
        String toString = bookNumber + "|" + title + "|" + author;
        //if(borrower!=null){
        //  toString+=("|#" + borrower.getPatronNumber()) + ". " + (borrower.getName()) + (dueDate.toString());
        // }
        return toString;
    }


   /*/**
    * Calculates the date that the book is due. Called when book is needed to be checked out.
    * @return due date calculated 2 weeks from the day the book is checked out.
    * **/
   /*public LocalDate calculateDueDate(){
       LocalDate today = LocalDate.now();
       dueDate = today.plusWeeks(2); //<---use this line in Main class when you need to check out a book in a patron's name.
       return dueDate;
   }*/

   /*Get number of copies of a book through linear search in library interface by using a count and going through
   * ArrayList of books while looking for same book title/authors. Check how many are available by checking if a
   * patron is borrowing the book.*/

}
