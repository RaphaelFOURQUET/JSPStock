<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<jsp:include page="WEB-INF/head.jsp"/>

<body>

	<% String utilisateurConnecte = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
	%>

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

	<%="Bienvenue " + utilisateurConnecte+" !"%><br />

	<a class="<%=Constante.BUTTON_COLOR %>" href="logout">Log out</a>

	<%
		}
	%>

</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>