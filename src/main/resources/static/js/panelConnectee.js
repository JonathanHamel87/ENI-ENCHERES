$(document).ready(function () {

    /* Gestion en mode connecté */
    $('#radio-ventes').change(function () {
        if ($('#radio-ventes').is(':checked')){
            // Ventes
            $('#vente-cours').attr('checked', true);
            $('#vente-cours').attr('disabled', false);
            $('#vente-non-debute').attr('checked', false);
            $('#vente-non-debute').attr('disabled', false);
            $('#vente-termine').attr('checked', false);
            $('#vente-termine').attr('disabled', false);
            // Achats
            $('#enchere-ouverte').attr('checked', false);
            $('#enchere-ouverte').attr('disabled', true);
            $('#enchere-cours').attr('checked', false);
            $('#enchere-cours').attr('disabled', true);
            $('#enchere-remporte').attr('checked', false);
            $('#enchere-remporte').attr('disabled', true);
        }else{
            // Ventes
            $('#vente-cours').attr('checked', false);
            $('#vente-non-debute').attr('checked', false);
            $('#vente-termine').attr('checked', false);
            // Achats
            $('#enchere-ouverte').attr('checked', false);
            $('#enchere-cours').attr('checked', false);
            $('#enchere-remporte').attr('checked', false);
        }

    });
    $('#radio-achat').change(function () {
        if($('#radio-achat').is(':checked')){
            // Achats
            $('#enchere-ouverte').attr('checked', true);
            $('#enchere-ouverte').attr('disabled', false);
            $('#enchere-cours').attr('checked', false);
            $('#enchere-cours').attr('disabled', false);
            $('#enchere-remporte').attr('checked', false);
            $('#enchere-remporte').attr('disabled', false);
            // Ventes
            $('#vente-cours').attr('checked', false);
            $('#vente-cours').attr('disabled', true);
            $('#vente-non-debute').attr('checked', false);
            $('#vente-non-debute').attr('disabled', true);
            $('#vente-termine').attr('checked', false);
            $('#vente-termine').attr('disabled', true);
        }else{
            // Achats
            $('#enchere-ouverte').attr('checked', false);
            $('#enchere-cours').attr('checked', false);
            $('#enchere-remporte').attr('checked', false);
            // Ventes
            $('#vente-cours').attr('checked', false);
            $('#vente-non-debute').attr('checked', false);
            $('#vente-termine').attr('checked', false);
        }
    });
});