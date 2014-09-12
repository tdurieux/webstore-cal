<%-- 
    Document   : basket
    Created on : Apr 22, 2013, 10:35:08 AM
    Author     : julien
--%>

<%@page import="books.BooksItf"%>
<%@page import="books.BooksEntity"%>
<%@page import="books.Books"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="commands.CommandsEntity"%>
<%@page import="commands.CommandsItf"%>
<%@page import="java.util.List"%>

<%@ include file="includes/top.jsp" %>

<%
    // Initialization used to list all books
    BooksItf books;
    Context context = new InitialContext();
    books = (BooksItf) context.lookup(BooksItf.class.getName());
    
    CommandsItf command;
    command = (CommandsItf) context.lookup(CommandsItf.class.getName());
    String[] booksCommand = (String[]) session.getAttribute("booksCommand");
    
    try {
        if (booksCommand.length != 0) {
            out.println("<form class=\"row center_text\" action=\"AddBooks2BasketServlet\" method=\"GET\"><input type=\"hidden\" name=\"action\" value=\"removeBooks\" /><div class=\"medium default btn pretty\"><input type=\"submit\" value=\"Delete all books\"/></div></form>");
            out.println("<form class=\"row center_text\" action=\"AddBooks2BasketServlet\" method=\"GET\"><input type=\"hidden\" name=\"action\" value=\"removeSelectedBooks\" /><div class=\"medium default btn pretty\"><input type=\"submit\" value=\"Remove selected books\"/></div>");
      
            String output = "<table id=\"tbl_list_books\"><tr><th>Title</th><th>Author</th><th>Date</th><th>Action</th></tr>" ;
            for(String b : booksCommand) {
                BooksEntity book = books.getBook(b) ;
                output += "<tr><td>" + book.getId() + "</td><td>"+book.getAuthor()+"</td><td>"+book.getDate()+"</td><td><input type=\"checkbox\" name=\"book\" value=\""+book.getId()+"\"></td></tr>" ;
            }
            output += "</table></form>" ;
            out.println(output);
        
            out.println("<br/><form class=\"row center_text\" action=\"AddBooks2BasketServlet\" method=\"GET\"><input type=\"hidden\" name=\"action\" value=\"validCommand\" /><div class=\"medium default btn pretty\"><input type=\"submit\" value=\"Valid your basket\"/></div></form>");
        } else {
            String output = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"primary alert\">Basket is empty !</li></div></div>" ;
            out.println(output);         
        }
    } catch (NullPointerException e) {
       String output = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"primary alert\">Basket is empty !</li></div></div>" ;
       out.println(output);
    }
%>

<%@ include file="includes/bottom.jsp" %>