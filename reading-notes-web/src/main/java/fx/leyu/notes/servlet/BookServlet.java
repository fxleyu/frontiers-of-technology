package fx.leyu.notes.servlet;

import fx.leyu.notes.service.BookService;
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
        String json = bookService.getBook("SIBN");
        write(resp, json + "autowired");
    }

    private void write(HttpServletResponse resp, String json) {
        PrintWriter writer = null;
        try {
            resp.setCharacterEncoding("utf-8");
            writer = resp.getWriter();
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
