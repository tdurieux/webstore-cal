/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import display.PageWeb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import users.UsersItf;

/**
 *
 * @author Julien Duribreux, Dufour Justin
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/AddUserServlet"})
public class AddUserServlet extends HttpServlet {

    /**
     * EJB used to interact with database
     */
    @EJB 
    private UsersItf users ;
        
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        try {
            if ("addUser".equals(request.getParameter("action"))) {
                String pseudo = request.getParameter("pseudo");
                String password = request.getParameter("password");
                String permission = request.getParameter("userPermission") ;
                if (pseudo.equals("") || password.equals("") || permission.equals("")) {
                    out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"danger alert\">Fields can not be empty !</li></div></div>").toString()); 
                } else {
                    String permission_lvl = "user" ;
                    if (permission.equals("1")) {
                        permission_lvl = "admin" ;
                    }
                    out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"secondary alert\">"+pseudo + " added as " + permission_lvl + " !</li></div></div>").toString());   
                    users.addUser(pseudo, password, permission);
                }
            } if ("login".equals(request.getParameter("action"))) { 
                String pseudo = request.getParameter("pseudo");
                String password = request.getParameter("password");
                if (pseudo.equals("") || password.equals("")) {
                    out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"danger alert\">Fields can not be empty !</li></div></div>").toString()); 
                } else {
                    if (users.userExists(pseudo, password)) {
                        session.setAttribute("userPseudo", pseudo);
                        if (users.isAdmin(pseudo)) {
                            session.setAttribute("userPermission", 1);
                        } else {
                            session.setAttribute("userPermission", 0);
                        }
                        out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"secondary alert\">You are now connected as "+pseudo+" !</li></div></div>").toString());
                    } else {
                        out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"danger alert\">Wrong login or password !</li></div></div>").toString()); 
                    }
                }
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
