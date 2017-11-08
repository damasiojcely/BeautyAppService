package pe.com.ctaf.beautyapp.controllers;
import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Location;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "LocationsController",urlPatterns = "/locations")
public class LocationsController  extends javax.servlet.http.HttpServlet{
    BeautyappService service;
    String url;
 public LocationsController(){
     super();
     service=new BeautyappService();
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
                List<Location> locations = service.findAllLocations();
                request.setAttribute("locations", locations);
                url = "listLocations.jsp";
            }
            if(action.equals("show")) {
                String id = request.getParameter("id");
                Location location = service.findLocationById(id);
                request.setAttribute("location", location);
                url = "showLocation.jsp";
            }
            if(action.equals("new")) {
                url = "newLocation.jsp";
            }
            if(action.equals("edit")) {
                String id = request.getParameter("id");
                Location location = service.findLocationById(id);
                request.setAttribute("location", location);
                url = "editLocation.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                Location location = service.createLocation(name);
                List<Location> locations = service.findAllLocations();
                request.setAttribute("locations", locations);
                url = "listLocations.jsp";
            }
            if(action.equals("update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                boolean isUpdated = service.updateLocation(id, name);
                List<Location> locations = service.findAllLocations();
                request.setAttribute("locations", locations);
                url = "listLocations.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
 }


}
