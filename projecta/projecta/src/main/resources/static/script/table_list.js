


$(document).ready( function () {
	
	//var table =$('#content_id').DataTable();
	
	
	 console.log("start_loading ");
	 
	var  table = $('#content_id').DataTable({
			"sAjaxSource": "/content/ap/",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [

				  { "mData": "pracownik_id" },
				   { "mData": "name" },
				  { "mData": "salary" },
				   { "mData": "dataZatrudnienia" },
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-danger" type="button"  id="del_id"   >' + 'DEL' + '</button>'; }},
				  { "mData": function (data, type, row, meta) {  
					   return '<button class="btn btn-primary" type="button"  id="edit_id"   >' + 'EDIT' + '</button>'; }}  
			]
	 });	
	 
	 
	
		
		
		
	  $("#active_id").click(function(event) { 
		 var table =$('#content_id').DataTable();	  
			 table.destroy();	
			 table = $('#content_id').DataTable({
				"sAjaxSource": "/content/byfield/ap/",
				"sAjaxDataProp": "",
				"order": [[ 0, "asc" ]],
				"aoColumns": [

					  { "mData": "pracownik_id" },
					   { "mData": "name" },
					  { "mData": "salary" },
					   { "mData": "dataZatrudnienia" },
					  { "mData": function (data, type, row, meta) {  
						   return '<button class="btn btn-danger" type="button"  id="del_id"   >' + 'DEL' + '</button>'; }},
					  { "mData": function (data, type, row, meta) {  
						   return '<button class="btn btn-primary" type="button"  id="edit_id"   >' + 'EDIT' + '</button>'; }}  
				]
			  });
	 
	 
		}); 	
		
		$("#noactive_id").click(function(event) { 			
			
		     console.log("filter_id ");  
				 
			 var table =$('#content_id').DataTable();
				table.destroy();
				 table = $('#content_id').DataTable({
				"sAjaxSource": "/content/ap/",
				"sAjaxDataProp": "",
				"order": [[ 0, "asc" ]],
				"aoColumns": [

					  { "mData": "pracownik_id" },
					   { "mData": "name" },
					  { "mData": "salary" },
					   { "mData": "dataZatrudnienia" },
					  { "mData": function (data, type, row, meta) {  
						   return '<button class="btn btn-danger" type="button"  id="del_id"   >' + 'DEL' + '</button>'; }},
					  { "mData": function (data, type, row, meta) {  
						   return '<button class="btn btn-primary" type="button"  id="edit_id"   >' + 'EDIT' + '</button>'; }}  
				]
			   });	
				//location.reload();
		 
		
    })
		
		
		
		
 
     $("#form_prac").submit(function(event) {	
  //   $("#savestat_id").click(function(event) { 			
			
	     		if (   $('#id_id').val()>0  ){
				   event.preventDefault();
 	               event.stopPropagation();
				   sendEdit();
				   
				}   
				else {
				   event.preventDefault();
 	               event.stopPropagation();
				   sendInsert();
					
				}	
		}); 
			
	$('#content_id tbody').on( 'click', '#del_id', function () {
    console.log("delete ");  
       var data = table.row( $(this).parents('tr') ).data();
	
	   
	   	sendDel(data.pracownik_id);

	});			
	$('#content_id tbody').on( 'click', '#edit_id', function () {
		    console.log("edit ");  
	   
			
       var data = table.row( $(this).parents('tr') ).data();
	   console.log('  TITLE '+data.title);
	   
		$('#id_name').val(data.name);
		$('#id_number').val(data.salary);
		$('#id_date').val(data.dataZatrudnienia);
	    $('#id_id').val(data.pracownik_id);
        $('#edit_modal_id').modal('show');	
	});		
	
	//addnew_id
	  $("#addnew_id").click(function(event) { 	
	     $('#id_name').val('');
		 $('#id_number').val('');
		 $('#id_date').val('');
	     $('#id_id').val(0);
	     $('#edit_modal_id').modal('show');	
	  });	

});


    function sendEdit(){
    
        	var data = {
			val1 : $('#id_name').val(),
			val2 : $('#id_number').val(),
			val3 : $('#id_date').val()
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
	
	function sendInsert(){
    		
	    var form = $('#form_prac')[0];
        var data = new FormData(form);
	
    	 console.log('   sendInsert ');
    	$.ajax({
			type: "POST",
			enctype: 'form-data',
			url: "/content/savedata/",
			data: data,
			processData: false,
			contentType: false,
			cache: false,
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