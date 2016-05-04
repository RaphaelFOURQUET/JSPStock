<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>
<!-- <!DOCTYPE html PUBLIC>
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
</head> -->

 <jsp:include page="head.jsp"/>

<body>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
	</jsp:include>

	<%
		Produit p = (Produit) request.getAttribute("produit");
	%>

	<!-- Id est passe deux fois, en disabled et en hidden pour etre vu par utilisateur (disabled) et transmis en formulaire(hidden) -->
	<div class="row">
		<form class="col s12"  method="post" action="edit">
			<div class="row">
			<div class="input-field col s6">
					<input disabled value="<%=p.getId()%>" type="text"
						class="validate" name="id"> <label for="id">ID</label>
				</div>
				<div class="input-field col s6">
					<input value="<%=p.getId()%>" type="hidden"
					 name="id"> <label for="id"></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input value="<%=p.getNom()%>" id="name" type="text"
						class="validate" name="name"> <label for="name">Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input value="<%=p.getDescription()%>" type="text" name="description">
					 <label for="description">Description</label>
				</div>
			</div>

			<div class="row">

				<button class="btn waves-effect waves-light" type="submit">
					Edit <i class="material-icons right">send</i>
				</button>

			</div>
		</form>
	</div>


</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>