<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 14/04/2020
  Time: 09:08
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="w-75 h-100 d-flex flex-row">
    <ul class="w-100 h-100 d-flex flex-row justify-content-end list-group">
        session = ${sessionScope.userActif}
        <!-- Menu non connecté -->
        <c:if test="${not empty sessionScope.userActif && sessionScope.userActif != null}">
            <li class="list-group-item border-0"><a href="/deconnexion">Déconnexion</a></li>
        </c:if>

        <!-- Menu connecté -->
        <c:if test="${empty sessionScope.userActif}">
            <li class="list-group-item"><a href="/inscription">s'inscrire</a></li>
            <li class="list-group-item border-0 border-bottom"><a href="/connexion">se connecter</a></li>
        </c:if>
    </ul>
</nav>