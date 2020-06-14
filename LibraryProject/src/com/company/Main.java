package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Final_Project.java
 * @author Varshini Ganendran
 * **/
public class Main {
    static final String filename = "src/PatronLists.txt";
    static final String file = "src/BookLists.txt";
    static Scanner in = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Patron> patrons = new ArrayList<>();
    //static String[] books; //hold the list of books
    //static String[] patrons;

    public static void main(String[] args) {


        //Patrons
        try {
            File names_file = new File(filename); // Specify the filename
            Scanner myReader = new Scanner(names_file);

            int line_num = 1;
            System.out.println("PATRONS:");
            //read the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //read in one line from a while
                System.out.print(line_num+ ". ");
                //tokenize the line
                StringTokenizer st = new StringTokenizer(data, "|");
                System.out.println("Name: " + st.nextToken());
                System.out.println("Phone Number: " + st.nextToken());
                System.out.println("Patron Number: " + st.nextToken());
                line_num++;
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            //file is not there, so create it

            writeFile1();
        }

        System.out.println("\nBOOKS: ");
        //Books
        try {
            File namesFile = new File(file); // Specify the filename
            Scanner myReader = new Scanner(namesFile);

            int line_nom = 1;
            //read the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //read in one line from a while
                System.out.print(line_nom+ ". ");
                //tokenize the line
                StringTokenizer st = new StringTokenizer(data, "|");
                System.out.println("Title: " + st.nextToken());
                System.out.println("Author: " + st.nextToken());
                System.out.println("Book Number: " + st.nextToken());
                line_nom++;
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            //file is not there, so create it

            writeFile2();
        }
        System.out.println("\n");
        mainMenu(); // calls the MainMenu
    }

    private static void writeFile1() {
        try {
            FileWriter myWriter = new FileWriter(filename);

            System.out.println("How many patrons?");
            int num_patrons = in.nextInt();

            for (int i = 0; i < num_patrons; i++) {
                System.out.println("Enter name: ");
                String name = in.next();
                System.out.println("Enter phone number(only enter digits, no spaces): ");
                String phoneNum = in.next();
                Patron p = new Patron (name, phoneNum);
                int patronNum = p.getPatronNumber();
                myWriter.write(name+"|" + phoneNum + "|" + patronNum + "\r\n");
                patrons.add(i, p);
            }
            myWriter.close();
        }
        catch(IOException error){
            System.out.println("error occurred creating a file");
        }
    }

    private static void writeFile2() {
        try {
            FileWriter myWriter = new FileWriter(file);

            System.out.println("How many books?");
            int num_books = in.nextInt();

            for (int i = 0; i < num_books; i++) {
                System.out.println("Enter title of book: ");
                String title = in.next();
                System.out.println("Enter author of book: ");
                String author = in.next();
                Book b = new Book (title, author);
                int bookNum = b.getBookNumber();
                myWriter.write(title + "|" + author + "|" + bookNum + "\r\n");
                books.add(i, b);
            }
            myWriter.close();
        }
        catch(IOException error){
            System.out.println("error occurred creating a file");
        }
    }

    public static void mainMenu() {
        System.out.println("Welcome to Toronto Public Library, Please type one of the following options");
        System.out.println("MENU");
        System.out.println("Enter 1 for Patron Mode");
        System.out.println("Enter 2 for Librarian Mode");
        System.out.println("Enter any key to exit the program.");
        System.out.println("Enter key: ");
        int choice = in.nextInt();
        if(choice==1){
            System.out.println("PATRON MODE: ");
            Book m = Search();
            if(m==null){
                System.out.println("Book was not found.");
            }else{
                System.out.println(m.toString());
            }
        }else if(choice==2){
            LibrarianMode();
        }else{
            System.exit(0);
        }
    }


    public static void LibrarianMode(){
        System.out.println("LIBRARIAN MODE:");
        System.out.println("Enter 1 to check out books.");
        System.out.println("Enter 2 to check in books.");
        System.out.println("Enter 3 to add new books to catalogue.");//add to arraylist of books
        System.out.println("Enter 4 to search books. ");
        System.out.println("Enter 5 to add patron. ");//add to arraylist of patrons
        System.out.println("Enter 6 to change patron info. ");//search for patron and replace with new info
        System.out.println("Enter any other key to go back.");
        System.out.println("Enter key: ");
        int Libchoice =in.nextInt();

        if (Libchoice==1){
            CheckInOutBooks(true);
        }

        if (Libchoice==2){
            CheckInOutBooks(false);
        }

        if (Libchoice==3){
            System.out.println("Enter number of books to be added:");
            int num = in.nextInt();
            for(int i = 0; i < num; i++) {
                books.add(AddNewBooks());
            }
        }

        if (Libchoice==4){
            Book b = Search();
            if(b == null){
                System.out.println("Book was not found.");
            }else{
                System.out.println(b.toString());
            }
        }

        if (Libchoice==5){
            System.out.println("Enter number of patrons to be added:");
            int num = in.nextInt();
            for(int i = 0; i < num; i++) {
                patrons.add(AddNewPatron());
            }
        }

        if (Libchoice==6){
            ChangePatronInfo();
        }

        else {
            mainMenu();
        }
    }

