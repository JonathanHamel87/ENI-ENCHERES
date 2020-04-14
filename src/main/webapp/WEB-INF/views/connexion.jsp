<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 14/04/2020
  Time: 08:40
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/header.jsp"%>
<section class="ml-25 w-50">
   <form method="get" action="">
      <div>
         <label for="identifiant">Identifiant :</label>
         <input name="identifiant" id="identifiant" required />
      </div>
      <div>
         <label for="password">Mot de passe :</label>
         <input name="password" id="password" required />
      </div>
      <div>
         <button class="btn btn-primary" type="submit">Connexion</button>
         <div>
            <input type="checkbox" name="souvenir" id="souvenir"/>
            <label for="souvenir"></label>
            <a>Mot de passe oublié</a>
         </div>
      </div>
   </form>
   <button>Créer un compte</button>
</section>

</body>
</html>