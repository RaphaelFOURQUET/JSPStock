<%@page import="fr.adaming.utilisateur.UtilisateurDAO"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<jsp:include page="WEB-INF/head.jsp"/>

<body>

	<% //int connectedUserId = Integer.parseInt((String)request.getSession().getAttribute(Constante.KEY_CONNECTED_USER));
			//BUG : necessiterait creation AccueilServlet pour verifier user par id et non par name.
	//dans un servlet accueil ?
	//String utilisateurConnecte = utilisateurDAO.findUtilisateur(connectedUserId);
	
	String utilisateurConnecte = (String)request.getSession().getAttribute("userName"); %>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="WEB-INF/navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Connexion" name="logo" />
	</jsp:include>


	<%
		if (utilisateurConnecte == null) {
			//Afficher formulaire connexion
	%>


	<div class="container">
		<div class="row">
			<form class="col s12" method="post" action="login">
				<div class="row">
					<div class="<%=Constante.COL_SIZE%>">
						<input placeholder="login"
							name="<%=Constante.PARAM_USER_LOGIN%>" id="first_name"
							type="text" class="validate"> <label for="first_name">Utilisateur</label>
					</div>
				</div>
				<div class="row">
					<div class="<%=Constante.COL_SIZE%>">
						<input placeholder="password"
							name="password" type="password" class="validate"> 
							<label for="password">Password</label>
					</div>
				</div>
				<button class="<%=Constante.BUTTON_COLOR %>" value="Log in"
					type="submit">Log in</button>
			</form>
		</div>
	</div>

	<%
		} else {
			//Afficher page bienvenue
	%>

	<div class="container">
		<div class="row">
	<%="Bienvenue " + utilisateurConnecte+" !"%><br />
		</div>
		<div class="row">
	<a class="<%=Constante.BUTTON_COLOR %>" href="produit">Produits</a>
		</div>
	</div>
	
	<%
		}
	%>

</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>