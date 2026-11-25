 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;
import modelo.Usuario;
import modelo.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author LAUGU
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("LOGIN SERVLET EJECUTANDO");
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
        UsuarioDao dao = new UsuarioDao();
        Usuario usuarioValidado = dao.validar(usuario, clave);
        
        if (usuarioValidado != null) {
            //Si el usuario es valido, creamos la sesion
            HttpSession session = request.getSession();
            session.setAttribute("usuario",usuarioValidado);
            
            //Redirige segùn el rol
            String destino = "";
            switch (usuarioValidado.getRol()) {
                case 1: //Acceso a la interfaz de administrador
                    destino = "/WEB-INF/vistas/administrador/administrador.jsp";
                    break; 
                    
                case 2: // Acceso de la interfaz del empleado
                    destino = "/WEB-INF/vistas/empleado/empleado.jsp";
                    break;
                    
                case 3: // Acceso de la interfaz del clientes
                    destino = "/WEB-INF/vistas/cliente/cliente.jsp";
                    break;
                default: session.invalidate();
                response.sendRedirect(request.getContextPath() + "/index.jsp?error=rol");
                     return;
            }
            request.getRequestDispatcher(destino).forward(request, response);
            
        } else {
            //si el usuario no es valido, redirigir al login con un error
            response.sendRedirect(request.getContextPath() + "/index.jsp?error=1");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
