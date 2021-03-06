/**
 * 
 */

$(document).ready( function () {
	
	
	var coursecols=null;
	var courserows=null;
	var catcols=null;
	var catrows=null;
	var oTable=null;
	var ocTable=null;
	var osTable=null;
	var osrTable=null;
	var studentcols=null;
	var studentrows=null;
	var students=[];
	var myBackup=null;
	
	 intializePage();
	 

	 
	 
	 
	 
	    
	    function intializePage(){
	    	   getCatData(0,function(){drawDataTable(catcols,catrows);});

	    	    
	    	   getCourseDetailsForCoursesTable(0,function(){drawDataTable1(coursecols,courserows);});
	    	    $('#coursediv').hide();
	    
	    	
	    	
	    };
	    
	    function resetCourseTable(c)
	    {
	    	
	    	$("#courses").dataTable().fnDestroy();
	    	
	    	getCourseDetailsForCoursesTable(c,function(){drawDataTable1(coursecols,courserows);});
	    };
	    
	    
	    function resetCatTable(ca)
	    {
	    	
	    	
	    	  getCatData(ca,function(){drawDataTable(catcols,catrows);});
	    };
	    function resetStudentTable(a,i,b)
	    {
	    	
	    	
	   
	    	/*if($("#students").aoData.length>0)
	    		{
	    		alert("hello");
	    		$("#students").dataTable().fnDestroy();
	    		}*/
	    	getUserForCourses(0,0,a,i,b,function(){drawStudentTable(studentcols,studentrows);});
	    };
	 
	    
	    
	    function drawDataTable(columns, data) {
	    
	    	
	        oTable = $('#category').DataTable({
	        	 
	                "aoColumnDefs": columns,
	                "aaData": data
	               
	        });
	      
	    };
	    
	   function drawDataTable1(columns, data) {
	    
	    	
	        ocTable = $('#courses').DataTable({
	        	 
	                "aoColumnDefs": columns,
	                "aaData": data
	               
	        });
	      
	    };
	    
	   function drawStudentTable(columns, data,instruct) {
	    
	    	
	        osTable = $('#students').DataTable({
	        	 
	                "aoColumnDefs": columns,
	                "aaData": data
	               
	        });
	        //if(instruct==3)
	        //{
	        //$('#students').append('<td></td><td></td><td></td><td></td><td><button id="SubmitButtonstudents" class="btn btn-primary" data-dismiss="modal">Add Selected Students</button></td>');
	        //}
	    };
	    
function drawStudentRecsTable(columns, data,instruct) {
	    
	    	
	        osrTable = $('#studentrecs').DataTable({
	        	 
	                "aoColumnDefs": columns,
	                "aaData": data
	               
	        });
	        //if(instruct==3)
	        //{
	        //$('#students').append('<td></td><td></td><td></td><td></td><td><button id="SubmitButtonstudents" class="btn btn-primary" data-dismiss="modal">Add Selected Students</button></td>');
	        //}
	    };
	
	 
  /*******************Modal Reset Function*******************************************************/
		function resetModal(modal,myBackup)
		{
			
			$(modal).modal('hide').remove();
			 var myClone = myBackup.clone();
		        $('body').append(myClone);
		       
		};
 
    

  /*********************Button Event Functions************************************************************/  
		
		
 /*
  * Functions to reset modals 
  * when they have been closed to 
  * ensure data not cached
  * */

	$('#closecor').click(function()
		{
		bootbox.confirm("Are you sure you want to cancel without saving?", function(result) {if (result==true){resetModal('#courseModal',myBackup);}else{$('#courseModal').modal('show');}});

		});
	$('#closecat').click(function()
		{
		bootbox.confirm("Are you sure you want to cancel without saving?", function(result) {if (result==true){resetModal('#catModal',myBackup);}else{$('catModal').modal('show');}});

		});
		
		
/*Function call to detect when 
 * "View Courses" 
 * button selected
 * */ 
    $('#viewc').click(function()
    	{
		     	viewc();
		     	resetCourseTable(0);
    	});
    $('#viewallc').click(function()
        	{
    				
    		
    			 
    				$("#students").dataTable().fnDestroy();
    				
    		     	viewc();
    		     	resetCourseTable(0);
    		     	 $('#viewallc').hide();
    		     	
        	});
    $('#viewallcs').click(function()
        	{
    				
    		
    			 
    				$("#studentrecs").dataTable().fnDestroy();
    				
    		     	viewc();
    		     	resetCourseTable(0);
    		     	 $('#viewallcs').hide();
    		     	$('#studentrecsdiv').hide();
        	});
    
 /*
  * Function call when 
  * "Add Course" button selected 
  * in the course view
  * */   
    
	$('#addc').click(function () 
			{
				myBackup = $('#courseModal').clone();
				getTutorsForTutorSels(0);
				getCourseNamesforSels(0);
				$('#ncatnamedd').hide();
				$('#ncatnamed').show();
				$('#ccatnamesel').show();
				$("#courseModal").modal('show');




			});
	
	
	
/*
 * Function called when 
 * Add Student Button 
 * selected on course table
 * 
 * */
	
	$('#courses').on( 'click', '#addstudents', function () 
	{
	
	
		
		var a = $(this).closest('tr').find('td:first').text();
		var b = $(this).closest('tr').find("td").eq(6).text();
		var instruct=3;
		getUserForCourses(0,0,a,instruct,b,function(){drawStudentTable(studentcols,studentrows,instruct);});
		 students[0]=$(this).closest('tr').find('td:first').text();
		 $('#pagetitle').text("Students");
		$("#coursediv").hide();
		$("#studentrecsdiv").hide();
		$("#studentdiv").show();
		$('#addcat1').hide();
    	$('#viewcat').hide();
    	$('#addc').hide();
    	$('#viewallc').show();
    	$('#viewallcs').hide();
	
	
	
	
	});
	
	
	
	/*
	 * Function called when 
	 * View Students Button 
	 * selected on course table
	 * 
	 * */	
	
	
	
	    $('#courses').on( 'click', '#viewcs', function () {
	    	
	    
	    	
	    	
	    	var courseid= $(this).closest('tr').find('td:first').text();
	    	var coursename= $(this).closest('tr').find("td").eq(1).text();
	    	$('#pagetitle').text(coursename+" Participants");
	    	$('#scourseID').val(courseid);
	    	$('#addcat1').hide();
	    	$('#viewcat').hide();
	    	$('#addc').hide();
	    	$('#viewallcs').show();
	    	$('#viewallc').hide();
	    	var instruct=4;
	    	//alert($('#scourseID').val());
	    	//resetStudentTable(a,4,0);
	    
	    	getUserForCourses(0,0,courseid,instruct,0,function(){drawStudentRecsTable(studentcols,studentrows,instruct),$('#coursediv').hide(),$('#studentrecsdiv').show();});
	    	
	    	
	    });
	    
	    
		/*
		 * Function called when 
		 * Delete Course Button 
		 * selected on course table
		 * 
		 * */
	    
	    
	    
		$('#courses').on( 'click', '#deleteCourse', function () {
			
			
			var row=null;
			var rowid=null;
		
	
			var a = $(this).closest('tr').find('td:first').text();
			row=ocTable
		    .row( $(this).parents('tr') );
			rowid=5;
		    CompleteUpDel(a,row,rowid);
		   
			  
			});

		/*
		 * Function called when 
		 * Edit Course Button 
		 * selected on course table
		 * 
		 * */

		$('#courses').on( 'click', '#editCourse', function () {
		
			var tid=this.getAttribute('tid');
			
			getTutorsForTutorSels(tid);
		
		
			var a = $(this).closest('tr').find('td:first').text();
			var b = $(this).closest('tr').find("td").eq(1).text();
			var c = $(this).closest('tr').find("td").eq(6).text();
		
			
			$('#cccatid').val(a);
			$("#courseName").val(b);
			$("#capacity").val(c);
			$("#coursename").hide();
			$("#ccatname").hide();
			$("#coursenameseld").hide();
			$("#acrb").hide();
			
			$("#sem").hide();
			$("#req").hide();
			$("#level").hide();
			$("#ccatnamesel").hide();
			
			$("#CourseUpdateButton").show();
			$("#CourseSubmitButton").hide();
			$("#courseModalLabel").val("Edit Course");
			$("#coursetitle").text("Course: "+b);
			

		
		    row=ocTable
		    .row( $(this).parents('tr') );
		   
		    
		    	rowid=this.id;
		    	$('#courseModal').modal('show');
			});
		
		
		
			
		    $('#CourseUpdateButton').click(function(){
		    		
		    		bootbox.confirm("Are you sure you want to update this course?", function(result) {if (result==true){updateCourse(7),resetCourseTable(0);};
		    		
		    		
		    	});
			
			
			  
			});
		    
	
    
	/*
	 * Function call when 
	 * "View Courses" button 
	 * on category table selected
	 * */    
		$('#category').on( 'click', '#viewc', function () {
			
			
			viewc();
			var b = $(this).closest('tr').find("td").eq(1).text();
			var a = $(this).closest('tr').find('td:first').text();
			
			$("#pagetitle").text(b+' Courses');
			resetCourseTable(a);
			
	
			
		});
	
	
	/*
	 * Function call when 
	 * Add Course" button 
	 * on category table selected
	 * */
		
		$('#category').on( 'click', '#addcourse', function () {
			myBackup = $('#courseModal').clone();
			getTutorsForTutorSels(0);
			var a = $(this).closest('tr').find('td:first').text();
			var b = $(this).closest('tr').find("td").eq(1).text();
			getCourseNamesforSels(a);
			$('#cccatid').val(a);
			$("#catnamesel option[id='"+a+"']").attr('selected', 'selected');
			$('#catName').val(b);
			$("#courseModal").modal('show');
			console.log(studentcols,studentrows);
			
		});
		
		
		/*
		 * Function call when 
		 * Delete Category button 
		 * on category table selected
		 * */
		
		
		$('#category').on( 'click', '#deleteCat', function () {
			
			var row=null;
			var role=this.getAttribute('role');
	
			var a = $(this).closest('tr').find('td:first').text();
			row=oTable
	        .row( $(this).parents('tr') );
		    CompleteUpDel(a,row,4);
		   });
    		
	/*
	 * Function to set up courses view
	 * */   	
	    	
	    	function viewc()
	    	{
	
			    	$("#catdiv").hide();
			        $("#coursediv").show();
			        $("#studentdiv").hide();
			    	$("#viewc").hide();
			    	$("#addcat1").hide();
			    	$("#viewcat").show();
			    	$("#addc").show();
			    	$("#pagetitle").text('Courses');
	    	
	    	};
    
	/*
	 * Function called when "View Categories"
	 *  button pressed on courses page
	 * */ 
	    	$('#viewcat').click(function()
	    	{
		    	$("#category").dataTable().fnDestroy();
		    	$("#catdiv").show();
		    	$("#coursediv").hide();
		    	$("#studentsdiv").hide();
		    	$("#viewc").show();
		    	$("#addcat1").show();
		    	$("#viewcat").hide();
		    	$("#addc").hide();
		    	$("#pagetitle").text('Categories');
		    	
	    	
		    	getCatData(0,function(){drawDataTable(catcols,catrows);});
	    	 
	    	
	    	});
	    
    
 
    
  
    
  
    
    
    $('#SubmitButtoncat').click(function()
    		{
    	bootbox.confirm("Are you sure you want to add this category", function(result) {if (result==true){updateCatCourse(1,function(result){if(result==true){resetCatTable(0),resetModal('#catModal',myBackup)
    		;}});};
    	});
    		});
    
    
 
    

    
    
    $('#CourseSubmitButton').click(function()
    {
  
    	bootbox.confirm("Are you sure you want to add this course?", function(result) {if (result==true){insertCatCourse(2,function(result){if(result==true){resetCatTable(0),resetModal('#courseModal',myBackup)
    		;}});};
    	});
    	
    	
    	
    });

	
	
	













		
	
	
    







	$('#category').on( 'click', '#editCat', function () {
			
				
				var row=null;
			
			
		
				var a = $(this).closest('tr').find('td:first').text();
				var b = $(this).closest('tr').find("td").eq(1).text();
				var c = $(this).closest('tr').find("td").eq(2).text();
				
		
				$('#catID').val(a);
				$('#categoryName').val(b);
				$('#catDescript').val(c);
				$('#SubmitButtoncat').hide();
				$('#catModalLabel').text('Update Category');
				$('#catFormLabel').text('Update Category');
				$('#UpdateButtoncat').show();
				$('#catModal').modal('show');
				
			
			    row=oTable
			    .row( $(this).parents('tr') );
			  
			    
			    	rowid=this.id;
			});
			    
			$('#UpdateButtoncat').click(function(){
				
				bootbox.confirm("Are you sure you want to update this category?", function(result) {if (result==true){updateCatCourse(6,function(result){if(result==true){resetCatTable(0);}});};
				
				});
			});
	
	
	//CompleteUpDel(a,row,rowid);
    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
	  
			
  /**************************Course Table Buttons**********************************/
			

	    
	    

	    
	    
	    
	    


	

	
    function CompleteUpDel(a,row,rowid)
    {
    	 bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
    });
    };
    
    
    
    /*****************************Students Tables**********************************/
    
    

	$('#students').on( 'change', '.checkbox', function () {
	
	
	    if($(this).is(":checked")) {
	        
	        var id=this.id;
	      
	       
	      
	        students[students.length]=id;
	      
	    }
	    
	  });
	
	
	
    $('#studentrecs').on( 'click', '#editgrade', function () {
    	alert("hello");
    	var studentid = $(this).closest('tr').find('td:first').text();
    	var grade = $(this).closest('tr').find('#grade').val();
    	var courseid= $('#scourseID').val();
    	
    	
    	bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true)updateStudentData(courseid,studentid,grade,function(result) {if (result==true){alert("ok");};
    
    	});
    	});
    	
    	
    	
    	
    });

			
	$('#students').on( 'click', '#SubmitButtonstudents', function (){
		
		

		
		 bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){addStudentstoCourses(students,function(result){if(result==true){$("#students").dataTable().fnDestroy(),$('#studentdiv').hide(),viewc(),
		 resetCourseTable(0);}});
		 $("#students").dataTable().fnDestroy();
		 students=[];
		 };
		 });
	});
    

			
    
  
    
    
    
   			
										
			
				
				
				
				
	
				
				
				
				
				
				
				
