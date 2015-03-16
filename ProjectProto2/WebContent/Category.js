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
	var studentcols=null;
	var studentrows=null;
	var students=[];
	var myBackup=null;
	
	 intializePage();
	
	 
  /*******************Modal Reset Function*******************************************************/
		function resetModal(modal,myBackup)
		{
			
			$(modal).modal('hide').remove();
			 var myClone = myBackup.clone();
		        $('body').append(myClone);
		       
		};
 
    

  /*********************Button Event Functions************************************************************/  

	$('#closecor').click(function()
		{
		bootbox.confirm("Are you sure you want to cancel without saving?", function(result) {if (result==true){resetModal('#courseModal',myBackup);}else{$('#courseModal').modal('show');}});

		});
	$('#closecat').click(function()
		{
		bootbox.confirm("Are you sure you want to cancel without saving?", function(result) {if (result==true){resetModal('#catModal',myBackup);}else{$('catModal').modal('show');}});

		});
	 
    $('#viewc').click(function()
    	{
		     	viewc();
		     	resetCourseTable(0);
    	});
    		
    	
    	
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
    	bootbox.confirm("Are you sure you want to add this category", function(result) {if (result==true){insertCatCourse(1,function(result){if(result==true){resetCatTable(0),resetModal('#catModal',myBackup)
    		;}});};
    	});
    		});
    
    
 
    

    
    
    $('#CourseSubmitButton').click(function()
    {
  
    	bootbox.confirm("Are you sure you want to add this course?", function(result) {if (result==true){insertCatCourse(2,function(result){if(result==true){resetCatTable(0),resetModal('#courseModal',myBackup)
    		;}});};
    	});
    	
    	
    	
    });
	$('#category').on( 'click', '#viewc', function () {
		
		
		viewc();
		var b = $(this).closest('tr').find("td").eq(1).text();
		var a = $(this).closest('tr').find('td:first').text();
		alert(a);
		$("#pagetitle").text(b+' Courses');
		resetCourseTable(a);
		//getCourseNamesForCourses(a,function(){drawDataTable1(coursecols,courserows);});

		
	});
	
	
	
	$('#category').on( 'click', '#addcourse', function () {
		myBackup = $('#courseModal').clone();
		getTutorsForTutorSels();
		var a = $(this).closest('tr').find('td:first').text();
		var b = $(this).closest('tr').find("td").eq(1).text();
		getCourseNamesforSels(a);
		$('#cccatid').val(a);
		$("#catnamesel option[id='"+a+"']").attr('selected', 'selected');
		$('#catName').val(b);
		$("#courseModal").modal('show');
		console.log(studentcols,studentrows);
		
	});


	$('#addc').click(function () 
	{
		myBackup = $('#courseModal').clone();
		getTutorsForTutorSels();
		getCourseNamesforSels(0);
		$('#ncatnamedd').hide();
		$('#ncatnamed').show();
		$('#ccatnamesel').show();
		$("#courseModal").modal('show');




	});



	$('#courses').on( 'click', '#addstudents', function () 
	{
	
	
		
		var a = $(this).closest('tr').find('td:first').text();
		var b = $(this).closest('tr').find("td").eq(6).text();
	
		getUserForCourses(0,0,a,3,b,function(){drawStudentTable(studentcols,studentrows);});
		 students[0]=$(this).closest('tr').find('td:first').text();
		//$("#scourseID").val($(this).closest('tr').find('td:first').text());
		$("#coursediv").hide();
		$("#studentdiv").show();
	
	
	
	
	});





		
	
	
    
	$('#category').on( 'click', '#4', function () {
		alert("hello");
		
		var row=null;
		var rowid=null;
	
		var role=this.getAttribute('role');
		alert(role);
		var a = $(this).closest('tr').find('td:first').text();
	
		alert(a);
	
	    row=oTable
        .row( $(this).parents('tr') );
	    
		rowid=this.id;

		
		
		
		CompleteUpDel(a,row,rowid);
	    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
  	  
    	
	});






	$('#category').on( 'click', '#6', function () {
			
				
				var row=null;
			
			
				var role=this.getAttribute('role');
				alert(role);
				var a = $(this).closest('tr').find('td:first').text();
				var b = $(this).closest('tr').find("td").eq(1).text();
				var c = $(this).closest('tr').find("td").eq(2).text();
			
				alert(a);
				alert(b);
				alert(c);
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
				
				bootbox.confirm("Are you sure you want to update this category?", function(result) {if (result==true){insertCatCourse(6),resetCatTable(0);};
				
				});
			});
	
	
	//CompleteUpDel(a,row,rowid);
    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
	  
			
  /**************************Course Table Buttons**********************************/
			
	$('#courses').on( 'click', '#5', function () {
		
		
		var row=null;
		var rowid=null;
	
		var role=this.getAttribute('role');
		alert(role);
		var a = $(this).closest('tr').find('td:first').text();
	
		alert(a);
	
	    row=ocTable
	    .row( $(this).parents('tr') );
	  
	    
	    	rowid=this.id;
	    
		
		
		
		CompleteUpDel(a,row,rowid);
	    //bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
		  
		});



	$('#courses').on( 'click', '#7', function () {
	
		
		
	
		var role=this.getAttribute('role');
		alert(role);
		var a = $(this).closest('tr').find('td:first').text();
		var b = $(this).closest('tr').find("td").eq(1).text();
		var c = $(this).closest('tr').find("td").eq(5).text();
		alert(c);
		$('#cccatid').val(a);
		$("#courseName").val(b);
		$("#capacity").val(c);
		
		$("#ccatname").hide();
		$("#coursenameseld").hide();
		$("#acrb").hide();
		$("#tutor").hide();
		$("#sem").hide();
		$("#req").hide();
		$("#level").hide();
		$("#ccatnamesel").hide();
		
		$("#CourseUpdateButton").show();
		$("#CourseSubmitButton").hide();
	
		alert(a);
	
	    row=ocTable
	    .row( $(this).parents('tr') );
	   
	    
	    	rowid=this.id;
	    	$('#courseModal').modal('show');
		});
		
	    $('#CourseUpdateButton').click(function(){
	    		
	    		bootbox.confirm("Are you sure you want to update this course?", function(result) {if (result==true){insertCatCourse(7),resetCourseTable(0);};
	    		
	    		
	    	});
		
		
		  
		});
	    
	    
	    
	    $('#courses').on( 'click', '#viewcs', function () {
	    	
	    	alert("oala");
	    	
	    	
	    	var a = $(this).closest('tr').find('td:first').text();
	    	$('#scourseID').val(a);
	    	//alert($('#scourseID').val());
	    	getUserForCourses(0,0,a,4,0,function(){drawStudentTable(studentcols,studentrows),$('#coursediv').hide(),$('#studentdiv').show();});
	    	
	    	
	    });
	    
	    
	    
	    


	

	
    function CompleteUpDel(a,row,rowid)
    {
    	 bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(a,row,rowid);};
    });
    };
    
    
    
    /*****************************Students Tables**********************************/
    
    

	$('#students').on( 'change', '.checkbox', function () {
	
	
	    if($(this).is(":checked")) {
	        
	        var id=this.id;
	        alert(id);
	       
	      
	        students[students.length]=id;
	        alert(students);
	    }
	    
	  });
	
	
	
    $('#students').on( 'click', '#editgrade', function () {
    	
    	var studentid = $(this).closest('tr').find('td:first').text();
    	var grade = $(this).closest('tr').find('#grade').val();
    	var courseid= $('#scourseID').val();
    	
    	
    	updateStudentData(courseid,studentid,grade,function(result) {if (result==true){alert("ok");};
    
    	});
    	
    	
    	
    	
    });
	$('#SubmitButtonstudents').click(function(){
		
		
		alert(students);
		
		 bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){addStudentstoCourses(students,function(result){if(result==true){$("#students").dataTable().fnDestroy(),$('#studentdiv').hide(),viewc(),
	 	resetCourseTable(0);}});
		 students=null;
		 };
		 });
	});
    

			
    
  
    
    
    
   			
										
			
				
				
				
				
	
				
				
				
				
				
				
				
