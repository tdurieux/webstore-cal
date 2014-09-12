<%-- 
    Document   : researchRecap
    Created on : Apr 15, 2013, 5:06:42 PM
    Author     : Julien
--%>

<%@ include file="includes/top.jsp" %>

<%
    // If session has been set
    String book_title = "" ;
    String book_author = "" ;
    String book_date = "" ;
    if (null != session.getAttribute("session")) {
        %><div class="row center_text"><div class="centered four columns"><li class="secondary alert">You've already made a research !</li></div></div><%
        book_title = (String) session.getAttribute("book_title") ;
        book_author = (String) session.getAttribute("book_author") ;
        book_date = (String) session.getAttribute("book_date") ;
    } else {
        %><div class="row center_text"><div class="centered four columns"><li class="primary alert">No research has been done yet !</li></div></div><%
    }
%>

<form class="row center_text" action="researchRecap.jsp" post="post">
    <ul class="centered six columns">
        <li class="prepend field">
            <span class="adjoined xnarrow">Title</span>
            <input class="xwide text input" type="text" name="book_title" placeholder="Book title" value="<%=book_title%>" />
        </li>
        <li class="prepend field">
            <span class="adjoined xnarrow">Author</span>
            <input class="xwide text input" type="text" name="book_author" placeholder="Author's name" value="<%=book_author%>" />
        </li>
        <li class="prepend field">
            <span class="adjoined xnarrow">Year</span>
            <input class="xwide text input" type="text" name="book_date" placeholder="Publication date" value="<%=book_date%>" />
        </li>
    </ul>
    <div class="centered five columns">
        <div class="medium default btn pretty"><input type="reset" value="Reset" /></div>
        <div class="medium default btn pretty"><input type="submit" value="Research" /></div>
    </div>
</form>

<%@ include file="includes/bottom.jsp" %>