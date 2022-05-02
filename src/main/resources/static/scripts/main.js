$(function(){
    if (typeof $.cookie('userId') === 'undefined') {
      window.location.href = '/auth';
    }
});

$(function() {
    $( "#openClose" ).load( "/openTasks?id=" + $.cookie('userId'));

    $(document).on('click', '.header-nav-item', function(e){
        $('.header-nav-item').removeClass('active');
        $(this).addClass('active');
        $('.data-placeholder').empty();
    });
});

$(function(){
    $(document).on('click', '.header-nav-item', function(e){
        $('#openClose').empty();

        switch(this.text){
            case("Открытые задачи"):
                $( "#openClose" ).load( "/openTasks?id=" + $.cookie('userId'));
                break;
            case("Закрытые задачи"):
                $( "#openClose" ).load( "/closeTasks" );
                break;
        };
    });
});

$(function(){
    $(document).on('click', '#outBtn', function(e){
        $.removeCookie('userId');
    });
});