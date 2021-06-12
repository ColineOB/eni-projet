<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="fr.eni.projet.bo.ArticleVendu"%>
    <%@page import="fr.eni.projet.bo.Categorie"%>
    <%@page import="fr.eni.projet.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	</head>
	<body>
		<%@ include file="./fragments/headerConnect.jsp" %>
		<section>
			<h1 id="titreDetailVente" class="titre">Détail Vente</h1>
			<div class="blocEntierDetailVente">
				<div class="blocContenu">
					<h4>${article.nomArticle}</h4>
				</div>
				<div class="blocDouble">
					<div class="blocNom">	
						<p>Description : </p>
					</div>
					<div class="blocContenu">
						<p>${article.description}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">	
						<p>Categorie : </p>
					</div>
					<div class="blocContenu">
						<p>${categorie.libelle}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">	
						<p>Meilleur offre : </p>
					</div>
					<div class="blocContenu">
						<p>${article.prixVente}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">	
						<p>Mise à prix : </p>
					</div>
					<div class="blocContenu">
						<p>${article.miseAPrix}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">	
						<p>Fin de l'enchère : </p>
					</div>
					<div class="blocContenu">
						<p>${article.dateFinEncheres}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">
						<p>Retrait : </p>
					</div>
					<div class="blocContenu">
						<p>${user.rue}</p>
						<p>${user.codePostal} ${user.ville}</p>
					</div>
				</div>
				<div class="blocDouble">
					<div class="blocNom">
						<p>Vendeur : </p>
					</div>
					<div class="blocContenu">
						<p>${user.pseudo}</p>
					</div>
				</div>
				<div class="blocDouble">
					<form method="post" action="<%=request.getContextPath() %>/ServletDetailVente">
						<div class="blocNom">
							<label for="prix">Ma proposition  : </label>
						</div>
						<div class="blocContenu">
							<input type="number" name="prix" id="prix" min="${article.prixVente}">
							<input type="submit" id="encherir" value="Enchérir" class="bouton">
						</div>
					</form>
				</div>
			</div>
		</section>
		<%@ include file="./fragments/footer.html" %>
	</body>
</html>