package museum_management_system.Presentation.Controllers.Staff;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import museum_management_system.Application.Service.ArtsService;
import museum_management_system.Storage.Model.Art;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "artsServlet", value = "/staff-art-servlet") @MultipartConfig
public class ArtsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        switch (request.getParameter("op")) {
            case "insert_art": insertArt(request, response); break;
            case "update_art": updateArt(request, response); break;
            case "delete_art": deleteArt(request, response); break;
            default: System.out.println("Invalid operation"); break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void insertArt(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Map<String, String> jsonMap = new HashMap<>();

        jsonMap.put("name", request.getParameter("name"));
        jsonMap.put("desc", request.getParameter("desc"));
        jsonMap.put("artist", request.getParameter("artist"));
        jsonMap.put("length", request.getParameter("length"));
        jsonMap.put("height", request.getParameter("height"));

        Part filePart = request.getPart("cover");

        ArtsService artsService = new ArtsService();
        List<Art> arts = artsService.save(getServletContext().getRealPath(""), jsonMap, filePart);

        Gson gson = new Gson();
        String json = gson.toJson(arts);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void updateArt(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Map<String, String> jsonMap = new HashMap<>();

        jsonMap.put("id", request.getParameter("id"));
        jsonMap.put("name", request.getParameter("name"));
        jsonMap.put("desc", request.getParameter("desc"));
        jsonMap.put("artist", request.getParameter("artist"));
        jsonMap.put("length", request.getParameter("length"));
        jsonMap.put("height", request.getParameter("height"));

        Part filePart = request.getPart("cover");

        ArtsService artsService = new ArtsService();
        List<Art> arts = artsService.update(getServletContext().getRealPath(""), jsonMap, filePart);

        Gson gson = new Gson();
        String json = gson.toJson(arts);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void deleteArt(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int art_id = Integer.parseInt(request.getParameter("id"));
        Gson gson = new Gson();

        ArtsService artService = new ArtsService();
        List<Art> arts = artService.delete(art_id);

        String json = gson.toJson(arts);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}
