$('.message a').click(function() {
	loginRegisterSwitch();
});

function loginRegisterSwitch() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
}

function showAlertAfterRegistration() {
	$('div.alert.alert-success').show();
}

$("button.register")
		.click(
				function() {
					var name = $("form.register-form input.name").val();
					var surname = $("form.register-form input.surname").val();
					var email = $("form.register-form input.email").val();
					var password = $("form.register-form input.password").val();
					var cpassword = $("form.register-form input.cpassword")
							.val();
					var login = $("form.register-form input.login").val();
					var role = $("form.register-form input.role").val();

					if (name == '' || email == '' || password == ''
							|| cpassword == '' || surname == '') {
						alert("Please fill all fields...!!!!!!");
					} else if ((password.length) < 5) {
						alert("Password should atleast 5 character in length...!!!!!!");
					} else if (!(password).match(cpassword)) {
						alert("Your passwords don't match. Try again?");
					} else {
						var userRegistration = {
							name : name,
							surname : surname,
							email : email,
							password : password,
							login : login,
							role : role
						};

						$.post("registration", userRegistration,
								function(data) {
									if (data == 'Success') {
										$("form")[0].reset();
										$("form")[1].reset();
										loginRegisterSwitch();
										showAlertAfterRegistration();
									}
								});
					}
				});

$("button.login").click(function() {

	var password = $("form.login-form input.password").val();
	var login = $("form.login-form input.login").val();

	if (password == '' || login == '') {
		alert("Please fill login form...!!!!!!");
	} else {
		var userLogin = {
			password : password,
			login : login
		};

		$.post("login", userLogin, function(data) {
			if(data !== ''){
				var customUrl = '';
				var urlContent = window.location.href.split('/');
				for (var i = 0; i < urlContent.length-1; i++) {
					customUrl+=urlContent[i]+'/'
				}
				customUrl+=data.destinationUrl;
				window.location = customUrl;
			}
			$("form")[1].reset();
		});
	}
});
