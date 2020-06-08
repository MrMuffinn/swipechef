$(document).ready(function(){
    $("#nietopslaan").on('click', function(){
      alert(id);
      id++;


    });
  });

  


var id = 1;

$(function(){

var gerechtId = id;
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
        success: function (ingredienten) {
            for (var i = 0; i < ingredienten.length; i++) {
                
                var ingredientrij = ingredienten[i]
                if (ingredientrij.gerecht == gerechtId){
                    console.log(ingredientrij);
                    $gerechtingredienten.append(`<li>${ingredientrij.product} ${ingredientrij.hoeveelheidPP}</li>`);
                }
            }
        }
    });

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
});

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
});

$(document).ready(function(){
    $("#welopslaan").on('click', function(){
      alert(gerechtId);
      
    });
  });
    


});
