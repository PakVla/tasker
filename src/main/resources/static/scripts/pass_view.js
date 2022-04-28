$(document).on('click', '#pass_control',function(e){
    if ($('#floatingPassword').attr('type') == 'password'){
        $('#pass_control').addClass('view');
     	$('#floatingPassword').attr('type', 'text');
    } else {
    	$('#pass_control').removeClass('view');
    	$('#floatingPassword').attr('type', 'password');
    }
});

