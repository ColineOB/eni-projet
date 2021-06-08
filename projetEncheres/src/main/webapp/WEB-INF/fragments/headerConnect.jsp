<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="py-3 bg-dark header-demodule fixed-top">
	<div class="container text-white" id="entete">
		<div id="logo">
			<a href="index.jsp">ENI-Encheres</h1>
		</div>

		<div>
			<a href="index.jsp">Enchères</a>
			<a href="${pageContext.request.contextPath}/ServletNouvelleVente">Vendre un article</a>
			<a href="">Mon profil</a>
			<a href="${pageContext.request.contextPath}/ServletDeconnexion">Déconnexion</a>
		</div>
	</div>
</header>