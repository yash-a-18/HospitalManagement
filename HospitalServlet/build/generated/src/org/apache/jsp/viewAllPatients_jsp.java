package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class viewAllPatients_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>Doc_Signed In</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write(" <style>\n");
      out.write("        body{\n");
      out.write("  background-image: url(\"136949.jpg\");\n");
      out.write("  background-repeat:no-repeat;\n");
      out.write("  background-attachment: fixed;\n");
      out.write("  background-position: center; \n");
      out.write("       background-size:cover;\n");
      out.write("       }\n");
      out.write("    </style>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    ");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet resultset=null;
        
    
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\t<div class=\"container-fluid\">\n");
      out.write("  <br>\n");
      out.write("  <h2>Hospital Management System</h2>\n");
      out.write("  <p>Place where all your problems are cured.</p>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-sm bg-dark navbar-white sticky-top justify-content-left\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("    <img src=\"logo.jpg\" alt=\"logo\" style=\"width:70px;\">\n");
      out.write("  </a>\n");
      out.write("    \n");
      out.write("    <a class=\"nav-link\" href=\"Doc_signedin.jsp\">Appointments</a>\n");
      out.write("    \n");
      out.write("    <a class=\"nav-link\" href=\"viewAllPatients.jsp\">Consultations</a>\n");
      out.write("  \n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("    <li class=\"nav-item mr-sm-5\">\n");
      out.write("        <a class=\"nav-brand\" href=\"reg_patient.html\">\n");
      out.write("            <img src=\"patient_admissoon.png\" alt=\"Register Patient\" style=\"width:40px\">\n");
      out.write("        </a>\n");
      out.write("    </li>\n");
      out.write("  </ul>\n");
      out.write("    \n");
      out.write("    <form class=\"form-inline\" action=\"# \">\n");
      out.write("    <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\">\n");
      out.write("    <button class=\"btn btn-success\" type=\"submit\">Search</button>\n");
      out.write("  </form>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("    <div class=\"container table-responsive\">\n");
      out.write("  <h2>Patient List</h2>         \n");
      out.write("  <table class=\"table table-hover table-light\">\n");
      out.write("    <thead>\n");
      out.write("      <tr>\n");
      out.write("          <th>ID</th>\n");
      out.write("        <th>Name</th>\n");
      out.write("        <th>Gender</th>\n");
      out.write("        <th>Age</th>\n");
      out.write("        <th>Date of Admission</th>\n");
      out.write("        <!--<th>Status</th>-->\n");
      out.write("        <th>Bill Amount</th>\n");
      out.write("        <th>Profile</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");
try{
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","");
        pst=connection.prepareStatement("SELECT pat_id,pat_name,pat_gender,pat_age,pat_doa FROM patient");
        resultset=pst.executeQuery();
        while(resultset.next()){

      out.write("\n");
      out.write("      <tr>\n");
      out.write("        <td>");
      out.print(resultset.getString("pat_id"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(resultset.getString("pat_name"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(resultset.getString("pat_gender"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(resultset.getString("pat_age"));
      out.write("</td>\n");
      out.write("        <td>");
      out.print(resultset.getString("pat_doa"));
      out.write("</td>\n");
      out.write("        <td>00.00</td>\n");
      out.write("        <td><a href=\"viewPatient.jsp\">view</a><td>\n");
      out.write("      </tr>\n");
      out.write("      ");

        }
        connection.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
