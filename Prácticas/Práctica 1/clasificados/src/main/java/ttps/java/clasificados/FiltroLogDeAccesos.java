package ttps.java.clasificados;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@Slf4j
public class FiltroLogDeAccesos implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String proccesedRequest = request.getRemoteAddr() + " [" + new Date().toString() + "] " + httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI() + " " + httpServletRequest.getHeader("User-Agent");
        log.info(proccesedRequest);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
