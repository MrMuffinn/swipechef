function back_to_top() {
    $('body,html').animate({
        scrollTop: 0
    }, 100);
}

let gerechten = [];
let ingredienten = [];
let arrayId = 1;
let arraySize = 0;
let ingredientId = 0;
let gerechtId = 1;

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
            gerechten = data;
            gerechtId = data[arrayId - 1].id;
            $gerechtnaam.html(data[arrayId - 1].naam);
            $gerechtbereidingswijze.html('<strong>Bereidingswijze: </strong>' + data[arrayId - 1].bereidingswijze);
            $gerechtbereidingstijd.append('<strong>Bereidingstijd: </strong>' + data[arrayId - 1].bereidingstijd + ' minuten');
        }
    });

    $.ajax({
        type: 'GET',
        url: '/ingredienten',
        success: function (data) {
            ingredienten = data;
            if (arraySize > 0) {
                for (var i = 0; i < data.length; i++) {
                    var ingredientrij = data[i]
                    if (ingredientrij[1] == gerechtId) {
                        $gerechtingredienten.append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
                    }
                }
            }
            else {
            }
        }
    });



});

function vervanghtml() {
    if (arrayId < arraySize) {
        arrayId++;
        gerechtId = gerechten[arrayId - 1].id;
        ingredientId = gerechten[arrayId - 1].id;
        $("#gerecht-naam").empty().append(gerechten[arrayId - 1].naam);
        $("#gerecht-bereidingstijd").empty().append('<strong>Bereidingstijd: </strong>' + gerechten[arrayId - 1].bereidingstijd + ' minuten');
        $("#gerecht-bereidingswijze").empty().append('<strong>Bereidingswijze: </strong>' + gerechten[arrayId - 1].bereidingswijze);
        $("#gerecht-ingredienten").empty();
        for (var i = 0; i < ingredienten.length; i++) {
            var ingredientrij = ingredienten[i]
            if (ingredientrij[1] == gerechtId) {
                $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
            }
        }
    }
    else {
        arrayId = 1;
        gerechtId = gerechten[arrayId - 1].id;
        ingredientId = gerechten[arrayId - 1].id;
        $("#gerecht-naam").empty().append(gerechten[arrayId - 1].naam);
        $("#gerecht-bereidingstijd").empty().append('<strong>Bereidingstijd: </strong>' + gerechten[arrayId - 1].bereidingstijd + ' minuten');
        $("#gerecht-bereidingswijze").empty().append('<strong>Bereidingswijze: </strong>' + gerechten[arrayId - 1].bereidingswijze);
        $("#gerecht-ingredienten").empty();
        for (var i = 0; i < ingredienten.length; i++) {
            var ingredientrij = ingredienten[i]
            if (ingredientrij[1] == gerechtId) {
                $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
            }
        }
    }
}

$(document).ready(function () {
    $("#volgendegerecht").on('click', function () {
        vervanghtml();
    });
});


