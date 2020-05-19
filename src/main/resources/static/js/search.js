$(document).ready(function () {
    /* Affichage liste complète des enchères en cours */
    $.ajax({
        method : 'GET',
        url : '/encheres/search',
        success : function (result) {
            $('#liste-encheres').html(result);
        }
    });
    /* Affichage panel user */
    $.ajax({
        method : 'GET',
        url : '/encheres/panelUser',
        success : function (result) {
            $('#panel-enchere').html(result);
        }
    });

    /* Affichage des enchères correspondantes au filtre de recherche */
    $('#btn-search').click(function () {
        let categorie = $('#categorie').val();
        let nomArticle = $('#saisie').val();
        let bEncheres = $('#radio-achat').prop('checked');
        let bVentes = $('#radio-ventes').prop('checked');
        let bVenteEnCours = $('#vente-cours').prop('checked');
        let bVenteNonDebutee = $('#vente-non-debute').prop('checked');
        let bVenteTerminee = $('#vente-termine').prop('checked');
        let bEnchereOuverte = $('#enchere-ouverte').prop('checked');
        let bEnchereEnCours = $('#enchere-cours').prop('checked');
        let bEnchereRemportee = $('#enchere-remporte').prop('checked');


        if ($('#userActif').val() == null || $('#userActif').val() == ""){
            bEncheres = false;
            bVentes = false;
            bVenteEnCours = false;
            bVenteNonDebutee = false;
            bVenteTerminee = false;
            bEnchereOuverte = false;
            bEnchereEnCours = false;
            bEnchereRemportee = false;
        }

        console.log("Saisie = "+nomArticle);
        let data = "categorie="+categorie
            +"&nomArticle="+nomArticle
            +"&bEncheres="+bEncheres
            +"&bVentes="+bVentes
            +"&bVenteEnCours="+bVenteEnCours
            +"&bVenteNonDebutee="+bVenteNonDebutee
            +"&bVenteTerminee="+bVenteTerminee
            +"&bEnchereOuverte="+bEnchereOuverte
            +"&bEnchereEnCours="+bEnchereEnCours
            +"&bEnchereRemportee="+bEnchereRemportee;
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