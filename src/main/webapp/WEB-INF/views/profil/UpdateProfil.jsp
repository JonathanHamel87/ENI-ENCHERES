<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 15/04/2020
  Time: 11:00
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <label>Pseudo :</label>
    <input type="text" id="pseudo-update-profil" value="${user.pseudo}" />
</div>
<div>
    <label>Nom :</label>
    <input type="text" id="nom-update-profil" value="${user.nom}" />
</div>
<div>
    <label>Prénom :</label>
    <input type="text" id="prenom-update-profil" value="${user.prenom}" />
</div>
<div>
    <label>Email :</label>
    <input type="text" id="email-update-profil" value="${user.email}" />
</div>
<div>
    <label>Téléphone :</label>
    <input type="text" id="telephone-update-profil" value="${user.telephone}" />
</div>
<div>
    <label>Rue :</label>
    <input type="text" id="rue-update-profil" value="${user.rue}" />
</div>
<div>
    <label>Code Postal :</label>
    <input type="text" id="codePostal-update-profil" value="${user.codePostal}" />
</div>
<div>
    <label>Ville :</label>
    <input type="text" id="ville-update-profil" value="${user.ville}" />
</div>
<div id="list-btn" class="w-50 ml-25 d-flex flex-row align-items-center justify-content-center">
    <button type="button" class="btn btn-primary" id="btn-enregistrer-profil" onclick="saveProfil();">Enregistrer</button>
    <button type="button" class="btn btn-primary" id="btn-supprimer-profil" onclick="deleteProfil();">Supprimer mon compte</button>
</div>