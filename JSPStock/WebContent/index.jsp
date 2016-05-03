<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des stocks</title>
<style>
@font-face {
	font-family: 'Material Icons';
	font-style: normal;
	font-weight: 400;
	src: local('Material Icons'), local('MaterialIcons-Regular'),
		url(http://fonts.gstatic.com/s/materialicons/v16/2fcrYFNaTjcS6g4U3t-Y5ZjZjT5FdEJ140U2DJYC3mY.woff2)
		format('woff2');
}

.material-icons {
	font-family: 'Material Icons';
	font-weight: normal;
	font-style: normal;
	font-size: 24px;
	line-height: 1;
	letter-spacing: normal;
	text-transform: none;
	display: inline-block;
	white-space: nowrap;
	word-wrap: normal;
	direction: ltr;
	-webkit-font-feature-settings: 'liga';
	-webkit-font-smoothing: antialiased;
}
</style>
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</head>
<body>

	<% String utilisateurConnecte = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
	%>

	<%-- <nav>
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Logo</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<%
		if (utilisateurConnecte != null) {
			//Afficher formulaire connexion
	%>
			<ul class="right hide-on-med-and-down">
				<li><a href="logout">Log out</a></li>
			</ul>
			<% } %>
		</div>
	</nav> --%>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte"/>
	</jsp:include>


	<%
		if (utilisateurConnecte == null) {
			//Afficher formulaire connexion
	%>

	<!-- <nav>
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Logo</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
		</div>
	</nav> -->

	<%-- <form method="post" action="login">
		<!-- On envoie ce formulaire à login -->
		<label for="<%=Constante.PARAM_USER_LOGIN %>"> utilisateur : </label> <input name="<%=Constante.PARAM_USER_LOGIN %>" type="text" /><br />

		<input value="Log in" type="submit" />
	</form> --%>

	<div class="container">
		<div class="row">
			<form class="col s12" method="post" action="login">
				<div class="row">
					<div class="input-field col s6">
						<input placeholder="Placeholder"
							name="<%=Constante.PARAM_USER_LOGIN%>" id="first_name"
							type="text" class="validate"> <label for="first_name">Utilisateur</label>
					</div>
				</div>
				<button class="waves-effect waves-light btn" value="Log in"
					type="submit">Log in</button>
			</form>
		</div>
	</div>

	<%
		} else {
			//Afficher page bienvenue
	%>

	<!-- <nav>
		<div class="nav-wrapper">
			<a href="#!" class="brand-logo">Logo</a> <a href="#"
				data-activates="mobile-demo" class="button-collapse"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li><a href="logout">Log out</a></li>
			</ul>
		</div>
	</nav> -->

	<%="Bienvenue " + utilisateurConnecte+" !"%><br />

	<a href="logout">Log out</a>

	<%
		}
	%>

</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>