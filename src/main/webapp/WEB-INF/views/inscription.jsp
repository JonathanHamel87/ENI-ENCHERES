<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 14/04/2020
  Time: 08:40
  Version: 1.1
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="commons/header.jsp"%>
<section class="d-flex flex-column">
   ${sessionScope.userActif}
   <h2 class="w-100 text-center">Mon profil</h2>
   <form class="d-flex w-100 flex-wrap" method="post" action="/inscription/">
      <div class="d-flex flex-row w-100">
         <!-- Colonne gauche -->
         <div class="ml-5 mr-10 w-40">
            <div class="formulaire mt-4">
               <label for="pseudo">Pseudo* :</label>
               <input type="text" id="pseudo" name="pseudo" required />
            </div>
            <div class="formulaire mt-4">
               <label for="prenom">Prénom* :</label>
               <input type="text" id="prenom" name="prenom" required />
            </div>
            <div class="formulaire mt-4">
               <label for="telephone">Téléphone :</label>
               <input type="text" id="telephone" name="telephone"/>
            </div>
            <div class="formulaire mt-4">
               <label for="codePostal">Code postal* :</label>
               <input type="text" id="codePostal" name="codePostal" required />
            </div>
            <div class="formulaire mt-4">
               <label for="password">Mot de passe* :</label>
               <input type="password" id="password" name="password" required />
            </div>
         </div>

         <!-- Colonne droite -->
         <div class="w-40">
            <div class="formulaire mt-4">
               <label for="nom">Nom* :</label>
               <input type="text" id="nom" name="nom" required />
            </div>
            <div class="formulaire mt-4">
               <label for="email">Email* :</label>
               <input type="text" id="email" name="email" required />
            </div>
            <div class="formulaire mt-4">
               <label for="rue">Rue* :</label>
               <input type="text" id="rue" name="rue" required />
            </div>
            <div class="formulaire mt-4">
               <label for="ville">Ville* :</label>
               <input type="text" id="ville" name="ville" required />
            </div>
            <div class="formulaire mt-4">
               <label for="password2">Confirmation* :</label>
               <input type="password" id="password2" name="password2" required />
            </div>
         </div>
      </div>
      <div class="ml-25 w-50 text-center">* champs obligatoire</div>
      <!-- Boutons formulaire -->
      <div class="mt-3 ml-25 formulaire w-50 d-flex flex-row justify-content-between">
         <button class="btn btn-primary w-25" type="submit">Créer</button>
         <a class="btn btn-primary w-25" href="/" id="btn-inscription-annuler">Annuler</a>
      </div>
   </form>

</section>

</body>
</html>