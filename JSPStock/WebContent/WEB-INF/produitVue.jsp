<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<!-- Importation de JSTL Core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="head.jsp" />

<body>

	<%
		String utilisateurConnecte = (String) request.getSession().getAttribute("userName");
	%>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Liste de produits" name="logo" />
	</jsp:include>

	<jsp:useBean id="panier" class="fr.adaming.panier.Panier"
		scope="session">
	</jsp:useBean>


	<!-- <div class="container"> -->
	<div class="row">
		<table class="col s8 striped offset-s1">
			<thead class="grey">
				<tr>
					<th data-field="id">Id</th>
					<th data-field="name">Name</th>
					<th data-field="description">Description</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<jsp:useBean id="lastEditedProduct"
					class="fr.adaming.produits.Produit" scope="session">
								Executé seulement si l'objet lastEditedProduct n'existait pas (et est crée à l'instant).
				</jsp:useBean>

				<!-- JSTL core permet d'eviter le code java dans ma page jsp, notamment pour les boucles. -->
				<c:forEach items="${produits}" var="produit">
					<tr>
						<td>${produit.getId()}</td>
						<td>
							<c:choose>
								<c:when test="${produit == lastEditedProduct}">
									<b>${produit.getNom()}</b>
								</c:when>
								<c:otherwise>${produit.getNom()}</c:otherwise>
							</c:choose>
						</td>
						<td>${produit.getDescription()}</td>
						<td><a href="ajoutPanier?id=${produit.getId()}">Ajout panier</a></td>
						<td><a href="edit?id=${produit.getId()}">Edit</a></td>
						<td><a href="delete?id=${produit.getId()}">Delete</a></td>
					</tr>
				</c:forEach>

				<tr>
					<td><a href="ajout" class="<%=Constante.BUTTON_COLOR%>">Ajout</a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</tbody>

		</table>

		<div class="col s3">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title">Mon Panier</span>
					<c:forEach items="${panier.getProductIdQuantities()}" var="element"
						varStatus="status">
						<li class="collection-item">${element.key.getNom()}
							(${element.value}) <a class="secondary-content"
							href="deleteFromPanier?id=${element.key.getId()}">Retirer</a>
						</li>
					</c:forEach>
				</div>
				<div class="card-action">
				<c:if test="${!panier.getProductIdQuantities().isEmpty()}">
					<form method="post" action="validerPanier" >
						<button type="submit" class="<%=Constante.BUTTON_COLOR%>">Valider mon panier</button>
					</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<c:forEach items="${requestScope['panierElements']}" var="element" varStatus="status">
			<div class="col s2">
				<div class="card blue-grey">
					<div class="card-content white-text">
						<span class="card-title">${element.produit.nom}</span>
						<p>
							Quantite : <b>${element.quantite}</b>
						</p>
						<p>${element.produit.description}</p>
					</div>
					<div class="card-action">
						<a href="<c:url value="/deleteFromPanier">
							<c:param name="id" value="${element.produit.getId()}" />
							</c:url>">Retirer du panier
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>