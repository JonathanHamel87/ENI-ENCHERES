<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 18/05/2020
  Time: 12:59
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${userActif != null}">
    <!-- Achats -->
    <div class="w-55 nopadding d-flex align-content-start flex-column">
        <div class="nopadding w-100">
            <input type="radio" id="radio-achat" name="test" checked />
            <label>Achats</label>
        </div>

        <div class="nopadding ml-2 w-100">
            <div class="nopadding">
                <input type="checkbox" id="enchere-ouverte" checked />
                <label>enchères ouvertes</label>
            </div>
            <div class="nopadding">
                <input type="checkbox" id="enchere-cours" />
                <label>mes enchères en cours</label>
            </div>
            <div class="nopadding">
                <input type="checkbox" id="enchere-remporte" />
                <label>mes enchères remportées</label>
            </div>
        </div>
    </div>

    <!-- Ventes en cours -->
    <div class="w-45 d-flex align-content-start flex-column">
        <div class="nopadding w-100">
            <input type="radio" id="radio-ventes" name="test" />
            <label>Mes ventes</label>
        </div>

        <div class="nopadding ml-2 w-100">
            <div class="nopadding">
                <input type="checkbox" id="vente-cours" />
                <label>mes ventes en cours</label>
            </div>
            <div class="nopadding">
                <input type="checkbox" id="vente-non-debute" />
                <label>ventes non débutées</label>
            </div>
            <div class="nopadding">
                <input type="checkbox" id="vente-termine" />
                <label>ventes terminées</label>
            </div>
        </div>
    </div>
</c:if>
<script src="js/panelConnectee.js"></script>