/**********************************Table and form set up functions**************************************/
				
				
		
			    
			    
			    
			    
			    
			    
			    
			    /************Selects set up*********************/
			    
			    
			    
		
function setCatSels(catid,catname)
{
	var o2 = new Option("option text", "value");
o2.id=catid;

$(o2).html(catname);
$("#catnamesel").append(o2);

}
		   
			   
			   
			   
			   /**************Select Change Fucntions***********************/
			   
			   
$('#coursenamesel').change(function() {
	
	var optionID=$('#coursenamesel option:selected').attr('id');

	if(optionID!="1")
		{
	 
		    $('#coursename').hide();
	    	$('#level').hide();
	    	$('#acrb').hide();
	}
	
	 
	});
	
	
	$('#catnamesel').change(function() {
	
		
		//ccatname()
		var catid=$('#catnamesel option:selected').attr('id');
		if(catid!=1)
			{
			$('#ccatname').hide();
			getCourseNamesforSels(catid);
			}
		else
			{
			$('#ccatname').show();
			getCourseNamesforSels(0);
			}
			
		
	
	});
				
/**********************************Data Retrevial Functions**********************************************/	

/*The function below is used to populate
 * the categories table
 */
				
 function getCatData(a,callback){
		var dataString=null;
		
	
		
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
		        "bSortable": false,
		            "mData": "catdescript",
		            "aTargets": [2]
		    },
		    {
		        "sTitle": "Courses",
		        "bSortable": false,
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
		
	
	
	

		});
	
		}
		else
		{
		$("#content").html("No Results");
		}
		}
		});
	
	return;
	};
	
				

