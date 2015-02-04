/**
 * 
 */

$(document).ready( function () {
    getCatData(0);
    
    $('#SubmitButtoncat').click(function()
    		{
    	//alert("button hit");
    	$('#ModalConfirm').modal('show'),
    	$('#ConfirmButton').click(function(){insertCatCourse(1);});
    		});
    
    
    $('#CourseSubmitButton').click(function()
    {
     	$('#ModalConfirm').modal('show'),
    	$('#ConfirmButton').click(function(){insertCatCourse(2);
    	});
    	
    });
    
    
    
    
    function getCatData(a){
		var dataString=null;
		
		var table=$('#categorytable').DataTable();
		var rows = table
	    .rows()
	    .remove()
	    .draw();
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
			
			   
			
		$.each(data.Category, function(i,data)
		{
		
			
			

		if(a==0)
			{
				button1="<button id=3"+data.categoryid+" class=\"rud\" role=\"update\">Update</button>";
				button2="<button id=4"+data.categoryid+" class=\"rud\" role=\"delete\">Delete</button>";
				button3="<button id="+data.categoryid+" class=\"add\" role=\"add\">Add Course</button>";
				
		
				

			}
		else{
				button1="<button id=2"+data.categoryid+" class=\"rud\" role=\"restore\">Restore</button>";
				button2="<button id=5"+data.categoryid+" class=\"rud\" role=\"delete\"></button>";
				button3="<button id=5"+data.categoryid+" class=\"add\" role=\"add\">Add Course</button>";
			    
		}
		userdata=[data.categoryid,data.catname,data.catdescript, data.genericcount,button1,button2,button3];
	
		table.row.add( userdata).draw();
	

		});
	
		}
		else
		{
		$("#content").html("No Results");
		}
		}
		});
	
	};
    
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
			var catid=$('#ncatname').val();
			var courseid=$('#coursenamesel option:selected').attr('id');
			var coursename=$('#courseName').val();
			var accredbodid=$('#accreditbodsel option:selected').attr('id');
			var accredbodname=$('#accreditbod').val();
			var tutorid=$('#tutorsel option:selected').attr('id');
			var semesterid=$('#semestersel option:selected').attr('id');
			var capacity=$('#capcity').val();
			var equipreq=$('#equipsel option:selected').attr('id');
			
			
			Data=("catid="+catid+"&courseid="+courseid+"&coursename="+coursename+"&accredbodid="+accredbodid+"&accredbodname="
					+accredbodname+"&tutorid="+tutorid+"&semesterid="+semesterid+"&capacity="+capacity+"equipreq="+equipreq);
			
			
			alert(Data);
			}
		
		alert(catData);
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
					$('#incatform').find("input[type=text], textarea").val("");
				
				
				}
				else
				{
				$("#content").html("No Results");
				}
				}
			});
    
    
    
    
    
};


$('#categorytable tbody').on( 'click', '.add', function () {
	
	var rowid=this.id;
	
	$('#ncatname').val(rowid);
	alert(rowid);
	getUserForCourses(2);
	
	
	
});

function getUserForCourses(a)
{
	if(a==2)
	{
					
					dataString="archived=0,0&role=1,1";
				
				
				}
				
				
				
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
					
					alert(data.userid);
					
		
				if(a==2)
					{
					var o = new Option("option text", "value");
					o.id=data.userid;
					/// jquerify the DOM object 'o' so we can use the html method
					$(o).html(data.fname +" " + data.lname);
					$("#tutorsel").append(o);
					}
				
				 //$("#usertable").append(userData).removeClass("hidden");
				});
				$("#courseModal").modal('show');
			
				}
				else
				{
				$("#content").html("No Results");
				}
				}
				});
			
			};
			
			
			$('#coursenamesel').change(function() {
				
			var optionID=$('#coursenamesel option:selected').attr('id');
	
			if(optionID!="1")
				{
			 
			    $('#coursename').hide();
			}
			});
			
			
			$('#courseName').change(function() {
				
		
			    $('#coursenameseld').hide();
			
			});
			
			$('#accreditbod').change(function() {
				
				
			    $('#accredbodseld').hide();
			
			});
			
			
			
			$('#accreditbodsel').change(function() {
				
			var optionID=$('#accreditbodsel option:selected').attr('id');
			    //var optionID = $('option:selected').attr('id');
				//var optionID=this.id;
			if(optionID!="1")
				{
			    alert(optionID);
			    $('#acrb').hide();
			}
			});


//courseModal
});//on load