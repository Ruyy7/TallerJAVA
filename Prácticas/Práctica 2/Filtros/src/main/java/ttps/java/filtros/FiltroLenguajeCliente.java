package ttps.java.filtros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/LoginMultilenguaje")
public class FiltroLenguajeCliente implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String lenguajeNavegador = req.getLocale().getLanguage();
        if (lenguajeNavegador.equals("es") || lenguajeNavegador.equals("en"))
            req.setAttribute("archivoTextos","textos_" + lenguajeNavegador);
        else
            req.setAttribute("archivoTextos","textos_" + "es");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
