/**
 * 
 */

	$(document).ready( function () {
	var dayid=null;
	var timeid=null;
	var courseid=null;
	var roomid=null;
	var timecols=null;
	var timerows=null;
	var semid=null;
	var startdate=null;
	var enddate=null;
	var timetableid=null;
	var timetabletitle=null;
	
	initializePage();
	alert(timetableid);
	
	function initializePage(){
	getDataForSelectors(7,0,0,0);

	getDataForSelectors(1,0,0,0);
	
	getTableData(0,0,timeid,courseid,roomid,0,function(){drawtimetable(timecols,timerows);});
	$('#timetablecreator').hide();
	
	}
	
	
	
	$('#editttc').click(function(){
		$("#timetable").dataTable().fnDestroy();
		alert(timetableid);
		getTableData(10,0,timetableid,0,0,0,function(){drawtimetable(timecols,timerows);});
		$('#timetablecreator').show();
		$('#intialdiv').hide();
	
		$('#savec').show();
	
		
		
	});
	
	
	
	$('#edrafttt').click(function(){
		$("#timetable").dataTable().fnDestroy();
		getTableData(0,1,0,0,0,0,function(){drawtimetable(timecols,timerows);});
		$('#ttitle').text("Timetable (Draft)");
		$('#timetablecreator').show();
		$('#intialdiv').hide();
		$('#savett').show();
	
		$('#savewip').show();
		
		
		
	});
	
	
	$('#savec').click(function(){
		$("#timetable").dataTable().fnDestroy();
		 bootbox.confirm("Are you sure you want to save changes?", function(result) {if (result==true){saveTT(11,timetableid,function(result){if(result==true){getTableData(0,0,timeid,courseid,roomid,0,function(){drawtimetable(timecols,timerows);});}});};
		 });
			$('#timetablecreator').hide();
			$('#intialdiv').show();
		
		
	});
	
	
	
	
	
	
	$(function() {
		$( "#startdate" ).datepicker({changeYear: true,yearRange: "-0:+10",changeMonth:true,monthRange:"-0:+11",dateFormat: 'yy-mm-dd'});
		});
	$(function() {
		$( "#enddate" ).datepicker({changeYear: true,yearRange: "-0:+10",dateFormat: 'yy-mm-dd'});
		});
	$(function() {
		$( "#hstartdate" ).datepicker({changeYear: true,yearRange: "-0:+10",dateFormat: 'yy-mm-dd'});
		});
	$(function() {
		$( "#henddate" ).datepicker({changeYear: true,yearRange: "-0:+10",dateFormat: 'yy-mm-dd'});
		});
	


	
	
	
	$('#daysel').change(function() {
	
		
		dayid=$('#daysel option:selected').attr('id');
		
		if(dayid!=-1)
		{
	
		getDataForSelectors(2,dayid,0,0);
		$("#timesel").removeAttr("disabled");

		}
		
	});
	
	$('#timesel').change(function() {
		
		
		timeid=$('#timesel option:selected').attr('id');
	
		if(timeid!=-1)
		{
	
		getDataForSelectors(3,dayid,timeid,0);
		$("#coursesel").removeAttr("disabled");
		}
	
	});
	$('#coursesel').change(function() {

		
		courseid=$('#coursesel option:selected').attr('id');
	
		if(courseid!=-1)
		{
	
		getDataForSelectors(4,dayid,timeid,courseid);
		$("#roomsel").removeAttr("disabled");
		}
	
	});
	
	$('#roomsel').change(function() {
	
		
		roomid=$('#roomsel option:selected').attr('id');
		
		
	
	});
	
	
	
	 $('#timetable').on( 'click', '#deleteE', function () {
		 $("#timetable").dataTable().fnDestroy();
			var dayid1=this.getAttribute('day');
			var timeid1=this.getAttribute('time');
			var courseid1=this.getAttribute('course');
			
			bootbox.confirm("Are you sure you want to delete this entry?", function(result) {if (result==true){deleteCellObject(2,dayid1,timeid1,courseid1,timetableid,function(result){if(result==true){alert("ok"),getTableData(0,1,0,0,0,0,function(){drawtimetable(timecols,timerows);});}});
					
					
					
			}
			});		
		
			 
		 
		 });
	 
	 
	 $('#savewip').click(function(){
		 bootbox.confirm("Are you sure you want to save this draft?", function(result) {if (result==true){saveTT(3,0,function(result){if(result==true){alert("ok");}});};
		 });
	 });
	 
	 $('#savettsem').click(function(){
		 startdate=$('#startdate').val();
		 enddate=$('#enddate').val();
		 var semester=$('#semsel').val();
			 
		 InsertSem(5,startdate,enddate,semester,function(semesterid){$("#newsemtable").append("<tr><td>" + semester + "</td><td>" + startdate + "</td><td>" + enddate + "</td></tr>");});
		 $('#newsemtablediv').show();
		 $('#newsemdiv').hide();
	        
		 
		 
		
		 
	 });
		 
	
	

	
	
	$('#existingsem').change(function () {
		
	
	        
	        var id=$('#existingsem').val();
	        alert(id);
	        if(id=="Yes")
	        {
	        getSemesterDetails();
	        $('#semtablediv').show();
	        $('#savettm').show();
	      
	        }
	        else
	        	{
	        	$('#newsemdiv').show();
	        	
	        	}
	        
	        $('#intialdiv').hide();
	        
	      
	     
	    
	    
	  });
	
	$('#existingsem1').change(function () {
		
		
        
        var id=$('#existingsem1').val();
        alert(id);
        if(id=="Yes")
        {
        getSemesterDetails();
        $('#newsemesterhols').show();
        $('#holsels').hide();
      
        }
    
        $('#savesemhols').hide();
        $('#savettm').show();
     
    
    
  });
	
	
	

	 $('#hols').on( 'click', '#savesperiod', function () {
		 
		var hstartdate = $(this).closest('tr').find('#hstartdate').val();
	    var henddate = $(this).closest('tr').find('#henddate').val();
		 InsertSem(6,hstartdate,henddate,semid,function(result){if(result==1){$('#hols').append("<tr><td><label for='dob'>Start Date</label></td><td><input id='hstartdate' name='hstartdate' placeholder='Start Date'  type='text' required='true' class='form-control'></td><td>&nbsp;</td><td><label for='dob'>End Date</label></td><td><input id='henddate' name='henddate' placeholder='End Date'  type='text' required='true' class='form-control'></td><td>&nbsp;</td><td><button id='savesperiod' class='btn btn-success' title='Add Holiday Period'><span class='glyphicon glyphicon-plus'></span></button></td></tr>");}});
		 
	 });
	
	
	
	
	
	 $('#semtable').on( 'click', '#semcheck', function () {
		
		alert("hello");
	    if($(this).is(":checked")) {
	    	
	    	semid=this.getAttribute('name');
	        
	        
	        alert(semid);
	    
	        
	       
	      
	     
	    }
	    
	  });
	 
	 
	 $('#savettm').click(function(){
		alert("oala");
		 saveTT(4,semid,function(result){if(result==true){alert("ok");}});
		 
		 
	 });
	 
	 
	 
	 //this function adds a new timetable cell entry when button pressed
		$('#adde').click(function(){
			
			$("#timetable").dataTable().fnDestroy();
			
			refreshSels();
				var o1 = new Option("option text", "value");
				$(o1).html("- Select One-");	
				$(o1).prependTo('#daysel');

			//roomid=$('#roomsel option:selected').attr('id');
				addNewCellObject(1,dayid,timeid,courseid,roomid,timetableid,1,function(){drawtimetable(timecols,timerows), getDataForSelectors(1,0,0,0);});
			
		});
		
		
		
		$('#refreshsels').click(function(){
			refreshSels();
		});
	function refreshSels()
	{
		
		
		 $('#daysel')
		 	.find('option')
		    .remove()
		    .end();
		 
		 $('#timesel')
		 	.find('option')
		    .remove()
		    .end();
		 $('#coursesel')
		 	.find('option')
		    .remove()
		    .end();
		 $('#roomsel')
		 	.find('option')
		    .remove()
		    .end();
		 $("#roomsel").attr("disabled", "disabled");
		 $("#timesel").attr("disabled", "disabled");
		 $("#coursesel").attr("disabled", "disabled");
		 $("#daysel").removeAttr("disabled");
		
	};
	
	

	
	
	function drawtimetable(columns,data){
	
			    
		    
		        oTable = $('#timetable').DataTable({
		        	 
		                "aoColumnDefs": columns,
		                "aaData": data
		        
		               
		        });
		        $('#timetable th:nth-child(1)').hide();
		        $('#timetable td:nth-child(1)').hide();
		        $('#timetable_length').hide();
		      
		    };
		    
		    
		    
function getSemesterDetails(){
	
	
	dataString="instruct=5";
	
	$.ajax
	({
	type: "POST",
	url: "TimeTableRetrieve",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData.length)
	{
		

		//callback(id,name);
		
		
	$.each(data.TimeTableData, function(i,data)
	{
	
		
		

		 $("#semtable").append("<tr><td>" + data.semid + "</td><td>" + data.startdate + "</td><td>" + data.endate + "</td><td><input type='checkbox' id='semcheck' name='"+data.id+"'></td></tr>");


	});



	}

	}
	});
	alert("at end");
return;
};

	

		    
	
		
	  

