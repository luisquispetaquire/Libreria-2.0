/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author David
 */
public class Conexion {
    private Connection conn = null;
    public Connection CrearBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB;create=true");
         if (conn!=null){
            JOptionPane.showMessageDialog(null,"OK base de datos listo");
            
            String crearTablaTipoGasto = "CREATE TABLE Tipo_gasto(id INT,PRIMARY KEY (id), nombre VARCHAR(100))";
            String crearTablaComprobante = "CREATE TABLE Comprobante(id INT , PRIMARY KEY(id) , nombre VARCHAR(100)";
            String crearTablaRegistros="CREATE TABLE Registros(id INT ,PRIMARY KEY(id), venta_total DOUBLE, compra_total DOUBLE, gasto_total DOUBLE ,fecha DATE)";
            String crearTablaGastos="CREATE TABLE Gastos(id INT ,PRIMARY KEY(id),nombre VARCHAR(100), monto DOUBLE, descripcion VARCHAR(1000) ,id_registro INT ,FOREIGN KEY (id_registro) REFERENCES Registros (id), id_tipo INT , FOREIGN KEY(id_tipo) REFERENCES Tipo_gasto(id)";
            String crearTablaCompras="CREATE TABLE Compras(id INT ,PRIMARY KEY(id),nombre VARCHAR(100),nombre_proeveedor VARCHAR(100), monto DOUBLE, descripcion VARCHAR(1000) ,id_registro INT ,FOREIGN KEY (id_registro) REFERENCES Registros (id), id_comprobante INT , FOREIGN KEY(id_comprobante) REFERENCES Comprobante (id)";
            String crearTablaRecordatorios="CREATE TABLE Recordatorios(id INT ,PRIMARY KEY(id) , nombre VARCHAR(100),descripcion VARCHAR(1000), id_registro INT ,FOREIGN KEY (id_registro) REFERENCES Registros (id))";
            //String crearTablaConfiguraciones="CREATE TABLE Configuraciones(id INT ,PRIMARY KEY(id), pago_empleado DOUBLE, dinero_inicial DOUBLE)";
            
            
            try {
            PreparedStatement pstm = conn.prepareStatement(crearTablaTipoGasto);
            pstm.execute();
            pstm.close();
            
            PreparedStatement pstm2 = conn.prepareStatement(crearTablaComprobante);
            pstm2.execute();
            pstm2.close();
            
            PreparedStatement pstm3 = conn.prepareStatement(crearTablaRegistros);
            pstm3.execute();
            pstm3.close();
            
            PreparedStatement pstm4 = conn.prepareStatement(crearTablaGastos);
            pstm4.execute();
            pstm4.close();
            
            PreparedStatement pstm5 = conn.prepareStatement(crearTablaCompras);
            pstm5.execute();
            pstm5.close();
            
            PreparedStatement pstm6 = conn.prepareStatement(crearTablaRecordatorios);
            pstm6.execute();
            pstm6.close();
            
            
           JOptionPane.showMessageDialog(null,"BD Creada correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }
         }
      }catch(SQLException e){
       JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
  }
    
     public Connection AccederBD(){
       try{
         //obtenemos el driver de para mysql
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         //obtenemos la conexión
         conn = DriverManager.getConnection("jdbc:derby:.\\DB\\Derby.DB");
         if (conn!=null){
            JOptionPane.showMessageDialog(null,"OK base de datos listo");
         }
      }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
        int res;
        res = JOptionPane.showConfirmDialog(null,"Desea crear una base datos ?");
        if(res==0){
            Connection CrearBD = CrearBD();
        }
      }catch(ClassNotFoundException e){
         JOptionPane.showMessageDialog(null,e.getMessage(),"Error" ,  JOptionPane.ERROR_MESSAGE);
      }
       return conn;
  }
     
      public void cerracon (){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     
}