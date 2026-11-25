<%-- 
    Document   : empleado
    Created on : 18/11/2026, 7:42:24 p. m.
    Author     : LAUGU
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario == null || usuario.getRol() != 2) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Empleado - SPA MI GRACIA</title>
</head>
<body>

    <h1>SPA MI GRACIA</h1>
    <h2>¡Bienvenido, <%= usuario.getNombre() %>!</h2>
    <p>Nos alegra tenerte con nosotros.</p>
    <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
    <p><strong>Tipo de usuario:</strong> Empleado</p>    
     <a href="<%= request.getContextPath()%>/SalirServlet"> cerrar sesiòn </a>
</body>
</html>


