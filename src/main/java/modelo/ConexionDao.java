/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAUGU
 */

public class ConexionDao {
    private static final String url="jdbc:mysql://gateway01.ap-northeast-1.prod.aws.tidbcloud.com:4000/spa?sslMode=VERIFY_IDENTITY";
    public static final String username ="2vtSChyy858G76R.root";
    public static final String pass="ScbcJthiJ7bp9Pr6";
    // creamos una función para conectarnos a la base de datos
    public static Connection obtenerConexion() throws SQLException {
       try {
            // Cargar el driver de SQL Server
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Intentar la conexión
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Conexión exitosa a TIDB  cloud");
            return conn;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el controlador JDBC de MySQL", e);
        } catch (SQLException e) {
            System.err.println(" Error al conectar a la base de datos: ");
            e.printStackTrace();
            throw e;
        }
       
    }
    public static void main(String[] args){
        try {
           Connection test = ConexionDao.obtenerConexion();
            if(test!= null){
               System.out.println("Conexión probada correctamente desde main.");
               test.close();
               UsuarioDao dao = new UsuarioDao();
               dao.consultarUsuarios();
            }else{
               System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException ex) {
           System.err.println("Error al probar la conexion:");
           ex.printStackTrace();
        }
        UsuarioDao dao = new UsuarioDao();
        dao.consultarUsuarios();
    }
}
 

