<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/fragments/headerConnect.jsp"></jsp:include>
<body>
	<%@ include file="./fragments/headerWithoutConnect.html" %>
	<section>
	<h1>Mon profil</h1>
	<form action="<%=request.getContextPath() %>/ServletModifierProfil">" method="post" class="profil">
		<div class="inscription">
			<div id="gauche">
					<label for="pseudo">Pseudo:</label>
				<input type="text" name="pseudo" id="pseudo" value="${sessionScope['utilisateur'].pseudo}">
					<label for="prenom">Prénom:</label>
				<input type="text" name="prenom" id="prenom" value="${sessionScope['utilisateur'].prenom}">
					<label for="tel">Téléphone:</label>
				<input type="tel" name="tel" id="tel" value="${sessionScope['utilisateur'].telephone}" >
					<label for="cp">Code Postal:</label>
				<input type="text" name="cp" id="cp" value="${sessionScope['utilisateur'].codePostal}">
					<label for="mdp">Mot de passe:</label>
				<input type="password" name="mdp" id="mdp" placeholder="mdp" required>
			</div>
			<div id="droite">		
					<label for="nom">Nom:</label>
				<input type="text" name="nom" id="nom" value="${sessionScope['utilisateur'].nom}">
					<label for="email">@mail:</label>
				<input type="email" name="email" id="email" value="${sessionScope['utilisateur'].email}">
					<label for="rue">Rue:</label>
				<input type="text" name="rue" id="rue" value="${sessionScope['utilisateur'].rue}">
					<label for="ville">Ville:</label>
				<input type="text" name="ville" id="ville" value="${sessionScope['utilisateur'].ville}">
					<label for="confirmation">Confirmation:</label>
				<input type="password" name="confirmation" id="confirmation" placeholder="mdp" required>
			</div>
			<div id="bouton">
				<input type="submit" value="Modifier">
				<input type="button" value="Supprimer mon compte">
			</div>
		</div>
	</form>
	
	</section>
</body>
</html>