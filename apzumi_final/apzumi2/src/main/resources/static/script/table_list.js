


$(document).ready( function () {
	
	var table =$('#agreementsearch').DataTable();
	
	
	 console.log("start_loading ");
	  table = $('#content_id').DataTable({
			"sAjaxSource": "/content/",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [

				  { "mData": "id" },
				   { "mData": "title" },
				  { "mData": "body" },
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-danger" type="button"  id="del_id"   >' + 'DEL' + '</button>'; }},
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-primary" type="button"  id="edit_id"   >' + 'EDIT' + '</button>'; }}  
			]
	 });	
	 
	 
	 
	 
	 
	 $("#filter_id").on('change keyup paste', function () {	 
		     console.log("filter_id ");  
		    
			 var field=$('#filter_id').val();
		if(field!=''){	 
			 console.log("filter_id "+$('#filter_id').val());  
			  table.destroy();
			  table = $('#content_id').DataTable({
			"sAjaxSource": "/content/byfield/"+field,
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [

				  { "mData": "id" },
				   { "mData": "title" },
				  { "mData": "body" },
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-danger" type="button"  id="del_id"   >' + 'DEL' + '</button>'; }},
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-primary" type="button"  id="edit_id"   >' + 'EDIT' + '</button>'; }}  
			]
	 });	
	 	//location.reload();
		 }
		});
		
 
			
     $("#savestat_id").click(function(event) { 			
			
	     		sendEdit();
		}); 
			
	$('#content_id tbody').on( 'click', '#del_id', function () {
    console.log("delete ");  
       var data = table.row( $(this).parents('tr') ).data();
	
	   
	   	sendDel(data.id);

	});			
	$('#content_id tbody').on( 'click', '#edit_id', function () {
		    console.log("edit ");  
	   
			
       var data = table.row( $(this).parents('tr') ).data();
	   console.log('  TITLE '+data.title);
	   
		$('#id_edttitle').val(data.title);
		$('#id_edtbody').val(data.body);
	    $('#id_id').val(data.id);
        $('#edit_modal_id').modal('show');	
	});		
		
});


    function sendEdit(){
    
        	var data = {
			title : $('#id_edttitle').val()	,
			body : $('#id_edtbody').val()
    	    } 
	
        var id=$('#id_id').val();	
    	 console.log('Befor send json');
    	$.ajax({
		    type: "POST",
            url: "/content/edit/"+id,
			data : data,
			success : function(data){
        
				 console.log(data);
				 	location.reload();
							},
		   error : function(e) {
			    console.log("Error ");
				console.log("ERROR: ", e);
			}
		});
    };


    function sendDel(id){
    
         
		 
    	 console.log('Befor send json');
    	$.ajax({
		    type: "POST",
            url: "/content/delete/"+id,
		
			success : function(data){
        
				 console.log(data);
				 	location.reload();
							},
		   error : function(e) {
			    console.log("Error ");
				console.log("ERROR: ", e);
			}
		});
    };