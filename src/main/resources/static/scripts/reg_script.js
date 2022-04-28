$(document).on('submit', function(e){
    e.preventDefault();
    if (e.target.id != '#btn_cancel') {
            $('#div_none').hide();
            if ($('#floatingInput').val() == '' ||
             $('#floatingPassword').val() == '' ||
             $('#input_lastName').val() == '' ||
             $('#input_firstName').val() == '' ||
             $('#input_email').val() == '') {
                $('#div_none').show();
                $('#lb_error').text("Не все поля заполнены");
            }else{
                var dataReg = { login: $('#floatingInput').val(),
                                 password: $('#floatingPassword').val(),
                                 lastName: $('#input_lastName').val(),
                                 firstName: $('#input_firstName').val(),
                                 patronymic: $('#input_patronymic').val(),
                                 email: $('#input_email').val() }
                $.ajax({
                    url: '/reg',
                    type: 'POST',
                    data: JSON.stringify(dataReg),
                    contentType: 'application/json; charset=utf-8',
                    dataType: 'text',
                    async: true,
                    success: function(data) {
                        alert(data);
                    },
                    error: function(jqXHR) {
                        $('#div_none').show();
                        $('#lb_error').text(jqXHR.responseText);
                    }
                });
            };
        };
});
$(document).on('click', '#btn_cancel', function(e){
    window.location.href = '/auth';
});