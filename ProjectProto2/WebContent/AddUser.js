/**
 * 
 */

$(document).ready(function(){
document.getElementById("myBod").addEventListener("load", adduser());
$(function() {
	$( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
	});

$('#checkbox1').change(function() {
	$("#alertmessage").empty();
	
    if($(this).is(":checked")) {
        var returnVal = confirm("Are you sure?");
        $(this).attr("checked", returnVal);
    }
    $('#checknum').val("0");        
});
    
  
      



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

	 $("#table").append(user_data).removeClass("hidden");
	});
	}
	else
	{
	$("#content").html("No Results");
	}
	}
	});

};



	
	$("#onclick").click(function() {
	$('#useradddiv').css("display", "block");
	});
	$("#Userform #cancel").click(function() {
		//$("#useradddiv #Userform").val(" ");
		 $("input[type=text], textarea").val("");
		$("#useradddiv").css("display", "none");
	});

	

/*$('#add-user').click(function() {
	$('#Userform').css("display", "block");
	});
*/
	/*$('#add-user').click(function(){
	    
		
		$('#Userform').show();
	});*/
	
	
	
	
$('#SubmitButton').click(function()
{
	insertUser();
});


$('#SubmitButton1').click(function()
		{
	alert("i am here!");
		});

	

function insertUser(){

alert("got to here");

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
alert(role);
var checknum = $("#checknum").val();
alert(checknum);






var dataString="fname="+fname+"&lname="+lname+"&address1="+address1+"&address2="+address2+"&address3="+address3+"&address4="+address4+"&postcode="+postcode+"&phone="+phone+"&email="+email+"&dob="+dob+"&checknum="+checknum+"&role="+role;

//var dataString="userDetails=\'"+fname+"\',\'"+lname+"\',\'"+address1+"\',\'"+address2+"\',\'"+address3+"\',\'"+address4+"\',\'"+postcode+"\',\'"+phone+"\',\'"+email+ "\',\'"+archived+"\',\'"+dob+"\',\CURDATE()\,\'"+externalid+"\'";
//'\'Carrig\',\'Doyle\',\'36 MVG\',\'hillcrest\',\'Lucan\',\'Dublin\',\'Co.Dublin\',\'0851604445\',\'r@gmail.com\',\'0\',\'now()\',\'03-04-1980\',\'NULL\''";
//var dataString="userDetails=\'Barra\',\'Doyle\',\'36 MVG\',\'hillcrest\',\'Lucan\',\'Dublin\',\'Co.Dublin\',\'085160\',\'r@gmail.com\',\'0\',\'1980-04-03\',\CURDATE()\,\'NULL\'";

alert(dataString);





$.ajax({
type: "POST",
url: "InsertData",
data: dataString,
cache: false,
success: function(data)
{
	
$("#Userform").val('');
$("#alertmessage").prepend(data);
$("#myModal").modal('hide');
$("#Userform").focus();
}
});
return false;

//});
};


});//doc.ready function