    private static void CheckInOutBooks (boolean inOrOut) {//for check in it's true, checkout is false
        System.out.println("CHECK IN/OUT: \n Search for patron that is checking in/out book:");
        Patron customer = patronSearch();

        if(inOrOut) {
            System.out.println("Search for book to be checked out:");
            Book n = Search();
            try{
                if (n.getCheckOut()) {
                    System.out.println("Book has already been taken out.");
                } else {
                    if(customer.checkOutPatron(n)){
                        System.out.println("Book has successfully been checked out.");
                    }else{
                        System.out.println("Book could not be taken out.");
                    }
                }
            }catch(NullPointerException e){
                System.out.println("Book does not exist.");
            }
        }else{
            System.out.println("Search for book to be checked in:");
            Book n = Search();
            try{
                if (n.getCheckOut()) {
                    System.out.println("Book has already been taken out.");
                } else {
                    if(customer.checkInPatron(n)){
                        System.out.println("Book has successfully been checked out.");
                    }else{
                        System.out.println("Book could not be checked in successfully.");
                    }
                }
            }catch(NullPointerException e){
                System.out.println("Book does not exist.");
            }
        }
    }



    private static Patron patronSearch () {
        Patron p = null;
        System.out.println("SEARCH PATRONS\n Enter 1 to search by name\nEnter 2 to search by phone number ");
        System.out.println("Enter 3 to search by patron number\n Enter key: ");
        int choisi = in.nextInt();

        if(choisi == 1){//By name
            System.out.println("Type the name of the patron: ");
            String name1 = in.nextLine();

            for (int i = 0; i < patrons.size(); i++) {
                if (((patrons.get(i)).getName()).equals(name1)) {//if names match
                    p = patrons.get(i);
                }
            }

        } else if(choisi ==2){//By author
            System.out.println("Enter the phone number of the patron: ");
            String phoneNum1 = in.nextLine();

            for (int i = 0; i < patrons.size(); i++) {
                if (((patrons.get(i)).getPhoneNumber()).equals(phoneNum1)) {//if phone #s match
                    p = patrons.get(i);
                }
            }

        }else if(choisi ==3){//By patron number
            System.out.println("Enter the patron number: ");
            int patBer = in.nextInt();

            for (int i = 0; i < books.size(); i++) {
                if (((patrons.get(i)).getPatronNumber())==(patBer)) { //if patron #s match
                    p = patrons.get(i);
                }
            }
        }

        return p;
    }

    private static Book Search () { // search book from array list
        Book b = null;
        System.out.println("Press one of the numbers to search a certain way: ");
        System.out.println("1-By title\n2-By author\3By number: ");
        int choose = in.nextInt();

        if(choose==1) {//Search by title
            System.out.println("Please type in the book title:");
            String title1 = in.next();


            for (int i = 0; i < books.size(); i++) {
                if (((books.get(i)).getTitle()).equals(title1)) {// || b.getAuthor().equals(author) || (b.getBookNumber() == num)
                    b = books.get(i);
                }
            }


        } else if(choose==2){//Search by author
            System.out.println("Please enter the author name");
            String author1 = in.nextLine();

            for (int i = 0; i < books.size(); i++) {
                if (((books.get(i)).getAuthor()).equals(author1)) {// || b.getAuthor().equals(author) || (b.getBookNumber() == num)
                    b = books.get(i);
                }
            }


        } else if (choose==3){//Search by Number
            System.out.println("Please enter the Book Number");
            int num = in.nextInt();

            for (int i = 0; i < books.size(); i++) {
                if (((books.get(i)).getBookNumber())== num) {// || b.getAuthor().equals(author) || (b.getBookNumber() == num)
                    b = books.get(i);
                }
            }
        }
        return b;
    }

    private static void ChangePatronInfo () {
        System.out.println("Search for patron whose info must be changed: ");
        Patron p = patronSearch();

        System.out.println("Enter 1 to change patron's name, 2 to change phone number.");
        int num = in.nextInt();

        if (num == 1){
            System.out.println("Enter new name: ");
            String newName = in.nextLine();
            p.changeName(newName);
        }else{
            System.out.println("Enter new phone number: ");
            String newPhoneNum = in.nextLine();
            p.changePhoneNumber(newPhoneNum);
        }

    }

    private static Patron AddNewPatron() {
        System.out.println("Please enter your first and last name");
        String name = in.nextLine();
        System.out.println("Please enter your phone number");
        String num = in.nextLine();
        Patron p = new Patron(name, num);
        return p;
    }

    private static Book AddNewBooks() {
        System.out.println("Please enter the book title");
        String book = in.nextLine();
        System.out.println("Please enter the authors first and last name");
        String author =in.nextLine();
        Book b = new Book(book, author);
        return b;

    }


}

