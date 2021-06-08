<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.bll.ArticleManager"%>

<%@ include file="/WEB-INF/fragments/headerNotConnect.html" %>
<%-- <c:set var="a" value="${ArticleManager.selectionnerArticleById(e.no_article)}"/> --%>
		
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
				<%
			String uneVariable = (String) request.getAttribute("nomArticle");
		%>
		
		<p>L'information fournie par la Servlet est : <%=uneVariable %>.</p>
<%-- 				<p>Nom article : ${a.nomArticle}</p> --%>
				<p>Nom article : ${nomArticle}</p>
				<p>Numéro article : ${e.no_article}</p>
				<p>Date enchere : ${e.dateEncheres}</p>
				<p>Prix : ${e.montant_encheres} points</p>
			</div>
		</c:forEach>
	</div>
</section>