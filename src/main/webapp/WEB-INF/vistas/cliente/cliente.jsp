<%-- 
    Document   : cliente
    Created on : 18/11/2026, 7:41:58 p. m.
    Author     : LAUGU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario == null || usuario.getRol() != 3) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Cliente - SPA MI GRACIA</title>
</head>
<body>

    <h1>SPA MI GRACIA</h1>
    <h2>¡Bienvenido, <%= usuario.getNombre() %>!</h2>
    <p>Nos alegra tenerte con nosotros.</p>
    <p><strong>Nombre:</strong> <%= usuario.getNombre() %></p>
    <a href="${pageContext.request.contextPath}/SalirServlet"></a>
    <p><strong>Tipo de usuario:</strong> Cliente</p>
    <a href="<%= request.getContextPath()%>/SalirServlet"> Cerrar sesiòn </a>
    
    

</body>
</html>

