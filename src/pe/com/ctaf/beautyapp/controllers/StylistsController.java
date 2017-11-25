package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Owner;
import pe.com.ctaf.beautyapp.models.Stylist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "StylistsController",
        urlPatterns = {"/stylists"}
)

public class StylistsController extends  HttpServlet{
    BeautyappService service=new BeautyappService();

    public static String STYLISTS_EDIT_URI = "/editStylist.jsp";
    public static String STYLISTS_ADD_URI = "/newStylist.jsp";
    public static String STYLISTS_INDEX_URI = "/listStylist.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch(action) {
            case "update": {
                Stylist stylist = service.getStylistById(request.getParameter("id"));
                stylist.setDni(request.getParameter("dni"));
                stylist.setFirstName(request.getParameter("firstName"));
                stylist.setLastName(request.getParameter("lastName"));
                stylist.setEmail(request.getParameter("email"));
                Owner owner = service.getOwnerById(request.getParameter("oid"));
                stylist.setOwner(owner);
                String message = service.updateStylist(stylist) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;
            }

            case "create": {
                Stylist stylist=new Stylist();
                Owner owner=new Owner();
                stylist.setId(request.getParameter("id"));
                stylist.setDni(request.getParameter("dni"));
                stylist.setFirstName(request.getParameter("firstName"));
                stylist.setLastName(request.getParameter("lastName"));
                stylist.setEmail(request.getParameter("email"));
                stylist.setOwner(owner.setId(request.getParameter("oid")));
                String message = service.addStylist(stylist) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;
            }
            case "delete":{
                Stylist stylist=service.getStylistById(request.getParameter("id"));
                String message = service.deleteStylist(stylist)?
                        "Delete success" :
                        "Error while delete";
                log(message);
                break;
            }
        }
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(STYLISTS_INDEX_URI);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch(action) {
            case "add": {
                actionUri = STYLISTS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            }
            case "edit": {
                Stylist stylist = service.getStylistById(request.getParameter("id"));
                request.setAttribute("stylist", stylist);
                request.setAttribute("action", "edit");
                actionUri = STYLISTS_EDIT_URI;
                break;
            }
            default:
                actionUri = STYLISTS_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }

}
