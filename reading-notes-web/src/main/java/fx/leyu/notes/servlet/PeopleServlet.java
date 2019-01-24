package fx.leyu.notes.servlet;

import fx.leyu.notes.service.PeopleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(context);
        peopleService = springContext.getBean(PeopleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String pin = req.getParameter("pin");

        String result = "the pin is not valid";
        if (StringUtils.isNotBlank(pin)) {
            result = peopleService.register(pin) ? "SUCCESS" : "this pin had been used";
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
