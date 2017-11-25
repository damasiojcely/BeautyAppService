package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Salon;
import pe.com.ctaf.beautyapp.models.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServicesController",urlPatterns = "/services")
public class ServicesController extends HttpServlet{

    BeautyappService servic = new BeautyappService();


    public static String SERVICES_EDIT_URI = "/editService.jsp";
    public static String SERVICES_ADD_URI = "/newService.jsp";
    public static String SERVICES_INDEX_URI = "/listServices.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action) {
            case "update": {
                Service service = servic.getServiceById(request.getParameter("id"));
                service.setName(request.getParameter("name"));
                service.setPrice(Float.parseFloat(request.getParameter("price")));
                String message = servic.updateService(service) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;
            }
            case "agregate":{
                Salon salon=new Salon();
                Service service=new Service();
                service.setId(request.getParameter("id"));
                service.setName(request.getParameter("name"));
                service.setPrice(Float.parseFloat(request.getParameter("price")));
                service.setSalon(salon.setId(request.getParameter("court_id")));
                String message = servic.addService(service) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;
            }

        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(SERVICES_INDEX_URI);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch(action) {
            case "add": {
                actionUri = SERVICES_ADD_URI;
                request.setAttribute("action", "add");
                break;
            }
            case "edit": {
                Service service = servic.getServiceById(request.getParameter("id"));
                request.setAttribute("service", service);
                request.setAttribute("action", "edit");
                actionUri = SERVICES_EDIT_URI;
                break;
            }
            default:
                actionUri = SERVICES_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }
}