function getCourseNamesforSels(a)
{
		 $("#coursenamesel")
		.find('option')
		.remove()
		.end();
		var o1 = new Option("option text", "value");
		o1.id=1;
		$(o1).html("- Select One-");	
		$(o1).prependTo("#coursenamesel");
		
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
				$.each(data.Category, function(i,data)
						{
							setCourseSels(data.courseid,data.coursename,data.level);
				
					 
						 });
			
						}
					
						}
						});
					
				};
				
			function setCourseSels(courseid,coursename,level)
				    {
					
					var o1 = new Option("option text", "value");
					o1.id=courseid;
						
					$(o1).html(coursename+" " +level);
					$("#coursenamesel").append(o1);
						
				
};

					
					
								
								
/*The Function below is used
 * to populate the courses table
 */						
								
function getCourseDetailsForCoursesTable(a,callback)
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
						
						coursecols = [{
					        "sTitle": "ID",
					            "mData": "refno",
					            "aTargets": [0]
					    }, 
					    {
					        "sTitle": "Name",
					            "mData": "coursename",
					            "aTargets": [1]
					    },	
					    {

				        "sTitle": "Accreditation",
				            "mData": "acredbody",
				            "aTargets": [2]
				    },
				    {
				        "sTitle": "Level",
				            "mData": "level",
				            "aTargets": [3]
				    },
				    {
				        "sTitle": "Category",
				            "mData": "categoryname",
				            "aTargets": [4]
				    },
				    {
				        "sTitle": "Tutor",
				            "mData": "tutorname",
				            "aTargets": [5]
				    },
				    {
				        "sTitle": "Capacity",
				            "mData": "capacity",
				            "bSortable": false,
				            "aTargets": [6]
				    },
				    {
				        "sTitle": "Semester",
				            "mData": "semesterid",
				            "bSortable": false,
				            "aTargets": [7]
				    },
				    {
				        "sTitle": "Participants",
				            "mData": "btn4",
				            "bSortable": false,
				            "aTargets": [8]
				    },
				    {
				        "sTitle": "",
				            "mData": "btn3",
				            "bSortable": false,
				            "aTargets": [9]
				    },
				
				    {
					        "sTitle": "",
					            "mData": "btn1",
					            "bSortable": false,
					            "aTargets": [10]
					    },
					    {
					        "sTitle": "",
					            "mData": "btn2",
					            "bSortable": false,
					            "aTargets": [11]
					    }
					  
					  
					    ];
						
						 
						courserows=data.Category;
						callback(coursecols,courserows);
						
				
					
				
					}
					
					}
					});
				
				};
				
