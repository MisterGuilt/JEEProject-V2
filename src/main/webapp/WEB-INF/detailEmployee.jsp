<%@page import="java.util.ArrayList"%>
<%@page import="se.m1.model.User"%>
<%@page import="se.m1.model.Employees"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Project</title>
        <style>
        body {
          font-family: Arial, Helvetica, sans-serif;
          background-color: black;
        }
        * {
          box-sizing: border-box;
        }
        /* Add padding to containers */
        .container {
          padding: 16px;
          background-color: white;
        }
        /* Full-width input fields */
        input[type=text], input[type=password] {
          width: 100%;
          padding: 15px;
          margin: 5px 0 22px 0;
          display: inline-block;
          border: none;
          background: #f1f1f1;
        }
        input[type=text]:focus, input[type=password]:focus {
          background-color: #ddd;
          outline: none;
        }
        /* Overwrite default styles of hr */
        hr {
          border: 1px solid #f1f1f1;
          margin-bottom: 25px;
        }
        /* Set a style for the submit button */
        .registerbtn {
          background-color: #4CAF50;
          color: white;
          padding: 16px 20px;
          margin: 8px 0;
          border: none;
          cursor: pointer;
          width: 100%;
          opacity: 0.9;
        }
        .registerbtn:hover {
          opacity: 1;
        }
        /* Add a blue text color to links */
        a {
          color: dodgerblue;
        }
        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
          background-color: #f1f1f1;
          text-align: center;
        }
        ul {
          list-style-type: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          background-color: #333;
        }

        li {
          float: left;
        }

        li a {
          display: block;
          color: white;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
        }

        li a:hover:not(.active) {
          background-color: #111;
        }

        .active {
          background-color: #4CAF50;
          height: 50px;
        }

        .person{
            background-color: lightblue;
        }
</style>
    </head>
    <body>
         <div class="container">
                    <ul>
               <form method='post' action='Controller'>
             <li><input type="submit" class="active" name="logout" value="Log Out"></li>
             </form>
             <li><a class="person">Hello ${user.login}, you are an ${user.rank}</a></li>
           </ul>
                <h1>Details for ${employee.name} ${employee.firstname}</h1>
                <hr>
            <form method='post' name='myform' action='Controller'>    
                 <input type="number" value="${employee.id}" name='id' hidden>
                 <label for="name"><b>Name</b></label>
                 <input type="text" value="${employee.name}" name='name' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="firstname"><b>First Name</b></label>
                 <input type="text" value="${employee.firstname}" name='firstname' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="homephone"><b>Home Phone</b></label>
                 <input type="text" value="${employee.telhome}" name='homephone' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="mobilephone"><b>Mobile Phone</b></label>
                 <input type="text" value="${employee.telmob}" name='mobilephone' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="mobilepro"><b>Mobile Pro</b></label>
                 <input type="text" value="${employee.telpro}" name='mobilepro' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="address"><b>Address</b></label>
                 <input type="text" value="${employee.adress}" name='address' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="postalcode"><b>Postal Code</b></label>
                 <input type="text" value="${employee.postalcode}" name='postalcode' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="city"><b>City</b></label>
                 <input type="text" value="${employee.city}" name='city' ${(user.rank != "admin") ? "readonly" : ''}>

                 <label for="email"><b>Email</b></label>
                 <input type="text" value="${employee.email}" name='email' ${(user.rank != "admin") ? "readonly" : ''}>
            <hr>
            <button type="submit" name="update" class="registerbtn" ${(user.rank != "admin") ? "disabled" : ''}>Save</button>
            <button type="submit" name="cancel" class="registerbtn">Cancel</button>
            </form>
        </div>
    </body>
</html>