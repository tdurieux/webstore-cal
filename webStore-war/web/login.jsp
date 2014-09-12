<%-- 
    Document   : login
    Created on : May 4, 2013, 5:16:23 PM
    Author     : julien
--%>

<%@ include file="includes/top.jsp" %>

<form class="row center_text" action="AddUserServlet" method="GET" novalidate=""> 
    <ul class="centered six columns">
        <h6>- Login form -</h6>
        <input type="hidden" name="action" value="login" />
        <li class="prepend field">
            <span class="adjoined xnarrow">Pseudo</span>
            <input class="xwide text input" type="text" name="pseudo" required="required" placeholder="Pseudo"/>
        </li>
        <li class="prepend field">
            <span class="adjoined xnarrow">Pwd</span>
            <input class="xwide text input" type="password" name="password" required="required" placeholder="Password"/>
        </li>
    </ul>
    
    <div class="centered five columns">
        <div class="medium default btn pretty"><input type="reset" value="Reset" /></div>
        <div class="medium default btn pretty"><input type="submit" value="Log in" /></div>
    </div>
</form>

<%@ include file="includes/bottom.jsp" %>