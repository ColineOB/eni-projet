<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	</head>
	<body>

		<%@ include file="./fragments/headerWithoutConnect.html" %>

		<section>
			<div class="containerConnexion">
				<div class="messageErreur">${messageErreur}</div>
				<div class="blocEntierConnexion">
					<form method="post" action="<%=request.getContextPath() %>/ServletConnexion">
						<div class="blocIdentifiant">
								<label for="login">Identifiant : </label>
								<input type="text" name="login" id="login">
						</div>
						<div class="blocPassword">
							<label for="pass">Mot de passe : </label>
							<input type="password" name="pass" id="pass">
						</div>
						<div class="blocSubmitSouvenirOublie">
								<div class="boutonConnexion">
									<input type="submit" value="Connexion">
								</div>
			  					<div class="blocSouvenirOublie">
				  					<div class="blocSouvenir">
										<input type="checkbox" name="seSouvenirDeMoi" id="seSouvenirDeMoi" value="cocher">
										<label for="seSouvenirDeMoi" >Se souvenir de moi</label>
									</div>
		 							 <div class="blocOublie">
										<a href="<%=request.getContextPath() %>/ServletConnexion?message=La demande de réinitialisation du mot de passe a été envoyé par mail">Mot de passe oublié</a>
									</div>
								</div>
						</div>
					
					<div class="blocCreerCompte">
						<input type="button" onclick="window.location.href = '<%=request.getContextPath()%>/ServletInscription';" value="Créer un compte"/>
					</div>
			</form>
				</div>
			</div>
		</section>
		
		<%@ include file="./fragments/footer.html" %>
	</body>
</html>