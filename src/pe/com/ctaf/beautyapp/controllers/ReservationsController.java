package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Client;
import pe.com.ctaf.beautyapp.models.Reservation;
import pe.com.ctaf.beautyapp.models.Salon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ReservationsController", urlPatterns = "/reservations")
public class ReservationsController extends HttpServlet {
    BeautyappService service = new BeautyappService();

    public static String RESERVATIONS_EDIT_URI = "/editReservation.jsp";
    public static String RESERVATIONS_ADD_URI = "/createReservation.jsp";
    public static String RESERVATIONS_INDEX_URI = "/listReservation.jsp";
    public static String RESERVATIONS_INDEX2_URI = "/listReservation2.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ides=(String)request.getSession().getAttribute("uowner");
        String action = request.getParameter("action");
        switch (action){
            case "update": {
                Reservation reservation = service.getReservationById(request.getParameter("id"));
                reservation.setReserdate(Date.valueOf(request.getParameter("reser_date")));
                reservation.setResertime(Date.valueOf(request.getParameter("reser_time")));
                reservation.setPrice(Float.parseFloat(request.getParameter("price")));
                String message = service.updateReservation(reservation)?
                        "Update sucess" :
                        "Error while updating";
                log(message);
                break;
            }
            case "agregate":{
                Reservation reservation=new Reservation();
                Client client = new Client();
                Salon salon = new Salon();
                reservation.setId(Integer.parseInt(request.getParameter("id")));
                reservation.setReserdate(Date.valueOf(request.getParameter("reser_date")));
                reservation.setResertime(Date.valueOf(request.getParameter("reser_time")));
                reservation.setPrice(Float.parseFloat(request.getParameter("price")));
                reservation.setClient(client.setId(request.getParameter("client_id")));
                reservation.setSalon(salon.setId(request.getParameter("salon_id")));
                String message = service.addReservation(reservation)?
                        "Update sucess" :
                        "Error while updating";
                log(message);
                break;
            }
            case "delete":{
                Reservation reservation=service.getReservationById(request.getParameter("id"));
                String message=service.deleteReservation(reservation) ?
                        "Delete success" :
                        "Error while del";
                log(message);
                break;
            }
        }
        if(ides!=null){
            RequestDispatcher dispatcher=request.getRequestDispatcher(RESERVATIONS_INDEX2_URI);
            dispatcher.forward(request,response);
        }
        else {
            RequestDispatcher dispatcher=request.getRequestDispatcher(RESERVATIONS_INDEX_URI);
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcli=(String)request.getSession().getAttribute("uclient");
        String action = request.getParameter("action");
        String actionUri;
        switch (action){

            case "add": {
                Salon salon = service.getSalonById(request.getParameter("ids"));
                Client client = service.getClientById(idcli);
                request.setAttribute("client",client);
                request.setAttribute("salon",salon);
                request.setAttribute("action","add");
                actionUri = RESERVATIONS_ADD_URI;
                break;
            }
            case "edit": {
                Reservation reservation = service.getReservationById(request.getParameter("id"));
                request.setAttribute("reservation",reservation);
                request.setAttribute("action","edit");
                actionUri = RESERVATIONS_EDIT_URI;
                break;
            }
            default:
                actionUri=RESERVATIONS_INDEX_URI;
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher(actionUri);
        dispatcher.forward(request,response);
    }
}
