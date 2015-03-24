<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="head.jsp" %>
<%@ include file="commonmodals.jsp" %>
<script type='text/javascript' src="Tutor.js"></script>
</head>
<body>
<h1>Semester Timetable</h1>


<div id="timetablediv" class="tableboxlg"><table class="display" id="timetable" width="100%" cellspacing="0"></table></div>
<h1>Today's Schedule</h1>
<div id="schedulelist" class="tableboxsml"><table class="table" id="schedule" width="100%" cellspacing="0">
<thead>
    <tr>
    	<th>Time</th>
    	<th>Course</th>
        <th>Room</th>
        <th></th>
    
    
       
      
    </tr>
    </thead>
      <tfoot>
 
    
    </tfoot>
    <tbody></tbody>

</table></div>


<div class="modal fade" id="rollcallmodal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
              Confirm
            </h4>
         </div>
         <div class="modal-body">
		 <div id="schedulelist" class="tableboxsml"><table class="table" id="studentlist" width="100%" cellspacing="0">
		 <thead>
    <tr>
    	<th></th>
    	<th></th>
        <th></th>
    
    
       
      
    </tr>
    </thead>
      <tfoot>
 
    
    </tfoot>
    <tbody></tbody>

</table></div>

	
	</div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Cancel
            </button>
              <button id="ConfirmButton" class="btn btn-primary"     data-dismiss="modal">Confirm</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->


</body>
</html>