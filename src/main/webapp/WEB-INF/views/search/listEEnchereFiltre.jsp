<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 16/04/2020
  Time: 15:01
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${articles}" var="article">
    <div class="w-40 border border-dark">
        <h5>${article.nomArticle}</h5>
        <p>Prix : ${article.prixInitial}</p>
        <p>Fin de l'enchère : ${article.dateFinEncheres}</p>
        <p>Vendeur : <a href="${pageContext.request.contextPath}/consultationProfil?noUtilisateur=${article.noUtilisateur.noUtilisateur}">${article.noUtilisateur.pseudo}</a></p>
    </div>
</c:forEach>