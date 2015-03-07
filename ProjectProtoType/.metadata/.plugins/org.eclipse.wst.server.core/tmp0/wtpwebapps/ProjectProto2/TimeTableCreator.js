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
	getDataForSelectors(1,0,0,0);
	getTableData(0,dayid,timeid,courseid,roomid,function(){drawtimetable(timecols,timerows);});
	
	
	
	$('#nt').click(function(){
		alert("button hot");
	
		getDataForSelectors(1,0,0,0);

		
	});
	
	


	
	
	
	$('#daysel').change(function() {
		alert("hello");
		
		dayid=$('#daysel option:selected').attr('id');
		alert(dayid);
		if(dayid!=-1)
		{
		alert("ok");
		getDataForSelectors(2,dayid,0,0);
		}
		
	});
	
	$('#timesel').change(function() {
		alert("hello");
		
		timeid=$('#timesel option:selected').attr('id');
		alert(timeid);
		if(timeid!=-1)
		{
		alert("ok");
		getDataForSelectors(3,dayid,timeid,0);
		}
	
	});
	$('#coursesel').change(function() {
		alert("hello");
		
		courseid=$('#coursesel option:selected').attr('id');
		alert(timeid);
		if(courseid!=-1)
		{
		alert("ok");
		getDataForSelectors(4,dayid,timeid,courseid);
		}
	
	});
	
	$('#roomsel').change(function() {
		alert("hello");
		
		roomid=$('#roomsel option:selected').attr('id');
		alert(roomid);
		
	
	});
	
	
	
	 $('#timetable').on( 'click', '#deleteE', function () {
		 
			var dayid=this.getAttribute('day');
			var timeid=this.getAttribute('time');
			var courseid=this.getAttribute('course');
			alert(dayid);
			alert(timeid);
			alert(courseid);
			 
		 
		 });
		 
	
	
	$('#adde').click(function(){
		alert("button hot");
		$("#timetable").dataTable().fnDestroy();
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
			var o1 = new Option("option text", "value");
			$(o1).html("- Select One-");	
			$(o1).prependTo('#daysel');

		//roomid=$('#roomsel option:selected').attr('id');
		getTableData(1,dayid,timeid,courseid,roomid,function(){drawtimetable(timecols,timerows);});
		
	});
	
	

	
	
	function drawtimetable(columns,data){
	
			    
		    	alert("got to here");
		        oTable = $('#timetable').DataTable({
		        	 
		                "aoColumnDefs": columns,
		                "aaData": data
		        
		               
		        });
		        $('#timetable th:nth-child(1)').hide();
		        $('#timetable td:nth-child(1)').hide();
		      
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
		 $('#coursesel')
		 	.find('option')
		    .remove()
		    .end();
		 $('#roomsel')
		 	.find('option')
		    .remove()
		    .end();
			
	
		
	}
	if(a==2)
	{
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
		sel="#roomsel";
		
	}
	
	
	 $("#coursenamesel")
	 	.find('option')
	    .remove()
	    .end();

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
	
		
		

		setdaySels(data.id,data.iname,sel);
	
	//table.row.add(userdata).draw();


	});
	var o1 = new Option("option text", "value");
	$(o1).html("- Select One-");	
	$(o1).prependTo(sel);


	}

	}
	});
	alert("at end");
return;
};

	
function getTableData(instruct,b,c,d,e,callback)
{
	if(instruct==1)
	{
	dataString="instruct="+instruct+"&attrib1="+b+"&attrib2="+c+"&attrib3="+d+"&attrib4="+e;
	}
	else
	{
	dataString="instruct="+instruct;
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
	
	
$.each(data.TimeTableData, function(i,data)
{

	alert(data.iname);
	

//setCatSels(data.categoryid,data.catname);


//table.row.add(userdata).draw();


});

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
		/// jquerify the DOM object 'o' so we can use the html method
		$(o).html(name);
		$(sel).append(o);
		
	};
	

});




