/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.CoberturaController;
import Controllers.DetalleRecetaController;
import DTO.DTOCobertura;
import Models.Cobertura;
import Models.DetalleReceta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carme
 */
@WebServlet(name = "AltaDetalles", urlPatterns = {"/AltaDetalles"})
public class AltaDetalles extends HttpServlet {

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
        
         CoberturaController controller = new CoberturaController();
        ArrayList<DTOCobertura> listCobertura = controller.obtenerCobertura();
        request.setAttribute("lstCobertura", listCobertura);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AltaDetalle.jsp");
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
        
         HttpSession s = request.getSession();
        ArrayList<DetalleReceta> lstDetalle = (ArrayList<DetalleReceta>) s.getAttribute("lstDetalle");

        if (lstDetalle == null) {
            lstDetalle = new ArrayList<>();
        }
        
        
         int idCobertura = Integer.parseInt(request.getParameter("cboCoberturaSuministros"));        
        Cobertura co = new Cobertura();
        co.setIdCobertura(idCobertura);
        
        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

        CoberturaController controladorCob = new CoberturaController();
        DTOCobertura cobertura = controladorCob.obtenerCoberturaID(idCobertura);
        float precioLista= cobertura.getPrecioLista();
        float descuento = cobertura.getDescuento();
        float precioFinal = cantidad * (precioLista - (precioLista * (descuento / 100)));

        DetalleReceta nuevoDetalle = new DetalleReceta(); 
        
        nuevoDetalle.setCantidad(cantidad);
        nuevoDetalle.setCobertura(co);
        nuevoDetalle.setPrecioFinal(precioFinal);
        
        lstDetalle.add(nuevoDetalle);
        s.setAttribute("lstDetalle", lstDetalle);
        
           
        ArrayList<DTOCobertura> lstDetalle2 = (ArrayList<DTOCobertura>) s.getAttribute("lstDetalle2");

        if (lstDetalle2 == null) {
            lstDetalle2 = new ArrayList<>();
        }
        lstDetalle2.add(cobertura);
        s.setAttribute("lstDetalle2", lstDetalle2);

        response.sendRedirect("/LC4Parcial/AltaRecetas");

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
