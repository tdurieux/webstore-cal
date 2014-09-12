<%-- 
    Document   : register
    Created on : 2 mai 2013, 11:11:14
    Author     : duribreux
--%>

<%@ include file="includes/top.jsp" %>

<form class="row center_text" action="AddUserServlet" method="GET" novalidate=""> 
    <ul class="centered six columns">
        <h6>- Create a new user -</h6>
        <input type="hidden" name="action" value="addUser" />
        <li class="prepend field">
            <span class="adjoined normal">Pseudo</span>
            <input class="wide text input" type="text" name="pseudo" required="required" placeholder="Pseudo"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Pwd</span>
            <input class="wide text input" type="text" name="password" required="required" placeholder="Password"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Full name</span>
            <input class="wide text input" type="text" name="fname" required="required" placeholder="fname"/>      
        </li>
        <li class="prepend field">
            <span class="adjoined normal">E-mail</span>
            <input class="wide text input" type="text" name="email" required="required" placeholder="email"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Address</span>
            <input class="wide text input" type="text" name="address" required="required" placeholder="address"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">City</span>
            <input class="wide text input" type="text" name="city" required="required" placeholder="city"/>          
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Postal Code</span>
            <input class="wide text input" type="text" name="pcode" required="required" placeholder="pcode"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Country</span>
            <input class="wide text input" type="text" name="country" required="required" placeholder="country"/>
        </li>
        <li class="prepend field">
            <span class="adjoined normal">Phone number</span>
            <input class="wide text input" type="text" name="phone" required="required" placeholder="phone"/>
        </li>
        Available only for tests... Should be only for admins
        <div class="field">
            <div  class="picker">
                <select name="userPermission">
                    <option disabled>User's permission</option>
                    <option value="0">User</option>
                    <option value="1">Admin</option>
                </select>
            </div>
        </div>
    </ul>
    
    <div class="centered five columns">
        <div class="medium default btn pretty"><input type="reset" value="Reset" /></div>
        <div class="medium default btn pretty"><input type="submit" value="Add user" /></div>
    </div>
</form>

<%@ include file="includes/bottom.jsp" %>