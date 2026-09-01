package ttps.java.clasificados;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class Login extends HttpServlet {
    List<Usuario> usuarios;

    public void init(){
        this.usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Pablo","123",new Publicador()));
        usuarios.add(new Usuario("Ines","1234",new Administrador()));
        usuarios.add(new Usuario("Juan","12345",new Publicador()));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Recibo los parámetros de autenticación
        String usernameParam = request.getParameter("username");
        String passwordParam = request.getParameter("password");

        Optional<Usuario> usuarioRegistrado = this.usuarios.stream().filter(u -> u.getNombreUsuario().equals(usernameParam) && u.getClave().equals(passwordParam)).findFirst();

        if (usuarioRegistrado.isPresent()){
            getServletContext().setAttribute("ultimoAcceso", usuarioRegistrado.get().getNombreUsuario());
            if (usuarioRegistrado.get().getPerfil() instanceof Administrador){
                response.sendRedirect("administrador.html");
            }
            else {
                response.sendRedirect("publicador.html");
            }
        }
        else{
            response.sendRedirect("error.html");
        }
    }

}
