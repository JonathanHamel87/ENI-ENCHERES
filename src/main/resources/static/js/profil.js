$(document).ready(function () {
    $.ajax({
       type : 'GET',
       url : '/profil/',
       success : function (result) {
            $('#profil').html(result);
       }
    });
});

/* fonction pour afficher la page modification */
function updateProfil(){
    $.ajax({
        type : 'GET',
        url : '/profil/modification',
        success : function (result) {
            $('#profil').html(result);
        }
    });
}

/* Fonction pour enregistrer les modifications */
function saveProfil(){
    let pseudo = $('#pseudo-update-profil').val();
    let nom = $('#nom-update-profil').val();
    let prenom = $('#prenom-update-profil').val();
    let email = $('#email-update-profil').val();
    let telephone = $('#telephone-update-profil').val();
    let codePostal = $('#codePostal-update-profil').val();
    let ville = $('#ville-update-profil').val();
    let password;
    let newPassword;
    let newPassword2;
    let data ="pseudo="+pseudo
        +"&nom="+nom
        +"&prenom="+prenom
        +"&email="+email
        +"&telephone="+telephone
        +"&codePostal="+codePostal
        +"&ville="+ville;
    console.log("Nom = "+nom);
    console.log("Data = "+data);
    $.ajax({
        type : 'POST',
        url : '/profil/update',
        data : data,
        success : function (result) {
            $('#profil').html(result);
        }
    });
}

/* Fonction pour supprimer le compte */
function deleteProfil(){


    $.ajax({
       type : 'GET',
       url : '/profil/delete',
       success : function (result) {
            //$('#profil').html(result);
           window.location.replace("/");
       }
    });
}