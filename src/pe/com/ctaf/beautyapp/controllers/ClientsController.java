package pe.com.ctaf.beautyapp.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Client;

@WebServlet(
        name ="ClientsController",
        urlPatterns={"/client"}

)
public class ClientsController extends  HttpServlet{

    BeautyappService service=new BeautyappService();
    public static String CLIENTS_EDIT_URI = "/editClient.jsp";
    public static String CLIENTS_ADD_URI = "/newClient.jsp";
    public static String CLIENTS_INDEX_URI = "/listClient.jsp";



    public ClientsController(){

    }

    protected  void  doPost( HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        byte var5 = -1;
        switch(action.hashCode()) {
            case -838846263:
                if (action.equals("update")) {
                    var5 = 0;
                }
                break;
            case 1832640804:
                if (action.equals("agregate")) {
                    var5 = 1;
                }
        }
        Client client;
        String message;
        RequestDispatcher dispatcher;
        switch(var5) {
            case 0:
                client = this.service.getClientById(request.getParameter("id"));
                client.setDni(request.getParameter("dni"));
                client.setFirstName(request.getParameter("firstName"));
                client.setLastName(request.getParameter("lastName"));
                client.setEmail(request.getParameter("email"));
                client.setPassword(request.getParameter("password"));
                client.setPhone(request.getParameter("phone"));
                message = this.service.updateClient(client) ? "Update success" : "Error while updating";
                this.log(message);
                dispatcher = request.getRequestDispatcher(CLIENTS_INDEX_URI);
                dispatcher.forward(request, response);
            case 1:
                client = new Client();
                client.setId(request.getParameter("id"));
                client.setDni(request.getParameter("dni"));
                client.setFirstName(request.getParameter("firstName"));
                client.setLastName(request.getParameter("lastName"));
                client.setEmail(request.getParameter("email"));
                client.setPassword(request.getParameter("password"));
                client.setPhone(request.getParameter("phone"));

                message = this.service.addClient(client) ? "Add success" : "Error while updating";
                this.log(message);
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            default:
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                actionUri = CLIENTS_ADD_URI;
                request.setAttribute("action", "add");
                break;
            case 1:

                Client client = this.service.getClientById(request.getParameter("id"));

                request.setAttribute("client",client );
                request.setAttribute("action", "edit");
                actionUri = CLIENTS_EDIT_URI;
                break;
            default:
                actionUri = CLIENTS_INDEX_URI;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(actionUri);
        dispatcher.forward(request, response);
    }


}