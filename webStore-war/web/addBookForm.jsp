<%-- 
    Document   : addBookForm
    Created on : Apr 18, 2013, 7:51:25 PM
    Author     : julien
--%>

<%@page import="display.ListBooks"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="books.BooksItf"%>
<%@ include file="includes/top.jsp" %>

<%
    // Initialization used to list all books
    BooksItf books;
    Context context = new InitialContext();
    books = (BooksItf) context.lookup(BooksItf.class.getName());
    int nbBooks = books.listBooks().size() ;
%>

<%
   String permission ;
   try {
       permission = session.getAttribute("userPermission").toString() ;
   } catch (NullPointerException e) {
       permission = "0" ;
   }
   
   if (permission.equals("1")) {
%>
<form class="row center_text" action="AddBooksServlet" method="POST" novalidate=""> 
    <div class="medium default btn pretty"><input type="submit" value="Auto create 3 books" /></div>
</form>

<form class="row center_text" action="AddBooksServlet" method="GET" novalidate=""> 
    <ul class="centered six columns">
        <h6>- Create a new book -</h6>
        <input type="hidden" name="action" value="addBook" />
            <li class="prepend field">
                <span class="adjoined xnarrow">Title</span>
                <input class="xwide text input" type="text" name="book_title" required="required" placeholder="Book title"/>
            </li>
            <li class="prepend field">
                <span class="adjoined xnarrow">Author</span>
                <input class="xwide text input" type="text" name="book_author" required="required" placeholder="Author's name"/>
            </li>
            <li class="prepend field">
                <span class="adjoined xnarrow">Year</span>
                <input class="xwide text input" type="text" name="book_date" required="required" placeholder="Publication date" />
            </li>
        </ul>

        <div class="centered five columns">
            <div class="medium default btn pretty"><input type="reset" value="Reset" /></div>
            <div class="medium default btn pretty"><input type="submit" value="Add book" /></div>
        </div>

        <%
            if (nbBooks > 0) {
                %><h6 class="centered six columns button_display" onClick="display()"> <i class="icon-resize-full"></i>Click to display all books</h6><div class="centered six columns hiddenBooks"><%
                out.println(new ListBooks(books.listBooks()).toString()) ;
                %></div><%
            } else {
                %><h6 class="centered six columns"><i class="icon-info-circled"></i>There is no book !</h6><%
            }
        %>
    </form>
<% } else { %>
    <div class="row center_text"><div class="centered six columns"><li class="danger alert">You have not the permission to add some books, log as admin !</li></div></div> 
<% } %>
<%@ include file="includes/bottom.jsp" %>
