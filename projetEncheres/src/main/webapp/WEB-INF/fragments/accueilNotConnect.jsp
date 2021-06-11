<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.bll.ArticleManager"%>
<%@ page import="fr.eni.projet.bo.Enchere"%>
<%@ page import="fr.eni.projet.bo.ArticleVendu"%>

<%@ include file="/WEB-INF/fragments/headerNotConnect.html" %>
<%-- <c:set var="a" value="${ArticleManager.selectionnerArticleById()}"/> --%>
		
<section class="section_accueil">
	<h1 class="titre titre-accueil">Liste des enchères</h1>
	
	<div class="div_global_search">
		<h3>Filtres :</h3>
		
		<form action="<%=request.getContextPath()%>/ServletAccueil" method="post" id="form_search" class="row">
			<div class="row col-md-6">
				<div class="col-md-12">
					<input type="search" id="article-search" name="article-search" aria-label="Rechercher parmis les enchères" placeholder="🔍 Nom de l'article">
				</div>
				<div class="col-md-12 div_categories_accueil">
					<label for="selectCategorie">Catégorie : </label>
					<select name="selectCategorie" id="selectCategorie">
						<c:forEach var="c" items="${categorie}">
							<c:choose>
								<c:when test="${c.libelle == ''}">
									<option value="${c.noCategorie}">Toutes</option>
								</c:when>
								<c:otherwise>
									<option value="${c.noCategorie}">${c.libelle}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-6 div_btn_search">
				<input type="submit" value="Rechercher" id="btn_search" class="bouton"/>
			</div>
		</form>
	</div>
	
	<div class="div_global_articles">
		<c:forEach var="e" items="${enchere}">
			<div class="div_articles">
				<h4><a>${e.article.nomArticle}</a></h4>
				<p>Prix : ${e.montant_encheres} points</p>
				<p>Fin de l'enchère : ${e.dateEncheres}</p>
				<p>Vendeur : ${e.user.pseudo}</p>
			</div>
		</c:forEach>
	</div>
</section>