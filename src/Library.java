import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    /**
     * Constructs a new library with an empty list of books.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Add books in the library if it's not already in library.
     * @param newBook the book to be added.
     */
    public void addBook(Book newBook) {
        for(Book book : books) {
            if(book.getISBN() == newBook.getISBN()) {
                System.out.println("This book is already in Library!");
                design();
                return;
            }
        }
        books.add(newBook);
        System.out.println("The Book was successfully added: " + newBook.getTitle());
        design();
    }

    /**
     * Remove book in books list with given name.
      * @param name name of the book to be removed.
     */
    public void removeBook(String name) {
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(name)) {
                books.remove(book);
                System.out.println("The book was successfully removed: " + book.getTitle());
                design();
                return;
            }
        }
        System.out.println("The Book is not in library");
        design();
    }

    /**
     * Gives details about the given book.
     * @param reviewedBook the book to be reviewed.
     */
    public void getBook(Book reviewedBook) {
        for(Book book : books) {
            if (book.getISBN() == reviewedBook.getISBN()) {
                System.out.println(reviewedBook.getTitle() + " is being skimmed through");
                System.out.println(" The tittle is: " + reviewedBook.getTitle()
                        + "\n The Author is: "  + reviewedBook.getAuthor()
                        + "\n The genre is: " + reviewedBook.getGenre()
                        + "\n ISBN number is: " + reviewedBook.getISBN());
                design();
                return;
            }
        }
        System.out.println("This book is not available");
        design();

    }

    /**
     * Lists all saved books in the library.
     */
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("There is no book in the library");
            design();
            return;
        }
        for(Book book : books) {
            System.out.println("* " + book.getTitle());
        }
        design();
    }

    /**
     * finds the book by its tittle and provides its details. If the book is not exist with this name then it prints a message.
     * @param name the tittle of the searched book.
     */
    public void findBookByName(String name) {
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(name)) {
                System.out.println("The book found!");
                getBook(book);
                return;
            }
        }
        System.out.println("This book is not Available!");
        design();
    }

    /**
     * finds the book by its author and provides its details. If it can't find the book, it prints a message.
     * @param author the author of the searched book.
     */
    public void findBookByAuthor(String author) {
        // I added boolean isBookFound ,because I don't want to show as many warnings as there are books.
        boolean isBookFound = false;
        for(Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("The book found!");
                getBook(book);
                isBookFound = true;
            }
        }
        if(!isBookFound) {
            System.out.println("This book is not Available!");
            design();
        }
    }

    /**
     * find the book by its genre and provides its details. If it can't find the book, it prints a message.
     * @param genre the genre of the searched book.
     */
    public void findBookByGenre(String genre) {
        // I added boolean isBookFound ,because I don't want to show as many warnings as there are books.
        boolean isBookFound = false;
        for(Book book : books) {
            if(book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("The book found!");
                getBook(book);
                isBookFound = true;
            }
        }
        if(!isBookFound) {
            System.out.println("This book is not Available!");
            design();
        }
    }

    /**
     * Prints the shape to make the console easier to read.
     */
    public void design() {
        for(int i =0;i < 50; i ++) {
            System.out.print("-");
        }
        System.out.println(" ");
    }

    /**
     * Saves the book list in a .csv data so that books can be access the list again when the program is closed.
     */
    public void saveBooksToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Books.csv"))){
            for(Book book : books) {
                String line = book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "," + book.getISBN();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the book list from .csv data to the main program.
     */
    public void loadBooksFromFile() {
        books = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("Books.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields.length == 4) {
                    String tittle = fields[0];
                    String author = fields[1];
                    String genre = fields[2];
                    long isbn = Long.parseLong(fields[3]);
                    Book book = new Book(tittle,author,genre);
                    book.setISBN(isbn);
                    books.add(book);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
