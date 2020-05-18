<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 13/04/2020
  Time: 11:02
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commons/header.jsp"%>
<section class="ml-5 h-95 w-90 d-flex flex-column">
    <!-- Titre -->
    <h3 class="text-center">Liste des enchères</h3>

    <!-- Recherche -->
    <div class="w-100 d-flex flex-row mt-2">
        <!-- Filtre -->
        <div class="w-50">
            <label class="w-100">Filtres :</label>
            <input class="w-100 mb-2" type="search" id="saisie"/>

            <label class="w-25">Catégorie :</label>
            <select class="w-50" id="categorie">
                <option id="0">Toutes</option>
                <c:forEach items="${categories}" var="categorie">
                    <option id="${categorie.noCategorie}">${categorie.libelle}</option>
                </c:forEach>
            </select>
        </div>
        <!-- Bouton rechercher -->
        <button class="btn btn-primary w-30 ml-10" id="btn-search">Rechercher</button>

    </div>

    <!-- Afficxhage liste -->
    <div class="w-100 mt-4 d-flex flex-row flex-wrap" id="liste-encheres"></div>
</section>
<script src="js/search.js"></script>
</body>
</html>
