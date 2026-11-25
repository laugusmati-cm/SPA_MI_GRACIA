<%-- 
    Document   : index.jsp
    Created on : 11/11/2026, 9:01:35 p. m.
    Author     : LAUGU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SPA MI GRACIA | Iniciar Sesion</title>
    <link href="public/css/estilos.css" rel="stylesheet">
</head>
<body>
    <!-- Contenedor de la pagina para iniciar sesión-->
     <div class="login-card">
        <!-- Encabezado informativo-->
         <div class="login-header">
            <h1>Iniciar Sesion</h1>
            <p>Ingrese a sus credenciales para acceder al sistema</p>
         </div>
         <!-- Formulario de inicio de sesión-->
          <form action="LoginServlet" method="POST">
            <!--Campo de usuario o Correo electronico-->
            <div class="form-group">
                <label for="username">Usuario o Correo Electrónico</label>
                <input type="text" id="username" name="usuario" class="form-control" placeholder="Ej: 2021001 o usuario@dominio.com" required>
            </div>
            <!--Campo de contraseña-->
            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="clave" class="form-control" placeholder="Ingrese su contraseña" required>
            </div>
         
            <!-- Boton de inicio de sesión-->
             <button type="submit" class="btn-submit">Iniciar Sesion</button>
                    <!-- mostrar mensajes de error -->
                    <% if ("1".equals(request.getParameter("error"))){ %> 
                        <p class="error">Usuario o contraseña incorrectos:</p>
                    <% } else if ("cerrado".equals(request.getParameter("estado"))) { %>
                        <P class ="exito">Has cerrado la sesiòn correctamente.</p> 
                    <% } else if ("exito".equals(request.getParameter("registro"))) { %>
                        <p class="exito">Tu cuenta ha sido creada exitosamente. Ahora inicia sesiòn.</p> 
                    <% } %>
             <!--Pie Pagina-->
             <footer class="login-footer">
                <p> ¿Aun no tienes tu cuenta? <a href="vista/cuentas/cuentas_nuevas/cuentas.jsp">Registrate aquí</a></p>
                
             </footer>
          </form>
     </div>
</body>
</html>