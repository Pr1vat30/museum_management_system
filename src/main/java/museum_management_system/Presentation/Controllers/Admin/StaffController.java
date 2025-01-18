package museum_management_system.Presentation.Controllers.Admin;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import museum_management_system.Application.Service.StaffService;
import museum_management_system.Storage.Model.Staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "m-staffServlet", value = "/admin-staff-servlet")
public class StaffController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        switch (request.getParameter("op")) {
            case "insert_staff": insertStaff(request, response); break;
            case "update_staff": updateStaff(request, response); break;
            case "delete_staff": deleteStaff(request, response); break;
            default: System.out.println("Invalid operation"); break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void insertStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        StaffService staffService = new StaffService();
        List<Staff> staff = staffService.save(jsonMap);

        String json = gson.toJson(staff);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void updateStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Gson gson = new Gson();
        Map<String, Object> jsonMap = gson.fromJson(request.getReader(), Map.class);

        StaffService staffService = new StaffService();
        List<Staff> staff = staffService.update(jsonMap);

        String json = gson.toJson(staff);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }

    public void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int staff_id = Integer.parseInt(request.getParameter("id"));
        Gson gson = new Gson();

        StaffService staffService = new StaffService();
        List<Staff> staff = staffService.delete(staff_id);

        String json = gson.toJson(staff);
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        }
    }
}
