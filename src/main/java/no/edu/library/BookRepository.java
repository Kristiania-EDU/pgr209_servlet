package no.edu.library;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> listAll() {
        return books.stream().toList();
    }
}
