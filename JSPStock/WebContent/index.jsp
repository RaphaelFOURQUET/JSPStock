<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des stocks</title>
</head>
<body>

	<%
		String utilisateurConnecte = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
	
		if(utilisateurConnecte == null) {
			//Afficher formulaire connexion
	%>

	<form method="post" action="login">
		<!-- On envoie ce formulaire à login -->
		<label for="<%=Constante.PARAM_USER_LOGIN %>"> utilisateur : </label> <input name="<%=Constante.PARAM_USER_LOGIN %>" type="text" /><br />

		<input value="Log in" type="submit" />
	</form>

	<%
		} else {
			//Afficher page bienvenue
	%>
	<%= "Bienvenue "+utilisateurConnecte %><br/>

	<a href="logout">Log out</a>
	
	<%
		}

	%>

</body>
</html>