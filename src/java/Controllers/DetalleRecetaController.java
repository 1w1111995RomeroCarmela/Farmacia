package Controllers;

import Models.DetalleReceta;

import DTO.DTODetalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleRecetaController {

    public DetalleRecetaController() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetalleRecetaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    //INSERTAR     
    public void insertarDetalleReceta(DetalleReceta nuevo) {
        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("insert into Detalle_receta values (?,?,?,?)")) {
            ps.setInt(1, nuevo.getReceta().getIdReceta());
            ps.setInt(2, nuevo.getCantidad());
            ps.setInt(3, nuevo.getCobertura().getIdCobertura());
            ps.setFloat(4, nuevo.getPrecioFinal());

            int filasAfectadas = ps.executeUpdate();
            System.out.println(String.valueOf(filasAfectadas) + " Detalle de Receta Insertado");
        } catch (SQLException | NumberFormatException e) {
            Logger.getLogger(RecetaController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //OBTENER TODOS
    public ArrayList<DTODetalle> obtenerDetalle(int idDetalle) {
        ArrayList<DTODetalle> listDetalle = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement st = cnn.prepareStatement(" select id_detalle_receta idDetalle, id_receta idReceta, "
                        + " cantidad cant, s.nombre nomSuministro, "
                        + " s.es_venta_libre esVentLibre, s.precio precOriginal, os.nombre obraSoc, "
                        + " c.descuento descCobertura, dr.precio_final precFinal "
                        + " from Detalle_receta dr "
                        + " join Coberturas c on dr.id_cobertura = c.id_cobertura "
                        + " join Suministros s on c.id_suministro = s.id_suministro "
                        + " join Obras_sociales os on os.id_obra_social = c.id_obra_social "
                        + "where id_receta = ? ")) {

            st.setInt(1, idDetalle);
            rs = st.executeQuery();
            
            
            while (rs.next()) {
                DTODetalle dto = new DTODetalle();
                dto.setIdDetalleReceta(rs.getInt("idDetalle"));
                dto.setIdReceta(rs.getInt("idReceta"));
                dto.setCantidad(rs.getInt("cant"));
                dto.setNombSuministro(rs.getString("nomSuministro"));
                dto.setEsVentaLibre(rs.getBoolean("esVentLibre"));
                dto.setPrecOriginal(rs.getFloat("precOriginal"));
                dto.setObraSocial(rs.getString("obraSoc"));
                dto.setDescCobertura(rs.getFloat("descCobertura"));
                dto.setPrecFinal(rs.getFloat("precFinal"));

                listDetalle.add(dto);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return listDetalle;
    }

}