/**********************************Table and form set up functions**************************************/
				
				
			    
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
			    	
			    	$("#category").dataTable().fnDestroy();
			    	  getCatData(ca,function(){drawDataTable(catcols,catrows);});
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
			    
			   function drawStudentTable(columns, data) {
			    
			    	
			        osTable = $('#students').DataTable({
			        	 
			                "aoColumnDefs": columns,
			                "aaData": data
			               
			        });
			      
			    };
			    
			    
			    
			    
			    
			    
			    
			    /************Selects set up*********************/
			    
			    
			    
			
			

			   /*function setCourseSels(courseid,coursename,level)
			    {
					var o1 = new Option("option text", "value");
					o1.id=courseid;
					/// jquerify the DOM object 'o' so we can use the html method
					$(o1).html(coursename+" " +level);
					$("#coursenamesel").append(o1);
					
			    }*/
			   
			   function setCatSels(catid,catname)
			    {
					var o2 = new Option("option text", "value");
					o2.id=catid;
					/// jquerify the DOM object 'o' so we can use the html method
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
						alert("hello");
						
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
				alert(dataString);
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
										/// jquerify the DOM object 'o' so we can use the html method
									$(o1).html(coursename+" " +level);
									$("#coursenamesel").append(o1);
										
										
										
								    }
			
					
					
								
								
								
								
			function getCourseDetailsForCoursesTable(a,callback)
				{
					dataString="instruct=2&archived="+a;
					alert(dataString);
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
							        "sTitle": "Capacity",
							            "mData": "capacity",
							            "bSortable": false,
							            "aTargets": [5]
							    },
							    {
							        "sTitle": "Semester",
							            "mData": "semesterid",
							            "bSortable": false,
							            "aTargets": [6]
							    },
							    {
							        "sTitle": "Participants",
							            "mData": "btn4",
							            "bSortable": false,
							            "aTargets": [7]
							    },
							    {
							        "sTitle": "",
							            "mData": "btn3",
							            "bSortable": false,
							            "aTargets": [8]
							    },
							
							    {
								        "sTitle": "",
								            "mData": "btn1",
								            "bSortable": false,
								            "aTargets": [9]
								    },
								    {
								        "sTitle": "",
								            "mData": "btn2",
								            "bSortable": false,
								            "aTargets": [10]
								    }
								  
								  
								    ];
									
									 // drawDataTable(columns, data.Category);
									courserows=data.Category;
									callback(coursecols,courserows);
									
							
								
							
								}
								
								}
								});
							
							};
							
							
							
							
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
										function getTutorsForTutorSels()
										{
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
													
														 
															 });
												
													
													var o = new Option("option text", "value");
													$(o).html("- Select One-");	
													$(o).prependTo("#tutorsel");
													
															}
															
															}
															});
														
													};
									
										
										
										
										function setTutorSels(userid,fname,lname)
										{
											var o = new Option("option text", "value");
											o.id=userid;
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
		
		alert("data="+Data1);
		
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
				
	
	
	
    
    function insertCatCourse(a,callback){
		var Data=null;
		var courseid=null;
		var catid=null;
	
		if(a==1 || a==6)
		{
		catid=$('#catID').val();
	
		var name = $("#categoryName").val();
		var description = $("#catDescript").val();
		Data="instructid="+a+"&name="+name+"&description="+description+"&catid="+catid;
		}
		else if(a==5 || a==7)
			{
			//var catid = $("#ncatname").val();
			//var catid2=$("#ncatname").getVal();
			var catid=$('#cccatid').val();
		
			//alert("catid="+catid2);
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
			alert("coursename="+coursename);
			var level=$('#level option:selected').attr('id');
			var accredbodname=$('#accreditbod').val();
			var tutorid=$('#tutorsel option:selected').attr('id');
		
			var capacity=$('#capacity').val();
		
			var equipreq=$('#equipsel option:selected').attr('id');
			
			if(courseid!=1)
				{
				coursename="na";
				accredbodname="na";
				}
			
	
			Data=("instructid="+a+"&catid="+catid+"&courseid="+courseid+"&coursename="+coursename+"&level="+level+"&accredbodname="
					+accredbodname+"&tutorid="+tutorid+"&capacity="+capacity+"&equipreq="+equipreq);
			
			
			
			
			alert(Data);
			
		

		
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
					alert(messageid);
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