<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<script type='text/javascript' src="Error.js"></script>
<body>


<%
String success = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) success = cookie.getValue();
   
}
}
//if(userName == null) response.sendRedirect("login.html");
%>
<h3>Hi <%=success %>, Login successful.</h3>
<div class="modal fade" id="ErrorModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4  class="modal-title" id="myModalLabel">
             Error Message
            </h4>
         </div>
         <div class="modal-body">
		 <div><h4 style="color:red"> The uploaded file contained one or more missing fields please review the file and try again</h4></div>


</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Cancel
            </button>
              <button id="errorbutton" class="btn btn-primary"     data-dismiss="modal">Ok</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</body>
</html>