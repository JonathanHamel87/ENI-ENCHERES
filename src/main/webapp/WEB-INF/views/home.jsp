<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 13/04/2020
  Time: 11:02
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accueil</title>
</head>
<body>
Liste des catégories :
<br>
<c:forEach items="${categories}" var="categorie">
    - ${categorie.libelle}
    <br>
</c:forEach>

</body>
</html>
