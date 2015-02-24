<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    
     <%@ include file="head.jsp" %>
     <%@ include file="commonmodals.jsp" %>
         <script type='text/javascript' src="AddUser.js"></script>
         


<body id="myBod">


  
	 <div id="alertmessage"></div>
	
	
<!-- Button trigger modal -->
<br>
<br>

<button class="btn btn-primary" data-toggle="modal" 
   data-target="#myModal" id="adduser1">
   Add User
</button>
<button class="btn btn-primary" id="updateButton">
  Restore User
</button>
<button class="btn btn-primary" id="uploadButton">
 Upload Users
</button>
<button class="btn btn-primary" id="allusers">
Return to previous
</button>


	

<div id="mainform1" style="padding-top:80px;padding-left:5px;padding-right:5px">

  <table id="usertable" class="display" width="100%" cellspacing="0">
  <thead>
    <tr>
    	<th>ID </th>
    	<th>Role</th>
        <th>First Name </th>
        <th>Last Name </th>
        <th>Address 1</th>
        <th>Address 2</th>
        <th>Address 3</th>
        <th bSortable="false">Post Code</th>
       	<th class="nonsorting">Phone</th>
        <th class="nonsorting">Email</th>
      	<th class="nonsorting"></th>
        <th class="nonsorting"></th>
        <th class="nonsorting"></th>
       
      
    </tr>
    </thead>
      <tfoot>
 
    
    </tfoot>
    <tbody></tbody>
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
           
            <h4 class="modal-title" id="myModalLabel">
               Add New User Details
            </h4>
         </div>
         <div class="modal-body">

  <h2>New User Form</h2>
  <form class="form-horizontal" role="form" id="induserform">
 
  
    
 

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
    <input id='lastName' name="lastName" placeholder="Last Name" class="form-control" data-validation="alphanumeric" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="address1">Address 1</label>
  <div class="col-sm-4">
    <input id='address1' name="address1" placeholder="Address 1" class="form-control"  data-validation="alphanumeric" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4"  for="address2">Address 2</label>
<div class="col-sm-4">
    <input id="address2" name="address2" placeholder="Address 2" class="form-control"  type="text" required="This is required">
    
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
    <input id="postcode" name="postcode" placeholder="Postode" class="form-control" type="text" data-validation="alphanumeric">
    
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
    <input id="datepicker" name="dob" placeholder="Date of Birth"  type="text" required="true">

  </div>
</div>
  
<div id="rolediv" class="form-group">
   <label class="control-label col-sm-4" for="sel1">Member Role:</label>
   <div class="col-sm-4">
      <select class="form-control" id="role">
      <option id="0">- Select One -</option>
        <option id="1">Tutor</option>
        <option id="2">Student</option>
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
<button id="ShowRecButton" class="btn btn-primary" style="display:none">Display Records</button>
<div id="recordtablediv" style="display:none">
 <table id="userrectable" class="table" width="100%" cellspacing="0">
  <thead>
    <tr>
    	<th>Course Name</th>
    	<th>Start Date</th>
    	<th>Completion Date</th>
        <th>Final Grade</th>
  
       
      
    </tr>
    </thead>
      <tfoot>
 
    
    </tfoot>
    <tbody></tbody>
</table>

</div>
</div>



         <div class="modal-footer">
            <button id="closemyModal" class="btn btn-danger" data-dismiss="modal">Cancel</button>
             <button id="SubmitButton" class="btn btn-primary" data-dismiss="modal">Submit</button>
             <button id="UpdateUserButton" class="btn btn-primary" data-dismiss="modal" style="display:none">Update</button>

            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->




</body>

</html>


