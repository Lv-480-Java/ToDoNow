package andriypyzh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class UserAuthenticationFilter implements Filter {

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("", "/", "/authentication.jsp", "/registered.jsp")));

    @Override
    public void init(FilterConfig config) throws ServletException {
        // If you have any <init-param> in web.xml, then you could getByName them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //
        HttpSession session = req.getSession(false);
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedIn || allowedPath) {
            chain.doFilter(servletRequest, servletResponse);
        }
        resp.sendRedirect("authentication.jsp");
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }

}
