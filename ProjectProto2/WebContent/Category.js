/**
 * 
 */

$(document).ready( function () {
	
	
	var coursecols=null;
	var courserows=null;
	var catcols=null;
	var catrows=null;
	var oTable=null;
   //var table=$('#categorytable').DataTable();
    getCatData(0,function(){drawDataTable(catcols,catrows);});

    getUserForCourses();
    getCourseNamesForCourses(0,function(){alert("cs="+coursecols,"cr="+courserows);});
    
    
    
    
    function drawDataTable(columns, data) {
    
    	
        oTable = $('#datatable-sample').DataTable({
        	 
                "aoColumnDefs": columns,
                "aaData": data
               
        });
      
    };
    

    $('#viewc').click(function()
    		{
    	viewc();
    	getCourseNamesForCourses(0,function(){drawDataTable(coursecols,courserows);});
    
    		});
    		
    	
    	
    	function viewc()
    	{

    	$("#datatable-sample").dataTable().fnDestroy();
    	$("#viewc").hide();
    	$("#addcat1").hide();
    	$("#viewcat").show();
    	$("#addc").show();
    	$("#pagetitle").text('Courses');
    	
    	
    	
    		
    		};
    
    
    $('#viewcat').click(function()
    		{

    	$("#datatable-sample").dataTable().fnDestroy();
    	$("#viewc").show();
    	$("#addcat1").show();
    	$("#viewcat").hide();
    	$("#addc").hide();
    	$("#pagetitle").text('Categories');
    	
    	 getCatData(0,function(){drawDataTable(catcols,catrows);});
    	
    		//drawDataTable(catcols,catrows);
    		});
    
    
  
    
    
    $('#SubmitButtoncat').click(function()
    		{
    	bootbox.confirm("Are you sure you want to add this category", function(result) {if (result==true){insertCatCourse(1);};
    	});
    		});
    

    
    
    $('#CourseSubmitButton').click(function()
    {
    	bootbox.confirm("Are you sure you want to add this course?", function(result) {if (result==true){insertCatCourse(2);};
    	});
    	
    	
    	
    });
	$('#datatable-sample').on( 'click', '#viewc', function () {
		alert("alert hello");
		$("#datatable-sample").dataTable().fnDestroy();
		viewc();
		var b = $(this).closest('tr').find("td").eq(1).text();
		var a = $(this).closest('tr').find('td:first').text();
		$("#pagetitle").text(b+' Courses');
		getCourseNamesForCourses(a,function(){drawDataTable(coursecols,courserows);});
		
	});
	
    
	$('#datatable-sample').on( 'click', '#4', function () {
		alert("hello");
		
		var row=null;
		var rowid=null;
	
		var role=this.getAttribute('role');
		alert(role);
		var a = $(this).closest('tr').find('td:first').text();
	
		alert(a);
	
	    row=oTable
        .row( $(this).parents('tr') );
	    alert(row);
		rowid=this.id;
		
		
		alert(rowid);
		CompleteUpDel(a,row,rowid);
	    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
  	  
    	
	});


$('#datatable-sample').on( 'click', '#5', function () {
	alert("hello");
	
	var row=null;
	var rowid=null;

	var role=this.getAttribute('role');
	alert(role);
	var a = $(this).closest('tr').find('td:first').text();

	alert(a);

    row=oTable
    .row( $(this).parents('tr') );
    alert(row);
	rowid=this.id;
	
	
	alert(rowid);
	CompleteUpDel(a,row,rowid);
    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
	  
	});

	
    function CompleteUpDel(a,row,rowid)
    {
    	 bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
    });
    };

			
    
  
    
    
    
    function getCatData(a,callback){
		var dataString=null;
		
		var userdata=null;
		/*var rows = table
	    .rows()
	    .remove()
	    .draw();*/
		var button1=null;
		var button2=null;
		
		if(a==0)
			{
			dataString="instruct=1&archived=0";
		
			}
		else
		{
			
			dataString="instruct=1&archived=1";
		
		}
		
		
		
		$.ajax
		({
		type: "POST",
		url: "CategoryCourseRetrieve",
		dataType:"json",
		data: dataString,
		cache: false,
		success: function(data)
		{
		if(data.Category.length)
		{
			
			catcols = [{
		        "sTitle": "ID",
		            "mData": "categoryid",
		            "aTargets": [0]
		    }, {
		        "sTitle": "Name",
		            "mData": "catname",
		            "aTargets": [1]
		    }, {
		        "sTitle": "Description",
		            "mData": "catdescript",
		            "aTargets": [2]
		    },
		    {
		        "sTitle": "Courses",
		            "mData": "btn4",
		            "aTargets": [3]
		    },
		    {
		        "sTitle": "",
		            "mData": "btn1",
		            "bSortable": false,
		            "aTargets": [4]
		    },
		    {
		        "sTitle": "",
		            "mData": "btn2",
		            "bSortable": false,
		            "aTargets": [5]
		    },
		    {
		        "sTitle": "",
		            "mData": "btn3",
		            "bSortable": false,
		            "aTargets": [6]
		    }		    
		    ];
			
			catrows=data.Category;
			callback(catcols,catrows);
			
			
		$.each(data.Category, function(i,data)
		{
		
			
			

		setCatSels(data.categoryid,data.catname);
		
	
		//table.row.add(userdata).draw();
	

		});
	
		}
		else
		{
		$("#content").html("No Results");
		}
		}
		});
		alert("at end");
	return;
	};
	

	
	
	
				
				
				
				
				function getCourseNamesForCourses(a,callback)
				{
					dataString="instruct=2&archived="+a;
			
								$.ajax
								({
								type: "POST",
								url: "CategoryCourseRetrieve",
								dataType:"json",
								data: dataString,
								cache: false,
								success: function(data)
								{
								if(data.Category.length)
								{
									//data.Category.append("btn1:btn1");
									coursecols = [{
								        "sTitle": "CourseID",
								            "mData": "courseid",
								            "aTargets": [0]
								    }, {
								        "sTitle": "Name",
								            "mData": "coursename",
								            "aTargets": [1]
								    }, {
								        "sTitle": "Accreditation Body",
								            "mData": "acredbody",
								            "aTargets": [2]
								    },
								    {
								        "sTitle": "Level",
								            "mData": "level",
								            "aTargets": [3]
								    },
								    {
								        "sTitle": "",
								            "mData": "btn1",
								            "bSortable": false,
								            "aTargets": [4]
								    },
								    {
								        "sTitle": "",
								            "mData": "btn2",
								            "bSortable": false,
								            "aTargets": [5]
								    },
								    {
								        "sTitle": "",
								            "mData": "btn3",
								            "bSortable": false,
								            "aTargets": [6]
								    }
								    ];
									
									 // drawDataTable(columns, data.Category);
									courserows=data.Category;
									callback(coursecols,courserows);
									
								$.each(data.Category, function(i,data)
								{
							
									
								
									setCourseSels(data.courseid,data.coursename,data.level);
						
							 
								 //$("#usertable").append(userData).removeClass("hidden");
								});
								
							
								}
								else
								{
									$("#coursenamesel").append("- No Options -");
								}
								}
								});
							
							};
							
							
							
							function getUserForCourses()
							{
								dataString="archived=0,0&role=1,1";
											$.ajax
											({
											type: "POST",
											url: "GetUserData",
											dataType:"json",
											data: dataString,
											cache: false,
											success: function(data)
											{
											if(data.User.length)
											{
											
												   
												
											$.each(data.User, function(i,data)
											{
												
											
												
									
										
												var o = new Option("option text", "value");
												o.id=data.userid;
												/// jquerify the DOM object 'o' so we can use the html method
												$(o).html(data.fname +" " + data.lname);
												$("#tutorsel").append(o);
												
											
											 //$("#usertable").append(userData).removeClass("hidden");
											});
											
										
											}
											else
											{
												$("#tutorsel").append("- Select one -");
											}
											}
											});
										
										};
							
				
							   function setCourseSels(courseid,coursename,level)
							    {
									var o1 = new Option("option text", "value");
									o1.id=courseid;
									/// jquerify the DOM object 'o' so we can use the html method
									$(o1).html(coursename+" " +level);
									$("#coursenamesel").append(o1);
									
							    }
							   
							   function setCatSels(catid,catname)
							    {
									var o2 = new Option("option text", "value");
									o2.id=catid;
									/// jquerify the DOM object 'o' so we can use the html method
									$(o2).html(catid+ " " +catname);
									$("#catnamesel").append(o2);
									
							    }
				
				
				
				
				$('#coursenamesel').change(function() {
					
				var optionID=$('#coursenamesel option:selected').attr('id');
		
				if(optionID!="1")
					{
				 
					    $('#coursename').hide();
				    	$('#level').hide();
				    	$('#acrb').hide();
				}
				
				 
				});
				
				
				$('#courseName').change(function() {
					
			
				    //$('#coursenameseld').hide();
				
				});
				
				
	
	
	
    
    function insertCatCourse(a){
		var Data=null;
		if(a==1)
		{
		
		var name = $("#categoryName").val();
		var description = $("#catDescript").val();
		Data="instructid=1&name="+name+"&description="+description;
		}
		else
			{
			//var catid = $("#ncatname").val();
			//var catid2=$("#ncatname").getVal();
			var catid=$('#catnamesel option:selected').attr('id');
			alert("catid="+catid);
			//alert("catid="+catid2);
			var courseid=$('#coursenamesel option:selected').attr('id');
			var coursename = $("#courseName").val();
			alert("coursename="+coursename);
			var level=$('#level option:selected').attr('id');
			var accredbodname=$('#accreditbod').val();
			var tutorid=$('#tutorsel option:selected').attr('id');
			var semesterid=$('#semestersel option:selected').attr('id');
			var capacity=$('#capcity').val();
			var equipreq=$('#equipsel option:selected').attr('id');
			
			if(courseid!=1)
				{
				coursename="na";
				accredbodname="na";
				}
			
			
			Data=("instructid=2&catid="+catid+"&courseid="+courseid+"&coursename="+coursename+"&level="+level+"&accredbodname="
					+accredbodname+"&tutorid="+tutorid+"&semesterid="+semesterid+"&capacity="+capacity+"&equipreq="+equipreq);
			
			
			alert(Data);
			}
		
		
		$.ajax({
			type: "POST",
			url: "CategoryCourses",
			data: Data,
			dataType:"json",
			cache: false,
			success: function(data)
			{
				 $('#message').empty();
				 $('#sfmessage').empty();
				if(data.CatMessage.length)
				{
				$.each(data.CatMessage, function(i,data)
				{
				
				//var user_data="<div>"+data.fname + " "+data.lname + " " + data.address1+"</div>";
				messageid=data.messagecode;
				message=data.insertmessagestring;
			
			
				 $('#sfmessage').prepend(message);
			
				 
			
			
				});
			
					$('#ModalMessage').modal('show');
					$('#catModal').find('form')[0].reset();
					 $('#courseModal').find('form')[0].reset();
				
				
				}
				else
				{
				$("#content").html("No Results");
				}
				}
			});
    
    
    
    
    
};

function upDel(itemid,row,instruct)
{

	
	
	dataString="catcourseid="+itemid+"&instructid="+instruct;
	alert(dataString);
		
		$.ajax({
			type: "POST",
			url: "CategoryCourses",
			data: dataString,
			dataType:"json",
			cache: false,
			success: function(data)
			{
				 $('#sfmessage').empty();
				if(data.CatMessage.length)
				{
				$.each(data.CatMessage, function(i,data)
				{
				
				var messageid=data.messagecode;
				alert(messageid);
				var message=data.insertmessagestring;
				if(messageid==2)
					{
					  row
				        .remove()
				        .draw();
					
					}
			
				 $('#sfmessage').prepend(message);
				
				

				});
				$('#ModalMessage').modal('show');
				 
				}
				else
				{
				$("#content").html("No Results");
				}
				}
			});
};
		




			
			


//courseModal
});//on load