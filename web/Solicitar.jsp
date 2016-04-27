<%-- 
    Document   : Solicitar
    Created on : Apr 26, 2016, 2:08:03 PM
    Author     : Foalster
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/styles.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulario</title>
    </head>
        <body>
        <div class = "container">
            <div class="wrapper">
                <form method="post" action="SolicitarC">
                    <h1 class="form-signin-heading">Solicita</h1>
                    Tiempo de prestamo: <input type="text" name="tiempo"/><br/><br/>
                    Lugar de entrega: <input type="text" name="lugar"/><br/><br/>
                    Motivo: <br/><input type="text" name="motivo" id ="motivo"/><br/><br/><br/>
                    <input type="submit" value="Solicitar"/>
                </form>
            </div>
        </div>
    </body>
</html>
