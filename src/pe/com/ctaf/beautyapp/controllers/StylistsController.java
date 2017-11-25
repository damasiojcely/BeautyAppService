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
        urlPatterns = {"/stylist"}
)

public class StylistsController extends  HttpServlet{
    BeautyappService service=new BeautyappService();

    public static String STYLISTS_EDIT_URI = "/editStylist.jsp";
    public static String STYLISTS_ADD_URI = "/newStylist.jsp";
    public static String STYLISTS_INDEX_URI = "/listStylists.jsp";

    public StylistsController() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        byte var5 = -1;
        switch(action.hashCode()) {
            case -1352294148:
                if (action.equals("create")) {
                    var5 = 1;
                }
                break;
            case -1335458389:
                if (action.equals("delete")) {
                    var5 = 2;
                }
                break;
            case -838846263:
                if (action.equals("update")) {
                    var5 = 0;
                }
        }

        Stylist stylist;
        String message;
        Owner owner;
        switch(var5) {
            case 0:
                stylist = this.service.getStylistById(request.getParameter("id"));
                stylist.setFirstName(request.getParameter("firstName"));
                stylist.setLastName(request.getParameter("lastName"));
                stylist.setEmail(request.getParameter("email"));
                stylist.setPhone(request.getParameter("phone"));
               // stylist.setOwner(owner);
                message = this.service.updateStylist(stylist) ? "Update success" : "Error while updating";
                this.log(message);
                break;
            case 1:
                stylist = new Stylist();
                owner =new Owner();

                stylist.setId(request.getParameter("id"));
                stylist.setFirstName(request.getParameter("firstName"));
                stylist.setLastName(request.getParameter("lastName"));
                stylist.setEmail(request.getParameter("email"));
                stylist.setPhone(request.getParameter("phone"));
                stylist.setOwner(owner.setId(request.getParameter("id")));
                message = this.service.addStylist(stylist) ? "Update success" : "Error while updating";
                this.log(message);
                break;
            case 2:
                stylist = this.service.getStylistById(request.getParameter("id"));
                message = this.service.deleteStylist(stylist) ? "Delete success" : "Error while delete";
                this.log(message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(STYLISTS_INDEX_URI);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        byte var6 = -1;
        switch(action.hashCode()) {
            case 96417:
                if (action.equals("add")) {
                    var6 = 0;
                }
                break;
            case 3108362:
                if (action.equals("edit")) {
                    var6 = 1;
                }
        }

        String actionUri;
        switch(var6) {
            case 0:
                actionUri = STYLISTS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            case 1:
                Stylist stylist = this.service.getStylistById(request.getParameter("id"));
                request.setAttribute("stylist", stylist);
                request.setAttribute("action", "edit");
                actionUri = STYLISTS_EDIT_URI;
                break;
            default:
                actionUri = STYLISTS_INDEX_URI;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }



}
