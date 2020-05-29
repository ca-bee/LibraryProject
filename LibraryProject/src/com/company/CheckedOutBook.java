package com.company;

import java.time.LocalDate;


/**
 * CheckedOutBook.java
 * @author Natasha
 * **/
public class CheckedOutBook {

    private Book book;
    private LocalDate dueDate;

    /**
     * Constructs a checked out book with check out date and due date.
     * @param book the book that was checked out and includes all its info(title, author, etc.)
     * @param dueDate date that book is due to be returned to library, which is 3 weeks from the check out date
     * **/
    public CheckedOutBook(Book book, LocalDate dueDate){
        this.book = book;
        this.dueDate = dueDate;
    }

    /**
     * Gets the book that is due.
     * @return b the book with all its information.
     * **/
    public Book getBook() {
        return book;
    }

    /**
     * Gets the date that this book is due.
     * @return dueDate the date the book is due; 3 weeks from the date it was checked out.
     * **/
    public LocalDate getDueDate(){
        return dueDate;
    }

    /**
     * Formats the information of CheckedOutBook into String.
     * @return the toString method of Book b and the date the book is due.
     * **/
    public String toString(){
        return book.toString() + "| Due: " + dueDate.toString();
    }
}
