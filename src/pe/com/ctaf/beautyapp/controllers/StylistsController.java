package pe.com.ctaf.beautyapp.controllers;

import models.BeautyService;
import models.Stylist;
import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Stylist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "StylistController", urlPatterns = "/stylist")
public class StylistsController extends   javax.servlet.http.HttpServlet{

        BeautyappService service;
        String url;

        public StylistsController(){
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
                if(action.equals("index2")) {
                    List<Stylist> stylists = service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("show")) {
                    String id = request.getParameter("id");
                    Stylist stylist = service.findStylistById(id);
                    request.setAttribute("stylist", stylist);
                    url = "showStylist.jsp";
                }
                if(action.equals("new")) {
                    url = "newStylist.jsp";
                }
                if(action.equals("edit")) {
                    String id = request.getParameter("id");
                    Stylist stylist = service.findStylistById(id);
                    request.setAttribute("stylist", stylist);
                    url = "editStylist.jsp";
                }
            }
            if(method.equals("POST")) {
                // Create Action
                if(action.equals("create")) {
                    String dni = request.getParameter("dni");
                    Stylist stylist = service.createStylist(dni);
                    List<Stylist> stylists = service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("create")) {
                    String firstName = request.getParameter("first_name");
                    Stylist stylist = service.createStylist(firstName);
                    List<Stylist> stylists = service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("create")) {
                    String lastName = request.getParameter("last_name");
                    Stylist stylist = service.createStylist(lastName);
                    List<Stylist> stylists= service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("create")) {
                    String email = request.getParameter("email");
                    Stylist stylist = service.createStylist(email);
                    List<Stylist> stylists= service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("create")) {
                    String phone = request.getParameter("phone");
                    Stylist stylist = service.createStylist(phone);
                    List<Stylist> stylists = service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
                if(action.equals("update")) {
                    String id = request.getParameter("id");
                    String dni = request.getParameter("dni");
                    String firstName = request.getParameter("first_name");
                    String lastName = request.getParameter("last_name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    boolean isUpdated = service.updateClient(id, dni,firstName,lastName,email,phone);
                    List<Stylist> stylists = service.findAllStylists();
                    request.setAttribute("stylist", stylists);
                    url = "listStylists.jsp";
                }
            }

            request.getRequestDispatcher(url).forward(request, response);
        }



}
