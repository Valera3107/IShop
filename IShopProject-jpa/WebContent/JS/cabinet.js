var products = null;

$.get("products", function(data) {
			if (data !== '') {
				products = data;
			}
		})
		.done(
				function() {

					var cardsContent = "";
					jQuery
							.each(
									products,
									function(i, value) {
										cardsContent += "<div class='card text-white bg-danger col-3' style='max-width: 18rem; height: 19rem;'>"
												+ "<div class='card-header title-row'>"
												+ value.name
												+ "</div>"
												+ "<div class='card-body'>"
												+ "<h5 class='card-title'>Description:</h5>"
												+ "<p class='card-text'>"
												+ value.description
												+ "</p>"
												+ "<h5 class='card-title'>Amount: "
												+ value.amount
												+ "</h5>"
												+ "<h5 class='card-title'>Price: "
												+ value.price
												+ "$</h5>"+
												"<a href='product?id="+value.id+"' class='card-link link-style'>link to the card</a>"
												+ "</div>" + "</div>"
									});
					$('#productCards').html(cardsContent);
				}).done(function(){

var userRole = null;
$.get("UserRole", function(data){
	if(data !== ''){
		userRole = data;
	}
}).done(function(){
	if(userRole == 'ADMINISTRATOR'){
		$('a.card-link').hide();
	}
});
});