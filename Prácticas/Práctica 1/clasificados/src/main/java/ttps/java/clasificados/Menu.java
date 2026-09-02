package ttps.java.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/menu")
public class Menu extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        RequestDispatcher rd = req.getRequestDispatcher("/Encabezado");
        rd.include(req,resp);

        String usuario = req.getAttribute("usuario").toString();

        PrintWriter out = resp.getWriter();

        if (req.getAttribute("perfil") instanceof Administrador){
            out.println("<h1>Menú de Operaciones - Administrador</h1>");
            out.println("<p>Seleccione una opción:</p>");
            out.println("<ul>");
            out.println("  <li><a href='#'>Listar Usuarios Publicadores</a></li>");
            out.println("  <li><a href='#'>ABM Administradores</a></li>");
            out.println("  <li><a href='#'>Ver Estadísticas</a></li>");
            out.println("</ul>");
        }
        else{
            out.println("<h1>Menú de Operaciones - Publicador</h1>");
            out.println("<p>Seleccione una opción:</p>");
            out.println("<ul>");
            out.println("  <li><a href='#'>Actualizar Datos de Contacto</a></li>");
            out.println("  <li><a href='#'>ABM de Publicaciones</a></li>");
            out.println("  <li><a href='#'>Contestar Consultas</a></li>");
            out.println("</ul>");
        }
            out.println("<p>Logueado como "+ usuario + "</p>");
        }
}
