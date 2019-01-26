package fx.leyu.notes.web.filter;

import fx.leyu.notes.service.PeopleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginStateFilter implements Filter {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private PeopleService peopleService;

    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext context = filterConfig.getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(context);
        peopleService = springContext.getBean(PeopleService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("[LOGIN] start");
        LOGGER.info("[LOGIN] start");
        LOGGER.warn("[LOGIN] start");
        LOGGER.error("[LOGIN] start");
        if (!(request instanceof HttpServletRequest && response instanceof HttpServletResponse)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (checkLoginStatus(httpServletRequest.getSession())) {
            chain.doFilter(request, response);
            return;
        }

        String pin = httpServletRequest.getParameter("pin");
        LOGGER.debug("[LOGIN] the pin is {}", pin);

        if (StringUtils.isBlank(pin)) {
            httpServletResponse.addCookie(new Cookie("pin", "unknown"));
            write(response, "[LOGIN_ERROR] Please take a pin!");
            return;
        }

        httpServletResponse.addCookie(new Cookie("pin", pin));
        if (peopleService.isValid(pin) || peopleService.register(pin)) {
            logOnStatus(httpServletRequest.getSession());
            chain.doFilter(request, response);
        } else {
            write(response, "[LOGIN_ERROR] Please take a unique pin!");
        }
    }

    private void logOnStatus(HttpSession session) {
        if (session != null) {
            session.setAttribute("login_status", Boolean.TRUE);
        }
    }

    private boolean checkLoginStatus(HttpSession session) {
        if (session == null) {
            return false;
        }

        return Boolean.TRUE.equals(session.getAttribute("login_status"));
    }

    @Override
    public void destroy() {
    }

    private void write(ServletResponse resp, String json) {
        resp.setCharacterEncoding("utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
