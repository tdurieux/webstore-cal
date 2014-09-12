<%-- 
    Document   : researchRecap
    Created on : Apr 15, 2013, 5:16:11 PM
    Author     : Julien
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="books.BooksItf"%>
<%@ include file="includes/top.jsp" %>

<%
    // Set variables
    String book_title = request.getParameter("book_title");
    String book_author = request.getParameter("book_author");
    String book_date = request.getParameter("book_date");
    // Check Date
    boolean variablesAreSet = true ;
    if (book_title.isEmpty() || book_author.isEmpty() || book_date.isEmpty()) {
        variablesAreSet = false ;
    }
    // Session if variablesAreSet
    if (variablesAreSet) {
        session.setAttribute("book_title", book_title);
        session.setAttribute("book_author", book_author);
        session.setAttribute("book_date", book_date);
        session.setAttribute("session", 1);
    }
%>

<div class="row">
    <div class="centered six columns center_text"><%
        if (variablesAreSet) {
            BooksItf books;
            Context context = new InitialContext();
            books = (BooksItf) context.lookup(BooksItf.class.getName());
            boolean exist = books.bookExists(book_title, book_author, book_date);
            
            if (exist) {
                %><li class="primary alert center_text">Book exists</li><%=book_title%> written by <%=book_author%> in <%=book_date%><%
            } else { 
                %><li class="danger alert center_text">Book does not exist !</li><%=book_title%> written by <%=book_author%> in <%=book_date%><% 
            }
            
        } else {
            %><li class="danger alert center_text">You have to fill all the form !</li><%
        }
    %>
    </div>
</div>

    
<%@ include file="includes/bottom.jsp" %>
