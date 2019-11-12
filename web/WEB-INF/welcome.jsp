<%-- 
    Document   : welcome
    Created on : 15 oct. 2019, 09:36:23
    Author     : Anil DEVADAS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="se.m1.User"%>
<%@page import="se.m1.Employee"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Project</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <form method='post' name='myform' action='Controller'>
        <h1 style="float:left;"> Welcome, <c:out value="${user.username} (${user.rank})"/></h1>
        <h1 style="float:right;">Log Out<button type="submit" name="logout"><i class="material-icons">power_settings_new</i></button></h1>
            
            <table border="1" class="table">
                <thead
                <tr>
                     <td><b>Selection</b></td>
                    <td><b>Name</b></td>
                    <td><b>First Name</b></td>
                    <td><b>Home Phone</b></td>
                    <td><b>Mobile Phone</b></td>
                    <td><b>Work Phone</b></td>
                    <td><b>Address</b></td>
                    <td><b>Postal Code</b></td>
                    <td><b>City</b></td>
                    <td><b>Email</b></td>
                </tr>
                </thead>
                <tbody
                <tr>
                    <c:forEach items="${empList}" var="employee"> 
                    <tr>
                        <td><input type="radio" name="id" value="${employee.id}"/></td>
                        <td>${employee.name}</td>
                        <td>${employee.firstname}</td>
                        <td>${employee.homePhone}</td>
                        <td>${employee.mobilePhone}</td>
                        <td>${employee.proPhone}</td>
                        <td>${employee.address}</td>
                        <td>${employee.postalCode}</td>
                        <td>${employee.city}</td>
                        <td>${employee.mail}</td>
                    </tr>
                    </c:forEach>
                    
                </tr>
                </tbody>
            </table>
       
            <input type="submit" name="add" value="Add Employee" ${(user.rank != "admin") ? "disabled" : ''}>
            <input type="submit" name="detail" value="Detail">
            <input type="submit" name="delete" value="Delete" ${(user.rank != "admin") ? "disabled" : ''}>
        </form>

    </body>
</html>
