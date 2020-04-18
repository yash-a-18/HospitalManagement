/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DC
 */
public class LoginVerifierServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("Inside");
        String unm=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        out.println("<html><body>");
        try
        {
            out.println("Inside");
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Inside");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system?zeroDateTimeBehavior=convertToNull&useSSL=false","root","");
            out.println("Inside");
            PreparedStatement pst = connection.prepareStatement("select doc_dob from data where doc_email=?");
            out.println("Inside");
            pst.setString(1,unm);
            ResultSet rs=pst.executeQuery();
            int flag=0;
            
            while(rs.next())
            {
                String tmp=rs.getString("doc_dob");
                if(tmp.equals(pwd))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                RequestDispatcher rd=request.getRequestDispatcher("Doc_signedin.jsp");
                rd.forward(request, response);
            }
            else
            {
                out.println("Invalid Username or Password!!! Try again.");
                RequestDispatcher rd=request.getRequestDispatcher("sign_in.html");
                rd.include(request, response);
            }
            pst.close();
            connection.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(LoginVerifierServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            out.close();
        }
        out.println("</body></html>");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerifierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginVerifierServlet.class.getName()).log(Level.SEVERE, null, ex);
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
