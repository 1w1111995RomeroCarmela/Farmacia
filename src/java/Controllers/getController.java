
package Controllers;

import Models.Cliente;
import Models.ObraSocial;
import Models.Presupuesto;
import Models.Profesional;

import Models.Sucursal;
import Models.TipoSuministro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class getController {
    
     
    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    public getController() {
        
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // GET CLIENTES
    public ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Clientes ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                 
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                int telefono = rs.getInt("telefono");
                
                Cliente c = new Cliente();
                c.setIdCliente(idCliente);
                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setDocumento(dni);
                c.setTelefono(telefono);
                

                lst.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
    //OBTENER CLIENTE POR DNI
    public Cliente obtenerClientePorDNI(int dni) {
        ResultSet rs = null;
        Cliente c = new Cliente();
        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Clientes where dni = ?")) {
            ps.setInt(1, dni);

            rs = ps.executeQuery();
            if (rs.next()) {
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDocumento(rs.getInt("dni"));
                c.setTelefono(rs.getInt("telefono"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return c;
    }
    
    //GET SUCURSAL
      public ArrayList<Sucursal> obtenerSucursal() {
        ArrayList<Sucursal> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Sucursales ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                 
                int idSucursal = rs.getInt("id_sucursal");
                String nombre = rs.getString("sucursal");
                
                
                Sucursal suc = new Sucursal();
                suc.setIdSucursal(idSucursal);
                suc.setNombre(nombre);
                
                lst.add(suc);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
      // GET PROFESIONALES
    public ArrayList<Profesional> obtenerProfesionales() {
        ArrayList<Profesional> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Profesionales ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                 
                int idProfesional = rs.getInt("id_profesional");
                int matricula = rs.getInt("matricula");                
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                
                
                Profesional p = new Profesional();
                p.setIdProfesional(idProfesional);
                p.setMatricula(matricula);
                p.setNombre(nombre);
                p.setApellido(apellido);
                
                lst.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
     
    //GET OBRAS SOCIALES
    public ArrayList<ObraSocial> obtenerObraSocial() {
        ArrayList<ObraSocial> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Obras_sociales ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                 
                int idObraSocial = rs.getInt("id_obra_social");                              
                String nombre = rs.getString("nombre");
                
                ObraSocial  o = new ObraSocial();
                o.setIdObraSocial(idObraSocial);                
                o.setNombre(nombre);
                             

                lst.add(o);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
    
    // GET TIPO SUMINISTROS
     public ArrayList<TipoSuministro> obtenerTipoSuministro() {
        ArrayList<TipoSuministro> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Tipos_suministros ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                 
                int idTipoSuministro = rs.getInt("id_tipo_suministro");
                String descripcion = rs.getString("descripcion");
                
                
                TipoSuministro tipoS = new TipoSuministro();
                tipoS.setIdTipoSuministro(idTipoSuministro);
                tipoS.setDescripcion(descripcion);                

                lst.add(tipoS);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
     
     
     //PRESUPUESTO
     
      public ArrayList<Presupuesto> getAll () {
          ArrayList<Presupuesto> lst = new ArrayList<>();
        ResultSet rs = null;
       
        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Presupuestos")) {
            
           

            rs = ps.executeQuery();
            while(rs.next()) {
                    Presupuesto p = new Presupuesto();
                    p.setIdPresupuesto(rs.getInt("id_presupuesto"));                
                    p.setIdReceta(rs.getInt("id_recetas"));
                    p.setFecha(rs.getDate("fecha"));
                    p.setMontoTotal(rs.getFloat("monto_total"));
                    p.setMontoFacturar(rs.getFloat("monto_a_facturar"));
                    
                    lst.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;
    }
      
       public ArrayList<Presupuesto> obtenerPresupuesto(int idPresupuesto) {
        ArrayList<Presupuesto> listPresupuesto = new ArrayList<>();
        ResultSet rs = null;
        Presupuesto p = new Presupuesto();
        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT * FROM Presupuestos where id_recetas = ?")) {
            
            ps.setInt(1, idPresupuesto);

            rs = ps.executeQuery();
            
            
            while (rs.next()) {
                
               p.setIdPresupuesto(rs.getInt("id_presupuesto"));                
                p.setIdReceta(rs.getInt("id_recetas"));
                p.setFecha(rs.getDate("fecha"));
                p.setMontoTotal(rs.getFloat("monto_total"));
               p.setMontoFacturar(rs.getFloat("monto_a_facturar"));

                listPresupuesto.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return listPresupuesto;
    }
    
}
