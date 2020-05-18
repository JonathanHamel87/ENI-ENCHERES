$(document).ready(function () {
    /* Affichage liste complète des enchères en cours */
    $.ajax({
        method : 'GET',
        url : '/encheres/search',
        success : function (result) {
            $('#liste-encheres').html(result);
        }
    });

    /* Affichage des enchères correspondantes au filtre de recherche */
    $('#btn-search').click(function () {
        let categorie = $('#categorie').val();
        let nomArticle = $('#saisie').val();
        console.log("Saisie = "+nomArticle);
        let data = "categorie="+categorie+"&nomArticle="+nomArticle;
        $.ajax({
            method : 'GET',
            url : '/encheres/searchFiltre',
            data : data,
            success : function (result) {
                $('#liste-encheres').html(result);
            }
        });
    });
});