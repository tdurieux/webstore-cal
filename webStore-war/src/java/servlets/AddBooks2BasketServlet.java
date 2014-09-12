package servlets;

import books.BooksEntity;
import commands.CommandsItf;
import display.PageWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Control the Commands creation requests
 * @author Julien Duribreux, Dufour Justin
 */
@WebServlet(name = "AddBooks2BasketServlet", urlPatterns = {"/AddBooks2BasketServlet"})
public class AddBooks2BasketServlet extends HttpServlet {

    /**
     * EJB used to interact with database
     */
    @EJB
    private CommandsItf commands ;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String relPath = request.getContextPath();
        try {
            HttpSession session = request.getSession(true);
            if ("buyBooks".equals(request.getParameter("action"))) {
                String[] listOfBooks = request.getParameterValues("book") ;
                if (listOfBooks == null) {
                    String sentence = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"danger alert\">Fields can not be empty !</li></div></div>" ;
                    out.println(new PageWeb(sentence).toString());
                } else {
                    String sentence = "<div class=\"row center_text\"><div class=\"centered six columns\"><li class=\"secondary alert\">Books added to your basket, check it to validate your command !</li></div></div>" ;
                    out.println(new PageWeb(sentence).toString());
                    try { // add a new book in the basket
                        String[] old_books = (String[]) session.getAttribute("booksCommand") ;
                        String[] new_books = listOfBooks ;
                        List<String> list = new ArrayList<String>();
                        list.addAll(Arrays.asList(old_books));
                        list.addAll(Arrays.asList(new_books));                         
                        session.removeAttribute("booksCommand");
                        String[] array = list.toArray(new String[list.size()]);
                        session.setAttribute("booksCommand", array);
                    } catch (Exception e) { // first add
                        session.setAttribute("booksCommand", request.getParameterValues("book"));
                    }
                }
            } else if ("removeSelectedBooks".equals(request.getParameter("action"))) {
                String[] books = (String[]) session.getAttribute("booksCommand");
                String[] selectedBooks = (String[]) request.getParameterValues("book");
                List<String> list = new ArrayList<String>();
                for (String old : books) {
                    boolean found = false ;
                    for (String toRemove : selectedBooks) {
                        if (old.equals(toRemove)) found = true ;
                    }
                    if (!found) list.add(old) ;
                }
                String[] array = list.toArray(new String[list.size()]);
                session.setAttribute("booksCommand", array);
                response.sendRedirect(relPath + "/basket.jsp");
            } else if ("removeBooks".equals(request.getParameter("action"))) {
                session.removeAttribute("booksCommand");
                response.sendRedirect(relPath + "/basket.jsp");
            } else if ("validCommand".equals(request.getParameter("action"))) {
                String sentence = "<div class=\"row center_text\"><div class=\"centered six columns\"><li class=\"secondary alert\">Command process started !</li></div></div>" ;
                String[] listOfBooks = (String[]) session.getAttribute("booksCommand");
                String username = (String) session.getAttribute("userPseudo") ;
                out.println(new PageWeb(sentence).toString());
                commands.addCommand(listOfBooks, username);
                session.removeAttribute("booksCommand");
            } else {
                out.println(new PageWeb("<div class=\"row center_text\"><div class=\"centered four columns\"><i class=\"icon-home\"></i><a href=\"index.jsp\">Home</a><br/>Nothing to do there !</div></div>").toString());
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
