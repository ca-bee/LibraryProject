/**
 * Book.java
 * @author Natasha
 * **/
public class Book {
    private String title;
    private String author;
    private final int bookNumber;//ID for each book
    private static int last_bookNumber = 0;//helps keep track of book ID
    private static boolean checkOut = false;//if false, book is in library; if true, book is checked out


    /**
     * Makes a new copy of a book with title, author and the list of patrons that have checked this book out. Also has a unique book ID.
     * @param title the title of the book
     * @param author the name of the author of the book
     * **/
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        checkOut = false;
        bookNumber = last_bookNumber;
        last_bookNumber++;
    }


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

    /**
     * Checks if the book is checked out or not.
     * @return false if the book is available and true if it is checked out.
     * **/
    public boolean getCheckOut(){return checkOut;}

    /**
     * Changes the status of the book of whether it has been checked out or not to the opposite.
     * **/
    public void changeCheckOut(){
        if(checkOut){//if book already checked out
            checkOut=false;//book is checked in
        }else{
            checkOut=true; //otherwise book is checked out
        }
    }

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


    /**
     * Converts the information about book to String so that it is readable.
     * @return the book's number, title, author and its number of copies.
     * **/
    public String toString(){
        String info = "Book number: " + bookNumber + "/Title: " + title + "/Author: " + author;
        return info;
    }


}
