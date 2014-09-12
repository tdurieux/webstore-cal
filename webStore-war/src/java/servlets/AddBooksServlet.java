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
import books.BooksItf ;

/**
 * Control the Books creation requests
 * @author Julien Duribreux, Dufour Justin
 */
@WebServlet(name = "AddBooksServlet", urlPatterns = {"/AddBooksServlet"})
public class AddBooksServlet extends HttpServlet {

    /**
     * EJB used to interact with database
     */
    @EJB 
    private BooksItf books ;
        
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
            if ("addBook".equals(request.getParameter("action"))) {
                String title = request.getParameter("book_title");
                String author = request.getParameter("book_author");
                String date = request.getParameter("book_date") ;
                if (title.equals("") || author.equals("") || date.equals("")) {
                    String sentence = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"danger alert\">Fields can not be empty !</li></div></div>" ;
                    out.println(new PageWeb(sentence).toString());
                } else {
                    String sentence = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"secondary alert\">" + request.getParameter("book_title") + " has been added !</li></div></div>";
                    out.println(new PageWeb(sentence).toString());
                    books.addBook(request.getParameter("book_title"), request.getParameter("book_author"), request.getParameter("book_date").toString());
                }
            } else {
                out.println(new PageWeb("<p class=\"center_text\"><i class=\"icon-info-circled\"></i>3 books has been added !</p>").toString());
                books.addBook("Le seigneur des anneaux", "J. R. R. Tolkien", "1954");
                books.addBook("Harry Potter", "J. K. Rowling", "1997");
                books.addBook("Ange et demon", "Dan Brown", "2000");
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
