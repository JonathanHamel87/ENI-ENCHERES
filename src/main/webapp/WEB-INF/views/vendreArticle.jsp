<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 15/04/2020
  Time: 14:30
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commons/header.jsp"%>
<section class="ml-5 h-95 w-90 d-flex flex-column">
    <!-- Titre -->
    <h3 class="w-100 text-center">Nouvelle vente</h3>
    <!-- Image -->

    <!-- Formulaire -->
    <form class="w-75" method="post" action="${pageContext.request.contextPath}/vendreArticle/">
        <div>
            <label>Article :</label>
            <input name="nomArticle" type="text" required />
        </div>
        <div>
            <label>Description :</label>
            <textarea required name="description"></textarea>
        </div>
        <div>
            <label>Catégorie :</label>
            <select name="nomCategorie">
                <c:forEach items="${categories}" var="categorie">
                    <option id="${categorie.noCategorie}">${categorie.libelle}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>Photo de l'article :</label>
            <div class="parent-div">
                <button class="btn btn-light">UPLOADER</button>
                <input type="file" name="upfile" />
            </div>
        </div>
        <div>
            <label>Mise à prix :</label>
            <input type="number" name="prixInitial" required />
        </div>
        <div>
            <label>Début de l'enchère :</label>
            <input type="datetime-local" name="dateDebutEnchere" required />
        </div>
        <div>
            <label>Fin de l'enchère :</label>
            <input type="datetime-local" name="dateFinEnchere" required />
        </div>
        <fieldset class="">
            <legend>Retrait</legend>
            <div>
                <label>Rue :</label>
                <input type="text" value="${user.rue}" name="rue" required />
            </div>
            <div>
                <label>Code postal :</label>
                <input type="text" value="${user.codePostal}" name="codePostal" required />
            </div>
            <div>
                <label>Ville :</label>
                <input type="text" value="${user.ville}" name="ville" required />
            </div>
        </fieldset>
        <button class="btn btn-primary">Enregistrer</button>
        <button class="btn btn-primary" id="btn-annuler-vente">Annuler</button>
    </form>
</section>
<script src="js/vendreArticle.js"></script>
</body>
</html>