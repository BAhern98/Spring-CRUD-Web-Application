<%-- 
    Document   : addBrewery
    Created on : 4 Mar 2020, 09:02:51
    Author     : k00203657
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <h3>Edit The Brewery Details!</h3>

    <form:form method="POST" action="/Assignment2/breweries/updateBrewery" modelAttribute="brewerie">

        <table>
            <tr>
                <td><form:label path="id">ID</form:label></td>
                <td><form:input path="id"  readonly="true"/></td>
                <td style="color:red"><form:errors path="id"/> </td>
            </tr>
          
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" /></td>
                <td style="color:red"><form:errors path="name"/> </td>
            </tr>
          
            <tr>
                <td><form:label path="address1">Address 1</form:label></td>
                <td><form:input path="address1" /></td>
                <td style="color:red"><form:errors path="address1"/> </td>
            </tr>
            <tr>
                <td><form:label path="address2">Address 2</form:label></td>
                <td><form:input path="address2"/></td>
                <td style="color:red"><form:errors path="address2"/> </td>

            </tr>
            <tr>
                <td><form:label path="city">City</form:label></td>
                <td><form:input path="city"/></td>
                <td style="color:red"><form:errors path="city"/> </td>

            </tr>
            <tr>
                <td><form:label path="state">State</form:label></td>
                <td><form:input path="state"/></td>
                <td style="color:red"><form:errors path="state"/> </td>

            </tr>
               <tr>
                <td><form:label path="code">Code</form:label></td>
                <td><form:input path="code"/></td>
                <td style="color:red"><form:errors path="code"/> </td>

            </tr>
        
            <tr>
                <td><form:label path="country">Country</form:label></td>
                <td><form:input path="country"/></td>
                <td style="color:red"> <form:errors path="country"/> </td>
            </tr>
         
            <tr>
                <td><form:label path="phone">Phone Number</form:label></td>
                <td><form:input path="phone"/></td>
                <td style="color:red"> <form:errors path="phone"/> </td>
            </tr>
                  <tr>
                <td><form:label path="website">Website</form:label></td>
                <td><form:input path="website"/></td>
                <td style="color:red"><form:errors path="website"/> </td>

            </tr>
        
            <tr>
                <td><form:label path="description">Description</form:label></td>
                <td><form:input path="description"/></td>
                <td style="color:red"> <form:errors path="description"/> </td>
            </tr>
            <tr>
                <td><form:label path="addUser">Add User</form:label></td>
                <td><form:input path="addUser"/></td>
                <td style="color:red"> <form:errors path="addUser"/> </td>
            </tr>
        
            <tr>
                <td><form:label path="creditLimit">Credit Limit</form:label></td>
                <td><form:input path="creditLimit"/></td>
                <td style="color:red"> <form:errors path="creditLimit"/> </td>
            </tr>
            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email"/></td>
                <td style="color:red"> <form:errors path="email"/> </td>
            </tr>
            	  <tr>
                <td><form:label path="latitude">Latitude</form:label></td>
                <td><form:input path="latitude"/></td>
                <td style="color:red"> <form:errors path="latitude"/> </td>
            </tr>
            <tr>
                <td><form:label path="longitude">Longitude</form:label></td>
                <td><form:input path="longitude"/></td>
                <td style="color:red"> <form:errors path="longitude"/> </td>
            </tr>
                 
          

            <tr>
             
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </body>
</form:form>
</html>
