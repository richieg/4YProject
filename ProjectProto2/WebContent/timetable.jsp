<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="head.jsp" %>
<%@ include file="commonmodals.jsp" %>

<html>
<body>

    <div id="menu" class="menu">
        <a href="userindex.jsp">
            <img src="Images\users1.jpg" /><br>
            Tutor & Student Management
        </a>
        <a href="courseindex.html">
            <img src="Images\course2.png" />
            Category & Course Management
        </a>
     
        <a href="fieldReps.html">
            <img src="Images\timetable1.png" />
            Timetables
        </a>
		  <a href="fieldReps.html">
            <img src="Images\report.png" /><br>
            Reports
        </a>
       
      
    </div>


<button class="btn btn-primary" data-toggle="modal" 
   data-target="#catModal" id="addcattegory">
   Add Room
</button>


<!--Room Modal -->
<div class="modal fade" id="catModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Add Room
            </h4>
         </div>
         <div class="modal-body">

  <h2>New Room Form</h2>
  <form class="form-horizontal" role="form" id="roomform">
 
  
    
 

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="roomName">Name</label>
  <div class="col-sm-4">
    <input id='roomName' name="roomName" placeholder="Room Name" class="form-control" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="capacity">Capacity</label>
<div class="col-sm-4">
    <input id='capacity' name="capacity" placeholder="Capacity" class="form-control" type="text" data-validation="number">
    
  </div>
</div>


<div class="form-group">
  <label class="control-label col-sm-4" for="capacity">PC/ Laptop</label>
<div class="col-sm-4">
    <input id='pccount' name="pccount" placeholder="Pc/ Laptop Count" class="form-control" type="text" data-validation="number">
    
  </div>
</div>



</form>
</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             <button id="SubmitButtoncat" class="btn btn-primary" data-dismiss="modal">Submit</button>
     
         </div>
   </div>
      
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
</html>