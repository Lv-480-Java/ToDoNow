package andriypyzh.servlets.filter;

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

    private static final Set<String> ALLOWED_PATHS =
            Collections.unmodifiableSet(new HashSet<>(
                    Arrays.asList("", "/", "/authentication.jsp", "/registered.jsp",
                            "/RegisterServlet", "/LoginServlet", "/LogOutServlet")));

    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        String path = req.getRequestURI()
                .substring(req.getContextPath().length())
                .replaceAll("[/]+$", "");

        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedIn || allowedPath) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.setAttribute("error", "Please Log In");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("authentication.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
