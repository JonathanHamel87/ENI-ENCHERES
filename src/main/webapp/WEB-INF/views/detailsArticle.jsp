<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 20/05/2020
  Time: 08:44
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commons/header.jsp"%>
<section id="detailsArticle">
    <input type="text" id="id-article" value="${article.noArticle}" hidden />
    <input type="text" id="id-acheteur" value="${acheteur.noUtilisateur}" hidden />

    <h3>Détail vente</h3>
    <p>${article.nomArticle}</p>
    <div>Descriptions : ${article.description}</div>
    <div>Catégorie : ${article.noCategorie.libelle}</div>
    <div>Meilleure offre:
        <c:if test="${enchere != null}">
            ${enchere.montantEnchere}
        </c:if>
        <c:if test="${enchere == null}">
            0
        </c:if>
    </div>
    <div>Mise à prix: ${article.prixInitial}</div>
    <div>Fin de l'enchère: ${article.dateFinEncheres}</div>
    <div>Retrait: ${retrait.rue} ${retrait.codePostal} ${retrait.ville}</div>
    <div>Vendeur: ${vendeur.pseudo}</div>
    <div>
        <c:if test="${enchere != null}">
            <c:set var="proposition" value="${enchere.montantEnchere +1}"/>
        </c:if>
        <c:if test="${enchere == null}">
            <c:set var="proposition" value="${article.prixInitial +1}"/>
        </c:if>
        Ma proposition :
        <input type="number" id="proposition" value="${proposition}"/>
        <button id="btn-enchere">Enchérir</button>
    </div>
    <div id="message-erreur"></div>
    <div id="message-ajout"></div>
</section>
<script src="js/enchere.js"></script>
</body>
</html>

