<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="py-3 bg-dark header-demodule fixed-top">
	<div class="container text-white" id="entete">
		<div id="logo">
			<a href="index.jsp">
				<img alt="" src="img/unicorn3.png" width="50px" height="50px">
				ENI-Encheres
				<img alt="" src="img/unicorn3.png" width="50px" height="50px">
			</a>
		</div>

		<div id="div_nav">
			<a href="index.jsp">
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
				Enchères
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
			</a>
			<a href="${pageContext.request.contextPath}/ServletNouvelleVente">
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
				Vendre un article
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
			</a>
			<a href="${pageContext.request.contextPath}/ServletModifierProfil">
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
				Mon profil
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
			</a>
			<a href="${pageContext.request.contextPath}/ServletDeconnexion">
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
				Déconnexion
				<img alt="" src="img/unicorn4.png" width="20px" height="30px">
			</a>
		</div>
	</div>
</header>