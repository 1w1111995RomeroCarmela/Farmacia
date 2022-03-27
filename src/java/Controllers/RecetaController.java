package Controllers;

import Models.Receta;
import DTO.DTOReceta;
import Models.DetalleReceta;
import com.sun.org.glassfish.gmbal.ManagedObjectManagerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecetaController {

    public RecetaController() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecetaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    //INSERTAR     
    public int insertarReceta(Receta nueva, ArrayList<DetalleReceta> lst) {
        int idReceta = 0;
        Connection cnn = null;
        PreparedStatement ps = null;
        PreparedStatement psDetalle = null;
        PreparedStatement psPresu = null;
        PreparedStatement psMonto = null;
        Statement st = null;
        ResultSet rs = null;

        float montoTotal = 0;
        float montoFacturar = 0;
        int idCober = 0;

        try {
            cnn = DriverManager.getConnection(url, user, pass);
            cnn.setAutoCommit(false);

            ps = cnn.prepareStatement("INSERT into recetas VALUES (?,?,?,?)");

            ps.setInt(1, nueva.getCliente().getIdCliente());
            ps.setInt(2, nueva.getObraSocial().getIdObraSocial());
            ps.setInt(3, nueva.getProfesional().getIdProfesional());
            ps.setInt(4, nueva.getSucursal().getIdSucursal());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas != 0) {
                st = cnn.createStatement();
                rs = st.executeQuery("select @@identity id_receta");
                if (rs.next()) {
                    idReceta = rs.getInt("id_receta");
                    rs.close();
                }
                for (DetalleReceta detRec : lst) {
                    psDetalle = cnn.prepareStatement("insert into Detalle_receta values (?,?,?,?)");
                    nueva.setIdReceta(idReceta);
                    detRec.setReceta(nueva);
                    psDetalle.setInt(1, detRec.getReceta().getIdReceta());
                    psDetalle.setInt(2, detRec.getCantidad());
                    psDetalle.setInt(3, detRec.getCobertura().getIdCobertura());
                    psDetalle.setFloat(4, detRec.getPrecioFinal());
                    psDetalle.executeUpdate();

                    idCober = detRec.getCobertura().getIdCobertura();
                    montoTotal += detRec.getPrecioFinal();

                    psMonto = cnn.prepareStatement("select (su.precio*cob.descuento)/100 montoDescuento from "
                            + "Coberturas cob join Suministros su on cob.id_suministro=su.id_suministro "
                            + "where cob.id_cobertura = ?");
                    psMonto.setInt(1, idCober);
                    
                    rs = psMonto.executeQuery();

                    
                    if (rs.next()) {
                        montoFacturar = montoFacturar + rs.getFloat("montoDescuento");
                        
                        
                    }
                }
                rs.close();
                
                psPresu = cnn.prepareStatement("insert into Presupuestos (id_recetas,fecha,monto_total,monto_a_facturar) values (?,GETDATE(),?,?)");
                psPresu.setInt(1, idReceta);
                psPresu.setFloat(2, montoTotal);
                psPresu.setFloat(3, montoFacturar);
                
                psPresu.executeUpdate();

                cnn.commit();
                psDetalle.close();
                psMonto.close();
                psPresu.close();
                st.close();
            }
            ps.close();
            System.out.println(String.valueOf(filasAfectadas) + " Receta Insertada");

        } catch (SQLException | NumberFormatException e) {
            try {
               
                cnn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(RecetaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(RecetaController.class.getName()).log(Level.SEVERE, null, e);
        }
        return idReceta;
    }

    public ArrayList<DTOReceta> obtenerRecetas() {
        ArrayList<DTOReceta> lstRecetasMostrar = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery("select id_recetas idReceta, CONCAT_WS(', ',c.apellido,c.nombre) cliente, os.nombre obraSoc, "
                    + " CONCAT_WS(', ',p.apellido,p.nombre) profesional, s.sucursal sucursal "
                    + " from Recetas r "
                    + " join Clientes c on r.id_cliente = c.id_cliente "
                    + " join Obras_sociales os on  r.id_obra_social = os.id_obra_social "
                    + " join Profesionales p on r.id_profesional = p.id_profesional "
                    + " join Sucursales s on r.id_sucursal = s.id_sucursal ");
            while (rs.next()) {
                DTOReceta dto = new DTOReceta();
                dto.setIdReceta(rs.getInt("idReceta"));
                dto.setNomApeCliente(rs.getString("cliente"));
                dto.setObraSocial(rs.getString("obraSoc"));
                dto.setNomApeProfesional(rs.getString("profesional"));
                dto.setSucursal(rs.getString("sucursal"));

                lstRecetasMostrar.add(dto);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lstRecetasMostrar;
    }

}
