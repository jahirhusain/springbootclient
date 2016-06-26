$(document).ready(function() {
    $('#userInfoForm')
        .bootstrapValidator({
            fields: {
                age: {
                    message: 'Age is not valid',
                    validators: {
                        notEmpty: {
                            message: 'Age is required '
                        },
                     regexp: {
                        regexp: /^[0-9]*$/,
                        message: 'Age can consist only numbers'
                    }
                    }
                },
                userName: {
                    validators: {
                        notEmpty: {
                            message: 'Name is required '
                        }
                    }
                },
                emailAddress: {
                    
                    validators: {
                        notEmpty: {
                            message: 'Email Address is required '
                        },
                    }
                },
                mobile: {
                	validators: {
                        notEmpty: {
                            message: 'Mobile Number is required '
                        },
                    }
                },
                street: {
                    validators: {
                        notEmpty: {
                            message: 'Street is required'
                        }
                    }
                },
                city: {
                    validators: {
                        notEmpty: {
                            message: 'City is required'
                        }
                    }
                },
                pin: {
                    validators: {
                        notEmpty: {
                            message: 'Pin is required'
                        },
                        regexp: {
                            regexp: /^[0-9]*$/,
                            message: 'Age can consist only numbers'
                        }
                    }
                }
            }
        }).on('success.form.bv', function(e) {
            e.preventDefault();
            var $form = $(e.target);
            var bv = $form.data('bootstrapValidator');
        });
        
});

$(document).ready(function() {
	$("#deleteUser").click(function (){
		swal({
				title: "Are you sure?",
				text: "Do you want to delete the selected user",
				type: "warning",
				showCancelButton: true,
				confirmButtonColor: '#DD6B55',
				confirmButtonText: 'Yes, delete it!',
				closeOnConfirm: true
			});
	});
});
