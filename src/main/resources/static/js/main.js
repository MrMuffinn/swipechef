function back_to_top() {
    $('body,html').animate({
        scrollTop: 0
    }, 100);
}

$(function() {
    var $naam = $('gerecht-naam');
    var $bereidingswijze = $('#gerecht-bereidingswijze');
    $.ajax({
        type: 'GET',
        url: '/gerechten',
        success: function(data) {
            $naam.append(data[0].naam);
            $bereidingswijze.append(data[0].bereidingswijze);
            console.log(data);
        }
    });

    // var $ingredienten = $('#gerecht-ingredienten');
    // $.ajax({
    //     type: 'GET',
    //     url: '/ingredienten/1',
    //     success: function(data) {
    //         $.each(data, function(i, ingredient) {
    //             $ingredienten.append(`<li>${ingredient.product.naam} ${ingredient.hoeveelheidPP}</li>`);
    //         });
    //     }
    // });

    // var $bereidingswijze = $('#gerecht-bereidingswijze');
    // $.ajax({
    //     type: 'GET',
    //     url: '/gerechten',
    //     success: function(data) {
    //         console.log(data[0]);
    //     }
    // });


});