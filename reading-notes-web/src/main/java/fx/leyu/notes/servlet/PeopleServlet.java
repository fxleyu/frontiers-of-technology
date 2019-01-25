package fx.leyu.notes.servlet;

import fx.leyu.notes.service.PeopleService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
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
        boolean hasLogin = checkLoginStatus(req);
        String result = "HAS LOGIN! WELCOME!";
        if (!hasLogin) {
            result = "LOGIN ERROR!";
            String pin = req.getParameter("pin");
            if (StringUtils.isNotBlank(pin) && peopleService.register(pin)) {
                result = "LOGIN SUCCESS";
                setLoginStatus(req.getSession());
                Cookie cookie = new Cookie("pin", pin);
                resp.addCookie(cookie);
            }
        }
        write(resp, result);
    }

    private void setLoginStatus(HttpSession session) {
        session.setAttribute("login_status", Boolean.TRUE);
    }

    private boolean checkLoginStatus(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }

        Object obj = session.getAttribute("login_status");
        if (obj instanceof Boolean) {
            return BooleanUtils.isTrue((Boolean) obj);
        }
        return false;
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
