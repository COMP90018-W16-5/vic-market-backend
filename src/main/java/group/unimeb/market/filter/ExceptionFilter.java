package group.unimeb.market.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;

public class ExceptionFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(ExceptionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean isRethrow = !Objects.isNull(request.getAttribute("Exception"));
        /* Whether this exception has already been re-threw */
        if (isRethrow) {
            chain.doFilter(request, response);
            return;
        }
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            request.setAttribute("Exception", e);
            /* rethrow it to exception hander controller */
            request.getRequestDispatcher("/error/rethrow").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
