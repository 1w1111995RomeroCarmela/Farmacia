/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.CoberturaController;
import Controllers.DetalleRecetaController;
import Controllers.RecetaController;
import Controllers.getController;
import DTO.DTOCobertura;
import Models.Cliente;
import Models.Cobertura;
import Models.DetalleReceta;
import Models.ObraSocial;
import Models.Profesional;
import Models.Receta;
import Models.Sucursal;
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
@WebServlet(name = "AltaRecetas", urlPatterns = {"/AltaRecetas"})
public class AltaRecetas extends HttpServlet {

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
        ArrayList<Profesional> listProfesionales = controller.obtenerProfesionales();
        request.setAttribute("lstProfesionales", listProfesionales);

        getController controller2 = new getController();
        ArrayList<Sucursal> listSucursal = controller2.obtenerSucursal();
        request.setAttribute("lstSucursal", listSucursal);

        getController controller3 = new getController();
        ArrayList<ObraSocial> listObraSocial = controller3.obtenerObraSocial();
        request.setAttribute("lstObraSocial", listObraSocial);       
        
        getController controller5 = new getController();
        ArrayList<Cliente> listCliente = controller5.obtenerClientes();
        request.setAttribute("lstClientes", listCliente);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AltaReceta.jsp");
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
       
                   
        
        Cliente c = new Cliente();
        int idCli =Integer.parseInt(request.getParameter("cboClientes"));
        c.setIdCliente(idCli);

        ObraSocial osocial = new ObraSocial();
         int idOS =  Integer.parseInt(request.getParameter("cboObraSocial"));
        osocial.setIdObraSocial(idOS);

        Profesional p = new Profesional();
        int idProf = Integer.parseInt(request.getParameter("cboProfesionales"));
        p.setIdProfesional(idProf);

        Sucursal s = new Sucursal();
        int idSuc = Integer.parseInt(request.getParameter("cboSucursal"));
        s.setIdSucursal(idSuc);

        Receta r = new Receta(c,osocial,p,s);
       

        RecetaController controller= new RecetaController();
//        int idReceta = controller.insertarReceta(r);
//        r.setIdReceta(idReceta);

        ArrayList<DetalleReceta> lstDetalle = (ArrayList<DetalleReceta>)request.getSession().getAttribute("lstDetalle");

        if(lstDetalle != null){
            int idReceta = controller.insertarReceta(r, lstDetalle);
            request.getSession().removeAttribute("lstDetalle");
        }
        
       
        response.sendRedirect("/LC4Parcial/ListadoRecetas");
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
