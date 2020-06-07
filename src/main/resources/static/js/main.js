function back_to_top() {
   $('body,html').animate({
       scrollTop: 0 }, 100); }

$(function()
{
   var $gerechten = $('#gerechten');
   $.ajax({
       type: 'GET',
       url: '/gerechten',
       success: function (data) {
           $.each(data, function(i, gerecht){
               $gerechten.append(`<li>${gerecht.naam}</li>`);
           });

       }
   });

   var $ingredienten = $('#gerecht-ingredienten');
   $.ajax({
       type: 'GET',
       url: '/ingredienten/1',
       success: function (data) {
           $.each(data, function(i, ingredient){
               $ingredienten.append(`<li>${ingredient.product.naam} ${ingredient.hoeveelheidPP}</li>`);
           });

       }
   });

   var $bereidingswijze = $('#gerecht-bereidingswijze');
   $.ajax({
       type: 'GET',
       url: '/gerechten',
       success: function (data) {
                          $bereidingswijze.html(data[1].bereidingswijze);
            }
   });

});

