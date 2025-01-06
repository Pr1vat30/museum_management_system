package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import museum_management_system.Application.Dto.BigliettoDTO;
import museum_management_system.Application.Dto.MostraDTO;
import museum_management_system.Application.Service.GestioneBigliettiService;
import museum_management_system.Application.Service.GestioneMostreService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ticketshop", value = {"/ticketshop"})
public class ShopBigliettiController extends HttpServlet {
    public ShopBigliettiController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MostraDTO> eventi = GestioneMostreService.getAllMostre();
        request.setAttribute("eventi", eventi);
        request.getRequestDispatcher("WEB-INF/pages/ticketShopPhase1.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        int numeroBiglietti = (int) session.getAttribute("numeroBiglietti");
        LocalDate data = (LocalDate) session.getAttribute("data");
        int eventId = (int) session.getAttribute("eventId");
        float prezzo = (float) session.getAttribute("price");
        List<String> titolari = new ArrayList<>();
        for (int i = 1; i <= numeroBiglietti; i++) {
            String titolare = request.getParameter("titolare" + i);
            if (titolare != null && !titolare.isEmpty()) {
                titolari.add(titolare);
            }
        }
        float totalprice = 0;
        for(int i = 0; i < numeroBiglietti; i++) {
            BigliettoDTO tk = new BigliettoDTO();
            tk.setUserEmail(email);
            tk.setEventId(eventId);
            tk.setDataPrenotazione(data);
            tk.setPrezzo(prezzo);
            totalprice = totalprice + prezzo;
            tk.setTitolare(titolari.get(i));
            if(!GestioneBigliettiService.createBiglietto(tk)) {
                request.setAttribute("infoErrore", "Errore durante la validazione dei dati");
                request.getRequestDispatcher("WEB-INF/errors/erroreAcquisto.jsp").forward(request, response);
            }
        }
        request.setAttribute("eventoAcquistato", GestioneMostreService.getMostraName(eventId));
        request.setAttribute("totalprice", totalprice);
        request.getRequestDispatcher("WEB-INF/pages/ticketShopPhase3.jsp").forward(request, response);
    }
}
