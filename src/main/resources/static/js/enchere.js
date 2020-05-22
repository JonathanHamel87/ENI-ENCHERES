$(document).ready(function () {
    /* Enchérir */
    $('#btn-enchere').click(function () {
        let proposition = $('#proposition').val();
        let article = $('#id-article').val();
        let acheteur = $('#id-acheteur').val();

        let data = "acheteur="+acheteur
                    +"&article="+article
                    +"&proposition="+proposition;

        if (acheteur == null || acheteur == ""){
            $('#message-erreur').html("Merci de vous connecter !");
        }else{
            $('#message-erreur').html("");
            $.ajax({
                method : 'POST',
                url : '/encheres/addEnchere',
                data : data ,
                success : function (result) {
                    $('#message-ajout').html("Merci pour votre enchère !");
                    function reload(){
                        location.reload();
                    }
                    setTimeout(reload, 3000);
                }
            });
        }
    });
});