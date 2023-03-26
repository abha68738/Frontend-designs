<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Credify</title>
  </head>
  <body>
      <form action="updateDataById" method="post">
      
      <div class="form-group">
  <% Long id=(Long) request.getAttribute("id"); %>
      <input id="customerId" name="customerId" value="<%=id%>">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
  </div>
  <div class="form-group">
  <label for="usr">First Name</label>
  <input type="text" class="form-control" id="usr" name="first_name"  pattern="[A-Z]{a-z}">
  </div>
  <div class="form-group">
  <label for="usr">Last Name</label>
  <input type="text" class="form-control" id="usr" name="last_name"  pattern="[A-Z]{a-z}">
 </div>
 <div class="form-group">
  <label for="usr">Phone Number</label>
  <input type="number" class="form-control" id="usr" name="phone" pattern="[0-9]{10}" >
 </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
  </body>
</html>