function getDataForSelectors(a,b,c,d)
{
	var sel=null;
	dataString="instruct="+a+"&attrib1="+b+"&attrib2="+c+"&attrib3="+d;
	
	if(a==1)
		
	{
		

		sel="#daysel";
		 $(sel)
		 	.find('option')
		    .remove()
		    .end();
		 $('#timesel')
		 	.find('option')
		    .remove()
		    .end();
		 $("#timesel").attr("disabled", "disabled");
		 $('#coursesel')
		 	.find('option')
		    .remove()
		    .end();
		 $("#coursesel").attr("disabled", "disabled");
		 $('#roomsel')
		 	.find('option')
		    .remove()
		    .end();
		 $("#roomsel").attr("disabled", "disabled");
			
	
		
	}
	if(a==2)
	{
		 $("#daysel").attr("disabled", "disabled");
		sel="#timesel";
		 $(sel)
		 	.find('option')
		    .remove()
		    .end();
		 $('#coursesel')
		 	.find('option')
		    .remove()
		    .end();
		 $('#roomsel')
		 	.find('option')
		    .remove()
		    .end();
		
	}
	if(a==3)
	{
		 $("#timesel").attr("disabled", "disabled");
		sel="#coursesel";
		 $(sel)
		 	.find('option')
		    .remove()
		    .end();
		 $('#roomsel')
		 	.find('option')
		    .remove()
		    .end();
		
	}
	if(a==4)
	{
		 $("#coursesel").attr("disabled", "disabled");
		sel="#roomsel";
		
	}
	if(a==7)
		{
		sel="#timetableselect";
		}
	if(a==8)
		{
		dataString="instruct="+a+"&timetableid="+b;
		}
	
	 /*$("#coursenamesel")
	 	.find('option')
	    .remove()
	    .end();*/

	$.ajax
	({
	type: "POST",
	url: "TimeTableRetrieve",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData.length)
	{
		

		//callback(id,name);
		
		
	$.each(data.TimeTableData, function(i,data)
	{
	
		
		if(a==7)
			{
			setTimeTableSel(data.id,data.iname,sel);
			}
		else if(a==8)
			{
			displayid="Semester: "+data.id+" Year: "+data.iname;
			}
		else
			{
			setdaySels(data.id,data.iname,sel);
			}

	
	//table.row.add(userdata).draw();


	});
	
	if(a!=7)
	{
	var o1 = new Option("option text", "value");
	$(o1).html("- Select One-");	
	$(o1).prependTo(sel);
	}
	
	

	}

	}
	});
	alert("at end");
