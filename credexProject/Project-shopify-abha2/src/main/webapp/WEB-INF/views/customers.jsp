<%@page import="com.credify.CustomerData.ShopifyCustomer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <style>body{
        padding: 0;
        margin: 0;
        font-family: 'Times New Roman', Times, serif;
        overflow-y:scroll;

    }
    table{
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        border-collapse: collapse;
        width: 800;
        height: 200px;
        border: 1px solid #bdc3c7;
        box-shadow: 2px 2px 12px rgba(0,0,0,0.2), -1px -1px 8px rgba(0,0,0,0.2),;
        overflow-y:scroll;
    }
    tr{
        transition: all -2s ease-in;
        cursor: pointer;
    }
    th,td{
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;

    }
    #header{
        background-color:  #93dae5;
        color:#fff;
        
    }
    h1{
        font-weight: 600;
        text-align: center;
        background-color: #1672a0 ;
        color: #fff;
        padding: 10px 0px;
    }
    tr:hover{
        background-color: #93dae5;
    }
    @media only screen and (max-width: 768px){
        table{
            width: 50%;
        }
    }
    form{
    display:flex;
    justify-content:center;
    }
    a {
  margin-bottom:100px;
  margin-left:100px;
  padding:auto;
  text-decoration:none;
  position:fixed;
}
.bottom{
overflow-y:scroll;
}
    
        </style>

    <title>Credify</title>
  </head>
  <body>

  <form action="singleCustomer" method="POST">
     <table>
        <thead>
            <tr id="header">
                <th scope="row">id</th>
                <th scope="row">email</th>
                <th scope="row">first_name</th>
                <th scope="row">last_name</th>
                <th scope="row">phone</th>
                <th scope="row">Action</th>
            </tr>
        </thead>
        <tbody class="bottom">
            <% ShopifyCustomer[] customer=(ShopifyCustomer[]) request.getAttribute("customers"); %>
                <% for (int i=0; i < customer.length; i++) { %>
                    <tr>
                        <td>
                            <%=customer[i].getId()%>
                        </td>
                        <td>
                            <%=customer[i].getEmail()%>
                        </td>
                        <td>
                            <%=customer[i].getFirst_name()%>
                        </td>
                        <td>
                            <%=customer[i].getLast_name()%>
                        </td>
                        <td>
                            <%=customer[i].getPhone()%>
                        </td>
                        <td>
                            <button name="id" type="submit" value="<%=customer[i].getId()%>">View</button>
                            <%--<input name="id" type="submit" class="button" value="<%=customer[i].getId()%>">View</input> --%>
        
                        </td>
                    </tr>
                    <% } %>
        </tbody>
    </table>

</form>
    <a href="customerForm">                      

                      <button type="button" class="btn btn-secondary" id="submit">Create Customer</button>
     </a>

  </body>
    
        

</html>