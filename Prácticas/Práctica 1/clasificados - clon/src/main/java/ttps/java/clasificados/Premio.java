package ttps.java.clasificados;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Premio extends HttpServlet {
    private int contadorVisitas;

    public Premio() {
        this.contadorVisitas = 0;
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int visitas = this.contadorVisitas++;
        response.setContentType("application/json");
        String jsonResponse = String.format(
                "{\"msg\": \"Usted es el visitante nro %d\", \"visitas\": %d, \"ultimo_usuario\": \"%s\"}",
                visitas,
                visitas,
                getServletContext().getAttribute("ultimoAcceso")
        );

        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
    }
}
