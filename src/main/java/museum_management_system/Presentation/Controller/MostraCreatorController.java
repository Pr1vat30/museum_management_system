package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.MostraDTO;
import museum_management_system.Application.Service.GestioneMostreService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "EventCreator", value = "/eventcreator")
public class MostraCreatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/mostraCreator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Otteniamo il percorso dell'immagine dal form
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String postiLiberiParam = request.getParameter("postiLiberi");
        String prezzoParam = request.getParameter("prezzo");

        // Crea l'oggetto Evento
        MostraDTO evento = new MostraDTO();
        evento.setName(nome);
        evento.setDescription(descrizione);
        evento.setStartDate(LocalDate.parse(startdate));
        evento.setEndDate(LocalDate.parse(enddate));
        evento.setPostiLiberi(Integer.parseInt(postiLiberiParam));
        evento.setPosti(Integer.parseInt(postiLiberiParam));
        evento.setPriceXTicket(Float.parseFloat(prezzoParam));
        if(!GestioneMostreService.createMostra(evento)) {
            request.setAttribute("infoErrore", "Impossibile creare l'evento");
            request.getRequestDispatcher("WEB-INF/errors/erroreEvento.jsp").forward(request, response);
        }
        // Redirect o risposta di conferma
        request.getRequestDispatcher("WEB-INF/pages/mostreMain.jsp").forward(request, response);
    }
}