return;
};




function InsertSem(instruct,startdate,enddate,semester,callback)
{
	
	dataString="instruct="+instruct+"&semester="+semester+"&startdate="+startdate+"&enddate="+enddate;
	
	
	$.ajax
	({
	type: "POST",
	url: "TimeTableInsert",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData1.length)
	{
		
		 $('#sfmessage').empty();
			$.each(data.TimeTableData1, function(i,data)
					{
					
						
						

					


				
	

			semid=data.messagecode;
			message=data.insertmessagestring;
		
		
		
	
		
			 
		
					});
		
		
			
				callback(semid);

				};

				//

				} //
				});
				alert("at end");
				return;
				};






function saveTT(instruct,semester,callback)
{
	
	dataString="instruct="+instruct+"&semid="+semester;
	
	
	$.ajax
	({
	type: "POST",
	url: "TimeTableInsert",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData1.length)
	{
		
		 $('#sfmessage').empty();
			$.each(data.TimeTableData1, function(i,data)
					{
					
						
						

					


				
	

			messageid=data.messagecode;
			message=data.insertmessagestring;
		
		
		
			 $('#sfmessage').prepend(message);
		
			 
		
					});
		if(messageid=="1"){
		callback(true);
		}
		
		
				$('#ModalMessage').modal('show');


				};

				//

				} //
				});
				alert("at end");
				return;
				};

				
