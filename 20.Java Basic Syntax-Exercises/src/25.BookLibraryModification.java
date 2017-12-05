package ObjectsAndClasses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookLibraryModification {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LibraryMod library = new LibraryMod("My Library", new ArrayList<BookMod>());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String title = input[0];
            String author = input[1];
            String publisher = input[2];
            LocalDate date = (LocalDate.parse(input[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            String ISBN = input[4];
            double price = Double.parseDouble(input[5]);

            BookMod book = new BookMod(title, author, publisher, date, ISBN, price);
            library.getBooks().add(book);
        }

        LocalDate date = (LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        Comparator<BookMod> compareByReleaseDate = Comparator.comparing(BookMod::getDate);
        Comparator<BookMod> compareByName = Comparator.comparing(BookMod::getTitle);

        library.getBooks().stream()
                .filter(book -> book.getDate().compareTo(date) > 0)
                .sorted(compareByReleaseDate.thenComparing(compareByName))
                .forEach(book -> {
                    System.out.printf("%s -> %02d.%02d.%d%n", book.getTitle(), book.getDate().getDayOfMonth()
                            ,book.getDate().getMonth().getValue(), book.getDate().getYear());
                });

    }
}

class LibraryMod {
    private String name;
    private ArrayList<BookMod> books;

    LibraryMod(String name, ArrayList<BookMod> books) {
        this.name = name;
        this.books = books;
    }

    public ArrayList<BookMod> getBooks() {
        return books;
    }
}

class BookMod {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private String ISBN;
    private double price;

    BookMod(String title, String author, String publisher, LocalDate releaseDate, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public LocalDate getDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }
}
