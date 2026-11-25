 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author laugus
 */
public class UsuarioDao {
    //  Metodo para validar el inicio de sesion
    public Usuario validar(String usuario, String clave) {
        String sql = "SELECT * from usuarios WHERE (correo = ? OR usuario = ?) AND estado = 1";
        System.out.println("CONSULTA SQL COMPLETA: [" + sql +"]");
        System.out.println("PARAMETRO USUARIO: [" + usuario + "]");
        Usuario usuarioEncontrado = null;
        try (
            Connection conn = ConexionDao.obtenerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, usuario);
            System.out.println("Usuario recibido: " + usuario);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) { 
                    String claveBD = rs.getString("clave");
                    //temporal
                    System.out.println("Usuario encontrado"+ rs.getString("usuario"));
                    System.out.println("Estado:" + rs.getInt("estado"));
                    System.out.println(" ¡contraseña coincide?:" + (claveBD != null && claveBD.equals(clave)));
                    if (claveBD != null && claveBD.equals(clave)) {
                        usuarioEncontrado = new Usuario();
                        usuarioEncontrado.setId(rs.getInt("id"));
                        usuarioEncontrado.setNombre(rs.getString("nombre"));
                        usuarioEncontrado.setUsuario(rs.getString("usuario"));
                        usuarioEncontrado.setCorreo(rs.getString("correo"));
                        usuarioEncontrado.setRol(rs.getInt("rol"));
                    }       
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar usuario: ");
            e.printStackTrace();
        }    
        
        return usuarioEncontrado;
    }   
   
    // creamos el metodo para registrar nueva cuenta en este caso por defecto la cuenta que va a crear es para 2: estudiante
   
     public int NuevaCuenta(Usuario user) {
        int result = 0;
        
        String sql = "insert into usuarios " + "(nombre, usuario, correo, clave, rol)" + "VALUES(?, ?, ?, ?, ?)";
        

        try {
            Connection conn = ConexionDao.obtenerConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getNombre());
            pstmt.setString(2, user.getUsuario());
            pstmt.setString(3,user.getCorreo());
            pstmt.setString(4,user.getClave());
            pstmt.setInt(5, user.getRol());
                        
            result = pstmt.executeUpdate(); 
            System.out.println("Resultado del registro: " + result);
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: ");
                    e.printStackTrace();
        }
        return result;
        
    }
    public void consultarUsuarios() {
    
    try (Connection conn = ConexionDao.obtenerConexion()){
        System.out.println("BASE DE DATOS"+ conn.getCatalog());  System.out.println("SERVIDOR:" + conn.getMetaData().getURL());
        String sql = "SELECT * FROM usuarios LIMIT 5";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()){
            while (rs.next()) {
                System.out.println("Usuario:" + rs.getString("usuario"));
            }
        }
            
        
    } catch (SQLException e) {
            System.err.println("Error al consultar usuarios:");
            e.printStackTrace();
    }
    
    }
}
     
     


   
   
    

