package museum_management_system.Application.Facade;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.StaffService;
import museum_management_system.Storage.Model.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class StaffFacade {

    private final StaffService staffService;
    private final Gson gson;

    public StaffFacade() {
        this.staffService = new StaffService();
        this.gson = new Gson();
    }

    public void insertStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);
        Staff staff_item = new Staff(
                (String) jsonMap.get("cf"),
                (String) jsonMap.get("name"),
                (String) jsonMap.get("surname"),
                (String) jsonMap.get("email"),
                (String) jsonMap.get("password"),
                Double.parseDouble((String) jsonMap.get("salary")),
                (String) jsonMap.get("contract")
        );
        List<Staff> staff = staffService.save(staff_item);
        sendResponse(response, staff);
    }

    public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);
        Staff staff_item = new Staff(
                (String) jsonMap.get("cf"),
                (String) jsonMap.get("name"),
                (String) jsonMap.get("surname"),
                (String) jsonMap.get("email"),
                (String) jsonMap.get("password"),
                Double.parseDouble((String) jsonMap.get("salary")),
                (String) jsonMap.get("contract")
        );
        staff_item.setStaff_id(Integer.parseInt((String) jsonMap.get("staff_id")));
        List<Staff> staff = staffService.update(staff_item);
        sendResponse(response, staff);
    }

    public void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int staffId = Integer.parseInt(request.getParameter("id"));
        List<Staff> staff = staffService.delete(staffId);
        sendResponse(response, staff);
    }

    private void sendResponse(HttpServletResponse response, List<Staff> staff) throws IOException {
        String json = gson.toJson(staff);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}