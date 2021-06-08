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
			<div class="containerDetailVente">
				<div class="blocEntierDetailVente">
					<p>Nom de l'article: ${article.nomArticle}</p>
					<p>Description : ${article.description}</p>
					<p>Categorie : ${categorie.libelle}</p>
					<p>Meilleur offre : ${article.prixVente}</p>
					<p>Mise à prix : ${article.miseAPrix}</p>
					<p>Fin de l'enchère : ${article.dateFinEncheres}</p>
					<p>Retrait : ${user.rue}<p>${user.codePostal}</p><p>${user.ville}</p></p>
					<p>Vendeur : ${sessionScope['utilisateur'].pseudo}</p>
					<form method="post" action="<%=request.getContextPath() %>/ServletDetailVente">
						<label for="prix">Ma proposition  : </label>
						<input type="number" name="prix" id="prix" min="1">
						<input type="submit" value="Enchérir">
					</form>
				</div>
			</div>
		</section>
	</body>
</html>