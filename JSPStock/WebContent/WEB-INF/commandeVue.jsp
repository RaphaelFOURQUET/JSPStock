<%@ page import="fr.adaming.commande.Commande"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>

<!-- Importation de JSTL Core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="head.jsp" />

<body>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Mes commandes" name="logo" />
	</jsp:include>

	<%
		List<Commande> commandes = (List<Commande>) request.getSession().getAttribute("commandes");
	%>

	<div class="container">
		<c:forEach items="${commandes}" var="ligne" varStatus="status">

			<div class="chip">Commande ${status.getIndex()}</div>
			<br /> Etat : ${ligne.etatCommande}<br />
						Date de commande : ${ligne.dateCommande}

			<c:forEach items="${ligne.lignes}" var="element">
				<div class="center-align">
					<div class="card grey darken-3">
						<div class="card-content white-text">
							<span class="card-title">${element.produit.nom}</span>
							<p>
								Quantite : <b>${element.quantite}</b>
							</p>
							<p>${element.produit.description}</p>
						</div>
					</div>
				</div>
			</c:forEach>
			<br />
		</c:forEach>
	</div>

</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>