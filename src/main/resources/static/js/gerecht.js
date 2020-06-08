$(function(){
var gerechtId = 2;
var $gerechtnaam = $('#gerecht-naam');

$.ajax({
    type: 'GET',
    url: '/gerechten',
    success: function(data){
        console.log('succes', data);
        if( data.id = gerechtId){
        $gerechtnaam.html(data[data.id-1].naam);
        }               
    }
}
)

var $gerechtingredienten = $('#gerecht-ingredienten');
$.ajax({
    type: 'GET',
    url: '/ingredienten',
    success: function(data){
        console.log('succes', data);
        if( data.id = gerechtId){
            $gerechtingredienten.html(data[data.id-1].product);
                              
                       };
    }
})

var $gerechtbereidingswijze = $('#gerecht-bereidingswijze');
$.ajax({
    type: 'GET',
    url: '/gerechten',
    success: function(data){
        console.log('succes', data);
        if( data.id = gerechtId){
        $gerechtbereidingswijze.html(data[data.id-1].bereidingswijze);
        }               
    }
}
)

var $gerechtbereidingstijd = $('#gerecht-bereidingstijd');
$.ajax({
    type: 'GET',
    url: '/gerechten',
    success: function(data){
        console.log('succes', data);
        if( data.id = gerechtId){
        $gerechtbereidingstijd.html(data[data.id-1].bereidingstijd);
        }               
    }
}
)

});
