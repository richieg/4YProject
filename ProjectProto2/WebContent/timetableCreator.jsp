<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="head.jsp" %>
<%@ include file="commonmodals.jsp" %>
<script type='text/javascript' src="TimeTableCreator.js"></script>
</head>
<body>
<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="#">Library</a></li>
  <li class="active">Data</li>
</ol>

<div id="intialdiv" class="tableboxmed">

<div class="buttonbox">
<h2>Timetable Action Menu</h2>
<button class="btn btn-danger" id="editttc">
 

 <span class="glyphicon glyphicon-pencil"></span> Current Timetable
</button>



<button class="btn btn-primary" id="edrafttt">

<span class="glyphicon glyphicon-plus"></span>/ <span class="glyphicon glyphicon-pencil"></span> Draft Timetable
</button>

<button class="btn btn-success" id="semdet"  data-toggle="modal" 
   data-target="#semestermodal" id="addcattegory">

<span class="glyphicon glyphicon-plus"></span>/ <span class="glyphicon glyphicon-pencil"></span> Semester Details
</button>
<button class="btn btn-info" id="roomdet"  data-toggle="modal" 
   data-target="#semestermodal" id="addcattegory">

<span class="glyphicon glyphicon-plus"></span>/ <span class="glyphicon glyphicon-pencil"></span> Room Details
</button>
</div>
</div>







<div id="timetablecreator">
<h1>Time Table Editor</h1>
<div class="space"></div>
<div class="tableboxsml">
<br>

<table id='entryadd' class="table">

<tr>
 
  
  







<td>
 <label for="day">Day</label>
</td>
<td>
  <select class="form-control" id="daysel" name="daysel">
      <option id="-1">- Select Day -</option>
</select>

</td>


<td>
 <label for="time">Time</label>
 </td>
 <td>
  <select class="form-control" id="timesel" name="timesel">
      <option id="-1">- Select Time -</option>
</select>

</td>




<td>
 <label for="course">Course</label>
 </td>
 <td>
  <select class="form-control" id="coursesel" name="coursesel">
      <option id="-1">- Select Course -</option>
</select>

</td>

<td>
 <label for="room">Room</label>
 </td>
 <td>
  <select class="form-control" id="roomsel" name="roomsel">
      <option id="-1">- Select Room -</option>
</select>


</td>
<td style="width:45px">

<button class="btn btn-success" title='Add Entry' id="adde"><span class="glyphicon glyphicon-plus"></span></button>
</td>
<td style="width:45px">

<button class="btn btn-danger" title='Reset'  id="refreshsels"><span class="glyphicon glyphicon-refresh"></span></button>
</td>

</tr>

</table>
<div class="buttonbox">
<button class="btn btn-primary" id="savewip" style="display:none">
 

  Save as Draft
</button>



<button class="btn btn-primary" id="savett"  data-toggle="modal" 
   data-target="#semestermodal" style="display:none">

Save as Timetable
</button>


<button class="btn btn-primary" id="savec" style="display:none">Save Changes</button>
</div>
<div>
</div>
</div>

</div>



<br>
<br>


<h1 id="ttitle"></h1>
<div class="tableboxlg">
<div class="col-sm-2">
<label for="timetableselect">Select a Different Timetable</label>
 <select id="timetableselect" name="timetableselect" class="form-control">
 
</select>
</div>
</div>
<div class="space"></div>

 <div id="timetablediv" class="tableboxlg"><table class="display" id="timetable" width="100%" cellspacing="0"></table></div>
 
 
 <!-- Modal -->
<div class="modal fade" id="semestermodal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="catModalLabel">
              Assign to Semester
            </h4>
         </div>
         <div class="modal-body">
  <div id="intialdiv">
  Assign this timetable to an existing semester?&nbsp;    <select id="existingsem" name="existingsem" class="form-control">
  <option id="0">-Select One-</option>
      <option id="1">Yes</option>
      <option id="2">No</option>
</select>
</div>
  <div id="semtablediv" style="display:none"><table id="semtable" class="table"><tr><th>Semester</th><th>Start Date</th><th>End Date</th><th>Select Semester</th></tr></table></div>
  
  <div id="newsemdiv" style="display:none">
  Please select the semester you wish to add and its start and end date.<br>
  
  <form id="newsem"  class="form-horizontal" role="form">
  
  
   <div class="form-group">
  <label class="control-label col-sm-2" for="dob">Semester</label>
   <div class="col-sm-4">
    <select id="semsel" name="semsel" class="form-control">
      <option id="1">1</option>
      <option id="1">2</option>
</select>
</div>
</div>
  
  <div class="form-group">
  <label class="control-label col-sm-2" for="dob">Start Date</label>
  <div class="col-sm-4">
    <input id="startdate" name="startdate" placeholder="Start Date"  type="text" required="true" class="form-control">

  </div>

  
     <label class="control-label col-sm-2" for="dob">End Date</label>
  <div class="col-sm-4">
    <input id="enddate" name="enddate" placeholder="End Date"  type="text" required="true" class="form-control">
    </div>
  </div>
  
  </form>
  <div style="text-align:right"><button id="savettsem" class="btn btn-success" title="Save Semester"><span class="glyphicon glyphicon-floppy-disk"></span></button></div>
  </div>
  
  <div id="newsemtablediv" style="display:none">
   <h3>New Semester</h3>
  <table id="newsemtable" class="table"><tr><th>Semester</th><th>Start Date</th><th>End Date</th><th></th></tr></table>
  
  
  <div id="holsels">
   Add holiday periods for this semester?&nbsp;    <select id="existingsem1" name="existingsem1" class="form-control">
  <option id="0">-Select One-</option>
      <option id="1">Yes</option>
      <option id="2">No</option>
</select>
</div>
  </div>



  
  
 
<div id="newsemesterhols" style="display:none">
<h4>Select start and end dates for any holiday periods for this semester.</h4>
<table id="hols">
<tr>
  <td>
    <label for="dob">Start Date</label>
      </td>
  <td>

    <input id="hstartdate" name="hstartdate" placeholder="Start Date"  type="text" required="true" class="form-control">

  
  </td>
  <td>&nbsp;</td>
  <td>
     <label for="dob">End Date</label>
  </td>
  <td>

    <input id="henddate" name="henddate" placeholder="End Date"  type="text" required="true" class="form-control">

</td>
<td>&nbsp;</td>
<td><button id="savesperiod" class="btn btn-success" title="Add Holiday Period"><span class="glyphicon glyphicon-plus"></span></button></td>
 </tr>
</table>
 <div style="text-align:right"><button id="savesemhols" class="btn btn-success" title="Save Holiday Periods"><span class="glyphicon glyphicon-floppy-disk"></span></button></div>
<div id="holidaytablediv" style="display:none">
<table id="holidaytable" class="table"><tr><th>Start Date</th><th>End Date</th><th></th></tr></table>
</div>
  
 </div>
<div  class="modal-footer">
     <button id="canceltt"  class="btn btn-danger" data-dismiss="modal" title="cancel"><span class="glyphicon glyphicon-remove"></span></button>
    <button id="savettm" class="btn btn-success" style="display:none" data-dismiss="modal" title="save"><span class="glyphicon glyphicon-floppy-disk"></span></button>
    </div>
  </div>

  </div>

       
      </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
</html>