/*
 * The function below is used to retrieve
 * student details from the database and
 * add them to a table
 * in order to allow them to be added
 * to an instance of a course
 */						
							
							
function getUserForCourses(a,b,courseid,instruct,misc,callback)
{
	
	dataString="archived=0,0&role="+a+","+b+"&courseid="+courseid+"&instruct="+instruct+"&misc="+misc;
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
					
					
					studentcols = [{
				        "sTitle": "ID",
				            "mData": "userid",
				            "aTargets": [0]
				    }, 
				    {
				        "sTitle": "Role",
				            "mData": "role",
				            "aTargets": [1]
				    }, 
				    {
				        "sTitle": "First Name",
				            "mData": "fname",
				            "aTargets": [2]
				    },
				    {
				        "sTitle": "Last Name",
				            "mData": "lname",
				            "aTargets": [3]
				    },
		
				    {
				        "sTitle": "",
				            "mData": "misc",
				            "aTargets": [4]
				    }
				    
				    
				    ];
				
					studentrows=data.User;
					callback(studentcols,studentrows);
					   
				}
			
				}
				});
			
			};
			
										
										
										
function setTutorSels(userid,fname,lname)
{
	var o = new Option("option text", "value");
	o.id=userid;
	o.value=fname +" " +lname;
	/// jquerify the DOM object 'o' so we can use the html method
	$(o).html(fname +" " +lname);
	$("#tutorsel").append(o);
	
}
											
