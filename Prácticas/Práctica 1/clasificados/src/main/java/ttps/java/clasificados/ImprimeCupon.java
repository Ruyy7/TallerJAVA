package ttps.java.clasificados;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "ImprimeCupon", value = "/ImprimeCupon")
public class ImprimeCupon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texto = request.getParameter("texto");

        // 1. Leo la imagen base que ya está guardada en el servidor
        InputStream is = getServletContext().getResourceAsStream("/remera.jpg");
        BufferedImage imagen = ImageIO.read(is);

        // 2. Obtengo el Graphics2D para dibujar directamente sobre esa imagen
        Graphics2D graphics = imagen.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));

        // 3. Dibujo el texto personalizado ingresado por el usuario
        graphics.drawString(texto, 50, 300);

        // 4. Genero el código de retiro aleatorio y lo dibujo también
        int codigo = ThreadLocalRandom.current().nextInt(1000000, 99999999);
        graphics.setFont(new Font("Arial", Font.PLAIN, 14));
        graphics.drawString(texto + " CODIGO DE RETIRO #" + codigo, 300, 380);

        graphics.dispose();

        // 5. Escribo la imagen resultante directamente en la respuesta, como JPG
        response.setContentType("image/jpeg");
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(imagen, "jpg", outputStream);
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

