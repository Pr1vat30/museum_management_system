package museum_management_system.Presentation.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Dto.MostraDTO;
import museum_management_system.Application.Service.GestioneMostreService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mainEvents", value = "/mainevents")
public class MostraController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MostraDTO> eventi = GestioneMostreService.getAllMostre();
        req.setAttribute("eventi", eventi);
        req.getRequestDispatcher("WEB-INF/pages/mostreMain.jsp").forward(req, resp);
    }
}