/**********************************Insert or Update Functions**********************************************/		
	
	function updateStudentData(courseid,studentid,grade,callback)
	{
		Data="instructid=8&courseid="+courseid+"&studentid="+studentid+"&grade="+grade;
		studentData(Data,function(result){if(result==true){callback(true);}});
		
	}
	

										
										
	function addStudentstoCourses(Data1,callback){
		
	
		
		Data ="data="+JSON.stringify(Data1)+"&instructid=9";
		studentData(Data,function(result){if(result==true){callback(true);}});
		
	}
		
	function studentData(data,callback)
	{
		
	
			
			$.ajax({
				type: "POST",
				url: "StudentData",
				data:Data,
				dataType:"json",
				cache: false,
				success: function(data)
				{
					 $('#message').empty();
					 $('#sfmessage').empty();
					if(data.StudentMessage.length)
					{
					$.each(data.StudentMessage, function(i,data)
					{
					
					//var user_data="<div>"+data.fname + " "+data.lname + " " + data.address1+"</div>";
					messageid=data.messagecode;
					message=data.insertmessagestring;
					if(messageid==1)
					{
					callback(true);
					}
				
				
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
	    
	    
		
	}

	
	/*
	 * This function is used when a course is being
	 * added or updated to  populate the tutor
	 * selects in the relevant forms
	 * In the case of updates it also 
	 * prepops the select with the current
	 * tutor
	 */

function getTutorsForTutorSels(tid)
{
	var tutorname=null;
	var id=null;
	 $("#tutorsel")
	 	.find('option')
	    .remove()
	    .end();
	dataString="archived=0,0&role=1,1&courseid=0&instruct=1&misc=0";
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
					setTutorSels(data.userid,data.fname,data.lname);
					if(data.userid==tid)
					{
						tutorname=data.fname +" " +data.lname;
						id=data.userid;
					}
						 
				});
				
					
					var o = new Option("option text", "value");
					if(tid>0)
						{
						o.id=id;
						o.
						$(o).html(tutorname);	
						}
						else
							{
							$(o).html("- Select One-");
							}
								$(o).prependTo("#tutorsel");
					
				}
						
			}
		});
		
					
};

	/*
	 * This function is used to update 
	 * category information
	 */

				
