<%@include file="Header.jsp"%>

<script>
$(document).ready(function(){
	 var path="http://localhost:8083/ECommerceFrontEnd/resources/images/";
	 
 $("#producttable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8083/ECommerceFrontEnd/allproducts",
		    "dataSrc": ""
		  },
	  "columns": [
         { "data": "product_name" },
         { "data": "",
       	"render":function(data,type,row)
       	{
       	  return "&#8360;."+row.product_price+"";
         }  
         
         },
         { "data":"product_quantity" },
         
         {"data":"product_name",
       	  "Render":function(data,type,row){
       		  return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
       	  }
         },
         
         {"data":"product_id",
       	  "render":function(data,type,row){
       		  return "<a href='http://localhost:8083/ECommerceFrontEnd/"+row.product_id+"/ViewDetails' class='btn btn-primary'>View</a>";
       	  }
         }
                   
     ]
 });
   
   
});
</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<table class="table table-hover" id="producttable">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>Product Price </th>
						<th>Quantity</th>
						<th></th>
						<th></th>
						<th></th>
						
					</tr>
				</thead>
							</table>
		</div>
	</div>
</div>

<%@include file="Footer.jsp"%>