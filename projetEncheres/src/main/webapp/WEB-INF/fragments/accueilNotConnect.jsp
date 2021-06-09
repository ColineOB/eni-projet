<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.bll.ArticleManager"%>
<%@ page import="fr.eni.projet.bo.Enchere"%>
<%@ page import="fr.eni.projet.bo.ArticleVendu"%>

<%@ include file="/WEB-INF/fragments/headerNotConnect.html" %>
<%-- <c:set var="a" value="${ArticleManager.selectionnerArticleById()}"/> --%>
		
<section class="section_accueil">
	<h1>Liste des enchères</h1>
	
	<div class="div_global_search">
		<h3>Filtres :</h3>
		
		<form action="<%=request.getContextPath()%>/ServletAccueil" method="post" id="form_search">
			<div>
				<div>
					<input type="search" id="article-search" name="article-search" aria-label="Rechercher parmis les enchères" placeholder="🔍 Nom de l'article">
				</div>
				<div>
					<label for="selectCategorie">Categorie</label>
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
			<div>
				<input type="submit" value="Rechercher"/>
			</div>
		</form>
	</div>
	
	<div class="div_global_articles">
		<c:forEach var="e" items="${enchere}">
			<div class="div_articles">				
				<p>Nom article : ${e.article.nomArticle}</p>
				<p>Prix : ${e.montant_encheres} points</p>
				<p>Date enchere : ${e.dateEncheres}</p>
				<p>Vendeur : ${e.user.pseudo}</p>
			</div>
		</c:forEach>
	</div>
</section>