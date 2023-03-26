<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
 <style>
  *{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  body{
    background-color: rgb(219,226,226);
  }
  .row{
    background-color: white;
    border-radius: 30px;
    box-shadow: 12px 12px 22px grey;
  }
  img{
    border-top-left-radius: 30px;
    border-bottom-left-radius: 30px;
  }
  .btn1{
    border: none;
    outline: none;
    height: 50px;
    width: 100%;
    background-color: black;
    color: white;
    border-radius: 4px;
    font-weight: bold;
  }
  .btn1:hover{
    background: white;
    border: 1px solid;
    color: black;
  }
 </style>
  
  </head>
  <body>
    <section class="Form my-4 mx-5">
        <div class="container">
            <div class="row no-gutters">
                <div class="col-lg-5">
                    <img src="https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=420&q=80" class="img-fluid" alt="">
                </div>
                <div class="col-lg-7 px-5 pt-5">
                  <h1 class="font-weight-bold py-3">Credify</h1>
                  <h1>Please Login to your Store</h1>
                    <form  class="box" action="adminLogin" method="post">
                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="name" placeholder="Store-Name" class="form-control my-3 p-4" name="storeName" pattern="[a-zA-Z][a-zA-Z0-9\.]*" >
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-lg-7">
                                <input type="password" placeholder="Token" class="form-control  my-3 p-4"  id="password" name="password">

                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-lg-7">
                               <button type="submit" class="btn1 mt-3 mb-5">Login</button>
                        
                            </div>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </section>
  </body>
</html>