<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<%@ include file="commonmodals.jsp" %>
<script type='text/javascript' src="Category.js"></script>



<body id="myBod2">


 

	
	
<!-- Button trigger modal -->
<br>
<br>

<button class="btn btn-primary" id="users">
Return to previous
</button>


<button class="btn btn-primary" data-toggle="modal" 
   data-target="#catModal" id="addcattegory">
   Add Category
</button>

<button class="btn btn-primary" data-toggle="modal" 
   data-target="#accredbodModal" id="accredbod">
   Add Accreditation Body
</button>
<br>
<br>




<table id="categorytable" class="display" width="100%" cellspacing="0">
        <thead>
            <tr>
                <th>Category ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>No. of Courses</th>
                <th></th>
                <th></th>
                <th></th>
                
            </tr>
        </thead>
 
        <tfoot>
            <tr>
                <th>Category ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>No. of Courses</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </tfoot>
             <tbody>
            
        </tbody>
         </table>
<!-- Modal -->
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
               New Category
            </h4>
         </div>
         <div class="modal-body">

  <h2>New Category Form</h2>
  <form class="form-horizontal" role="form" id="incatform">
 
  
    
 

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="categoryName">Name</label>
  <div class="col-sm-4">
    <input id='categoryName' name="categoryName" placeholder="Category Name" class="form-control" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="catDescript">Description</label>
<div class="col-sm-4">
    <input id='catDescript' name="catDescript" placeholder="Description" class="form-control" type="text">
    
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

<!-- Course Modal -->
<div class="modal fade" id="courseModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Add Course Details
            </h4>
         </div>
         <div class="modal-body">

  <h2>New Course Form</h2>
  <form class="form-horizontal" role="form" id="induserform">
 
 
 
 
 
 <div id="ncatnamed" class="form-group" style="display:none">
  <label class="control-label col-sm-4" for="courseName">Enter New Course Name</label>
  <div class="col-sm-4">
    <input id='ncatname' name="ncatname" placeholder="Category Name" class="form-control" type="text">
    
  </div>
</div>
  
<div id="coursenameseld" class="form-group">
   <label class="control-label col-sm-4" for="sel1">Select Course Name:</label>
   <div class="col-sm-4">
      <select class="form-control" id="coursenamesel">
      <option id="1">- Select One -</option>
      <option value="2" id="2">Word Processing</option>
        <option value="3" id="3">Excell</option>
      </select>
        </div>
        </div>
 

<!-- Text input-->
<div id="coursename" class="form-group">
  <label class="control-label col-sm-4" for="courseName">Enter New Course Name</label>
  <div class="col-sm-4">
    <input id='courseName' name="courseName" placeholder="Course Name" class="form-control" type="text">
    
  </div>
</div>


<div id="accredbodseld"  class="form-group">
   <label class="control-label col-sm-4" for="sel2">Select Existing Accreditation Body:</label>
   <div class="col-sm-4">
      <select class="form-control" id="accreditbodsel">
      <option id="4">- Select One -</option>
      <option id="5">Not Applicable</option>
      </select>
        </div>
        </div>

<!-- Text input-->
<div id="acrb" class="form-group">
  <label class="control-label col-sm-4" for="accreditbod">Enter New Accreditation Body</label>
<div class="col-sm-4">
    <input id='accreditbod' name="accreditbod" placeholder="Accreditation Body" class="form-control" type="text">
    
  </div>
</div>

<div class="form-group">
   <label class="control-label col-sm-4" for="sel3">Select Tutor:</label>
   <div class="col-sm-4">
      <select class="form-control" id="tutorsel">
      <option id="opt1">- Select One -</option>
      </select>
        </div>
        </div>
        
        
        
        <div class="form-group">
   <label class="control-label col-sm-4" for="sel4">Select Semester:</label>
   <div class="col-sm-4">
      <select class="form-control" id="semestersel">
       <option id="1">1</option>
        <option id="2">2</option>
         <option id="3">3</option>
          <option id="4">4</option>
      </select>
        </div>
        </div>
        
        
        <div id="capacity" class="form-group">
  <label class="control-label col-sm-4" for="capacity">Capacity</label>
  <div class="col-sm-4">
    <input id='capcity' name="capcity" placeholder="capcity" class="form-control" type="text">
    
  </div>
</div>
        
 
        
        



  

        
        <div class="form-group">
   <label class="control-label col-sm-4" for="dob">Requires PC/ Laptops</label>
  <div class="col-sm-4">

    <select class="form-control" id="equipsel">
       <option id="1">- Select One -</option>
        <option id="2">Yes</option>
         <option id="3">No</option>
    </select>

</div>
</div>

<!-- Button -->


</form>
</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             <button id="CourseSubmitButton" class="btn btn-primary" data-dismiss="modal">Submit</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->






<!--Accredit Body Modal -->
<div class="modal fade" id="accredbodModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Accreditation Body
            </h4>
         </div>
         <div class="modal-body">

  <h2>New  Accreditation Body</h2>
  <form class="form-horizontal" role="form" id="accredbod">
 
  
    
 

<!-- Text input-->
<div class="form-group">
  <label class="control-label col-sm-4" for="categoryName">Name</label>
  <div class="col-sm-4">
    <input id='accredbod' name="accredbod" placeholder="Body Name" class="form-control" type="text">
    
  </div>
</div>

<!-- Text input-->




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