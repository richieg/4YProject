/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-03-01 14:51:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class timetable_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/commonmodals.jsp", Long.valueOf(1425126915480L));
    _jspx_dependants.put("/head.jsp", Long.valueOf(1424742902204L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("    \r\n");
      out.write("         <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("      \r\n");
      out.write("         <script src=\"CSS/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"jq/jquery-ui.min.js\"></script>\r\n");
      out.write("     <script src=\"CSS/bootbox.js\"></script>\r\n");
      out.write("    <script src=\"jq/form-validator/jquery.form-validator.min.js\"></script>\r\n");
      out.write("          <script type=\"text/javascript\" charset=\"utf8\" src=\"CSS/DataTables-1.10.4/media/js/jquery.dataTables.js\"></script>\r\n");
      out.write("      <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/DataTables-1.10.4/media/css/jquery.dataTables.css\">\r\n");
      out.write("        \r\n");
      out.write("     <link href=\"CSS/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"CSS/main.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"jq/jquery-ui.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<title>TEAd@S</title>\r\n");
      out.write(" \r\n");
      out.write("</head>\r\n");
      out.write("  <header>\r\n");
      out.write("      <img class=\"logo\" src=\"Images\\logo_orange.png\" alt=\"TEAd@S\">\r\n");
      out.write("    </header>");
      out.write('\r');
      out.write('\n');
      out.write("<div class=\"modal fade\" id=\"ModalMessage\" tabindex=\"-1\" role=\"dialog\" \r\n");
      out.write("   aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("   <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("         <div class=\"modal-header\">\r\n");
      out.write("            <button type=\"button\" class=\"close\" \r\n");
      out.write("               data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("                  &times;\r\n");
      out.write("            </button>\r\n");
      out.write("           \r\n");
      out.write("            <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("               Message\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\t\t <div id=\"sfmessage\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"modal-footer\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("               data-dismiss=\"modal\">Close\r\n");
      out.write("            </button>\r\n");
      out.write("             \r\n");
      out.write("            \r\n");
      out.write("           \r\n");
      out.write("         </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div><!-- /.modal-content -->\r\n");
      out.write("</div><!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\" id=\"ModalConfirm\" tabindex=\"-1\" role=\"dialog\" \r\n");
      out.write("   aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("   <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("         <div class=\"modal-header\">\r\n");
      out.write("            <button type=\"button\" class=\"close\" \r\n");
      out.write("               data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("                  &times;\r\n");
      out.write("            </button>\r\n");
      out.write("           \r\n");
      out.write("            <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("              Confirm\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\t\t <div><h4>Are you sure you wish to complete this action?</h4></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"modal-footer\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("               data-dismiss=\"modal\">Cancel\r\n");
      out.write("            </button>\r\n");
      out.write("              <button id=\"ConfirmButton\" class=\"btn btn-primary\"     data-dismiss=\"modal\">Confirm</button>\r\n");
      out.write("            \r\n");
      out.write("           \r\n");
      out.write("         </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div><!-- /.modal-content -->\r\n");
      out.write("</div><!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\" id=\"bulkupload\" tabindex=\"-1\" role=\"dialog\" \r\n");
      out.write("   aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("   <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("         <div class=\"modal-header\">\r\n");
      out.write("            <button type=\"button\" class=\"close\" \r\n");
      out.write("               data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("                  &times;\r\n");
      out.write("            </button>\r\n");
      out.write("           \r\n");
      out.write("            <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("              Bulk Upload\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\t\t <div><h4>Please select  a file .csv to upload</h4></div>\r\n");
      out.write("<input type=\"file\" id=\"i_file\" value=\"\"> \r\n");
      out.write("\r\n");
      out.write("        <form method=\"POST\" action=\"FileUploadServlet\" enctype=\"multipart/form-data\" >\r\n");
      out.write("            File:\r\n");
      out.write("            <input type=\"file\" name=\"file\" id=\"file\" /> <br/>\r\n");
      out.write("        \t<input type=\"submit\" value=\"Upload File\" />\r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write(" \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"modal-footer\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("               data-dismiss=\"modal\">Cancel\r\n");
      out.write("            </button>\r\n");
      out.write("              <button id=\"uploadButton\" class=\"btn btn-primary\"     data-dismiss=\"modal\">Upload</button>\r\n");
      out.write("            \r\n");
      out.write("           \r\n");
      out.write("         </div>\r\n");
      out.write("         </div>\r\n");
      out.write("      </div><!-- /.modal-content -->\r\n");
      out.write("</div><!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<button class=\"btn btn-primary\" data-toggle=\"modal\" \r\n");
      out.write("   data-target=\"#catModal\" id=\"addcattegory\">\r\n");
      out.write("   Add Room\r\n");
      out.write("</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Room Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"catModal\" tabindex=\"-1\" role=\"dialog\" \r\n");
      out.write("   aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" data-backdrop=\"static\">\r\n");
      out.write("   <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("         <div class=\"modal-header\">\r\n");
      out.write("            <button type=\"button\" class=\"close\" \r\n");
      out.write("               data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("                  &times;\r\n");
      out.write("            </button>\r\n");
      out.write("           \r\n");
      out.write("            <h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("               Add Room\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("  <h2>New Room Form</h2>\r\n");
      out.write("  <form class=\"form-horizontal\" role=\"form\" id=\"roomform\">\r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"roomName\">Name</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='roomName' name=\"roomName\" placeholder=\"Room Name\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"capacity\">Capacity</label>\r\n");
      out.write("<div class=\"col-sm-4\">\r\n");
      out.write("    <input id='capacity' name=\"capacity\" placeholder=\"Capacity\" class=\"form-control\" type=\"text\" data-validation=\"number\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"capacity\">PC/ Laptop</label>\r\n");
      out.write("<div class=\"col-sm-4\">\r\n");
      out.write("    <input id='pccount' name=\"pccount\" placeholder=\"Pc/ Laptop Count\" class=\"form-control\" type=\"text\" data-validation=\"number\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         <div class=\"modal-footer\">\r\n");
      out.write("            <button type=\"button\" class=\"btn btn-default\" \r\n");
      out.write("               data-dismiss=\"modal\">Close\r\n");
      out.write("            </button>\r\n");
      out.write("             <button id=\"SubmitButtoncat\" class=\"btn btn-primary\" data-dismiss=\"modal\">Submit</button>\r\n");
      out.write("     \r\n");
      out.write("         </div>\r\n");
      out.write("   </div>\r\n");
      out.write("      \r\n");
      out.write("      </div><!-- /.modal-content -->\r\n");
      out.write("</div><!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
