<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	</head>
	<body>
		<p>Nom vente</p>
		<p>Description : </p>
		<p>Categorie : </p>
		<p>Meilleur offre : </p>
		<p>Mise à prix : </p>
		<p>Fin de l'enchère : </p>
		<p>Retrait : </p>
		<p>Vendeur : ${sessionScope['utilisateur'].pseudo}</p>
		<form method="post" action="<%=request.getContextPath() %>/ServletDetailVente">
			<label for="prix">Ma proposition  : </label>
			<input type="number" name="prix" id="prix" min="1">
			<input type="submit" value="Enchérir">
		</form>
	</body>
</html>