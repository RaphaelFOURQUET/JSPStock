<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
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

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
	</jsp:include>


	<div class="container">
		<div class="row">
			<table class="col s10 striped">
				<thead>
					<tr>
						<th data-field="id">Id</th>
						<th data-field="name">Name</th>
						<th data-field="description">Description</th>
					</tr>
				</thead>
				<tbody>
					<% List<Produit> listP = (List<Produit>) request.getAttribute("produits"); 
			for(Produit p : listP) { %>

					<tr>
						<td><%=p.getId() %></td>
						<td><%=p.getNom() %></td>
						<td><%=p.getDescription() %></td>
						<td><a href="edit?id=<%=p.getId() %>">Edit</a></td>
						<td><a href="delete?id=<%=p.getId() %>">Delete</a></td>
					</tr>

					<%	}
		%>
					<tr>
						<td><a href="ajout" class="waves-effect waves-light btn">Ajout</a></td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>

</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>