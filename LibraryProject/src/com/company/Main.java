import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Final_Project {
    static String[] books; //hold the list of students
    static final String filename = "src/PatronLists";
    static final String file = "src/Librarian";
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> book;

    public static void main(String[] args) {

        try {
            FileWriter names_file = new FileWriter(filename); // Specify the filename
            Scanner myReader = new Scanner((Readable) names_file);

            int line_num = 1;
            //read the file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //read in one line from a while
                //System.out.print(line_num);
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

        System.out.println("Welcome to Toronto Public Library, Please type one of the following options");
        System.out.println("A.Create Patron");
        System.out.println("B.Librarian Login");
        System.out.println("C.Create Books");

        String name = in.nextLine();

        if (name.equals("A") || name.equals("a")) {
            getuserInput();
        }

        if (name.equals("B") || name.equals("b")) {
            getworkerInput();
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

    private static void getuserInput() {
        System.out.println("Please enter your first and last name");

        String name = in.nextLine();
        System.out.println("Please enter your phone number");
        int num = in.nextInt();
    }

    private static void getworkerInput () {
        System.out.println("Please enter the book title");
        String title = in.nextLine();
        System.out.println("Please enter the authors first and last name");
        String author =in.nextLine();

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
                //Search();
                break;
            case "E":

                break;
            case "F":

                break;
            //case "G":

            //break;
            default:
                //mainMenu();
                break;
        }
    }


}
