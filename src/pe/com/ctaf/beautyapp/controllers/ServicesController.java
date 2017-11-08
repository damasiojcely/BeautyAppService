package pe.com.ctaf.beautyapp.controllers;
import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@javax.servlet.annotation.WebServlet(name = "ServicesController",urlPatterns = "/services")
public class ServicesController extends javax.servlet.http.HttpServlet{
    BeautyappService service;
    String url;
    public ServicesController(){
        super();
        service = new BeautyappService();
        url="";
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{
        processReques("POST",request,response);
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)throws javax.servlet.ServletException, IOException{
        processReques("GET",request,response);
    }

    private void processReques(String method, HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException, IOException  {
        String action = request.getParameter("action");
        if(method.equals("GET")) {
            // Index Action
            if(action.equals("index")) {
                List<Service> services = service.findAllServices();
                request.setAttribute("services", services);
                url = "listServices.jsp";
            }
            if(action.equals("show")) {
                String id = request.getParameter("id");
                Service service1 = service.findAllServiceById(id);
                request.setAttribute("service", service1);
                url = "showService.jsp";
            }
            if(action.equals("new")) {
                url = "newService.jsp";
            }
            if(action.equals("edit")) {
                String id = request.getParameter("id");
                Service service1 = service.findServiceById(id);
                request.setAttribute("service", service1);
                url = "editService.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                Service service1 = service.createService(name);
                List<Service> services = service.findAllServices();
                request.setAttribute("services", services);
                url = "listServices.jsp";
            }
            if(action.equals("update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                boolean isUpdated = service.updateService(id, name);
                List<Service> services = service.findAllServices();
                request.setAttribute("services", services);
                url = "listServices.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
