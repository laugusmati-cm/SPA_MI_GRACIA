<%-- 
    Document   : nuevacuenta
    Created on : 24/11/2026, 1:40:47 a. m.
    Author     : LAUGU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SPA MI GRACIA | Crear Nueva Cuenta</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/public/css/estilos.css">
</head>
<body>
   <!-- Contenedor de la pagina para iniciar sesión-->
     <div class="login-card">
        <!-- Encabezado informativo-->
         <div class="login-header">
            <h1>Crear Nueva Cuenta</h1>
            <p>Cree su cuenta para obtener los servicios que ofrece el spa</p>
         </div>
         <!-- Formulario de inicio de sesión-->
         <form action="${pageContext.request.contextPath}/UsuarioServlet" method="POST">
             <input type="hidden" name="accion" value="nuevacuenta">
            <!--campo de nombre-->
            <div class="form-group">
                <label for="name">Nombre</label>
                <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Ingrese su nombre completo" required>
            </div>
            <div class="form-group">
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Cree un usuario" required>
            </div>
            
            <!--Campo  Correo electronico-->
            <div class="form-group">
                <label for="correo"> Correo Electrónico</label>
                <input type="email" id="correo" name="correo" class="form-control" placeholder="Ej: 2021001 o usuario@dominio.com" required>
            </div>
            <!--Campo de contraseña-->
            <div class="form-group">
                <label for="clave">Contraseña</label>
                <input type="password" id="clave" name="clave" class="form-control" placeholder="Ingrese su contraseña" required>
            </div>
            
            <!-- Boton de crear cuente-->
             <button type="submit" class="btn-submit">Crear Cuenta</button>
             
             <!-- link regreso al inicio de sesion-->
             <a href="<%= request.getContextPath() %>/index.jsp" class="link-login"> Regresar al inicio de sesiòn </a> 
             
        </form>     
             <!--Pie Pagina-->
             <footer class="login-footer">
                <p> derechos reservados &copy; 2026</p>
             </footer>
          
     </div> 
</body>
</html>
