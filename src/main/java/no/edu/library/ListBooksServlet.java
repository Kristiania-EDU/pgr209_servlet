package no.edu.library;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.Source;

import java.io.IOException;

public class ListBooksServlet extends HttpServlet {
    private final BookRepository bookRepository;

    public ListBooksServlet(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var path = req.getPathInfo().substring(1);
        var writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.write(String.format("<h1>Here are all the books in the category of: \"%s\"</h1>", path));
        writer.write("<ul>");

        for(var book : bookRepository.listAll()) {
            writer.write(String.format("<li>%s</li>", book.toString()));
        }

        writer.write("</ul>");
    }
}
