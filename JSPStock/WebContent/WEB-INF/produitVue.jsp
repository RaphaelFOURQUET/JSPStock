<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<jsp:include page="head.jsp"/>

<body>

	<% String utilisateurConnecte = (String) request.getSession().getAttribute(Constante.KEY_CONNECTED_USER);
	%>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Liste de produits" name="logo" />
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

					<%	} %>
					<tr>
						<td><a href="ajout" class="<%=Constante.BUTTON_COLOR %>">Ajout</a></td>
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