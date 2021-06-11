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

		<section class="sectionNouvelleVente">
		<h1 id="titreNouvelleVente">Nouvelle vente</h1>
			<div class="blocEntierNouvelleVente">
				<form method="post" action="<%=request.getContextPath() %>/ServletNouvelleVente">
				<div class="blocMessageErreur">
					<c:if test="${listeCodesErreur!=null}">
						<p style="color:red;">Erreur, l'article n'a pas pu être ajouté :</p>
						<c:forEach var="codeErreur" items="${listeCodesErreur}">
							<p style="color:red;">${LecteurMessage.getMessageErreur(codeErreur)}</p>
						</c:forEach>
					</c:if>
				</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="article">Article : </label>
						</div>
						<div class="blocContenu">
							<input type="text" name="article" id="article">
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="description">Description : </label>
						</div>
						<div class="blocContenu">
							<input type="text" name="description" id="description">
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="selectCategorie">Categorie</label>
						</div>
						<div class="blocContenu">
							<select name="selectCategorie" id="selectCategorie">
								<c:forEach var="c" items="${categorie}">
										<option value="${c.noCategorie}">${c.libelle}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="photo">Photo de l'article : </label>
						</div>
						<div class="blocContenu">
							<input type="file" name="photo" id="photo">
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="prix">Mise à prix : </label>
						</div>
						<div class="blocContenu">
							<input type="number" name="prix" id="prix" min="1">
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="debutEnchere">Début de l'enchère : </label>
						</div>
						<div class="blocContenu">
							<input type="datetime-local" name="debutEnchere" id="debutEnchere">
						</div>
					</div>
					<div class="blocDouble">
						<div class="blocNom">
							<label for="finEnchere">Fin de l'enchère : </label>
						</div>
						<div class="blocContenu">
							<input type="datetime-local" name="finEnchere" id="finEnchere">
						</div>
					</div>
					<fieldset class="blocRetrait">
					<legend>Retrait</legend>
					<div class="blocAdresse">
						<div class="blocDouble">
							<div class="blocNom">
								<label for="rue">Rue : </label>
							</div>
							<div class="blocContenu">
								<input type="text" name="rue" id="rue" value="${sessionScope['utilisateur'].rue}">
							</div>
						</div>
						<div class="blocDouble">
							<div class="blocNom">
								<label for="codePostal">Code postal : </label>
							</div>
							<div class="blocContenu">
								<input type="text" name="codePostal" id="codePostal" value="${sessionScope['utilisateur'].codePostal}">
							</div>	
						</div>
						<div class="blocDouble">
							<div class="blocNom">
								<label for="ville">Ville : </label>
							</div>
							<div class="blocContenu">
								<input type="text" name="ville" id="ville" value="${sessionScope['utilisateur'].ville}">
							</div>
						</div>
					</div>
					</fieldset>
					<div class="blocDouble">
						<div class="blocNom">
							<input type="submit" value="Enregistrer" class="bouton">
						</div>
						
						<div class="blocContenu">
							<input type="reset" value="Annuler" class="bouton">
						</div>
					</div>
				</form>
			</div>
		</section>
		
		<%@ include file="./fragments/footer.html" %>
	</body>
</html>