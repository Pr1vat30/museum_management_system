package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import museum_management_system.Application.Service.GestioneEventi_MostreService;

@WebServlet(name = "phase2redirect", value = {"/phase2redirect"})
public class ShopPhase2redirect extends HttpServlet {
    public ShopPhase2redirect() {}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LocalDate data = null;
        String email = (String) session.getAttribute("email");
        if (email == null) {
            req.setAttribute("infoErrore", "Sessione non valida");
            req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
        }
        String numeroBiglietti = req.getParameter("numero");
        if (numeroBiglietti == null ) {
            req.setAttribute("infoErrore", "Numero Biglietti non valido");
            req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
        }else{
            int numero = Integer.parseInt(numeroBiglietti);
            if(numero < 0 || numero > 8){
                req.setAttribute("infoErrore", "Numero Biglietti non valido");
                req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
            }
        }
        String dataPrenotazione = req.getParameter("data");
        if(dataPrenotazione == null){
            req.setAttribute("infoErrore", "Data non valida");
            req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
        }
        else{
            data = LocalDate.parse(dataPrenotazione);
            if(data.isBefore(LocalDate.now())){
                req.setAttribute("infoErrore", "Data non valida");
                req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
            }
        }
        String evento = req.getParameter("eventId");
        if(evento == null){
            req.setAttribute("infoErrore", "Evento non valido");
            req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
        }else{
            int eventId = Integer.parseInt(evento);
            if(!GestioneEventi_MostreService.validatePrenotazione(eventId, data, Integer.parseInt(numeroBiglietti))){
                req.setAttribute("infoErrore", "Combinazione data/evento non valida");
                req.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(req, resp);
            }
        }
        session.setAttribute("data", data);
        session.setAttribute("eventId", Integer.parseInt(evento));
        session.setAttribute("numeroBiglietti", Integer.parseInt(numeroBiglietti));
        session.setAttribute("price", GestioneEventi_MostreService.getPrice(Integer.parseInt(evento)));
        req.getRequestDispatcher("WEB-INF/pages/ticketShopPhase2.jsp").forward(req, resp);
    }
}
