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
	<form action="" method="post" class="inscription">
		<div class="inscription">
			<div id="gauche">
					<label for="pseudo">Pseudo:</label>
				<input type="text" name="pseudo" id="pseudo" placeholder="pseudo"  required>
					<label for="prenom">Prénom:</label>
				<input type="text" name="prenom" id="prenom" placeholder="prénom" required>
					<label for="tel">Téléphone:</label>
				<input type="tel" name="tel" id="tel" placeholder="00 00 00 00 00" >
					<label for="cp">Code Postal:</label>
				<input type="text" name="cp" id="cp" placeholder="00000"  required>
					<label for="mdp">Mot de passe:</label>
				<input type="password" name="mdp" id="mdp" placeholder="mdp" required>
			</div>
			<div id="droite">		
					<label for="nom">Nom:</label>
				<input type="text" name="nom" id="nom" placeholder="nom" required>
					<label for="email">@mail:</label>
						<span class="erreur">${form.erreurs['nom']}</span>
				<input type="email" name="email" id="email" placeholder="monEmail@domaine.fr" required>
						<span class="erreur">${form.erreurs['email']}</span>
					<label for="rue">Rue:</label>
				<input type="text" name="rue" id="rue" placeholder="rue" required>
					<label for="ville">Ville:</label>
				<input type="text" name="ville" id="ville" placeholder="ville" required>
					<label for="confirmation">Confirmation:</label>
						<span class="erreur">${form.erreurs['confirmation']}</span>
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