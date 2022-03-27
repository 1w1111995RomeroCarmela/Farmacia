package Controllers;

import DTO.DTOClientesImporteTotal;
import DTO.DTOFaltanteStock;
import DTO.DTOReceta;
import DTO.DTOProfesionalesRecetas;
import DTO.DTOTotalRecetasSucursal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListadoController {

    public ListadoController() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controllers.DetalleRecetaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    // REPORTE 1
    public ArrayList<DTOReceta> recetasPorProfesional(int idProfesional) {

        ArrayList<DTOReceta> lista = new ArrayList<>();
        try {
            Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement("select id_recetas idReceta, CONCAT_WS(', ',c.apellido,c.nombre) cliente, os.nombre obraSoc, "
                    + "                    CONCAT_WS(', ',p.apellido,p.nombre) profesional, s.sucursal sucursal "
                    + "                     from Recetas r "
                    + "                     join Clientes c on r.id_cliente = c.id_cliente "
                    + "                     join Obras_sociales os on  r.id_obra_social = os.id_obra_social "
                    + "                     join Profesionales p on r.id_profesional = p.id_profesional "
                    + "                     join Sucursales s on r.id_sucursal = s.id_sucursal "
                    + "	    where p.id_profesional = ?"
            );

            ps.setInt(1, idProfesional);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DTOReceta dto = new DTOReceta();
                dto.setIdReceta(rs.getInt("idReceta"));
                dto.setNomApeCliente(rs.getString("cliente"));
                dto.setObraSocial(rs.getString("obraSoc"));
                dto.setNomApeProfesional(rs.getString("profesional"));
                dto.setSucursal(rs.getString("sucursal"));

                lista.add(dto);
//                i
            }

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de acceso a datos!");
        }
        return lista;
    }

//REPORTE 2
    public ArrayList<DTOProfesionalesRecetas> cantidadRecetasPorProfesional() {

        ArrayList<DTOProfesionalesRecetas> listaProfesionales = new ArrayList<>();
        try {
            Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement("select count(r.id_recetas) as 'Cantidad de recetas', p.nombre+' '+p.apellido as 'Profesional'\n"
                    + "from Profesionales p join Recetas r on p.id_profesional = r.id_profesional\n"
                    + "group by p.nombre+' '+p.apellido\n"
                    + "order by 1 desc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int cantRecetas = rs.getInt(1);
                String profesional = rs.getString(2);

                DTOProfesionalesRecetas pl = new DTOProfesionalesRecetas();
                pl.setCantidadRecetas(cantRecetas);
                pl.setProfesional(profesional);

                listaProfesionales.add(pl);
            }

            rs.close();
            cnn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al hacer al traer los profesionales.");
        }
        return listaProfesionales;
    }

    //REPORTE 3
    public ArrayList<DTOClientesImporteTotal> ClientesPorImporteTotal() {

        ArrayList<DTOClientesImporteTotal> lista = new ArrayList<>();
        try {
            Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement("select c.nombre+' '+c.apellido as 'Cliente', p.monto_total\n"
                    + "from Clientes c join  Recetas r on r.id_cliente = c.id_cliente join Presupuestos p on p.id_recetas = r.id_recetas\n"
                    + "order by 2 desc");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString(1);
                double montoTotal = rs.getDouble(2);

                DTOClientesImporteTotal c = new DTOClientesImporteTotal();
                c.setNombreCliente(nombre);
                c.setMontoTotal(montoTotal);

                lista.add(c);
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al hacer al traer a los clientes con su monto total.");
        }
        return lista;
    }
    //Reporte 4
    public ArrayList<DTOFaltanteStock> faltanteStock() {
        
        ArrayList<DTOFaltanteStock> lista = new ArrayList<>();
        try {
            Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement("select su.sucursal, s.nombre, s.stock, (s.stock-dr.cantidad) as 'Stock Faltante'\n"
                    + "from Detalle_receta dr\n"
                    + "join Coberturas c on dr.id_cobertura = c.id_cobertura\n"
                    + "join Recetas r on r.id_recetas=dr.id_receta\n"
                    + "join Suministros s on s.id_suministro = c.id_suministro\n"
                    + "join Sucursales su on su.id_sucursal = s.id_sucursal\n"
                    + "where s.stock-dr.cantidad <= 0\n"
                    + "group by su.sucursal, s.nombre, s.stock, dr.cantidad");
           
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()) {
                
                String sucursal = rs.getString(1);
                String nombre = rs.getString(2);
                int stock = rs.getInt(3);
                int stockFaltante = rs.getInt(4);
                
                DTOFaltanteStock fs = new DTOFaltanteStock();
                fs.setNombreSuministro(nombre);
                fs.setStock(stock);
                fs.setStockFaltante(stockFaltante);
                fs.setSucursal(sucursal);
                
                lista.add(fs);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ListadoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de acceso a datos!");
        }
        return lista;
    }
    //Reporte 5
    public ArrayList<DTOTotalRecetasSucursal> totalRecetasPorSucursal() {
        
        ArrayList<DTOTotalRecetasSucursal> lista = new ArrayList<>();
        try {
             Connection cnn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = cnn.prepareStatement("select COUNT(r.id_recetas) as 'Cantidad de Recetas', SUM(p.monto_total) as 'Monto por cliente',\n"
                    + "SUM(p.monto_a_facturar) as 'Monto a facturar a Obras Sociales', su.sucursal, c.nombre\n"
                    + "from Recetas r join Clientes c on  c.id_cliente = r.id_cliente join Presupuestos p on p.id_recetas = r.id_recetas \n"
                    + "join Sucursales su on su.id_sucursal = r.id_sucursal\n"
                    + "group by su.sucursal, c.nombre");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                int cantidadRecetas = rs.getInt(1);
                float montoCliente = rs.getInt(2);
                float montoObrasSociales = rs.getFloat(3);
                String sucursal = rs.getString(4);
                String nombre = rs.getString(5);
                               
                DTOTotalRecetasSucursal t = new DTOTotalRecetasSucursal();
                
                t.setCantidadRecetas(cantidadRecetas);
                t.setMontoCliente(montoCliente);
                t.setMontoObrasSociales(montoObrasSociales);
                t.setNombre(nombre);
                t.setSucursal(sucursal);
                
                lista.add(t);
            }
            
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ListadoController.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al hacer al traer el total de recetas por sucursal.");
        }
        return lista;
    }
}
