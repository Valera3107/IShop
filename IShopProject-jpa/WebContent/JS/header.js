$(document).ready(function() {
	$('.leftmenutrigger').on('click', function(e) {
		$('.side-nav').toggleClass("open");
		e.preventDefault();
	})
})

$("button.product-logout").click(function() {
	$.get("LogOutServlet", function(data) {
		if (data !== '') {
			var customUrl = '';
			var urlContent = window.location.href.split('/');
			for (var i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + '/'
			}
			customUrl += data;
			window.location = customUrl;
		}
	});
});

$(document).ready(function() {
	$.get("UserRole", function(data) {
		if (data !== '') {
			userRole = data;
		}
	}).done(function() {
		if (userRole === 'ADMINISTRATOR') {
			$('li.bucket-option').hide();
		} else {
			$('li.create-product').hide();
		}
	});
});


