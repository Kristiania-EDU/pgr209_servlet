package no.edu.library;

import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryServer {
    private static final Logger logger = LoggerFactory.getLogger(LibraryServer.class);
    private final Server server = new Server(9080);
    private final BookRepository bookRepository;

    public LibraryServer() {
        bookRepository = new BookRepository();
    }

    public void start() throws Exception {
        var webApp = new WebAppContext(
            Resource.newClassPathResource("/webapp"), "/");

        webApp.addServlet(new ServletHolder(new AddBookServlet(bookRepository)), "/api/addBook");
        webApp.addServlet(new ServletHolder(new ListBooksServlet(bookRepository)), "/api/books/*");
        webApp.addServletContainerInitializer(new JettyJasperInitializer());

        server.setHandler(webApp);
        server.start();
        logger.info("Started server on {}", server.getURI());
    }

    public static void main(String[] args) throws Exception {
        new LibraryServer().start();
    }
}
