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
            static String[] books; //hold the list of books
            static String[] patrons;
            static final String filename = "src/PatronLists.txt";
            static final String file = "src/BookLists.txt";
            static Scanner in = new Scanner(System.in);
            static ArrayList<String> book;

            public static void main(String[] args) {


                //Patrons
                try {
                    File names_file = new File(filename); // Specify the filename
                    Scanner myReader = new Scanner(names_file);

                    int line_num = 1;
                    //read the file
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine(); //read in one line from a while
                        System.out.print(line_num+ ". ");
                        //tokenize the line
                        StringTokenizer st = new StringTokenizer(data, "|");
                        System.out.println("Name: " + st.nextToken());
                        System.out.println("Phone Number: " + st.nextToken());
                        System.out.println("Patron Number: " + st.nextToken());
                        System.out.println("Date: " + st.nextToken());
                        line_num++;
                    }
                    myReader.close();

                } catch (FileNotFoundException e) {
                    //file is not there, so create it

                    writeFile1();
                }

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
                        System.out.println("Date: " + st.nextToken());
                        line_nom++;
                    }
                    myReader.close();

                } catch (FileNotFoundException e) {
                    //file is not there, so create it

                    writeFile2();
                }
                mainMenu(); // callas the MainMenu
            }

    private static void writeFile1() {
        try {
            FileWriter myWriter = new FileWriter(filename);

            System.out.println("How many patrons?");
            int num_patrons = in.nextInt();
            patrons = new String[num_patrons];

            for (int i = 0; i < patrons.length; i++) {
                patrons[i] = in.next();
                myWriter.write(patrons[i] + "\r\n");
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
                    books = new String[num_books];

                    for (int i = 0; i < books.length; i++) {
                        books[i] = in.next();
                        myWriter.write(books[i] + "\r\n");
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
                        PatronMode();
                }else if(choice==2){
                        LibrarianMode();
                }else{
                        System.exit(0);
                }
             }

            public static void PatronMode() {
                System.out.println("PATRON MODE:");
                System.out.println("Enter 1 to check out books.");
                System.out.println("Enter 2 to check in books.");
                System.out.println("Enter any other key to go back.");
                System.out.println("Enter key: ");
                int Patchoice=in.nextInt();

                if (Patchoice==1){
                    CheckoutBooks();
                }

                else if (Patchoice==2){
                    CheckinBooks();
                }

                else {
                    mainMenu();
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
                    CheckoutBooks();
                }

                if (Libchoice==2){
                    CheckinBooks();
                }

                if (Libchoice==3){
                    AddNewBooks();
                }

                if (Libchoice==4){
                    Search();
                }

                if (Libchoice==5){
                    AddNewPatron();
                }

                if (Libchoice==6){
                    ChangePatronInfo();
                }

                else {
                    mainMenu();
                }
            }

            private static void CheckoutBooks () {// check out any books
                System.out.println("Please type in the book title");
                String title = in.nextLine();
                System.out.println("Please enter the author name");
                String author = in.nextLine();
                System.out.println("Please enter the Book Number");
                String num = in.nextLine();

            }

            private static void CheckinBooks () { // check in any books
                System.out.println("Please type in the book title");
                String title = in.nextLine();
                System.out.println("Please enter the author name");
                String author = in.nextLine();
                System.out.println("Please enter the Book Number");
                String num = in.nextLine();
            }

            private static void Search () { // search book from array list
                System.out.println("Please type in the book title");
                String title = in.nextLine();
                System.out.println("Please enter the author name");
                String author = in.nextLine();
                System.out.println("Please enter the Book Number");
                String num = in.nextLine();
            }

            private static void ChangePatronInfo () {
                System.out.println("Which one do you want to change?");
                System.out.println("OPTIONS");
                System.out.println("Enter A to Change your Name");
                System.out.println("Enter B to Change your Phone Number");
                //System.out.println("Enter C to Change address");
                String opt = in.nextLine();

                if (opt.equals("A") || opt.equals("a")) {

                }

                if (opt.equals("B") || opt.equals("b")) {

                }


            }

            private static void AddNewPatron() {
                System.out.println("Please enter your first and last name");
                String name = in.nextLine();
                System.out.println("Please enter your phone number");
                int num = in.nextInt();
                System.out.println("Please enter ");
            }

            private static void AddNewBooks() {
                System.out.println("Please enter the book title");
                String book = in.nextLine();
                System.out.println("Please enter the authors first and last name");
                String author =in.nextLine();
                System.out.println("Please Enter the book Number");
                String number = in.nextLine();

            }


        }


