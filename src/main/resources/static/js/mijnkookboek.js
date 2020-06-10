function back_to_top() {
    $('body,html').animate({
        scrollTop: 0
    }, 100);
}

let gerechten = [];
let ingredienten = [];
let gerechtId = 1;
let arraySize = 0;
let ingredientId= 0;

$(function () {

    var $gerechtnaam = $('#gerecht-naam');
    var $gerechtbereidingstijd = $('#gerecht-bereidingstijd');
    var $gerechtbereidingswijze = $('#gerecht-bereidingswijze');
    var $gerechtingredienten = $('#gerecht-ingredienten');
    

    $.ajax({
        type: 'GET',
        url: '/allegerechten',
        success: function (data) {
            arraySize = data.length;
            console.log('succes', data);
            gerechten = data;
            $gerechtnaam.html(data[gerechtId-1].naam);
            $gerechtbereidingswijze.html('Bereidingswijze: ' + data[gerechtId-1].bereidingswijze);
            $gerechtbereidingstijd.append('Bereidingstijd: ' + data[gerechtId-1].bereidingstijd + ' minuten');
        }
    });

    $.ajax({
        type: 'GET',
        url: '/ingredienten',
        success: function (data) {
            ingredienten = data;
            console.log(data);
            for (var i = 0; i < data.length; i++) {
                var ingredientrij = data[i]
                console.log(data[i]);
                if (ingredientrij[1] == gerechtId) {
                    console.log(ingredientrij);
                    $gerechtingredienten.append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
                }
            }
        }
    });

    

});

function vervanghtml() {
    if(gerechtId < arraySize){
    gerechtId++;
    ingredientId = gerechten[gerechtId-1].id;
    $("#gerecht-naam").empty().append(gerechten[gerechtId - 1].naam);
    $("#gerecht-bereidingstijd").empty().append('Bereidingstijd: ' + gerechten[gerechtId - 1].bereidingstijd + ' minuten');
    $("#gerecht-bereidingswijze").empty().append('Bereidingswijze: ' + gerechten[gerechtId - 1].bereidingswijze);
    $("#gerecht-ingredienten").empty();
    for (var i = 0; i < ingredienten.length; i++) {
        var ingredientrij = ingredienten[i]
        console.log(ingredienten[i]);
        if (ingredientrij[1] == gerechtId) {
            console.log(ingredientrij);
            $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
        }
    }
}
    else{
        gerechtId = 1;
        ingredientId = gerechten[gerechtId-1].id;
        $("#gerecht-naam").empty().append(gerechten[gerechtId - 1].naam);
        $("#gerecht-bereidingstijd").empty().append('Bereidingstijd: ' + gerechten[gerechtId - 1].bereidingstijd + ' minuten');
        $("#gerecht-bereidingswijze").empty().append('Bereidingswijze: ' + gerechten[gerechtId - 1].bereidingswijze);
        $("#gerecht-ingredienten").empty();
        for (var i = 0; i < ingredienten.length; i++) {
            var ingredientrij = ingredienten[i]
            console.log(ingredienten[i]);
            if (ingredientrij[1] == gerechtId) {
                console.log(ingredientrij);
                $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
            }
        }
    }
}

$(document).ready(function () {
    $("#volgendegerecht").on('click', function () {
        vervanghtml();
        alert(gerechtId);
    });
});

// $("#opslaan").on('click', function () {

//         alert(gerechtId);
//         var gerecht = gerechtId;
//          $.ajax({
//             type: 'POST',
//             data: { gerecht: gerechtId},
//             url: '/voorkeursgerecht/add',
//             success: function (response) {
//                 alert(response.d)
//                                 },
//             error: function(){
//                     ('error saving favoriet')
//                             }   
//             });
    
    
// });
