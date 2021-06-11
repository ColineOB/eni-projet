<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="fr.eni.projet.messages.LecteurMessage"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	</head>
	<body>

		<%@ include file="./fragments/headerConnect.jsp" %>

		<section>
		<h1>Modifier la vente</h1>
			<div class="containerNouvelleVente">
				<div class="blocEntierNouvelleVente">
					<form method="post" action="<%=request.getContextPath() %>/ServletModifVente">
					<div class="blocMessageErreur">
						<c:if test="${listeCodesErreur!=null}">
							<p style="color:red;">Erreur, l'article n'a pas pu être ajouté :</p>
							<c:forEach var="codeErreur" items="${listeCodesErreur}">
								${LecteurMessage.getMessageErreur(codeErreur)} </br>
							</c:forEach>
						</c:if>
					</div>
						<div class="blocArticle">
								<label for="article">Article : </label>
								<input type="text" name="article" id="article" value="${article.nomArticle}">
						</div>
						<div class="blocDescription">
							<label for="description">Description : </label>
							<input type="text" name="description" id="description" value="${article.description}">
						</div>
						<div class="blocCategorie">
							<label for="selectCategorie">Categorie</label>
							<select name="selectCategorie" id="selectCategorie">
								<c:forEach var="c" items="${categorie}">
										<option value="${c.noCategorie}">${c.libelle}</option>
								</c:forEach>
							</select>
<%-- 								<option value="${categorie.noCategorie}" selected >${categorie.libelle}</option> --%>
<%-- 									<c:if test="${c.noCategorie != categorie.noCategorie}"> --%>
<%-- 							        </c:if> --%>
<!-- https://stackoverflow.com/questions/2682018/set-html-dropdown-selected-option-using-jstl -->
						</div>
						<div class="blocPhoto">
							<label for="photo">Photo de l'article : </label>
							<input type="file" name="photo" id="photo" value="">
						</div>
						<div class="blocPrix">
							<label for="prix">Mise à prix : </label>
							<input type="number" name="prix" id="prix" min="1" value="${article.miseAPrix}">
						</div>
						<div class="blocDebutEnchere">
							<label for="debutEnchere">Début de l'enchère : </label>
							<input type="datetime-local" name="debutEnchere" id="debutEnchere" value="${article.dateDebutEncheres}">
						</div>
						<div class="blocFinEnchere">
							<label for="finEnchere">Fin de l'enchère : </label>
							<input type="datetime-local" name="finEnchere" id="finEnchere" value="${article.dateFinEncheres}">
						</div>
						<div class="blocRetrait">
							Retrait
							<div class="blocRue">
								<label for="rue">Rue : </label>
								<input type="text" name="rue" id="rue" value="${user.rue}">
							</div>
							<div class="blocCodePostal">
								<label for="codePostal">Code postal : </label>
								<input type="text" name="codePostal" id="codePostal" value="${user.codePostal}">
							</div>
							<div class="blocVille">
								<label for="ville">Ville : </label>
								<input type="text" name="ville" id="ville" value="${user.ville}">
							</div>
						</div>
						<div class="boutonConnexion">
							<input type="submit" value="Enregistrer">
							<input type="reset" value="Annuler">
						</div>
					</form>
				</div>
			</div>
		</section>
		
		<%@ include file="./fragments/footer.html" %>
	</body>
</html>