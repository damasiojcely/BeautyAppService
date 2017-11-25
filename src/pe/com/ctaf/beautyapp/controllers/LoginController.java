package pe.com.ctaf.beautyapp.controllers;

import pe.com.ctaf.beautyapp.models.BeautyappService;
import pe.com.ctaf.beautyapp.models.Client;
import pe.com.ctaf.beautyapp.models.Owner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController" , urlPatterns = "/login")
public class LoginController extends HttpServlet {
    BeautyappService service=new BeautyappService();

    public static String OWNER_IN_URI = "/index3.jsp";
    public static String CLIENT_IN_URI = "/index2.jsp";
    public static String LOGIN_URI = "/login.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("uownertext/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        if (service.getClientByEmail(email, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(CLIENT_IN_URI);
            dispatcher.forward(request, response);
            Client client=service.getClientIdByEmail(email,password);
            HttpSession sessionOr = request.getSession();
            sessionOr.setAttribute("uclient",client.getId());

        }else if (service.getOwnerByEmail(email,password)){
            RequestDispatcher dispatcher = request.getRequestDispatcher(OWNER_IN_URI);
            dispatcher.forward(request, response);
            Owner owner = service.getOwnerIdByEmail(email,password);
            HttpSession sessionOw = request.getSession();
            sessionOw.setAttribute("uowner",owner.getId());
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_URI);
            dispatcher.include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

