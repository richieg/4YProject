/**
 * 
 */
$(document).ready( function () {
getTutorTableData(20,404156,function(){drawtimetable(timecols,timerows);});
getTutorSchedule(15,404156);

	
	function drawtimetable(columns,data){
	
			    
		    
		        oTable = $('#timetable').DataTable({
		        	 
		                "aoColumnDefs": columns,
		                "aaData": data
		        
		               
		        });
		        $('#timetable th:nth-child(1)').hide();
		        $('#timetable td:nth-child(1)').hide();
		        $('#timetable_length').hide();
		      
		    };
		    




function getTutorTableData(instruct,tutorid,callback)
{

	dataString="instruct="+instruct+"&table=0&tutorid="+tutorid;
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


function getTutorSchedule(instruct,tutorid)
{

	dataString="instruct="+instruct+"&tutorid="+tutorid;
	alert(dataString);

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


	
	
	$.each(data.TimeTableData, function(i,data)
			{
		
		
		
		$("#schedule").append("<tr><td>" + data.cell + "</td><td>" + data.cell1 + "</td><td>" + data.cell2 + "</td><td>" + data.cell3 + "</td></tr>");

			});


	
	


} //

} //
});
alert("at end");
return;
};


//



});
