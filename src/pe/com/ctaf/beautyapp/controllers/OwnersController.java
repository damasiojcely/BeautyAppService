package pe.com.ctaf.beautyapp.controllers;
import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Owner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@javax.servlet.annotation.WebServlet(name = "OwnersController",urlPatterns = "/owners")
public class OwnersController extends javax.servlet.http.HttpServlet {
    BeautyappService service;
    String url;
    public OwnersController(){
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
                List<Owner> owners = service.findAllOwners();
                request.setAttribute("owners", owners);
                url = "listOwners.jsp";
            }
            if(action.equals("show")) {
                String id = request.getParameter("id");
                Owner owner = service.findOwnerById(id);
                request.setAttribute("owner", owner);
                url = "showOwner.jsp";
            }
            if(action.equals("new")) {
                url = "newOwner.jsp";
            }
            if(action.equals("edit")) {
                String id = request.getParameter("id");
                Owner owner = service.findOwnerById(id);
                request.setAttribute("owner", owner);
                url = "editOwner.jsp";
            }
        }

        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String name = request.getParameter("name");
                Owner owner = service.createOwner(name);
                List<Owner> owners = service.findAllOwners();
                request.setAttribute("owners", owners);
                url = "listOwners.jsp";
            }
            if(action.equals("update")) {
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                boolean isUpdated = service.updateOwner(id, name);
                List<Owner> owners = service.findAllOwners();
                request.setAttribute("owners", owners);
                url = "listOwners.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
