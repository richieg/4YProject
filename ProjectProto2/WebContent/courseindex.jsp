<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<%@ include file="commonmodals.jsp" %>

<script type='text/javascript' src="Category.js"></script>
<script type='text/javascript' src="JSControllers/CatCourseController.js"></script>



<body id="myBod2">

<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="#">Library</a></li>
  <li class="active">Data</li>
</ol>
<h1 id="pagetitle">Categories</h1>

<div id="intialdiv" class="tableboxmed">

<div class="buttonbox">



 

	



<button id="addcat1" class="btn btn-success" data-toggle="modal" 
   data-target="#catModal" id="addcattegory"><span class="glyphicon glyphicon-plus"></span>
   Add Category
</button>
<button class="btn btn-success"  id="addc" style="display:none"><span class="glyphicon glyphicon-plus"></span>
   
   Add Course
</button>
<button class="btn btn-info"  id="viewc" ><span class="glyphicon glyphicon-eye-open"></span>
 
   View Courses
</button>
<button class="btn btn-info"  id="viewcat" style="display:none"><span class="glyphicon glyphicon-eye-open"></span>
   View Categories
</button>
<button class="btn btn-info"  id="viewallc" style="display:none"><span class="glyphicon glyphicon-eye-open"></span>
   View All Courses
</button>
<button class="btn btn-info"  id="viewallcs" style="display:none"><span class="glyphicon glyphicon-eye-open"></span>
   View All Courses
</button>

</div>
</div>




<!-- Tables -->
 
 <div id="catdiv">   
 <table class="display" id="category" width="100%" cellspacing="0"></table></div> 
 <div id="coursediv"><table class="display" id="courses" width="100%" cellspacing="0"></table></div>
 
 
 <div id="studentdiv" style="display:none">

<input id='scourseID' name="catID" placeholder="catID" class="form-control" type="hidden">
<div class="tableboxmed">
<table class="display" id="students" width="100%" cellspacing="0"><thead></thead><tbody></tbody>
  <tfoot><tr><td></td><td></td><td></td><td></td><td><button id="SubmitButtonstudents" class="btn btn-success" data-dismiss="modal"><span class="glyphicon glyphicon-plus"></span>Add Selected Students</button></td></tr></tfoot></table>

 

    
 




         
            
     
         </div>
 </div>
  <div id="studentrecsdiv" style="display:none">
  <div class="tableboxmed">
  <table class="display" id="studentrecs" width="100%" cellspacing="0"></table>
  </div>
  </div>
 
 
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
           
            <h4 class="modal-title" id="catModalLabel">
               New Category
            </h4>
         </div>
         <div class="modal-body">

  <h2 id="catFormLabel">New Category Form</h2>
  <form class="form-horizontal" role="form" id="incatform">
 
  
  
  <div class="form-group" >
  <label class="control-label col-sm-4" for="catID"></label>
  <div class="col-sm-4">
    <input id='catID' name="catID" placeholder="catID" class="form-control" type="hidden">
    
  </div>
</div>
    
 

<!-- Text input-->
<div class="form-group" >
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
              <button id="UpdateButtoncat" class="btn btn-primary" data-dismiss="modal" style="display:none">Update</button>
     
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
           
            <h4 class="modal-title" id="courseModalLabel">
           Create New Course
            </h4>
         </div>
         <div class="modal-body">




  <form class="form-horizontal" role="form" id="courseform" >
   <h4 id="coursetitle"></h4>
  <div id="ncatidd" class="form-group" style="display:none">
  <label class="control-label col-sm-4" for="courseName"></label>
  <div class="col-sm-4">
    <input id='cccatid' name="ncatid" placeholder="Category ID" class="form-control" type="text">
    
  
    
  </div>
</div>
 
 
 
 <div id="ccatnamesel" class="form-group" style="display:none">
  <label class="control-label col-sm-4" for="courseName">Category Name</label>
  <div class="col-sm-4">

       <select class="form-control" id="catnamesel" name="options">
      <option id="1">- Select One -</option>
	</select>
    
  </div>
</div>


 <div id="ccatname" class="form-group">
  <label class="control-label col-sm-4" for="catName">Category Name</label>
  <div class="col-sm-4">
 <input id='catName' name="catName" placeholder="Category Name" class="form-control" type="text">
     

    
  </div>
</div>
  
<div id="coursenameseld" class="form-group">
   <label class="control-label col-sm-4" for="sel1">Select Course Name:</label>
   <div class="col-sm-4">
      <select class="form-control" id="coursenamesel">
      <option id="1">- Select One -</option>
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




<!-- Text input-->
<div id="acrb" class="form-group">
  <label class="control-label col-sm-4" for="accreditbod">Enter New Accreditation Body</label>
<div class="col-sm-4">
    <input id='accreditbod' name="accreditbod" placeholder="Accreditation Body" value="na" class="form-control" type="text">
    
  </div>
</div>




<div id="level"  class="form-group">
   <label class="control-label col-sm-4" for="sel2">Select Course Level:</label>
   <div class="col-sm-4">
      <select class="form-control" id="level">
      <option id="-1">- Select One -</option>
      <option id="0">Not Applicable</option>
            <option id="1">1</option>
                  <option id="2">2</option>
                        <option id="3">3</option>
                              <option id="4">4</option>
                                  <option id="5">5</option>
                                      <option id="6">6</option>
      </select>
        </div>
        </div>

<div id="tutor" class="form-group">
   <label class="control-label col-sm-4" for="sel3">Select Tutor:</label>
   <div class="col-sm-4">
      <select class="form-control" id="tutorsel">
      <option id="opt1" value=null>- Select One -</option>
      </select>
        </div>
        </div>
        
        

        
        
        <div id="capacityd" class="form-group">
  <label class="control-label col-sm-4" for="capacity">Capacity</label>
  <div class="col-sm-4">
    <input id='capacity' name="capcity" placeholder="capcity" class="form-control" type="text">
    
  </div>
</div>
        
 
        
        



  

        
        <div id="req" class="form-group">
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
               data-dismiss="modal" id="close">Close
            </button>
             <button id="CourseSubmitButton" class="btn btn-primary" data-dismiss="modal">Submit</button>
             <button id="CourseUpdateButton" class="btn btn-primary" data-dismiss="modal" style="display:none">Update</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->










   
 
        
        







</body>
</html>