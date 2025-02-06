package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
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

public class ArtsFacade {

    private final ArtsService artsService;
    private final Gson gson;

    public ArtsFacade() {
        this.artsService = new ArtsService();
        this.gson = new Gson();
    }

    public void insertArt(String contextPath, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        Map<String, String> jsonMap = extractArtParameters(request);
        Part filePart = request.getPart("cover");

        List<Art> arts = artsService.save(contextPath, jsonMap, filePart);
        sendResponse(response, arts);
    }

    public void updateArt(String contextPath, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> jsonMap = extractArtParameters(request);
        Part filePart = request.getPart("cover");

        List<Art> arts = artsService.update(contextPath, jsonMap, filePart);
        sendResponse(response, arts);
    }

    public void deleteArt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int artId = Integer.parseInt(request.getParameter("id"));
        List<Art> arts = artsService.delete(artId);
        sendResponse(response, arts);
    }

    private Map<String, String> extractArtParameters(HttpServletRequest request) {
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("id", request.getParameter("id"));
        jsonMap.put("name", request.getParameter("name"));
        jsonMap.put("desc", request.getParameter("desc"));
        jsonMap.put("artist", request.getParameter("artist"));
        jsonMap.put("length", request.getParameter("length"));
        jsonMap.put("height", request.getParameter("height"));
        return jsonMap;
    }

    private void sendResponse(HttpServletResponse response, List<Art> arts) throws IOException {
        String json = gson.toJson(arts);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}