package no.edu.library;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AddBookServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AddBookServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var bookTitle = req.getParameter("bookTitle");
        var bookAuthor = req.getParameter("bookAuthor");
        var book = new Book(bookAuthor, bookTitle);

        logger.info("Adding book -> {}", book);
    }

}
