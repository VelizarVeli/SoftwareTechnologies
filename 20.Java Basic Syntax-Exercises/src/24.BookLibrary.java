package ObjectsAndClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BookLibrary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Library library = new Library("My Library", new ArrayList<Book>());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String title = input[0];
            String author = input[1];
            String publisher = input[2];
            LocalDate date = (LocalDate.parse(input[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            String ISBN = input[4];
            double price = Double.parseDouble(input[5]);

            Book book = new Book(title, author, publisher, date, ISBN, price);
            library.getBooks().add(book);
        }

        Comparator<Map.Entry<String, List<Book>>> compareByTotalPrice
                = Comparator.comparing(kvp -> kvp.getValue().stream().map(Book::getPrice)
                .mapToDouble(Double::valueOf).sum(), Comparator.reverseOrder());
        Comparator<Map.Entry<String, List<Book>>> compareByName
                = Comparator.comparing(Map.Entry::getKey);

        library.getBooks()
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor))
                .entrySet()
                .stream()
                .sorted(compareByTotalPrice.thenComparing(compareByName))
                .forEach(kvp-> {
                    double totalPrice = kvp.getValue().stream()
                            .map(Book::getPrice)
                            .mapToDouble(Double::valueOf)
                            .sum();
                    System.out.printf("%s -> %.2f%n", kvp.getKey(), totalPrice);
                });
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;

    Library(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

class Book {
    private String title;
    private String author;
    private String publisher;
    private LocalDate releaseDate;
    private String ISBN;
    private double price;

    Book(String title, String author, String publisher, LocalDate releaseDate, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

}