package fx.leyu.notes.servlet;

import fx.leyu.notes.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(context);
        bookService = springContext.getBean(BookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        String info = req.getParameter("info");

        String result = "isbn is empty";
        if (StringUtils.isNotBlank(isbn)) {
            if (StringUtils.isNotBlank(info)) {
                result = bookService.storeBook(isbn, info) ? "SUCCESS" : "FAIL";
            } else {
                result = bookService.getBook(isbn);
            }
        }

        write(resp, result);
    }

    private void write(HttpServletResponse resp, String json) {
        resp.setCharacterEncoding("utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
