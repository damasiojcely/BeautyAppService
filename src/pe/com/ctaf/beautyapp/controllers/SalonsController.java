package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Location;
import pe.com.ctaf.beautyapp.models.Owner;
import pe.com.ctaf.beautyapp.models.Salon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SalonsController", urlPatterns = {"/salons"})
public class SalonsController extends HttpServlet {

    BeautyappService service = new BeautyappService();

    public static String SALONS_EDIT_URI = "/editSalon.jsp";
    public static String SALONS_ADD_URI = "/newSalon.jsp";
    public static String SALONS_INDEX_URI = "/listSalon.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idowner=(String)request.getSession().getAttribute("owner");
        String action=request.getParameter("action");
        switch (action){
            case "update": {
                Salon salon = service.getSalonById(request.getParameter("id"));
                salon.setId(request.getParameter("id"));
                salon.setName(request.getParameter("name"));
                salon.setPhone(request.getParameter("phone"));
                salon.setEmail(request.getParameter("email"));
                String message = service.updateSalon(salon) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;

            }
            case "agregate": {
                Owner owner = new Owner();
                Location location= new Location();
                Salon salon= new Salon();
                salon.setId(request.getParameter("id"));
                salon.setName(request.getParameter("name"));
                salon.setPhone(request.getParameter("phone"));
                salon.setEmail(request.getParameter("email"));
                salon.setOwner(owner.setId(request.getParameter("ownerid")));
                salon.setLocation(location.setId(request.getParameter("locationid")));
                String message = service.addSalon(salon) ?
                        "Update success" :
                        "Error while updating";
                log(message);
                break;
            }
            case "delete": {
                Salon salon = service.getSalonById(request.getParameter("id"));
                String message = service.deleteSalon(salon) ?
                        "Delete success" :
                        "Error while delet";
                log(message);
                break;
            }

        }
        if(idowner!=null){
            RequestDispatcher dispatcher = request.getRequestDispatcher(SALONS_INDEX_URI);
            dispatcher.forward(request,response);
        }
        //NO HAY OTRO LIST
        //else {
          //  RequestDispatcher dispatcher = request.getRequestDispatcher(COURTS_INDEX_URI);
            //dispatcher.forward(request,response);
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String actionUri;
        switch (action){
            case "add":{
                actionUri = SALONS_ADD_URI;
                request.setAttribute("action","add");
                break;
            }
            case "edit":{
                Salon salon = service.getSalonById(request.getParameter("id"));
                request.setAttribute("salon",salon);
                request.setAttribute("action","edit");
                actionUri = SALONS_EDIT_URI;
                break;
            }
            default:
                actionUri = SALONS_INDEX_URI;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request,response);
    }
}
