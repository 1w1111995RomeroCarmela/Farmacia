package Controllers;

import Models.Suministro;

import DTO.DTOSuministro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SuministroController {

    public SuministroController() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    //INSERTAR     
    public int insertarSuministro(Suministro s) {
        int idSuministro = 0;
        Statement st = null;
        ResultSet rs = null;
        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement("INSERT into Suministros values (?,?,?,?,?,?)")) {

            ps.setString(1, s.getNombre());
            ps.setFloat(2, s.getPrecio());
            ps.setInt(3, s.getStock());
            ps.setBoolean(4, s.isEsVentaLibre());
            ps.setInt(5, s.getTipoSuministro().getIdTipoSuministro());
            ps.setInt(6, s.getSucursal().getIdSucursal());

            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas != 0) {
                st = cnn.createStatement();
                rs = st.executeQuery("SELECT @@identity id_sumin");

                if (rs.next()) {
                    idSuministro = rs.getInt("id_sumin");
                    rs.close();
                }
                st.close();
            }

            System.out.println(String.valueOf(filasAfectadas) + " Suministro Insertado");
        } catch (SQLException | NumberFormatException e) {
            Logger.getLogger(SuministroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return idSuministro;
    }

    //OBTENER TODOS
    public ArrayList<DTOSuministro> obtenerSuministros() {
        ArrayList<DTOSuministro> listSuministro = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = cnn.prepareStatement(" select id_suministro idSum, s.nombre nomSuministro, s.precio precio, "
                        + " s.stock stock, s.es_venta_libre esVentLibre, ts.descripcion tipSum, "
                        + " su.sucursal sucursal "
                        + " from Suministros s "
                        + " join Tipos_suministros ts on s.id_tipo_suministro = ts.id_tipo_suministro "
                        + " join Sucursales su on s.id_sucursal = su.id_sucursal ")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                DTOSuministro dto = new DTOSuministro();
                dto.setIdSuministro(rs.getInt("idSum"));
                dto.setNombre(rs.getString("nomSuministro"));
                dto.setPrecio(rs.getInt("precio"));
                dto.setStock(rs.getInt("stock"));
                dto.setEsVentaLibre(rs.getBoolean("esVentLibre"));
                dto.setTipoSuministro(rs.getString("tipSum"));
                dto.setSucursal(rs.getString("sucursal"));

                listSuministro.add(dto);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return listSuministro;
    }

}
