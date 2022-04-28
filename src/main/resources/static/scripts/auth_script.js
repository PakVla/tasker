//Script for check fill input and auth
$(document).on('submit', function(e) {
    e.preventDefault();
    if (e.target.id != '#btn_reg') {
        $('#div_none').hide();
        if ($('#floatingInput').val() == '' || $('#floatingPassword').val() == '') {
            $('#div_none').show();
            $('#lb_error').text("Не введен логин или пароль");
        }else{
            var dataAuth = { login: $('#floatingInput').val(), password: $('#floatingPassword').val() };
            $.ajax({
                url: '/auth',
                type: 'POST',
                data: JSON.stringify(dataAuth),
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

$(document).on('click', '#btn_reg', function(e){
    window.location.href = '/reg';
});
