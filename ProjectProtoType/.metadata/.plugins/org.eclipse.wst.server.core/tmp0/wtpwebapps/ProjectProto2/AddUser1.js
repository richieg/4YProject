/**
 * 
 */

//document.getElementById("myBod").addEventListener("load", adduser);
function adduser(){
	$.ajax
	({
	type: "GET",
	url: "GetUserData",
	dataType:"json",
	cache: false,
	success: function(data)
	{
	if(data.User.length)
	{
	$.each(data.User, function(i,data)
	{
	
	//var user_data="<div>"+data.fname + " "+data.lname + " " + data.address1+"</div>";
	var user_data="<tr><td>"+data.fname+"</td><td>"+data.lname+"</td><td>"+data.address1+"</tr>";
	//$(user_data).appendTo("#content");
	alert(user_data);
	 $("#table").append(user_data).removeClass("hidden");
	});
	}
	else
	{
	$("#content").html("No Results");
	}
	}
	});
	
	
	$('#add-user').click(function(){
	    
		
		$('#Userform').show();
	});
	
	
	
	
$('#SubmitButton').click(function()
{
	




var fname = $("#firstName").val();
var lname = $("#lastName").val();
var address1 = $("#address1").val();
var dataString = "fname="+fname+"&lname="+lname+"&address1="+address1;




$.ajax({
type: "POST",
url: "InsertData",
data: dataString,
cache: false,
success: function(data)
{
	
$("#Userform").val('');
$("#alertmessage").prepend("New user "+data+" has been entered successfully");
$("#Userform").focus();
}
});
return false;
});
};