function deleteCellObject(instruct,b,c,d,e,callback){

	
	dataString="instruct="+instruct+"&dayid="+b+"&timeid="+c+"&courseid="+d+"&timetableid="+e;
	$.ajax
	({
	type: "POST",
	url: "TimeTableInsert",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData1.length)
	{
	
		$.each(data.TimeTableData1, function(i,data)
				{

			messageid=data.messagecode;
			
		
		
		
			
		
			 
		
					});
		if(messageid=="1"){
		callback(true);
		}


	} //

	} //
	});
	alert("at end");
	return;
	};
				
function addNewCellObject(instruct,dayid,timeid,courseid,roomid,timetableid,table,callback)
{
				
	dataString="instruct="+instruct+"&dayid="+dayid+"&timeid="+timeid+"&courseid="+courseid+"&roomid="+roomid+"&timetableid="+timetableid+"&table="+table;
	$.ajax
	({
	type: "POST",
	url: "TimeTableInsert",
	dataType:"json",
	data: dataString,
	cache: false,
	success: function(data)
	{
	if(data.TimeTableData1.length)
	{		
	
		timecols = [{
			
		    "sTitle": "",
		    "mData": "id",
		    "bSortable": false,
		    "aTargets": [0]
			},
			{ "sTitle": "",
			    "mData": "iname",
			    "bSortable": false,
			    "aTargets": [1]
			},
			{"sTitle": "09.00",
			            "mData": "cell",
			            "bSortable": false,
		            "aTargets": [2]
		    }, {
		        "sTitle": "10.00",
		            "mData": "cell1",
		            "bSortable": false,
		            "aTargets": [3]
		    }, {
		        "sTitle": "11.00",
		            "mData": "cell2",
		            "bSortable": false,
		            "aTargets": [4]
		    },
		    {
		        "sTitle": "12.00",
		            "mData": "cell3",
		            "bSortable": false,
		            "aTargets": [5]
		    },
		    {
		        "sTitle": "13.00",
		            "mData": "cell4",
		            "bSortable": false,
		            "aTargets": [6]
		    },
		    {
		        "sTitle": "14.00",
		            "mData": "cell5",
		            "bSortable": false,
		            "aTargets": [7]
		    },
		    {
		        "sTitle": "15.00",
		            "mData": "cell6",
		            "bSortable": false,
		            "aTargets": [8]
		    },	
		    {
		        "sTitle": "16.00",
		            "mData": "cell7",
		            "bSortable": false,
		            "aTargets": [9]
		    },
		    {
		        "sTitle": "17.00",
		            "mData": "cell8",
		            "bSortable": false,
		            "aTargets": [10]
		    },
		    {
		        "sTitle": "18.00",
		            "mData": "cell9",
		            
		            "aTargets": [11]
		    }
		    ];
			
			timerows=data.TimeTableData1;
			
			callback(timecols,timerows);
			
			
			$.each(data.TimeTableData1, function(i,data)
					{
					timetableid=data.id;
					
						
					});


			
			


		} //

		} //
		});
		alert("at end");
		return;
		};
				
				
	
