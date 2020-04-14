<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 13/04/2020
  Time: 14:08
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- Stylesheet -->
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

    <!-- Script -->
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <title>${title}</title>
</head>
<body>
    <header class="card nopadding w-100 d-flex flex-row justify-content-between">
        <h3 class="w-25 h-100 d-flex justify-content-center align-items-center">ENI-Enchères</h3>
        <c:if test="${sessionScope.title == 'accueil'}">
            <%@include file="navigation.jsp"%>
        </c:if>
    </header>
