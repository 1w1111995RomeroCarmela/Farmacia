/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DTO.DTOCobertura;
import Models.Cobertura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoberturaController {

    private String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLC4";
    private String user = "sa";
    private String pass = "asd158456";

    public CoberturaController() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<DTOCobertura> obtenerCobertura() {
        ArrayList<DTOCobertura> lst = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn.prepareStatement("select id_cobertura , os.nombre ObraSocial, s.nombre Suministro, descuento, s.precio precioLista\n"
                        + " from Coberturas\n"
                        + "join Obras_sociales os on Coberturas.id_obra_social = os.id_obra_social \n"
                        + "join Suministros s on Coberturas.id_suministro = s.id_suministro")) {

            rs = ps.executeQuery();
            while (rs.next()) {

                int idCobertura = rs.getInt("id_cobertura");

                String nombreObraSocial = rs.getString("ObraSocial");
                String nombreSuministro = rs.getString("Suministro");
                float descuento = rs.getFloat("descuento");
                float precioLista = rs.getFloat("precioLista");
                

                DTOCobertura c = new DTOCobertura();
                c.setIdCobertura(idCobertura);
                c.setNombreObraSocial(nombreObraSocial);
                c.setNombreSuministro(nombreSuministro);
                c.setDescuento(descuento);
                c.setPrecioLista(precioLista);

                lst.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;

    }
    
    public DTOCobertura obtenerCoberturaID(int idCobertura) {
        ResultSet rs = null;
        DTOCobertura dto = new DTOCobertura();
        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn.prepareStatement("select id_cobertura , os.nombre obraSocial, s.nombre suministro, descuento, s.precio precioLista "
                        + " from Coberturas "
                        + " join Obras_sociales os on Coberturas.id_obra_social = os.id_obra_social  "
                        + " join Suministros s on Coberturas.id_suministro = s.id_suministro "
                        + "where id_cobertura = ?")) {
            ps.setInt(1, idCobertura);

            rs = ps.executeQuery();
            if (rs.next()) {
                dto.setIdCobertura(rs.getInt("id_cobertura"));
                dto.setNombreObraSocial(rs.getString("obraSocial"));
                dto.setNombreSuministro(rs.getString("suministro"));
                dto.setDescuento(rs.getFloat("descuento"));
                dto.setPrecioLista(rs.getFloat("precioLista"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return dto;
    }

    //INSERT 
    public void insertarCobertura(Cobertura c) {
        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn.prepareStatement("insert Into Coberturas values(?,?,?)")) {
            ps.setInt(1, c.getObraSocial().getIdObraSocial());
            ps.setInt(2, c.getSuministro().getIdSuministro());
            ps.setFloat(3, c.getDescuento());

            int filasAfectadas = ps.executeUpdate();
            System.out.println(String.valueOf(filasAfectadas) + " Cobertura Insertada");
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error de acceso a datos en el INSERT de coberturas");
        }
    }

}
