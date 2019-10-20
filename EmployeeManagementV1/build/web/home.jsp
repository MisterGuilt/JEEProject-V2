<%-- 
    Document   : home
    Created on : 15 oct. 2019, 09:01:36
    Author     : Anil DEVADAS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="style.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Project</title>
    </head>
    
  <%--  <% 
        if(request.getAttribute("errKey") != null)
        {
            out.print((String)request.getAttribute("errKey"));
         }
    %>--%>
  
        <c:if test="${!empty errKey}">
            <c:out value="${errKey}" />
        </c:if>
    <body>
        <h1></h1>
        <form method='post' name='myform' action='Controller'>
          <input type="text" id="login" class="fadeIn second" name='loginField' placeholder="login">
          <input type="text" id="password" class="fadeIn third" name='pwdField' placeholder="password">
          <center><input type="submit" name="connexion" value="LogIn"></center>
        </form>
    </body>
</html>
