let gerechten = [];
let ingredienten = [];
let gerechtId = 1;
let arraySize = 0;
var $email = $('#email');

$(function () {

    var $gerechtnaam = $('#gerecht-naam');
    var $gerechtbereidingstijd = $('#gerecht-bereidingstijd');
    var $gerechtingredienten = $('#gerecht-ingredienten');

    $.ajax({
        type: 'GET',
        url: '/gerechten',
        success: function (data) {
            arraySize = data.length;
            gerechten = data;
            $gerechtnaam.html(data[gerechtId - 1].naam);
            $gerechtbereidingstijd.append('<strong>Bereidingstijd: </strong>' + data[gerechtId - 1].bereidingstijd + ' minuten');
        }
    });

    $.ajax({
        type: 'GET',
        url: '/ingredienten',
        success: function (data) {
            ingredienten = data;
            for (var i = 0; i < data.length; i++) {
                var ingredientrij = data[i]
                if (ingredientrij[1] == gerechtId) {
                    $gerechtingredienten.append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
                }
            }
        }
    });
});

function vervanghtml() {
    if (gerechtId < arraySize) {
        gerechtId++;
        $("#gerecht-naam").empty().append(gerechten[gerechtId - 1].naam);
        $("#gerecht-bereidingstijd").empty().append('<strong>Bereidingstijd: </strong>' + gerechten[gerechtId - 1].bereidingstijd + ' minuten');
        $("#gerecht-ingredienten").empty();
        for (var i = 0; i < ingredienten.length; i++) {
            var ingredientrij = ingredienten[i]
            if (ingredientrij[1] == gerechtId) {
                $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
            }
        }
    }
    else {
        gerechtId = 1;
        $("#gerecht-naam").empty().append(gerechten[gerechtId - 1].naam);
        $("#gerecht-bereidingstijd").empty().append('<strong>Bereidingstijd: </strong>' + gerechten[gerechtId - 1].bereidingstijd + ' minuten');
        $("#gerecht-ingredienten").empty();
        for (var i = 0; i < ingredienten.length; i++) {
            var ingredientrij = ingredienten[i]
            if (ingredientrij[1] == gerechtId) {
                $("#gerecht-ingredienten").append(`<li>${ingredientrij[2]} ${ingredientrij[4]} ${ingredientrij[3]}</li>`);
            }
        }
    }
}

$('#gebruikeridophalen').on('click', function () {

    var naam = $email.val();
    console.log(naam);

    $.ajax({
        type: 'GET',
        url: '/gebruiker/alle',
        success: function (data) {
            console.log('succes', data);
        }
    });
});

$(document).ready(function () {
    $("#volgendegerecht").on('click', function () {
        vervanghtml();
    });
});

$("#opslaan").on('click', function () {
    var gerecht = gerechtId;

    $.ajax({
        type: 'POST',
        data: { gerecht: gerechtId },
        url: '/voorkeursgerecht/add',
        success: function (response) {
        },
        error: function () {
            ('error saving favoriet')
        }
    });
});
