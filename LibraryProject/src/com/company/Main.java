package com.company;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;


public class Main {

    private static Scanner in = new Scanner(System.in);
    public final static String patronFile = "Patron List.txt";
    public final static String bookFile = "Book List.txt";

    public static void main(String[] args) {
        mainMenu();


        //Create the library of books and write into file
        System.out.println("How many books to add? ");
        int numBooks = in.nextInt();//loop this many times

        for(int i = 0 ; i < numBooks ; i++){
            System.out.println("Please enter the book title: ");
            String title = in.nextLine();

            System.out.println("Please enter the author's name: ");
            String author = in.nextLine();

            System.out.println("Please enter the number of copies: ");
            int copies = in.nextInt();

            Book book = new Book (title, author);
        }

        //Create patron list
        System.out.println("How many patrons are in the library? ");
        int numPatrons = in.nextInt();

        for(int i = 0; i < numPatrons ; i++){
            System.out.println("Please enter the patron's name: ");
            String name = in.nextLine();

            System.out.println("Please enter the author's name: ");
            String phoneNumber = in.nextLine();

            Patron patron = new Patron (name, phoneNumber);
        }


    }

    public static void mainMenu(){
        System.out.println("Welcome to the library!");

        System.out.println("\n\nMENU:");
        System.out.println("\nEnter 'A' for Patron Mode");
        System.out.println("Enter 'B' for Librarian Mode");
        System.out.println("Enter any other key to exit program.");
        System.out.println("\nEnter: ");

        String choice = in.nextLine();

        switch (choice) {
            case "A": //Book Search in Patron Mode
                Search();

                break;
            case "B": //Librarian Mode
                //Check Password-->then Librarian Menu
                librarianPass();

                break;
            default:
                System.exit(0);
        }
    }

    /**
     * Code from Oracle, look at copyright on PasswordField class. Create the GUI and show it.
     * For thread safety, this method should be invoked from the event dispatch thread.
     * */
    private static void librarianPass(){
        System.out.println("\nWill open a window for entering password...");
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                //Create and set up the window.
                JFrame frame = new JFrame("Librarian");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Create and set up the content pane.
                final PasswordField newContentPane = new PasswordField(frame);
                newContentPane.setOpaque(true); //content panes must be opaque
                frame.setContentPane(newContentPane);

                //Make sure the focus goes to the right component
                //whenever the frame is initially given the focus.
                frame.addWindowListener(new WindowAdapter() {
                    public void windowActivated(WindowEvent e) {
                        newContentPane.resetFocus();
                    }
                });

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });

    }


    public static void Librarian(){
        System.out.println("\n\nLIBRARIAN MODE: \n");
        System.out.println("Enter 'A' to check out books.");
        System.out.println("Enter 'B' to check in books.");
        System.out.println("Enter 'C' to add new books to catalogue.");//add to arraylist of books
        System.out.println("Enter 'D' to search books. ");
        System.out.println("Enter 'E' to add patron. ");//add to arraylist of patrons
        System.out.println("Enter 'F' to change patron info. ");//search for patron and replace with new info
        //System.out.println("Enter 'G' to change number of copies of a book: ");
        System.out.println("Enter any other key to go back.");
        System.out.println("\nEnter key: ");

        String choice=in.nextLine();
        switch (choice) {
            case "A":

                break;
            case "B":

                break;
            case "C":

                break;
            case "D":
                Search();
                break;
            case "E":

                break;
            case "F":

                break;
            //case "G":

                //break;
            default:
                mainMenu();
                break;
        }
    }



    public static void Search(){
        System.out.println("\n\nSearch for books by: ");
        System.out.println("\nTitle (Enter A): ");
        System.out.println("Author: (Enter B): ");
        System.out.println("Number: (Enter C): ");
        System.out.println("Enter any other key to go back to main menu: ");
        System.out.println("\nEnter key: ");

        String choice = in.nextLine();

        switch (choice) {
            case "A":

                break;
            case "B":

                break;
            case "C":

                break;
            default:
                mainMenu();
                break;
        }


    }

}
