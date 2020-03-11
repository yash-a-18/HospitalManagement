/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
public class Details extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String redirect;
            String doctor_id="dc_1";
            String doctor_ps="dc_1";
            String patient_id="pt_1";
            String patient_ps="pt_1";
            String get_id_dc=request.getParameter("usrnm");
            String get_ps_dc=request.getParameter("pswd");
            String get_id_pt=request.getParameter("usrnm");
            String get_ps_pt=request.getParameter("pswd");
            RequestDispatcher rd;
            //redirect="/Web Pages/Doc_signedin.html";
              //      rd=request.getRequestDispatcher(redirect);
            //if((request.getParameter("usrnm")) & (request.getParameter("pswd")))
            //{    
                if(get_id_dc.equals(doctor_id) && get_ps_dc.equals(doctor_ps))
                {
                    redirect="Doc_signedin.html";
                    rd=request.getRequestDispatcher(redirect);
                } 
                else if(strcmp(get_id_pt,patient_id) && strcmp(get_ps_pt,patient_ps))
                {
                    redirect="Pat_signedin.html";
                    rd=request.getRequestDispatcher(redirect);
                }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private boolean strcmp(String parameter, String doctor_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
