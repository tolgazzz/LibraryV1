import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.loadBooksFromFile();
        library.design();
        System.out.println("Welcome to your special library");
        library.design();

        question();
        Scanner scanner = new Scanner(System.in);

        while(true) {

            switch(scanner.nextLine().toLowerCase()) {
                case "exit" :
                    System.out.println("Exiting the library");
                    scanner.close();
                    library.saveBooksToFile();
                    return;

                case "add book" :
                    System.out.println("Enter the name: ");
                    String tittle = scanner.nextLine();
                    if(tittle.equalsIgnoreCase("")) {
                        while(tittle.equalsIgnoreCase("")) {
                            System.out.println("The book must have a name!");
                            System.out.println("Please enter a name: ");
                            tittle = scanner.nextLine();
                        }
                    }
                    System.out.println("Enter the author: ");
                    String author = scanner.nextLine();

                    System.out.println("Enter the genre: ");
                    String genre = scanner.nextLine();

                    Book book = new Book(tittle,author,genre);
                    library.addBook(book);
                    question();
                    break;

                case "remove book" :
                    System.out.println("Enter the name of book: ");
                    String nameOfBook = scanner.nextLine();
                    library.removeBook(nameOfBook);
                    question();
                    break;

                case "get book by name" :
                    System.out.println("Enter the name of book: ");
                    String tittleOfBook = scanner.nextLine();
                    library.findBookByName(tittleOfBook);
                    question();
                    break;

                case "get book by author" :
                    System.out.println("Enter the authors name: ");
                    String authorOfBook = scanner.nextLine();
                    library.findBookByAuthor(authorOfBook);
                    question();
                    break;

                case "get book by genre" :
                    System.out.println("Enter the genre of book: ");
                    String genreOfBook = scanner.nextLine();
                    library.findBookByGenre(genreOfBook);
                    question();
                    break;

                case "list books" :
                    library.listAllBooks();
                    question();
                    break;

                default: System.out.println("Invalid command. "  + "Please write one of these command: ");
                System.out.println("Add Book - Get Book By Name(Author or Genre) - Remove Book - List Books - Exit");
            }
        }



    }
    private static void question() {
        System.out.println("What do you want to do?");
        System.out.println("Add Book - Get Book By Name or Author or Genre - Remove Book - List Books - Exit");

    }
}
