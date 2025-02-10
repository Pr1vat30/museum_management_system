package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import museum_management_system.Application.Service.ArtsService;
import museum_management_system.Storage.Model.Art;
import museum_management_system.Storage.Utils.Validators.ArtValidator;

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

    public String insertArt(String contextPath, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        Map<String, String> jsonMap = extractArtParameters(request);
        Part filePart = request.getPart("cover");

        Map<String, Object> jsonMapForObjects = gson.fromJson(request.getReader(), Map.class);

        try{

            Art art_item = new Art(
                    (String) jsonMapForObjects.get("name"),
                    (String) jsonMapForObjects.get("desc"),
                    (String) jsonMapForObjects.get("artist"),
                    (String) jsonMapForObjects.get("lenght"),
                    (String) jsonMapForObjects.get("height")
            );

            System.out.println(art_item.getName());
            System.out.println(art_item.getDesc());
            System.out.println(art_item.getArtist());
            System.out.println(art_item.getLength());
            System.out.println(art_item.getHeight());
            ArtValidator.validateArt(art_item , filePart);

            List<Art> arts = artsService.save(contextPath, jsonMap, filePart);
            sendResponse(response, arts);
            return "ok";
        }catch (IllegalArgumentException e){
            System.out.println("Errore nell'inserimento: " + e.getMessage());
            return "error";
        }

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