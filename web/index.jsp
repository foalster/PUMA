<%-- 
    Document   : index
    Created on : Apr 24, 2016, 4:40:58 PM
    Author     : Foalster
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>¡Bienvenido a PUMA!</title> 
        <meta charset="UTF-8">
        <link href="css/styles.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        
        
        <div class="container">
            <h1>¡Bienvenido a PUMA!</h1>
	<div class="row">
        <div class="span12">
            <form id="custom-search-form" class="form-search form-horizontal pull-right">
                <div class="input-append span12">
                    <input type="text" class="search-query mac-style" placeholder="Search">
                    <button type="submit" class="btn"><i class="icon-search"></i></button>
                </div>
            </form>
        </div>
	</div>
</div>
        
        
        
        <div style="text-align: right;">
            <form action="IniciarSesion.jsp" method="post">
                <input type="submit" value="Iniciar Sesion"/>
            </form>
            <form action="Registrar.jsp" method="post">
                <input type="submit" value="Registrar"/>
            </form>
            <!--
            <form method="post" action="Usuarios.jsp">
                <input type="submit" value="Consulta Usuarios"/>
            </form>-->
        </div>  
    </body>
</html>