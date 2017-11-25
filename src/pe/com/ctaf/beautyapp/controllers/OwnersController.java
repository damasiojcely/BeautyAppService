package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OwnersController" , urlPatterns = "/owners")
public class OwnersController extends HttpServlet{

    BeautyappService service = new BeautyappService();

    public static String OWNERS_EDIT_URI = "/editOwner.jsp";
    public static String OWNERS_ADD_URI = "/newOwner.jsp";
    public static String OWNERS_INDEX_URI = "/listOwner.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String action = request.getParameter("action");
        switch (action){
            case "update": {
                Owner owner = service.getOwnerById(request.getParameter("id"));
                owner.setDni(request.getParameter("dni"));
                owner.setFirstName(request.getParameter("firstName"));
                owner.setLastName(request.getParameter("lastName"));
                owner.setEmail(request.getParameter("email"));
                owner.setPassword(request.getParameter("password"));
                owner.setPhone(request.getParameter("phone"));
                String message = service.updateOwner(owner) ?
                        "listOwner.jsp" :
                        "Error while updating";
                log(message);
                RequestDispatcher dispatcher=request.getRequestDispatcher(OWNERS_INDEX_URI);
                dispatcher.forward(request,response);

            }
            case "agregate":{
                Owner owner=new Owner();
                owner.setId(request.getParameter("id"));
                owner.setDni(request.getParameter("dni"));
                owner.setFirstName(request.getParameter("firstName"));
                owner.setLastName(request.getParameter("lastName"));
                owner.setEmail(request.getParameter("email"));
                owner.setPassword(request.getParameter("password"));
                owner.setPhone(request.getParameter("phone"));
                String message = service.addOwner(owner)?
                        "login.jsp" :
                        "Error while updating";
                log(message);
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request,response);
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String action = request.getParameter("action");
        String actionUri;
        switch (action){
            case "add": {
                actionUri = OWNERS_ADD_URI;
                request.setAttribute("action","add");
                break;
            }
            case "edit": {
                Owner owner=service.getOwnerById(request.getParameter("id"));
                request.setAttribute("owner",owner);
                request.setAttribute("action","edit");
                actionUri=OWNERS_EDIT_URI;
                break;
            }
            default:
                actionUri=OWNERS_INDEX_URI;
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher(actionUri);
        dispatcher.forward(request,response);
    }
}
