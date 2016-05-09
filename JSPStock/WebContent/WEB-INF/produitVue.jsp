<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<!-- Importation de JSTL Core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="head.jsp" />

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

					<%-- <% List<Produit> listP = (List<Produit>) request.getAttribute("produits"); 
			for(Produit p : listP) { %>

					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getNom() %></td>
						<td><%=p.getDescription() %></td>
						<td><a href="edit?id=<%=p.getId() %>">Edit</a></td>
						<td><a href="delete?id=<%=p.getId() %>">Delete</a></td>
					</tr>

					<%	} %> --%>
					
					<jsp:useBean id="lastEditedProduct"
								class="fr.adaming.produits.Produit"
								scope="session">
								Execute seulement si l'objet lastEditedProduct n'existait pas (et est crée à l'instant).
								</jsp:useBean>

					<!-- JSTL core permet d'eviter le code java dans ma page jsp, notamment pour les boucles. -->
					<c:forEach items="${produits}" var="produit">
<%-- 					<c:forEach items='${requestScope["produits"]}' var="produit"> --%>
 						<tr>
							<td>
							<!-- ${produit.getId()==lastEditedProduct.getId()} -->
								<c:choose>
									<c:when test="${produit == lastEditedProduct}">
										<b>${produit.getId()}</b></c:when>
									<c:otherwise>${produit.getId()}</c:otherwise>
								</c:choose>
							</td>
							<td>${produit.getNom()}</td>
							<td>${produit.getDescription()}</td>
							<td><a href="edit?id=${produit.getId()}">Edit</a></td>
							<td><a href="delete?id=${produit.getId()}">Delete</a></td>
						</tr>
					</c:forEach>



					<tr>
						<td><a href="ajout" class="${Constante.BUTTON_COLOR}">Ajout</a></td>
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