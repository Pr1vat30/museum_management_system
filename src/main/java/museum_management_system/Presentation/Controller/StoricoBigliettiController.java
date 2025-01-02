package museum_management_system.Presentation.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Dto.BigliettoDTO;
import museum_management_system.Application.Service.GestioneBigliettiService;

import java.io.IOException;
import java.util.List;

@WebServlet("/storico-biglietti")
public class StoricoBigliettiController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        if (email == null) {
            request.getRequestDispatcher("WEB-INF/errors/erroreAutenticazione.jsp").forward(request, response);
        }
        List<BigliettoDTO> biglietti = GestioneBigliettiService.getBigliettiByUser(email);
        request.setAttribute("biglietti", biglietti);
        request.getRequestDispatcher("WEB-INF/pages/ticketHistory.jsp").forward(request, response);
    }
}

