import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Final_Project.java
 * @author Varshini Ganendran
 * **/
public class Final_Project {
    static final String filename = "src/PatronLists.txt";
    static final String file = "src/BookLists.txt";
    static Scanner in = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Patron> patrons = new ArrayList<>();
    //private static Object String;
    private static Book book;
    private static LocalDate dueDate;
    //static String[] books; //hold the list of books
    //static String[] patrons;
    public static void main(String[] args) {
        System.out.println("How many patrons do you have?");
        
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
                books.add(b);
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
            System.out.println("Enter number of books to be added:");
            int num = in.nextInt();
            for(int i = 0; i < num; i++) {
                books.add(AddNewBooks());
            }
        }

        if (Libchoice==4){
            Search();
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

    private static void CheckoutBooks () {// check out any books
        System.out.println("Please type in the book title");
        String title = in.nextLine();
        System.out.println("Please enter the author name");
        String author = in.nextLine();
        System.out.println("Please enter the Book Number");
        String num = in.nextLine();
    }

        /**
         * Constructs a checked out book with check out date and due date.
         * @param book the book that was checked out and includes all its info(title, author, etc.)
         * @param dueDate date that book is due to be returned to library, which is 3 weeks from the check out date **/
    public void CheckedOutBook(Book book, LocalDate dueDate){
            this.book = book;
            this.dueDate = dueDate;
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

    public static void ChangeName () {
        System.out.println("Please enter given name that is input to the system");
        String given_name = in.nextLine();
        System.out.println("Enter the name you want to be changed in the system");
        String new_name = in.nextLine ();
    }

    public static void ChangePhoneNumber(){
       System.out.println("Enter your given phone number");
       int phone_num = in.nextInt();
       System.out.println("Enter the new phone number");
       int new_num = in.nextInt();
    }

    private static void ChangePatronInfo () {
        System.out.println("Which one do you want to change?");
        System.out.println("OPTIONS");
        System.out.println("Enter 1 to Change your Name");
        System.out.println("Enter 2 to Change your Phone Number");
        //System.out.println("Enter C to Change address");
        int opt = in.nextInt();

        if (opt==1) {
            ChangeName();
        }

        if (opt==2) {
            ChangePhoneNumber();
        }

        else {
            System.out.println(0);
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

