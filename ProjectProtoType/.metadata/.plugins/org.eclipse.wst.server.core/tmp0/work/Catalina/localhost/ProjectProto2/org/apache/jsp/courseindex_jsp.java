/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-02-28 15:27:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courseindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
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
      out.write("<script type='text/javascript' src=\"Category.js\"></script>\r\n");
      out.write("<script type='text/javascript' src=\"JSControllers/CatCourseController.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body id=\"myBod2\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<!-- Button trigger modal -->\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<a id=\"nav\" href=\"index.html\" title=\"Index\"><img src=\"Images\\back.png\" alt=\"back\"><br>Back to main menu</a>\r\n");
      out.write("\r\n");
      out.write("<h1 id=\"pagetitle\">Categories</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<button id=\"addcat1\" class=\"btn btn-primary\" data-toggle=\"modal\" \r\n");
      out.write("   data-target=\"#catModal\" id=\"addcattegory\">\r\n");
      out.write("   Add Category\r\n");
      out.write("</button>\r\n");
      out.write("<button class=\"btn btn-primary\"  id=\"addc\" style=\"display:none\">\r\n");
      out.write("   Add Course\r\n");
      out.write("</button>\r\n");
      out.write("<button class=\"btn btn-primary\"  id=\"viewc\" >\r\n");
      out.write("   View Courses\r\n");
      out.write("</button>\r\n");
      out.write("<button class=\"btn btn-primary\"  id=\"viewcat\" style=\"display:none\">\r\n");
      out.write("   View Categories\r\n");
      out.write("</button>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Tables -->\r\n");
      out.write("  <input type=\"file\" id=\"fileUpload\">\r\n");
      out.write(" <div id=\"catdiv\">   \r\n");
      out.write(" <table class=\"display\" id=\"category\" width=\"100%\" cellspacing=\"0\"></table></div> \r\n");
      out.write(" <div id=\"coursediv\"><table class=\"display\" id=\"courses\" width=\"100%\" cellspacing=\"0\"></table></div>\r\n");
      out.write(" <div id=\"studentdiv\" style=\"display:none\">\r\n");
      out.write("\r\n");
      out.write("<input id='scourseID' name=\"catID\" placeholder=\"catID\" class=\"form-control\" type=\"hidden\">\r\n");
      out.write("<table class=\"display\" id=\"students\" width=\"100%\" cellspacing=\"0\"></table>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("             <button id=\"SubmitButtonstudents\" class=\"btn btn-primary\" data-dismiss=\"modal\">Submit</button>\r\n");
      out.write("     \r\n");
      out.write("         </div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write("<!-- Modal -->\r\n");
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
      out.write("            <h4 class=\"modal-title\" id=\"catModalLabel\">\r\n");
      out.write("               New Category\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("  <h2 id=\"catFormLabel\">New Category Form</h2>\r\n");
      out.write("  <form class=\"form-horizontal\" role=\"form\" id=\"incatform\">\r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <div class=\"form-group\" >\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"catID\"></label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='catID' name=\"catID\" placeholder=\"catID\" class=\"form-control\" type=\"hidden\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"form-group\" >\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"categoryName\">Name</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='categoryName' name=\"categoryName\" placeholder=\"Category Name\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"catDescript\">Description</label>\r\n");
      out.write("<div class=\"col-sm-4\">\r\n");
      out.write("    <input id='catDescript' name=\"catDescript\" placeholder=\"Description\" class=\"form-control\" type=\"text\">\r\n");
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
      out.write("              <button id=\"UpdateButtoncat\" class=\"btn btn-primary\" data-dismiss=\"modal\" style=\"display:none\">Update</button>\r\n");
      out.write("     \r\n");
      out.write("         </div>\r\n");
      out.write("   </div>\r\n");
      out.write("      \r\n");
      out.write("      </div><!-- /.modal-content -->\r\n");
      out.write("</div><!-- /.modal -->\r\n");
      out.write("\r\n");
      out.write("<!-- Course Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"courseModal\" tabindex=\"-1\" role=\"dialog\" \r\n");
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
      out.write("               Add Course Details\r\n");
      out.write("            </h4>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("  <h2>New Course Form</h2>\r\n");
      out.write("  \r\n");
      out.write("  <form class=\"form-horizontal\" role=\"form\" id=\"courseform\" >\r\n");
      out.write(" \r\n");
      out.write("  <div id=\"ncatidd\" class=\"form-group\" style=\"display:none\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"courseName\"></label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='cccatid' name=\"ncatid\" placeholder=\"Category ID\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" <div id=\"ccatnamesel\" class=\"form-group\" style=\"display:none\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"courseName\">Category Name</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("\r\n");
      out.write("       <select class=\"form-control\" id=\"catnamesel\" name=\"options\">\r\n");
      out.write("      <option id=\"1\">- Select One -</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div id=\"ccatname\" class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"catName\">Category Name</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write(" <input id='catName' name=\"catName\" placeholder=\"Category Name\" class=\"form-control\" type=\"text\">\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("  \r\n");
      out.write("<div id=\"coursenameseld\" class=\"form-group\">\r\n");
      out.write("   <label class=\"control-label col-sm-4\" for=\"sel1\">Select Course Name:</label>\r\n");
      out.write("   <div class=\"col-sm-4\">\r\n");
      out.write("      <select class=\"form-control\" id=\"coursenamesel\">\r\n");
      out.write("      <option id=\"1\">- Select One -</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div id=\"coursename\" class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"courseName\">Enter New Course Name</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='courseName' name=\"courseName\" placeholder=\"Course Name\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div id=\"acrb\" class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"accreditbod\">Enter New Accreditation Body</label>\r\n");
      out.write("<div class=\"col-sm-4\">\r\n");
      out.write("    <input id='accreditbod' name=\"accreditbod\" placeholder=\"Accreditation Body\" value=\"na\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div id=\"sem\" class=\"form-group\">\r\n");
      out.write("   <label class=\"control-label col-sm-4\" for=\"sel4\">Select Semester:</label>\r\n");
      out.write("   <div class=\"col-sm-4\">\r\n");
      out.write("      <select class=\"form-control\" id=\"semestersel\">\r\n");
      out.write("      <option id=\"0\">- Select One -</option>\r\n");
      out.write("       <option id=\"1\">1</option>\r\n");
      out.write("        <option id=\"2\">2</option>\r\n");
      out.write("         <option id=\"3\">3</option>\r\n");
      out.write("          <option id=\"4\">4</option>\r\n");
      out.write("      </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"level\"  class=\"form-group\">\r\n");
      out.write("   <label class=\"control-label col-sm-4\" for=\"sel2\">Select Course Level:</label>\r\n");
      out.write("   <div class=\"col-sm-4\">\r\n");
      out.write("      <select class=\"form-control\" id=\"level\">\r\n");
      out.write("      <option id=\"-1\">- Select One -</option>\r\n");
      out.write("      <option id=\"0\">Not Applicable</option>\r\n");
      out.write("            <option id=\"1\">1</option>\r\n");
      out.write("                  <option id=\"2\">2</option>\r\n");
      out.write("                        <option id=\"3\">3</option>\r\n");
      out.write("                              <option id=\"4\">4</option>\r\n");
      out.write("                                  <option id=\"5\">5</option>\r\n");
      out.write("                                      <option id=\"6\">6</option>\r\n");
      out.write("      </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"tutor\" class=\"form-group\">\r\n");
      out.write("   <label class=\"control-label col-sm-4\" for=\"sel3\">Select Tutor:</label>\r\n");
      out.write("   <div class=\"col-sm-4\">\r\n");
      out.write("      <select class=\"form-control\" id=\"tutorsel\">\r\n");
      out.write("      <option id=\"opt1\">- Select One -</option>\r\n");
      out.write("      </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <div id=\"capacityd\" class=\"form-group\">\r\n");
      out.write("  <label class=\"control-label col-sm-4\" for=\"capacity\">Capacity</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("    <input id='capacity' name=\"capcity\" placeholder=\"capcity\" class=\"form-control\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("        \r\n");
      out.write(" \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div id=\"req\" class=\"form-group\">\r\n");
      out.write("   <label class=\"control-label col-sm-4\" for=\"dob\">Requires PC/ Laptops</label>\r\n");
      out.write("  <div class=\"col-sm-4\">\r\n");
      out.write("\r\n");
      out.write("    <select class=\"form-control\" id=\"equipsel\">\r\n");
      out.write("       <option id=\"1\">- Select One -</option>\r\n");
      out.write("        <option id=\"2\">Yes</option>\r\n");
      out.write("         <option id=\"3\">No</option>\r\n");
      out.write("    </select>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Button -->\r\n");
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
      out.write("             <button id=\"CourseSubmitButton\" class=\"btn btn-primary\" data-dismiss=\"modal\">Submit</button>\r\n");
      out.write("             <button id=\"CourseUpdateButton\" class=\"btn btn-primary\" data-dismiss=\"modal\" style=\"display:none\">Update</button>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write(" \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
