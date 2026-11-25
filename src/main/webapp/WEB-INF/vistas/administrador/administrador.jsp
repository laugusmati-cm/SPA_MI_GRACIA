<%-- 
    Document   : administrador
    Created on : 18/11/2026, 7:37:07 p. m.
    Author     : LAUGU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario == null || usuario.getRol() != 1) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Administrador - SPA MI GRACIA</title>
</head>
<body>
    <h1>SPA MI GRACIA</h1>
    <h2>¡Bienvenido, <%= usuario.getNombre() %>!</h2>
    <p>Nos alegra tenerte con nosotros.</p>
    <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
    <p><strong>Tipo de usuario:</strong> Administrador</p>    
     <a href="<%= request.getContextPath()%>/SalirServlet"> Cerrar sesiòn </a>
</body>
</html>