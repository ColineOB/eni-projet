<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
	
	<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	
	<jsp:forward page="ServletAccueil"></jsp:forward>
	
	<body>
		<%@ include file="/WEB-INF/fragments/headerNotConnect.html" %>
	
		<%@ include file="/WEB-INF/fragments/footer.html" %>
	</body>
</html>
