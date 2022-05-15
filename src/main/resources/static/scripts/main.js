$(function(){
    if (typeof $.cookie('userId') === 'undefined') {
        window.location.href = '/auth';
    }
});

$(function() {
    $( "#openClose" ).load( "/allTasks");

    $(document).on('click', '.header-nav-item', function(e){
        $('.header-nav-item').removeClass('active');
        $(this).addClass('active');
    });
});

$(function(){
    $(document).on('click', '.header-nav-subitem', function(e){
        var parent = $(this).closest("ul").prev("a").text();
        $('#openClose').empty();
        $('#typeLabel').text(parent + ': ' + this.text.split(' ')[0].toLowerCase());

        switch(parent){
            case("Все задачи"):
                switch(this.text){
                    case("Открытые задачи"):
                        $( "#openClose" ).load( "/allTasks?completed=false");
                        break;
                    case("Закрытые задачи"):
                        $( "#openClose" ).load( "/allTasks?completed=true");
                        break;
                    case("Все задачи"):
                        $( "#openClose" ).load( "/allTasks");
                        break;
                }
                break;

            case("Назначены мне"):
                switch(this.text){
                    case("Открытые задачи"):
                        $( "#openClose" ).load( "/userTasks?id=" + $.cookie('userId') + "&" + "completed=false");
                        break;
                    case("Закрытые задачи"):
                        $( "#openClose" ).load( "/userTasks?id=" + $.cookie('userId') + "&" + "completed=true");
                        break;
                    case("Все задачи"):
                        $( "#openClose" ).load( "/userTasks?id=" + $.cookie('userId'));
                        break;
                }
                break;

            case("Созданы мной"):
                switch(this.text){
                    case("Открытые задачи"):
                        $( "#openClose" ).load( "/userCreateTasks?id=" + $.cookie('userId') + "&" + "completed=false");
                        break;
                    case("Закрытые задачи"):
                        $( "#openClose" ).load( "/userCreateTasks?id=" + $.cookie('userId') + "&" + "completed=true");
                        break;
                    case("Все задачи"):
                        $( "#openClose" ).load( "/userCreateTasks?id=" + $.cookie('userId'));
                        break;
                }
                break;

        };
    });
});

$(function(){
    $(document).on('click', '#outBtn', function(e){
        $.removeCookie('userId');
    });
});