function getTableData(instruct,b,c,d,e,f,callback)
{
	
	if(instruct==10)
	{
		dataString="instruct="+instruct+"&table="+b+"&timetableid="+c;	
	}
	else
	{
	dataString="instruct="+instruct+"&table="+b;
	}
	alert(dataString);
$.ajax
({
type: "POST",
url: "TimeTableInsert",
dataType:"json",
data: dataString,
cache: false,
success: function(data)
{
if(data.TimeTableData1.length)
{

timecols = [{
	
    "sTitle": "",
    "mData": "id",
    "bSortable": false,
    "aTargets": [0]
	},
	{ "sTitle": "",
	    "mData": "iname",
	    "bSortable": false,
	    "aTargets": [1]
	},
	{"sTitle": "09.00",
	            "mData": "cell",
	            "bSortable": false,
            "aTargets": [2]
    }, {
        "sTitle": "10.00",
            "mData": "cell1",
            "bSortable": false,
            "aTargets": [3]
    }, {
        "sTitle": "11.00",
            "mData": "cell2",
            "bSortable": false,
            "aTargets": [4]
    },
    {
        "sTitle": "12.00",
            "mData": "cell3",
            "bSortable": false,
            "aTargets": [5]
    },
    {
        "sTitle": "13.00",
            "mData": "cell4",
            "bSortable": false,
            "aTargets": [6]
    },
    {
        "sTitle": "14.00",
            "mData": "cell5",
            "bSortable": false,
            "aTargets": [7]
    },
    {
        "sTitle": "15.00",
            "mData": "cell6",
            "bSortable": false,
            "aTargets": [8]
    },	
    {
        "sTitle": "16.00",
            "mData": "cell7",
            "bSortable": false,
            "aTargets": [9]
    },
    {
        "sTitle": "17.00",
            "mData": "cell8",
            "bSortable": false,
            "aTargets": [10]
    },
    {
        "sTitle": "18.00",
            "mData": "cell9",
            
            "aTargets": [11]
    }
    ];
	
	timerows=data.TimeTableData1;
	
	callback(timecols,timerows);
	
	
	$.each(data.TimeTableData1, function(i,data)
			{
			timetableid=data.id;
			timetabletitle=data.timetabletitle;
			
			});

	$('#ttitle').text("Timetable- "+timetabletitle);
	
	


} //

} //
});
alert("at end");
return;
};

	
	
	function setdaySels(id,name,sel)
	{
		var o = new Option("option text", "value");
		o.id=id;
		o.value=id;
		/// jquerify the DOM object 'o' so we can use the html method
		
		$(o).html(name);
	
		$(sel).append(o);
		
	};
	
	
	
	function setTimeTableSel(id,name,sel)
	{
		var o = new Option("option text", "value");
		o.id=id;
		o.value=id;
	
			$(o).html("Semester: "+id+"Year: "+name);
			
		$(sel).append(o);
		
	};
	
	

});




