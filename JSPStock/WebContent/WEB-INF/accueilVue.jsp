<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String nomUtilisateur = (String) request.getAttribute("nom");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueilVue.jsp</title>
</head>
<body>
	<jsp:include page="navBar.jsp">
		<jsp:param value="" name="utilisateurConnecte" />
	</jsp:include>
	Bonjour, bienvenue <%=nomUtilisateur%>.
</body>
</html>