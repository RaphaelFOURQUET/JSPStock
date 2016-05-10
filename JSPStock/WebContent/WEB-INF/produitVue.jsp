<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<!-- Importation de JSTL Core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="head.jsp" />

<body>

	<% String utilisateurConnecte = (String) request.getSession().getAttribute("userName"); 
		String buttonColor = Constante.BUTTON_COLOR; %>

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
						class="fr.adaming.produits.Produit" scope="session">
								Execute seulement si l'objet lastEditedProduct n'existait pas (et est crée à l'instant).
					</jsp:useBean>

					<!-- JSTL core permet d'eviter le code java dans ma page jsp, notamment pour les boucles. -->
					<c:forEach items="${produits}" var="produit">
						<%-- 					<c:forEach items='${requestScope["produits"]}' var="produit"> --%>
						<tr>
							<td>
								<!-- ${produit.getId()==lastEditedProduct.getId()} --> <c:choose>
									<c:when test="${produit == lastEditedProduct}">
										<b>${produit.getId()}</b>
									</c:when>
									<c:otherwise>${produit.getId()}</c:otherwise>
								</c:choose>
							</td>
							<td>${produit.getNom()}</td>
							<td>${produit.getDescription()}</td>
							<td><a href="ajoutPanier?id=${produit.getId()}">Ajout
									panier</a></td>
							<td><a href="edit?id=${produit.getId()}">Edit</a></td>
							<td><a href="delete?id=${produit.getId()}">Delete</a></td>
						</tr>
					</c:forEach>

					<tr>
						<td><a href="ajout" class="<%=Constante.BUTTON_COLOR%>">Ajout</a></td>
					</tr>

				</tbody>

			</table>

		</div>
	</div>

	<jsp:useBean id="panier" class="fr.adaming.panier.Panier"
		scope="session">
				Panier vide crée.
	</jsp:useBean>

	<%-- <div class="col s10 container">
		<ul class="collection with-header">
        	<li class="collection-header"><h4>Mon panier :</h4></li>
       	 	<c:forEach items="${panier.getProduits()}" var="prod" varStatus="status">
				<li class="collection-item">${prod.getNom()}
				<a href="deleteFromPanier?ligne=${status.getIndex()}">Enlever</a>
				</li>
			</c:forEach>

   		</ul>
   		 <a href="validerPanier" class="<%=Constante.BUTTON_COLOR%>">Valider mon panier</a>
    </div> --%>

	<div class="row">
		<div class="col s3 offset-s9">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title">Mon Panier</span>
					<c:forEach items="${panier.getProductIdQuantities()}" var="element"
						varStatus="status">
						<li class="collection-item">${element.key.getNom()} (${element.value})<%-- ${element} --%>
							<a class="secondary-content" href="deleteFromPanier?id=${element.key.getId()}">Enlever</a>
						</li>
					</c:forEach>
				</div>
				<div class="card-action">
					<a href="validerPanier" class="<%=Constante.BUTTON_COLOR%>">Valider mon panier</a>
				</div>
			</div>
		</div>
	</div>


</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>