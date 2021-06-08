<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%-- <%@ page session="false" %> --%>

<!DOCTYPE html>
<html lang="fr">
	
	<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
	
	<body>
		<c:choose>
			<c:when test="${sessionScope.utilisateur != null}">
				<%@ include file="/WEB-INF/fragments/accueilConnect.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/fragments/accueilNotConnect.jsp" %>
			</c:otherwise>
		</c:choose>
		
<%-- 		<c:if test=""></c:if> --%>
		
<%-- 		<%@ include file="/WEB-INF/fragments/accueilNotConnect.jsp" %> --%>
<%-- 		<%@ include file="/WEB-INF/fragments/accueilConnect.jsp" %> --%>

	
		<%@ include file="/WEB-INF/fragments/footer.html" %>
	</body>
</html>
