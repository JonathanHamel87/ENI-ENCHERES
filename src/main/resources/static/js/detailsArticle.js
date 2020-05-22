$(document).ready(function () {
    /* Affichage détails article */
    $('.details-article').click(function () {
        let id = $(this).attr('id');
        let path = $('.url').attr('id');
        let data = "id="+id;
        let url = path+'detailsArticle?'+data;
        console.log(url);

        window.location.replace(url);

    });

    /* Retour accueil */
    $('#logo').click(function () {
       window.location.replace('/');
    });
});