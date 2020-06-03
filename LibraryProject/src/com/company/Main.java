import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Book.java
 * @author Varshini Ganendran
 * **/
public class Final_Project {
    static String[] books; //hold the list of books
    static final String filename = "src/PatronLists";
    static final String file = "src/Librarian";
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> book;

    public static void main(String[] args) {
        mainMenu(); // callas the MainMenu

        try {
            FileWriter names_file = new FileWriter(filename); // Specify the filename
            Scanner myReader = new Scanner((Readable) names_file);

            int line_num = 1;
            //read the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //read in one line from a while
                System.out.print(line_num);
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

            System.out.println("How many students?");
            int num_books = in.nextInt();
            books = new String[num_books];
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        try {
            FileWriter myWriter = new FileWriter(filename);

            for (int i = 0; i < books.length; i++) {
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
        System.out.println("Enter A for Patron Mode");
        System.out.println("Enter B for Librarian Mode");
        System.out.println("Enter any key to exit the program.");
        System.out.println("Enter");
        String choice = in.nextLine();
    }

    public static void PatronMode() {
        System.out.println("PATRON MODE:");
        System.out.println("Enter 'A' to check out books.");
        System.out.println("Enter 'B' to check in books.");
        System.out.println("Enter any other key to go back.");
        System.out.println("Enter key: ");
        String Patchoice=in.nextLine();

        if (Patchoice.equals("A")||Patchoice.equals("a")){
            CheckoutBooks();
        }

        else if (Patchoice.equals("B")||Patchoice.equals("b")){
            CheckinBooks();
        }

        else {
            System.out.println(0);
        }

    }

    public static void LibrarianMode(){
        System.out.println("LIBRARIAN MODE:");
        System.out.println("Enter 'A' to check out books.");
        System.out.println("Enter 'B' to check in books.");
        System.out.println("Enter 'C' to add new books to catalogue.");//add to arraylist of books
        System.out.println("Enter 'D' to search books. ");
        System.out.println("Enter 'E' to add patron. ");//add to arraylist of patrons
        System.out.println("Enter 'F' to change patron info. ");//search for patron and replace with new info
        System.out.println("Enter any other key to go back.");
        System.out.println("Enter key: ");
        String Libchoice =in.nextLine();

        if (Libchoice.equals("A")||Libchoice.equals("a")){
            CheckoutBooks();
        }

        if (Libchoice.equals("B")||Libchoice.equals("b")){
            CheckinBooks();
        }

        if (Libchoice.equals("C")||Libchoice.equals("c")){
            AddNewBooks();
        }

        if (Libchoice.equals("D")||Libchoice.equals("d")){
            Search();
        }

        if (Libchoice.equals("E")||Libchoice.equals("e")){
            AddNewPatron();
        }

        if (Libchoice.equals("F")||Libchoice.equals("f")){
            ChangePatronInfo();
        }

        else {
            System.out.println(0);
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

