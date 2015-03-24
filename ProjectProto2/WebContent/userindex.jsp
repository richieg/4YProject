<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    
     <%@ include file="head.jsp" %>
     <%@ include file="commonmodals.jsp" %>
         <script type='text/javascript' src="AddUser.js"></script>
         <script type='text/javascript' src="CommonMethods.js"></script>
         
         


<body id="myBod">
<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="#">Library</a></li>
  <li class="active">Data</li>
</ol>
<h1>Tutor/ Student Management</h1>

<div id="intialdiv" class="tableboxmed">

<div class="buttonbox">

<button class="btn btn-success" data-toggle="modal" 
   data-target="#myModal" id="adduser1"><span class="glyphicon glyphicon-plus"></span>
   Add New Tutor/ Student
</button>
<button class="btn btn-primary" id="updateButton"><span class="glyphicon glyphicon-refresh"></span>
  Restore Tutor/ Student
</button>
<button class="btn btn-warning" id="bulkuploadbtn" data-toggle="modal" 
   data-target="#bulkupload"><span class="glyphicon glyphicon-import"></span>
Import Students
</button>
<button class="btn btn-primary" id="allusers"><span class="glyphicon glyphicon-eye-open"></span>
View All Tutors/ Students
</button>


  
</div>
</div>
	
	
<!-- Button trigger modal -->





	

<div id="mainform1" style="padding-top:80px;padding-left:5px;padding-right:5px">

  <table id="usertable" class="display" width="100%" cellspacing="0">
  <thead>
    <tr>
    	<th>ID </th>
    	<th>Role</th>
        <th>First Name </th>
        <th>Last Name </th>
        <th class="no-sort">Address 1</th>
        <th class="no-sort">Address 2</th>
        <th class="no-sort">Address 3</th>
        <th>Post Code</th>
       	<th class="no-sort">Phone</th>
        <th class="no-sort">Email</th>
      	<th class="no-sort"></th>
        <th class="no-sort"></th>
    
       
      
    </tr>
    </thead>
  
    <tbody></tbody>
        <tfoot>
 
    
    </tfoot>
</table>


</div>

   <div class="form-group">
      <label class="sr-only" for="inputfile">File input</label>
      <input type="file" id="inputfile">
   </div>








<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="userModalLabel">
               Add New Tutor/ Student
            </h4>
         </div>
         <div class="modal-body">

 
  <form class="form-horizontal" role="form" id="induserform">
  
  
  <div id="firstnamediv0" class="form-group">
  <label class="control-label col-sm-4" for="firstName0">First Name</label>
  <div class="col-sm-4">
    <input id='firstName0' name="firstName" placeholder="First Name" class="form-control"  data-validation="required" type="text" disabled>
    
  </div>
</div>

<!-- Text input-->
<div id="lastnamediv0" class="form-group">
  <label class="control-label col-sm-4" for="lastName0">Last Name</label>
<div class="col-sm-4">
    <input id='lastName0' name="lastName" placeholder="Last Name" class="form-control" data-validation="required" type="text" disabled>
    
  </div>
</div>
 
  
    
 

<!-- Text input-->
<div id="firstnamediv" class="form-group">
  <label class="control-label col-sm-4" for="firstName">First Name</label>
  <div class="col-sm-4">
    <input id='firstName' name="firstName" placeholder="First Name" class="form-control"  data-validation="required" type="text">
    
  </div>
</div>

<!-- Text input-->
<div id="lastnamediv" class="form-group">
  <label class="control-label col-sm-4" for="lastName">Last Name</label>
<div class="col-sm-4">
    <input id='lastName' name="lastName" placeholder="Last Name" class="form-control" data-validation="required" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="address1">Address 1</label>
  <div class="col-sm-4">
    <input id='address1' name="address1" placeholder="Address 1" class="form-control"  data-validation="required" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4"  for="address2">Address 2</label>
<div class="col-sm-4">
    <input id="address2" name="address2" placeholder="Address 2" class="form-control"  type="text" data-validation="required">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4"  for="address3">Address 3</label>
  <div class="col-sm-4">
    <input id="address3" name="address3" placeholder="Address 3" class="form-control"  type="text">
    
  </div>
</div>



<div class="form-group">
  <label class="control-label col-sm-4" for="postcode">Postcode</label>
  <div class="col-sm-4">
    <input id="postcode" name="postcode" placeholder="Postode" class="form-control" type="text" data-validation="required">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="phone">Phone No.</label>
 <div class="col-sm-4">
    <input id="phone" name="phone" placeholder="Phone No." class="form-control" type="text" data-validation="number" required>
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="email">Email</label>
  <div class="col-sm-4">
    <input id="email" name="email" placeholder="Email" class="form-control" type="text" data-validation="email" required="true">
    
  </div>
</div>

<div id="dobdiv" class="form-group">
   <label class="control-label col-sm-4" for="dob">Date of Birth</label>
  <div class="col-sm-4">
    <input id="datepicker" name="dob" placeholder="Date of Birth"  type="text" data-validation="required"  class="form-control">

  </div>
</div>
  
<div id="rolediv" class="form-group">
   <label class="control-label col-sm-4" for="sel1">Member Role:</label>
   <div class="col-sm-4">
      <select class="form-control" id="role" data-validation="required">
      <option id="0">- Select One -</option>
        <option id="1">Tutor</option>
        <option id="2">Student</option>
        <option id="3">Admin Staff</option>
        </select>
        </div>
        </div>
        
        <div class="form-group" style="display:none">
   <label class="control-label col-sm-4" for="dob">checknum</label>
  <div class="col-sm-4">
    <input id="checknum" name="checknum" value=1 class="form-control" type="text">

</div>
</div>



<!-- Button -->


</form>




         <div class="modal-footer">
            <button id="closemyModal" class="btn btn-danger" data-dismiss="modal">Cancel</button>
             <button id="SubmitButton" class="btn btn-primary" data-dismiss="modal">Submit</button>
             <button id="UpdateUserButton" class="btn btn-primary" data-dismiss="modal" style="display:none">Update</button>

            
           
         </div>
         <button id="ShowRecButton" class="btn btn-primary" style="display:none">Display Records</button>
<div id="recordtablediv" style="display:none">
<h4 id="usermessage" style="color:red; display:none">Please note grades are updated indepently from the information above. Once the <button class="btn btn-primary"> <span class="glyphicon glyphicon-pencil"></span></button> is clicked the new grade is saved to the database.</h4>
 <table id="userrectable" class="table" width="100%" cellspacing="0">
  <thead>
    <tr>
    	<th>Course ID</th>
    	<th>Course Name</th>
    	<th>Start Date</th>
    	<th>End Date</th>
        <th id="grade">Grade</th>
  
       
      
    </tr>
    </thead>
      <tfoot>
 
    
    </tfoot>
    <tbody></tbody>
</table>
<div id="recmessage"></div>
</div>
</div>
         
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->




</body>

</html>


