$(document).ready(function(){
    $('.u-section-2').hide();

    $('.go-to-register').click(function (){
        $('.u-section-1').hide();
        $('.u-section-2').show();
    });

    $('.go-to-login').click(function (){
        $('.u-section-1').show();
        $('.u-section-2').hide();
    });
});