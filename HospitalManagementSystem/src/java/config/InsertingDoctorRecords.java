/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author admin
 */
@WebServlet(name = "InsertingDoctorRecords", urlPatterns = {"/InsertingDoctorRecords"})
public class InsertingDoctorRecords extends HttpServlet {
String doc_name,dob,doc_address,doc_mobileno,doc_bloodgrp,doc_speciality,doc_achievements,doc_email,doc_yoe;
int doc_age,doc_weight;
Date doc_dob;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertingDoctorRecords</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertingDoctorRecords at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        doc_name=request.getParameter("doct_name");
        doc_address=request.getParameter("doct_address");
        dob=(request.getParameter("doct_dob"));
        doc_mobileno=request.getParameter("doct_mobileno");
        doc_bloodgrp=request.getParameter("doct_bloodgrp");
        doc_speciality=request.getParameter("doct_speciality");
        doc_achievements=request.getParameter("doct_achievements");
        doc_email=request.getParameter("doct_email");
        doc_yoe=request.getParameter("doct_yoe");
        doc_age=Integer.parseInt(request.getParameter("doct_age"));
        doc_weight=Integer.parseInt(request.getParameter("doct_weight"));
        doc_dob=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        HttpSession session=request.getSession(true);
        try
        {
            InsertRecord ir=new InsertRecord();
            ir.insertRecords(doc_name,doc_address,doc_dob,doc_age,doc_mobileno,doc_weight,doc_bloodgrp,doc_yoe,doc_speciality,doc_achievements,doc_email);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       // insertRecord(new Doctor(doc_name,doc_address,doc_dob,doc_age,doc_mobileno,doc_weight,doc_bloodgrp,doc_yoe,doc_speciality,doc_achievements,doc_email));
        
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
    try {
        processRequest(request, response);
    } catch (ParseException ex) {
        Logger.getLogger(InsertingDoctorRecords.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (ParseException ex) {
        Logger.getLogger(InsertingDoctorRecords.class.getName()).log(Level.SEVERE, null, ex);
    }
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
