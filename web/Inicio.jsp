<%-- 
    Document   : Inicio
    Created on : Apr 10, 2016, 3:23:56 AM
    Author     : Foalster
--%>



<%@page import="Servlet.SolicitarC"%>
<jsp:useBean id="consulta" class="Controlador.Control"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" session="false"%>
<%@ page language="java" %>
<%@ page import = "Modelo.Calculadora"%> 
<%@ page import = "java.util.LinkedList"%> 
<%! public int nombre;%> 

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link href="css/styles.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <script  type="text/javascript">
                            function reply(clicked_id){
                                Servlet.start(clicked_id);
                    
                }
                            </script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sessions = request.getSession(false);
            String usuario = (String) sessions.getAttribute("usuario");
        %>
        <h1>Welcome back, <%=usuario%>!</h1>


        <table border="1">
            <tr>
                <td>Marca</td>
                <td>Modelo</td>
                <td>Id</td>
                <td>Solicitar</td>
            </tr>
            <%
                int boton = -1;
                LinkedList<Calculadora> lista = consulta.getCalculadoras();

                consulta.conectar();
                lista = consulta.getCalculadoras();
                consulta.desconectar();
                
                nombre = 0;
                for (int i = 0; i < lista.size(); i++) {
                    nombre = lista.get(i).getIdCalculadora();
                    lista.get(i).getIdCalculadora();
                    out.println("<tr>");
                    out.println("<td>" + lista.get(i).getMarca() + "</td>");
                    out.println("<td>" + lista.get(i).getModelo() + "</td>");
                    out.println("<td>" + lista.get(i).getIdCalculadora() + "</td>");
                    if (lista.get(i).getDisponible()) {
                        out.println("<td>" + "<form action=\"Solicitar.jsp\"  method=\"post\">\n"
                                + "<input type=\"submit\" value=\"Solicitar\"/ id=" + nombre + " onClick = \"reply(this.id)\"> \n"
                                + "</form>"
                                + "</td>");
                        /**
                         out.println("<td><form action=\"SolicitarC\" method=\"post\">\n"
                                + "<input name =\"" + lista.get(i).getIdCalculadora() + "\"type=\"submit\" value=\"Solicitar\"/>\n"
                                + "</form></td>");
                                */

                    nombre = 0;
                    out.println("</tr>");
                }
                //System.out.println("A");
                SolicitarC.start(boton);
                }
            %>
                                
                                
                   
            
            
            
        </table>
    
    <div class = "container">
            <div class="wrapper">
                <form method="post" action="CrearObjeto">
                    <h1 class="form-signin-heading">Crear Objeto</h1>
                    Marca: <input type="text" name="marca"/><br/>
                    Modelo: <input type="text" name="modelo"/><br/>
                    <input type="submit" value="Crear"/>
                </form>
            </div>
        </div>
    </body>
</html>
