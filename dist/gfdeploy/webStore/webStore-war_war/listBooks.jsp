<%-- 
    Document   : listBooks
    Created on : Apr 22, 2013, 9:27:03 AM
    Author     : julien
--%>
<%@page import="display.ListBooks2Buy"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="books.BooksItf"%>
<%@ include file="includes/top.jsp" %>

<%
   String user ;
   try {
       user = session.getAttribute("userPermission").toString() ;
   } catch (NullPointerException e) {
       user = "" ;
   }
   if (!user.isEmpty()) {
%>

<%
    // Initialization used to list all books
    BooksItf books;
    Context context = new InitialContext();
    books = (BooksItf) context.lookup(BooksItf.class.getName());
    int nbBooks = books.listBooks().size() ;
    if (nbBooks > 0) {
        %><div class="row"><%
        out.println(new ListBooks2Buy(books.listBooks()).toString()) ;
        %></div><%
    } else {
        %><div class="row center_text"><div class="centered four columns"><i class="icon-info-circled"></i>There is no book !</div></div><%
    }
    %></div><%
%>

<% } else { %>
    <div class="row center_text"><div class="centered six columns"><li class="danger alert">You have to be logged to command a book !</li></div></div> 
<% } %>

<%@ include file="includes/bottom.jsp" %>