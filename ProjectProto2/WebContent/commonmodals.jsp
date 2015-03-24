<div class="modal fade" id="ModalMessage" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Message
            </h4>
         </div>
         <div class="modal-body">
		 <div id="sfmessage"></div>


</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->



<div class="modal fade" id="ModalActionAlert" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
               Message
            </h4>
         </div>
         <div class="modal-body">
		 <div id="message"></div>


</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Close
            </button>
             <button type="button" id="SubmitButton1" class="btn btn-priamry" 
               data-dismiss="modal">Submit
            </button>
             
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->




<div class="modal fade" id="ModalConfirm" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
              Confirm
            </h4>
         </div>
         <div class="modal-body">
		 <div><h4>Are you sure you wish to complete this action?</h4></div>


</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Cancel
            </button>
              <button id="ConfirmButton" class="btn btn-primary"     data-dismiss="modal">Confirm</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->



<div class="modal fade" id="bulkupload" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
           
            <h4 class="modal-title" id="myModalLabel">
              Bulk Upload
            </h4>
         </div>
         <div class="modal-body">
		 <div><h4>Please select  a .csv to upload</h4></div>


        <form method="POST" action="FileUploadServlet" enctype="multipart/form-data" >
            File:
            <input type="file" name="file" id='file' accept=".csv" /> <br/>
        	<input type="submit" value="Upload File" />
            
        </form>
 
</div>



         <div class="modal-footer">
            <button type="button" class="btn btn-default" 
               data-dismiss="modal">Cancel
            </button>
              <button id="uploadButton" class="btn btn-primary"     data-dismiss="modal">Upload</button>
            
           
         </div>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->


</body>

</html>


