/**
 * 
 */
$(document).ready( function () {
$('#datatable-sample').on( 'click', '#addcourse', function () {
				
				
					var a = $(this).closest('tr').find('td:first').text();
					var b = $(this).closest('tr').find("td").eq(1).text();
					$('#ncatid').val(a);
					
					//$('[name=options]').val(b);
					//$('select[name="options"]').find('option[id=a]').attr("selected",true);
					//$().find('option:contains(b)').attr("selected",true);
					$('#catName').val(b);
					

					$("#courseModal").modal('show');
					 //$('#coursename').show();
				  	//$('#level').show();
				  	//$('#acrb').show();
					//getUserForCourses(2);
					
					
					
				});


$('#addc').click(function () {
	
	

	
	//$('[name=options]').val(b);
	//$('select[name="options"]').find('option[id=a]').attr("selected",true);
	//$().find('option:contains(b)').attr("selected",true);
	$('#ncatnamedd').hide();
	$('#ncatnamed').show();
	

	$("#courseModal").modal('show');
	 //$('#coursename').show();
  	//$('#level').show();
  	//$('#acrb').show();
	//getUserForCourses(2);
	
	
	
});





	   // Use anything defined in the loaded script...





	
		
});
