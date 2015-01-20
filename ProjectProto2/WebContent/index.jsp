<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="js/jquery-2.1.0.min.js"></script>
         <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
         <script type='text/javascript' src="AddUser.js"></script>
         <script src="CSS/js/bootstrap.min.js"></script>
    <script src="jq/jquery-ui.min.js"></script>
    

    
<title>TEAd@S</title>
  <link href="CSS/css/bootstrap.min.css" rel="stylesheet">
    <link href="CSS/main.css" rel="stylesheet">
    <link href="jq/jquery-ui.css" rel="stylesheet">
</head>


<body id="myBod">


   <header>
      <img class="logo" src="Images\logo_orange.png" alt="TEAd@S">
    </header>
	 <div id="alertmessage"></div>
	

<div id="mainform1" style="padding-top:80px">

  <table id="table" class="ko-grid">
    <tr>
        <th>First Name </th>
        <th>Last Name </th>
         <th>Address</th>
    </tr>
</table>


</div>

   <div class="form-group">
      <label class="sr-only" for="inputfile">File input</label>
      <input type="file" id="inputfile">
   </div>







<!-- Button trigger modal -->

<button class="btn btn-primary" data-toggle="modal" 
   data-target="#myModal">
   Add User
</button>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
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
  <form class="form-horizontal" role="form">
 
  
    
 

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="firstName">First Name</label>
  <div class="col-sm-4">
    <input id='firstName' name="firstName" placeholder="First Name" class="form-control" required="This is required" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="lastName">Last Name</label>
<div class="col-sm-4">
    <input id='lastName' name="lastName" placeholder="Last Name" class="form-control" required="This is required" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="address1">Address 1</label>
  <div class="col-sm-4">
    <input id='address1' name="address1" placeholder="Address 1" class="form-control"  required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4"  for="address2">Address 2</label>
<div class="col-sm-4">
    <input id="address2" name="address2" placeholder="Address 2" class="form-control"  type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4"  for="address3">Address 3</label>
  <div class="col-sm-4">
    <input id="address3" name="address3" placeholder="Address 3" class="form-control"  type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="address4">Address 4</label>
    <div class="col-sm-4">
    <input id="address4" name="address4" placeholder="Address 4" class="form-control" type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="postcode">Postcode</label>
  <div class="col-sm-4">
    <input id="postcode" name="postcode" placeholder="Postode" class="form-control" type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="phone">Phone No.</label>
 <div class="col-sm-4">
    <input id="phone" name="phone" placeholder="Phone No." class="form-control" type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="control-label col-sm-4" for="email">Email</label>
  <div class="col-sm-4">
    <input id="email" name="email" placeholder="Email" class="form-control" type="text">
    
  </div>
</div>

<div class="form-group">
   <label class="control-label col-sm-4" for="dob">Date of Birth</label>
  <div class="col-sm-4">
    <input id="datepicker" name="dob" placeholder="Date of Birth" class="form-control" type="text">
    
  </div>
</div>
<div class="form-group">
   <label class="control-label col-sm-4" for="sel1">Member Role (select one):</label>
   <div class="col-sm-4">
      <select class="form-control" id="role">
        <option>Tutor</option>
        <option>Student</option>
        </select>
        </div>
        </div>
        
        <div class="form-group">
   <label class="control-label col-sm-4" for="dob">checknum</label>
  <div class="col-sm-4">
    <input id="checknum" name="checknum" value=1 class="form-control" type="text">

</div>
</div>

<!-- Button -->


</form>
</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             <button id="SubmitButton" class="btn btn-primary" data-dismiss="modal">Submit</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

<!-- Modal -->
<div class="modal fade" id="ModalActionAlert" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Action Confirm
            </h4>
         </div>
         <div class="modal-body">
		 <h3>Tick to confirm you wish to complete this action<input type="checkbox" id="checkbox1" /></h3>


</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             <button id="SubmitButton" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-dismiss="modal">Submit</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->



</body>

</html>


