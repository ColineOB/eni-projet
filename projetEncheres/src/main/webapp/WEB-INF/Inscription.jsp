<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@page import="fr.eni.projet.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
	<%@ include file="./fragments/headerWithoutConnect.html" %>
<section>
<h1 class="titre">Inscription</h1>
	<%-- formulaire d'inscription --%>
	<form method="post" action="<%=request.getContextPath() %>/ServletInscription" class="formulaireInscription">
		
			<div class="ligneFormulaire">
				<div class="gauche">
					<div><label for="pseudo">Pseudo:</label></div>
					<div><input type="text" name="pseudo" id="pseudo" value="${sessionScope['utilisateur'].pseudo}"></div>
				</div>
				<div class="droite">
					<div><label for="nom">Nom:</label></div>
					<div><input type="text" name="nom" id="nom" value="${sessionScope['utilisateur'].nom}"></div>
				</div>
			</div>
			<div class="ligneFormulaire">	
				<div class="gauche">
					<div><label for="prenom">Prénom:</label></div>
					<div><input type="text" name="prenom" id="prenom" value="${sessionScope['utilisateur'].prenom}"></div>
				</div>
				<div class="droite">
					<div><label for="email">@mail:</label></div>
					<div><input type="email" name="email" id="email" value="${sessionScope['utilisateur'].email}"></div>
				</div>
			</div>
			<div class="ligneFormulaire">
				<div class="gauche">
					<div><label for="tel">Téléphone:</label></div>
					<div><input type="tel" name="tel" id="tel" value="${sessionScope['utilisateur'].telephone}" ></div>
				</div>
				<div class="droite">
					<div><label for="rue">Rue:</label></div>
					<div><input type="text" name="rue" id="rue" value="${sessionScope['utilisateur'].rue}"></div>
				</div>
			</div>
			<div class="ligneFormulaire">
				<div class="gauche">
					<div><label for="cp">Code Postal:</label></div>
					<div><input type="text" name="cp" id="cp" value="${sessionScope['utilisateur'].codePostal}"></div>
				</div>
				<div class="droite">
					<div><label for="ville">Ville:</label></div>
					<div><input type="text" name="ville" id="ville" value="${sessionScope['utilisateur'].ville}"></div>
				</div>
			</div>
			<div class="ligneFormulaire">
				<div class="gauche">
					<div><label for="mdp">Mot de passe:</label></div>
					<div><input type="password" name="mdp" id="mdp" placeholder="mdp" required></div>
				</div>
				<div class="droite">
					<div><label for="confirmation">Confirmation:</label></div>
					<div><input type="password" name="confirmation" id="confirmation" placeholder="mdp" required></div>
				</div>
			</div>
			<div class="blocBouton">
				<div >
					<input type="submit" value="Créer" class="bouton">
				</div>
				<div >
					<input type="reset" value="annuler" class="bouton">
				</div>
			</div>
				<div class="messageErreur"><c:if test="${listeCodesErreur!=null}">
                    <p style="color:red;">Erreur d'inscription :</p>
                    <c:forEach var="codeErreur" items="${listeCodesErreur}">
                       <c:out value="${LecteurMessage.getMessageErreur(codeErreur)}" />
                    </c:forEach>
                </c:if>
			</div>
	</form>
</section>
</body>
<%@ include file="./fragments/footer.html" %>
</html>