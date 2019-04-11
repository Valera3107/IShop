$("button.createProduct").click(function() {
	var name = $(".name").val();
	var price = $(".price").val();
	var amount = $(".amount").val();
	var description = $(".description").val();

	var product = {
		name : name,
		price : price,
		amount : amount,
		description : description
	};


	$.post("product", product, function(data) {
		if (data == 'Success') {
			$(".validate-form")[0].reset();
		}
	});
	
});

$("button.btn-primary.buy-product").click(function(){
	var productId = jQuery(this).attr("product-id");
	$.post("bucketServlet", {'productId': productId},function(data){
		if(data == 'Success'){
			$("[data-dismiss=modal]").trigger({type:"click"});
		}
	})
})