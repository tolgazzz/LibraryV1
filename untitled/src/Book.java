import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Book {

    String title;
    String author;
    String genre;
    long isbn;
    private final Set<Long> isbnList = new HashSet<>();

    /**
     * Constructs a new book object with given parameters.
     * @param tittle The tittle of the book.
     * @param author The author of the book.
     * @param genre  The genre of the book.
     */
    public Book(String tittle, String author, String genre) {
        this.title = tittle;
        this.author = author;
        this.genre = genre;
        this.isbn  = createISBN();
    }
    /**
     * Creates a new unique ISBN for book.
     * @return unique ISBN number.
     */
    private long createISBN() {
        long min = 1000000000000L; // 13 digits inclusive
        long max = 10000000000000L; // 14 digits exclusive
        Random random = new Random();
        long number = min + ((long)(random.nextDouble()*(max-min))); //creates 13 digit random number
        if(isbnList.contains(number)) { // if ISBN is not unique then create new ISBN
            return createISBN();
        }
        isbnList.add(number);
        return number;
    }

    /**
     * Returns the tittle of the book.
     * @return the tittle of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets author of the book.
     * @return the author of book. If the author is not specified then it returns unknown.
     */
    public String getAuthor() {
        if(this.author.equalsIgnoreCase("")) {
            return "Unknown";
        }
        return this.author;
    }

    /**
     * Gets genre of the book.
     * @return genre of the book. If the genre of the book is not specified then it returns general.
     */
    public String getGenre() {
        if(this.genre.equalsIgnoreCase("")) {
            return "General";
        }
        return this.genre;
    }

    /**
     * @return Returns the ISBN of the book
     */
    public long getISBN() {
        return this.isbn;
    }

    /**
     * Sets the ISBN of the book
     * @param isbn ISBN of the book.
     */
    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

}
