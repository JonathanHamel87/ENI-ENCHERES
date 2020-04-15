<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 15/04/2020
  Time: 11:03
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.userActif != null}">
    <div>
        <label>Pseudo :</label>
        <input class="profil-disable" type="text" value="${user.pseudo}" />
    </div>
    <div>
        <label>Nom :</label>
        <input type="text" value="${user.nom}" disabled />
    </div>
    <div>
        <label>Prénom :</label>
        <input type="text" value="${user.prenom}" disabled />
    </div>
    <div>
        <label>Email :</label>
        <input type="text" value="${user.email}" disabled />
    </div>
    <div>
        <label>Téléphone :</label>
        <input type="text" value="${user.telephone}" disabled />
    </div>
    <div>
        <label>Rue :</label>
        <input type="text" value="${user.rue}" disabled />
    </div>
    <div>
        <label>Code Postal :</label>
        <input type="text" value="${user.codePostal}" disabled />
    </div>
    <div>
        <label>Ville :</label>
        <input type="text" value="${user.ville}" disabled />
    </div>
    <div id="list-btn" class="w-50 ml-25 d-flex flex-row align-items-center justify-content-center">
        <button type="button" class="btn btn-primary" id="btn-modifier-profil" onclick="updateProfil();">Modifier</button>
    </div>
</c:if>
<c:if test="${sessionScope.userActif == null}">
    Merci de vous connecter !
</c:if>