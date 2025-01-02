package museum_management_system.Presentation.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.BigliettoDTO;
import museum_management_system.Application.Service.GestioneBigliettiService;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

import java.io.IOException;


@WebServlet("/bigliettocontroller")
public class BigliettoController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ticketId = (int) request.getAttribute("ticketId");
        BigliettoDTO biglietto = GestioneBigliettiService.getBigliettobyID(ticketId);
        String qrcodePath = "/qrcode/" + biglietto.getId();
        String titolare = biglietto.getTitolare();
        // Passiamo i dettagli del biglietto alla JSP
        request.setAttribute("qrcode", qrcodePath);
        request.setAttribute("titolare", titolare);
        request.getRequestDispatcher("WEB-INF/pages/ticketRender.jsp").forward(request, response);
    }
}
