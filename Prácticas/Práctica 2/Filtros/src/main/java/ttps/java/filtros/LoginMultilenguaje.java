package ttps.java.filtros;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(name = "LoginMultilenguaje", value = "/LoginMultilenguaje")
public class LoginMultilenguaje extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String archivoTextos = (String) request.getAttribute("archivoTextos");

        ResourceBundle textos = ResourceBundle.getBundle(archivoTextos);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>" + textos.getString("titulo") + "</title></head>");
        out.println("<body>");
        out.println("<h1>" + textos.getString("titulo") + "</h1>");
        out.println("<form method=\"post\" action=\"Login\">");
        out.println("  " + textos.getString("labelUsuario")
                + ": <input type=\"text\" name=\"usuario\"/><br/>");
        out.println("  " + textos.getString("labelContraseña")
                + ": <input type=\"password\" name=\"password\"/><br/>");
        out.println("  <input type=\"submit\" value=\"" + textos.getString("labelBoton") + "\"/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

