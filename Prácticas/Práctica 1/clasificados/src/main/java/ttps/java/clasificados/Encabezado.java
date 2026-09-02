package ttps.java.clasificados;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Encabezado", value = "/Encabezado")
public class Encabezado extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        SitioClasificado sitio = (SitioClasificado) getServletContext().getAttribute("sitioClasificado");
        out.println("<h2>" + sitio.getNombre() + "</h2>");
        out.println("<p>" + sitio.getEmail() + " - Teléfono: " + sitio.getTelefono() + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

