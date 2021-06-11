<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@page import="fr.eni.projet.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
</head>

<body>
	<%@ include file="./fragments/headerConnect.jsp" %>
	<section>
	<h1 class="titre">Modifier profil</h1>
	<form method="post" action="<%=request.getContextPath() %>/ServletModifierProfil" class="formulaireInscription">
		
			<div class="ligneFormulaire">
				<div class="gauche">
					<label for="pseudo">Pseudo:</label>
					<input type="text" name="pseudo" id="pseudo" value="${sessionScope['utilisateur'].pseudo}">
				</div>
				<div class="droite">
					<label for="nom">Nom:</label>
					<input type="text" name="nom" id="nom" value="${sessionScope['utilisateur'].nom}">
				</div>
			</div>
			<div class="ligneFormulaire">	
				<div class="gauche">
					<label for="prenom">Prénom:</label>
					<input type="text" name="prenom" id="prenom" value="${sessionScope['utilisateur'].prenom}">
				</div>
				<div class="droite">
					<label for="email">@mail:</label>
					<input type="email" name="email" id="email" value="${sessionScope['utilisateur'].email}">
				</div>
			</div>
			<div class="ligneFormulaire">
					<div class="gauche"><label for="tel">Téléphone:</label>
				<input type="tel" name="tel" id="tel" value="${sessionScope['utilisateur'].telephone}" ></div>
					<div class="droite"><label for="rue">Rue:</label>
				<input type="text" name="rue" id="rue" value="${sessionScope['utilisateur'].rue}"></div>
			</div>
			<div class="ligneFormulaire">
					<div class="gauche"><label for="cp">Code Postal:</label>
				<input type="text" name="cp" id="cp" value="${sessionScope['utilisateur'].codePostal}"></div>
					<div class="droite"><label for="ville">Ville:</label>
				<input type="text" name="ville" id="ville" value="${sessionScope['utilisateur'].ville}"></div>
			</div>
			<div class="ligneFormulaire">
					<div class="gauche"><label for="mdp">Mot de passe:</label>
				<input type="password" name="mdp" id="mdp" placeholder="mdp" required></div>
					<div class="droite"><label for="confirmation">Confirmation:</label>
				<input type="password" name="confirmation" id="confirmation" placeholder="mdp" required></div>
			</div>
				<div class="blocBouton">
					<div>
						<input type="submit" value="Modifier"  class="bouton">
					</div>
				</div>
	</form>
	<form method="post" action="<%=request.getContextPath() %>/ServletSupprimerProfil" class="supprProfil">
	<input type="submit" name="Supprimer" value="Supprimer mon compte"  class="bouton">
	</form>
	<div class="messageErreur">
				<c:if test="${listeCodesErreur!=null}">
                    <p style="color:red;">Erreur de modification:</p>
                    <c:forEach var="codeErreur" items="${listeCodesErreur}">
                       <c:out value="${LecteurMessage.getMessageErreur(codeErreur)}" />
                    </c:forEach>
                </c:if>
			</div>
	</section>
</body>
</html>