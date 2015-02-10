/**
 * 
 */

$(document).ready(function(){
	
var table=$('#usertable').DataTable();
//call get user when page loads
document.getElementById("myBod").addEventListener("load", getUserData(0));

	
 


//form functionality

$(function() {
	$( "#datepicker" ).datepicker({changeYear: true,yearRange: "-100:+0",dateFormat: 'yy-mm-dd'});
	});





	

$.validate({
   
    modules : 'location, date, security, file',
    onError : function() {
      alert('Validation failed');
    },
    onSuccess : function() {
      alert('The form is valid!');
      return false; // Will stop the submission of the form
    },
    onValidate : function() {
      return {
        element : $('#some-input'),
        message : 'This input has an invalid value for some reason'
      };
    }
  });


//Button onclick methods
  
//called when user hits "Restore User" button
	  $('#updateButton').click(function()
			{
		 
	
		  
				//gets users that have been deleted previously
				getUserData(1);
				$('#adduser1').hide();
				$('#updateButton').hide();
				$('#allusers').show();
				
				
				
			});

	  //called when return to previous button selected in restore screnn

		$('#allusers').click(function()
			{
				   
					//$("#usertable").empty();
			
			
					getUserData(0);
					$('#adduser1').show();
					$('#updateButton').show();
					$('#allusers').hide();
				
					
					
					
				});
		
		//called when submit button on user form modal hit

		$('#SubmitButton').click(function()
					{
			
						insertUser();
				});



		//called when submit oon confirm modal hit
		$('#SubmitButton1').click(function()
				{
			
	
			 $('#checknum').val("0");        
				});




		//when restore button is hit the following retrieves the id
		//and calls insertdata to perform the update
		/*$(document).on('click','.rud',function ()
				{
		
				var row=this.id;
				//var role=$(this).attr('role');
				
				$('#ModalConfirm').modal('show');
	
				$('#ConfirmButton').click(function(){
					$('#ModalConfirm').modal('hide');
				
				});
				});*/
		
		$('.display tbody').on( 'click', '.rud', function () {
			var row=null;
			var rowid=null;
		    row=table
	        .row( $(this).parents('tr') );
	        alert("row first="+row);
			rowid=this.id;
			alert("rowid first="+rowid);
		
				var nrowid=null;
				nrowid=rowid;
				alert("second row="+nrowid);
		      
		        bootbox.confirm("Are you sure you want to complete this action?", function(result) {if (result==true){upDel(rowid,row);};
		        	  
		        	}); 
		        
		        nrowid=null;
		  
		});
				
				
				
		function upDel(rowid,row)
		{
			var rrowid=null;
			var dataString=null;
			rrowid=rowid;
			alert(rrowid);
			
			var instruct = rrowid.substring(0, 1);
			var rowid1=rrowid.substring(1, rrowid.lenght);
			dataString="userid="+rowid1+"&checknum="+instruct;
			alert(dataString);
				
				$.ajax({
					type: "POST",
					url: "InsertData",
					data: dataString,
					dataType:"json",
					cache: false,
					success: function(data)
					{
						 $('#sfmessage').empty();
						if(data.Message.length)
						{
						$.each(data.Message, function(i,data)
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



 
		
		
	






	


   //called for various functions what it returns depends upon what a is
		function getUserData(a){
			var dataString=null;
			
			//var table=$('#usertable').DataTable();
			var rows = table
		    .rows()
		    .remove()
		    .draw();
			var button1=null;
			var button2=null;
			
			if(a==0)
				{
				dataString="archived=0,0&role=1,0";
			
				}
			else if(a==1)
			{
				
				dataString="archived=1,1&role=1,0";
			
			}
			else if(a==2)
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
				
				
				
	
			if(a==0)
				{
					button1="<button id=3"+data.userid+" class=\"rud\" role=\"update\">Update</button>";
					button2="<button id=4"+data.userid+" class=\"rud\" role=\"delete\"><span class=\"glyphicon glyphicon-trash\"></span></button>";
					//userData="<tr><td id=\"userid\">"+data.userid+"</td><td id=\"fname\">"+data.fname+"</td><td id=\"lname\">"+data.lname+"</td><td id=\"address1\">"+data.address1+"<td><button id=3"+data.userid+" class=\"rud\" role=\"update\">update</button><button id=4"+data.userid+" class=\"rud\" role=\"delete\" >Delete</button></td></tr>";
	//<span class=\"glyphicon glyphicon-trash\"></span>
				}
			else{
					button1="<button id=2"+data.userid+" class=\"rud\" role=\"restore\">Restore</button>";
					button2="<button id=5"+data.userid+" class=\"rud\" role=\"delete\"></button>";
				    //userData="<tr><td id=\"userid\">"+data.userid+"</td><td id=\"fname\">"+data.fname+"</td><td id=\"lname\">"+data.lname+"</td><td id=\"address1\">"+data.address1+"<td><button id=2"+data.userid+" class=\"rud\" role=\"restore\">Restore</button>";
			}
			userdata=[data.userid,data.fname,data.lname, data.address1,button1,button2];
			table.row.add( userdata).draw();
		
			 //$("#usertable").append(userData).removeClass("hidden");
			});
		
			}
			else
			{
			$("#content").html("No Results");
			}
			}
			});
		
		};






	
	
	
	





	

			function insertUser(){
			
			
			
			var fname = $("#firstName").val();
			var lname = $("#lastName").val();
			var address1 = $("#address1").val();
			var address2 = $("#address2").val();
			var address3 = $("#address3").val();
			var address4 = $("#address4").val();
			var postcode = $("#postcode").val();
			var phone = $("#phone").val();
			var email = $("#email").val();
			var dob = $("#dob").val();
			var role = $("#role").val();
			alert (role);
			var checknum = $("#checknum").val();
			var messageid=null;
			var message=null;
			
			
			
			
			
			
			var dataString="fname="+fname+"&lname="+lname+"&address1="+address1+"&address2="+address2+"&address3="+address3+"&address4="+address4+"&postcode="+postcode+"&phone="+phone+"&email="+email+"&dob="+dob+"&checknum="+checknum+"&role="+role;
			

		
			
			
			//called to insert user data
			
			
			$.ajax({
			type: "POST",
			url: "InsertData",
			data: dataString,
			dataType:"json",
			cache: false,
			success: function(data)
			{
				 $('#message').empty();
				 $('#sfmessage').empty();
				if(data.Message.length)
				{
				$.each(data.Message, function(i,data)
				{
				
				//var user_data="<div>"+data.fname + " "+data.lname + " " + data.address1+"</div>";
				messageid=data.messagecode;
				message=data.insertmessagestring;
			
				if(messageid==1)
				{
				
				 $('#message').prepend(message);
				}
				else
				{
				 
				 $('#sfmessage').prepend(message);
				}
				 
			
			
				});
				if(messageid==1)
					{
				$('#ModalActionAlert').modal('show');
					}
				else{
					$('#ModalMessage').modal('show');
					$('#myModal').find('form')[0].reset();
					//$('#induserform').find("input[type=text], textarea").val("");
					 //$('#checknum').val("1");
					 getUser(0);
				
				}
				}
				else
				{
				$("#content").html("No Results");
				}
				}
			});
	

			};


});//doc.ready function
