<%-- 
    Document   : displayAgent
    Created on : 5 Feb 2020, 09:31:46
    Author     : k00203657
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Breweries</title>
    </head>
    <body>
        <table style="width:100%">
            <tr>
                <th align="left">ID</th>
                <th align="left">Name</th>
                <th align="left">Address 1</th>
                <th align="left">Address 2</th>
                <th align="left">City</th>
                <th align="left">State</th>
                <th align="left">Code</th>
                 <th align="left">Country</th>
                <th align="left">Phone</th>
                <th align="left">Website</th>
                <th align="left">Image</th>
                <th align="left">Description</th>
                <th align="left">Add User</th>
                <th align="left">Last Modified</th>
                <th align="left">Credit Limit</th>
                <th align="left">Email Address</th>
                <th align="left">Actions</th>
            </tr>
            <c:forEach items="${breweriesList}" var="brewerie"> 
                <tr>
                    <td>${brewerie.id}</td>
                    <td>${brewerie.name}</td>
                    <td>${brewerie.address1}</td>
                    <td>${brewerie.address2}</td>
                    <td>${brewerie.city}</td>
                    <td>${brewerie.state}</td>
                    <td>${brewerie.code}</td>
                    <td>${brewerie.country}</td>
                    <td>${brewerie.phone}</td>
                    <td>${brewerie.website}</td>
                    <td><img src="Image/${brewerie.image}" width="50" height="50"></td>
                   
                    <td>${brewerie.description}</td>
                    <td>${brewerie.addUser}</td>
                    <td>${brewerie.lastMod}</td>
                    <td>${brewerie.creditLimit}</td>
                    <td>${brewerie.email}</td>
                    <td>
          
                        <a href="\Assignment2\breweries\delete?id=${brewerie.id}" onclick="return confirmDelete('Are you sure you want to delete ${brewerie.name}')">Delete</a>
                         <a href="\Assignment2\breweries\edit?id=${brewerie.id}">Edit</a>
                        
                        <a href="\Assignment2\breweries\add">Insert</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
          <script>
            function confirmDelete(message)
            {
                return confirm(message);
            }
        </script>
    </body>
</html>