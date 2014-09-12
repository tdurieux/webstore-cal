<%-- 
    Document   : commands
    Created on : Apr 22, 2013, 5:36:39 PM
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
    

    List<CommandsEntity> commands = command.listCommands() ;
    if (commands.size() > 0) {
        String output = "<table id=\"tbl_list_books\">" ;
        for (CommandsEntity c : commands) {
            output += "<tr colspan=\"3\"><td>Command n°"+c.getId()+" by " + c.getUsername() +"</td></tr>" ;
            for(String b : c.getCommand()) {
                BooksEntity book = books.getBook(b) ;
                output += "<tr><td>" + book.getId() + "</td><td>"+book.getAuthor()+"</td><td>"+book.getDate()+"</td></tr>" ;
            }
            output += "<tr><td class=\"empty_row\"colspan=\"3\"></tr>" ;
        }
        output += "</table>" ;
        out.println(output);
        } else {
            String output = "<div class=\"row center_text\"><div class=\"centered four columns\"><li class=\"primary alert\">No command has been done !</li></div></div>" ;
            out.println(output);
        }

%>



<%@ include file="includes/bottom.jsp" %>