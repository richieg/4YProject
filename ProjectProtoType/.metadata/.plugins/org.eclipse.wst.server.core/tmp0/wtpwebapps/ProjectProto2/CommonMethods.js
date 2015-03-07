/**
 * 
 */
	var table=$('#categorytable').DataTable();
	$('.display tbody').on( 'click', '.rud', function () {
		var row=null;
		var rowid=null;
		var tableid=null;
		tableid=$(this).closest('table').attr('id');
		
		alert(tableid);
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