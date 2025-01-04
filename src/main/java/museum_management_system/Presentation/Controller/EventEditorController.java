package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.EventDTO;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "EventEditor", value = "/eventeditor")
public class EventEditorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventId = req.getParameter("id");
        EventDTO event = GestioneEventi_MostreService.getEventById(Integer.parseInt(eventId));
        req.setAttribute("event", event);
        req.getRequestDispatcher("WEB-INF/pages/eventEditor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupero dei parametri inviati dal form
        String id = request.getParameter("id"); // Non modificabile
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        int posti = Integer.parseInt(request.getParameter("posti"));
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        float prezzo= Float.parseFloat(request.getParameter("prezzo"));
        int postioccupati = Integer.parseInt(request.getParameter("postioccupati"));

//        // Recupero dell'evento originale per mantenere i valori che non sono stati modificati
//        EventDTO eventoOriginale = GestioneEventi_MostreService.getEventById(Integer.parseInt(id));
//
//        // Se un parametro non è stato modificato, manteniamo il valore originale
//        if (nome == null || nome.isEmpty()) {
//            nome = eventoOriginale.getName();
//        }
//        if (descrizione == null || descrizione.isEmpty()) {
//            descrizione = eventoOriginale.getDescription();
//        }
//        if (posti == null || posti.isEmpty()) {
//            posti = String.valueOf(eventoOriginale.getPosti());
//        }
//        if (startdate == null || startdate.isEmpty()) {
//            startdate = String.valueOf(eventoOriginale.getStartDate());
//        }
//        if (enddate == null || enddate.isEmpty()) {
//            enddate = String.valueOf(eventoOriginale.getEndDate());
//        }
//        if (prezzoParam == null || prezzoParam.isEmpty()) {
//            prezzoParam = String.valueOf(eventoOriginale.getPriceXTicket());
//        }

        int postiLiberi = posti-postioccupati;


        EventDTO nuovoEvento = new EventDTO();
        nuovoEvento.setId(Integer.parseInt(id));
        nuovoEvento.setName(nome);
        nuovoEvento.setDescription(descrizione);
        nuovoEvento.setPosti(posti);
        nuovoEvento.setPostiLiberi(postiLiberi);
        nuovoEvento.setStartDate(LocalDate.parse(startdate));
        nuovoEvento.setEndDate(LocalDate.parse(enddate));
        nuovoEvento.setPriceXTicket(prezzo);
        try{
            GestioneEventi_MostreService.updateEvent(nuovoEvento);
        }catch (IllegalArgumentException e){
            request.setAttribute("infoErrore", e.getMessage());
            request.getRequestDispatcher("WEB-INF/errors/erroreEvento.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/pages/eventsMain.jsp").forward(request, response);
    }
}
