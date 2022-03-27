/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.CoberturaController;
import Controllers.SuministroController;
import Controllers.getController;

import Models.Cobertura;
import Models.ObraSocial;
import Models.Sucursal;
import Models.Suministro;
import Models.TipoSuministro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carme
 */
@WebServlet(name = "AltaSuministros", urlPatterns = {"/AltaSuministros"})
public class AltaSuministros extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        getController controller = new getController();
        ArrayList<TipoSuministro> listTipoSuministro = controller.obtenerTipoSuministro();
        request.setAttribute("lstTipoSuministro", listTipoSuministro);

        getController controller2 = new getController();
        ArrayList<Sucursal> listSucursal = controller2.obtenerSucursal();
        request.setAttribute("lstSucursal", listSucursal);

        getController controller3 = new getController();
        ArrayList<ObraSocial> listObraSocial = controller3.obtenerObraSocial();
        request.setAttribute("lstObraSocial", listObraSocial);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AltaSuministro.jsp");
        dispatcher.forward(request, response);
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
        
        
        // Suministro
        String nombre =request.getParameter("txtNombre");
        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
        int stock = Integer.parseInt(request.getParameter("txtStock"));
        boolean esVentaLibre = Boolean.parseBoolean(request.getParameter("chkVentaLibre"));  
        
        int idTipo =Integer.parseInt( request.getParameter("cboTipoSuministro"));
        TipoSuministro nuevoTipoSuministro = new TipoSuministro();
        nuevoTipoSuministro.setIdTipoSuministro(idTipo);
        
        int idSuc =Integer.parseInt( request.getParameter("cboSucursal"));
        Sucursal nuevaSucursal = new Sucursal();
        nuevaSucursal.setIdSucursal(idSuc);
        
        Suministro nuevoSuministro = new Suministro(nombre,precio,stock,esVentaLibre, nuevoTipoSuministro, nuevaSucursal);
        
        SuministroController sC = new SuministroController();
        int idSuministro = sC.insertarSuministro(nuevoSuministro);
        
        //Cobertura
        ObraSocial oS = new ObraSocial();
        int idObraSocial = Integer.parseInt( request.getParameter("cboObraSocial"));
        oS.setIdObraSocial(idObraSocial);
        
        float descuento =  Float.parseFloat(request.getParameter("txtDescuento"));
        
        nuevoSuministro.setIdSuministro(idSuministro);
        
        Cobertura c = new Cobertura(oS, nuevoSuministro, descuento);
        CoberturaController controller = new CoberturaController();
        controller.insertarCobertura(c);
        
        response.sendRedirect("/LC4Parcial/ListadoSuministros");
        
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
