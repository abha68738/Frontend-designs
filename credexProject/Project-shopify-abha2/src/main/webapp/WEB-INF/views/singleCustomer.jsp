<%@page import="com.credify.CustomerData.ShopifyCustomer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
span {
	color: black;
	font-weight: 600;
	font: bold;
	margin-right: 10px;
}


</style>
</head>
<body>
	<div class="container">
		<h1>Customer Details</h1>
		<div class="row">
			<div class="col-md-4">
			
				<img class="fa fa-user" width="200px"
					height="300px" />
				
			</div>
		<hr>
		<div class="row">
			
			<div class="col-md-8">
				<%
				ShopifyCustomer customer = (ShopifyCustomer) request.getAttribute("customers");
				{
				%>
				<h4>Customer Details</h4>
				<p>
					<span> Customer Id :</span>
					<%=customer.getId()%>
				</p>
				<p>
					<span>Customer Name :</span>
					<%=customer.getFirst_name()%>
					
				</p>
				<p>
					<span>Email :</span>
					<%=customer.getEmail()%></p>
				<p>
					<span>Address :</span>
			        
			  
			    }
				</p>
				<p>
					<span>Total Orders :</span>
					<%=customer.getOrders_count()%>
				</p>
				<p>
					<span>Last Order:</span>
					<%=customer.getLast_order_name()%>
				</p>
				<p>
					<span>Last Order id :</span>
					<%=customer.getLast_order_id()%>
				</p>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<div class="row-2">
		                    <form action="updateCustomer" method="post">
		                   <button  name="id" type="submit" value="<%=customer.getId()%>">Update</button>	
		                   </form>
					
		</div>
		<div class="row-3">
		                   <form action="deleteCustomer" method="post">
		                   <button  name="id" type="submit" value="<%=customer.getId()%>">Delete</button>	
		                   </form>
							
		</div>
</body>
</html>