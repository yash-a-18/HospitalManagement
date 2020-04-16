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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author admin
 */
public class DoctorRecords extends HttpServlet {
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
        doc_name=request.getParameter("doc_name");
        doc_address=request.getParameter("doc_address");
        dob=(request.getParameter("doc_dob"));
        doc_mobileno=request.getParameter("doc_mobileno");
        doc_bloodgrp=request.getParameter("doc_bloodgrp");
        doc_speciality=request.getParameter("doc_speciality");
        doc_achievements=request.getParameter("doc_achievements");
        doc_email=request.getParameter("doc_email");
        doc_yoe=request.getParameter("doc_yoe");
        doc_age=Integer.parseInt(request.getParameter("doc_age"));
        doc_weight=Integer.parseInt(request.getParameter("doc_weight"));
        doc_dob=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        insertRecord(new Doctor(doc_name,doc_address,doc_dob,doc_age,doc_mobileno,doc_weight,doc_bloodgrp,doc_yoe,doc_speciality,doc_achievements));
    }
    private static void insertRecord(Doctor d) 
    { 
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
        Session session = sessionFactory.openSession(); 
        session.beginTransaction(); session.save(d); 
        session.getTransaction().commit(); 
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
        Logger.getLogger(DoctorRecords.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(DoctorRecords.class.getName()).log(Level.SEVERE, null, ex);
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
    }// 
}
