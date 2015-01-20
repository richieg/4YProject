/**
 * 
 */

	

	
	
	
	function loginuser(){
		var username = $("#user").val();
		var password = $("#pwd").val();
	
		var user_data=" ";
		dataString = "user="+username+"&pwd="+password;
		alert(dataString);
		alert("hello");
		$.ajax
		({
		type: "POST",
		url: "LoginUser",
		dataType:"string",
		data: dataString,
		cache: "false",
		success: function(data)
		{
			alert("got to here!!!");}
		
		});
	

	};
	
	/*function userLog(user_data){
		this.user_data1=user_data;
		//alert(user_data1 + "userdata1");
		$.ajax({
			type: "POST",
			url: "LoginUser",
			data: user_data1,
			cache: false,
			success: function(data)
			{
				alert("success");
		
			}
			});
		return 1;
	};*/
	

	

	
	

	
	
	