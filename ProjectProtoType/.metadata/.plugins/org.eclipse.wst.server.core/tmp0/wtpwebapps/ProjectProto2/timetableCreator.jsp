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
<div id="selects div" class="container-fluid">
<div class="center-block">
<table>

<tr>
 
  
  






<td>
 <label class="control-label col-sm-1" for="day" >Day</label>
</td>
<td>
  <select class="form-control" id="daysel" name="daysel">
      <option id="-1">- Select Day -</option>
</select>

</td>

<td>
  <label class="control-label col-sm-1" for="cours">Time</label>
</td>
<td>
  <select class="form-control" id="timesel" name="timesel">
      <option id="-1">- Select Time -</option>
</select>

</td>



<td>
  <label class="control-label col-sm-1" for="coursename">Course</label>

</td>
<td>
  <select class="form-control" id="coursesel" name="coursesel">
      <option id="-1">- Select Course -</option>
</select>

</td>
<td>
  <label class="control-label col-sm-1" for="room">Room</label>

</td>
<td>
  <select class="form-control" id="roomsel" name="roomsel">
      <option id="-1">- Select Room -</option>
</select>


</td>
<td>
<button class="btn btn-success"  id="adde"><span class="glyphicon glyphicon-plus"></span></button>
</td>

</tr>

</table>
</div>
</div>

 <div id="timetablediv"><table class="display" id="timetable" width="100%" cellspacing="0"></table></div>

</body>
</html>