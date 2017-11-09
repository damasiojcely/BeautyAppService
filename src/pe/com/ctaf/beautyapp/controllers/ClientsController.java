package pe.com.ctaf.beautyapp.controllers;

import models.BeautyService;
import models.Client;
import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ClientController", urlPatterns = "/client")
public class ClientsController extends  javax.servlet.http.HttpServlet{
   BeautyappService service;
    String url;

  public ClientsController(){
      super();
      service =new BeautyappService();
      url=" ";
  }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method, HttpServletRequest request, HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(method.equals("GET")) {
            // Index Action
            if(action.equals("index")) {
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("show")) {
                String id = request.getParameter("id");
                Client client = service.findClientById(id);
                request.setAttribute("client", client);
                url = "showClient.jsp";
            }
            if(action.equals("new")) {
                url = "newClient.jsp";
            }
            if(action.equals("edit")) {
                String id = request.getParameter("id");
                Client client = service.findClientById(id);
                request.setAttribute("client", client);
                url = "editClient.jsp";
            }
        }
        if(method.equals("POST")) {
            // Create Action
            if(action.equals("create")) {
                String dni = request.getParameter("dni");
                Client client = service.createClient(dni);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("create")) {
                String firstName = request.getParameter("first_name");
                Client client = service.createClient(firstName);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("create")) {
                String lastName = request.getParameter("last_name");
                Client client = service.createClient(lastName);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("create")) {
                String email = request.getParameter("email");
                Client client = service.createClient(email);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("create")) {
                String phone = request.getParameter("phone");
                Client client = service.createClient(phone);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
            if(action.equals("update")) {
                String id = request.getParameter("id");
                String dni = request.getParameter("dni");
                String firstName = request.getParameter("first_name");
                String lastName = request.getParameter("last_name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                boolean isUpdated = service.updateClient(id, dni,firstName,lastName,email,phone);
                List<Client> clients = service.findAllClients();
                request.setAttribute("client", clients);
                url = "listClients.jsp";
            }
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    }
