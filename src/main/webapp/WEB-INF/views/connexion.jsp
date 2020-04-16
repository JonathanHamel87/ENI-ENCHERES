<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 14/04/2020
  Time: 08:40
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commons/header.jsp"%>
<section class="ml-25 w-50">
   <form method="get" action="${pageContext.request.contextPath}/connexion/" >
      <div class="form-group">
         <label for="identifiant">Identifiant :</label>
         <input name="identifiant" id="identifiant" required />
      </div>
      <div class="form-group">
         <label for="password">Mot de passe :</label>
         <input name="password" id="password" type="password" required />
      </div>
      <div class="form-group">
         <div class="form-check">
            <input type="checkbox" name="souvenir" id="souvenir"/>
            <label for="souvenir">Se souvenir de moi</label>
         </div>
         <a>Mot de passe oublié</a>
      </div>
      <button class="btn btn-primary" type="submit">Connexion</button>
      ${sessionScope.messageError}
   </form>
   <button>Créer un compte</button>

</section>

</body>
</html>