function updateCatCourse(instruct,callback)
{

	catid=$('#catID').val();
	
	
	var name = $("#categoryName").val();
	var description = $("#catDescript").val();
	Data="instructid="+instruct+"&name="+name+"&description="+description+"&catid="+catid;
		
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
						
						
							messageid=data.messagecode;
							message=data.insertmessagestring;
						
						
							 $('#sfmessage').prepend(message);
						
							 
						
					
						});
					
							$('#ModalMessage').modal('show');
							$('#catModal').find('form')[0].reset();
							$('#courseModal').find('form')[0].reset();
								
								if(messageid=="1")
									{
										
										callback(true);
									}
									else
									{
										callback(false);
									}
							
						
						}
					
					}
				});
	    
    
    
    
    
};

/*
 * function used to update a courses tutor and/ or capacity
 */

function updateCourse(instruct,callback)
{

	var courseid=$('#cccatid').val();
	var tutorid=$('#tutorsel option:selected').attr('id');
	
	var capacity=$('#capacity').val();
	
	

	Data="instructid="+instruct+"&capacity="+capacity+"&tutorid="+tutorid+"&courseid="+courseid;
	
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
			
		
			messageid=data.messagecode;
			message=data.insertmessagestring;
		
		
			 $('#sfmessage').prepend(message);
		
			 
		
		
			});
		
				$('#ModalMessage').modal('show');
				$('#catModal').find('form')[0].reset();
				$('#courseModal').find('form')[0].reset();
	
			if(messageid=="1")
			{
				
				callback(true);
			}
			else
			{
				callback(false);
			}
			
			
			}
		
			}
		});





};
		
	
	
	
    
    function insertCatCourse(a,callback){
		var Data=null;
		var courseid=null;
		var catid=null;
	
		if(a==1)
		{
			Data="instructid="+instruct+"&name="+name+"&description="+description+"&catid="+catid;	
		}
		else if(a==5 || a==7)
			{
			//var catid = $("#ncatname").val();
			//var catid2=$("#ncatname").getVal();
			var catid=$('#cccatid').val();
		
			
			if(a==7)
				{
			courseid=$('#cccatid').val();
				}
			}
			else
				{
			
			courseid=$('#coursenamesel option:selected').attr('id');
				}
			
			
			
		
			var catid=$('#catnamesel option:selected').attr('id');
			var coursename = $("#courseName").val();
	
			var level=$('#level option:selected').attr('id');
			var accredbodname=$('#accreditbod').val();
			var tutorid=$('#tutorsel option:selected').attr('id');
		
			var capacity=$('#capacity').val();
		
			var equipreq=$('#equipsel option:selected').attr('id');
			
			if(courseid!=1)
				{
				coursename="na";
				accredbodname="na";
				
			
	
			Data=("instructid="+a+"&catid="+catid+"&courseid="+courseid+"&coursename="+coursename+"&level="+level+"&accredbodname="
					+accredbodname+"&tutorid="+tutorid+"&capacity="+capacity+"&equipreq="+equipreq);
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
					
				if(messageid=="6")
				{
					
					callback(true);
				}
				else
				{
					callback(false);
				}
				
				
				}
			
				}
			});
    
    
    
    
    
};

			function upDel(itemid,row,instruct)
			{
			
				
				
				dataString="catcourseid="+itemid+"&instructid="+instruct;
				
					
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