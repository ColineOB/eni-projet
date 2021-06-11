<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.projet.bll.ArticleManager"%>
<%@ page import="fr.eni.projet.bo.Enchere"%>
<%@ page import="fr.eni.projet.bo.ArticleVendu"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/fragments/headerConnect.jsp" %>
		
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
				<div class="col-md-12 div_btn_choice">
					<div class="">
						<input class="check-input" type="radio" name="achatVenteRadios" id="achatsRadio" value="achatsRadio" onclick="disableElementsVente()">
						<label class="check-label" for="achatsRadio">
						    Achats
						</label>
						<div class="check-btns">
							<div class="">
								<input class="check-input" type="checkbox" value="achatsCheck" id="encheresOuvertes">
								<label class="check-label" for="encheresOuvertes">
							    	Enchères ouvertes
							  	</label>
							</div>
							<div class="">
							  	<input class="check-input" type="checkbox" value="achatsCheck" id="encheresEnCours">
							  	<label class="check-label" for="encheresEnCours">
							    	Mes enchères en cours
							  	</label>
							</div>
							<div class="">
							  	<input class="check-input" type="checkbox" value="achatsCheck" id="encheresGagnees">
							  	<label class="check-label" for="encheresGagnees">
							    	Mes enchères remportées
							  	</label>
							</div>
						</div>
					</div>
					<div class="">
						<input class="check-input" type="radio" name="achatVenteRadios" id="ventesRadio" value="ventesRadio" onclick="disableElementsAchat()">
						<label class="check-label" for="ventesRadio">
						    Mes ventes
						</label>
						<div class="check-btns">
							<div class="">
								<input class="check-input" type="checkbox" name="venteCheck" value="en_cours" id="ventesEnCours">
								<label class="check-label" for="ventesEnCours">
							    	Mes ventes en cours
							  	</label>
							</div>
							<div class="">
							  	<input class="check-input" type="checkbox" name="venteCheck" value="non_debute" id="ventesNonDebutees">
							  	<label class="check-label" for="ventesNonDebutees">
							    	Ventes non débutées
							  	</label>
							</div>
							<div class="">
							  	<input class="check-input" type="checkbox" name="venteCheck" value="termine" id="ventesTerminees">
							  	<label class="check-label" for="ventesTerminees">
							    	Ventes terminées
							  	</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 div_btn_search">
				<input type="submit" value="Rechercher" id="btn_search"/>
			</div>
		</form>
	</div>
	
	<div class="div_global_articles">
		<c:forEach var="e" items="${enchere}">
			<div class="div_articles">				
				<h4><a href="<%=request.getContextPath() %>/ServletRedirectionModifDetailVente?no=${e.article.noArticle}">${e.article.nomArticle}</a></h4>
				<p>Prix : ${e.montant_encheres} points</p>
				<p>Fin de l'enchère : <fmt:parseDate value="${e.article.dateFinEncheres}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
						<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" /></p>
				<p>Vendeur : <a href="<%=request.getContextPath() %>/ServletModifierProfil?no=${e.user.noUtilisateur}">${e.user.pseudo}</a></p>
			</div>
		</c:forEach>
	</div>
</section>

<script src="${pageContext.request.contextPath}/js/myscripts.js"></script>
