/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2015-01-05 12:44:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      out.write("    <script src=\"js/jquery-2.1.0.min.js\"></script>\r\n");
      out.write("         <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type='text/javascript'>\r\n");
      out.write("  \r\n");
      out.write("$(document).ready(function()\r\n");
      out.write("{\r\n");
      out.write("\t$.ajax\r\n");
      out.write("\t({\r\n");
      out.write("\ttype: \"GET\",\r\n");
      out.write("\turl: \"GetUserData\",\r\n");
      out.write("\tdataType:\"json\",\r\n");
      out.write("\tsuccess: function(data)\r\n");
      out.write("\t{\r\n");
      out.write("\tif(data.User.length)\r\n");
      out.write("\t{\r\n");
      out.write("\t$.each(data.User, function(i,data)\r\n");
      out.write("\t{\r\n");
      out.write("\t//var user_data=\"<div>\"+data.fname + \" \"+data.lname + \" \" + data.address1+\"</div>\";\r\n");
      out.write("\tvar user_data=\"<tr><td>\"+data.fname+\"</td><td>\"+data.lname+\"</td><td>\"+data.address1+\"</tr>\";\r\n");
      out.write("\t//$(user_data).appendTo(\"#content\");\r\n");
      out.write("\t $(\"#table\").append(user_data).removeClass(\"hidden\");\r\n");
      out.write("\t});\r\n");
      out.write("\t}\r\n");
      out.write("\telse\r\n");
      out.write("\t{\r\n");
      out.write("\t$(\"#content\").html(\"No Results\");\r\n");
      out.write("\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t$('#add-user').click(function(){\r\n");
      out.write("\t    \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#Userform').show();\r\n");
      out.write("\t});\r\n");
      out.write("$('#SubmitButton').click(function()\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var fname = $(\"#firstName\").val();\r\n");
      out.write("var lname = $(\"#lastName\").val();\r\n");
      out.write("var address1 = $(\"#address1\").val();\r\n");
      out.write("var dataString = \"fname=\"+fname+\"&lname=\"+lname+\"&address1=\"+address1;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$.ajax({\r\n");
      out.write("type: \"POST\",\r\n");
      out.write("url: \"InsertData\",\r\n");
      out.write("data: dataString,\r\n");
      out.write("cache: false,\r\n");
      out.write("success: function(data)\r\n");
      out.write("{\r\n");
      out.write("\t\r\n");
      out.write("$(\"#Userform\").val('');\r\n");
      out.write("$(\"#alertmessage\").prepend(\"New user \"+data+\" has been entered successfully\");\r\n");
      out.write("$(\"#Userform\").focus();\r\n");
      out.write("}\r\n");
      out.write("});\r\n");
      out.write("return false;\r\n");
      out.write("});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("    \r\n");
      out.write("<title>TEAd@S</title>\r\n");
      out.write("  <link href=\"CSS\\bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"CSS\\main.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("   <header>\r\n");
      out.write("        <img class=\"logo\" src=\"Images\\logo_orange.png\" alt=\"TEAd@S\">\r\n");
      out.write("    </header>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div id=\"alertmessage\"></div>\r\n");
      out.write("\t<h1 class=\"h\">\r\n");
      out.write("     \r\n");
      out.write("    </h1>\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("  <table id=\"table\" class=\"ko-grid\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>First Name </th>\r\n");
      out.write("        <th>Last Name </th>\r\n");
      out.write("         <th>Address</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<button id=\"add-user\" class=\"btn btn-primary\" style=\"margin-top:0px\">Add User</button><br><br>\r\n");
      out.write("\r\n");
      out.write("<form id=\"Userform\" class=\"form-horizontal\"  style=\"display:none;\">\r\n");
      out.write("<fieldset>\r\n");
      out.write("\r\n");
      out.write("<!-- Form Name -->\r\n");
      out.write("<legend>New User</legend>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"control-group\">\r\n");
      out.write("  <label class=\"control-label\" for=\"firstName\">First Name</label>\r\n");
      out.write("  <div class=\"controls\">\r\n");
      out.write("    <input id='firstName' name=\"firstName\" placeholder=\"First Name\" class=\"input-large\" required=\"This is required\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"control-group\">\r\n");
      out.write("  <label class=\"control-label\" for=\"lastName\">Last Name</label>\r\n");
      out.write("  <div class=\"controls\">\r\n");
      out.write("    <input id='lastName' name=\"lastName\" placeholder=\"Last Name\" class=\"input-large\" required=\"This is required\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"control-group\" >\r\n");
      out.write("  <label class=\"control-label\" for=\"address1\">Address 1</label>\r\n");
      out.write("  <div class=\"controls\">\r\n");
      out.write("    <input id='address1' name=\"address1\" placeholder=\"Address 1\" class=\"input-large\" required=\"\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Text input-->\r\n");
      out.write("<div class=\"control-group\">\r\n");
      out.write("  <label class=\"control-label\" for=\"address2\">Address 23</label>\r\n");
      out.write("  <div class=\"controls\">\r\n");
      out.write("    <input id=\"address2\" name=\"address2\" placeholder=\"Address 2\" class=\"input-large\" type=\"text\">\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Button -->\r\n");
      out.write("<div class=\"control-group\">\r\n");
      out.write("  <label class=\"control-label\" for=\"submit\"></label>\r\n");
      out.write("  <div>\r\n");
      out.write("    <button id=\"SubmitButton\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</fieldset>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id='content'></div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
