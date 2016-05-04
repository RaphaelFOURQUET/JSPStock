<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

 <jsp:include page="head.jsp"/>
 
<body>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
	</jsp:include>

	<%
		Produit p = (Produit) request.getAttribute("produit");
		int freeIndex = (int) request.getAttribute("freeIndex");
	%>

	<!-- Id est passe deux fois, en disabled et en hidden pour etre vu par utilisateur (disabled) et transmis en formulaire(hidden) -->
	<div class="row">
		<form class="col s12" method="post" action="ajout">
			<div class="row">
				<div class="input-field col s6">
					<input disabled value="<%=freeIndex%>" type="text" class="validate"
						name="id"> <label for="id">ID</label>
				</div>
				<div class="input-field col s6">
					<input value="<%=freeIndex%>" type="hidden" name="id"> <label
						for="id"></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="name" id="name" type="text" class="validate"
						name="name"> <label for="name">Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input placeholder="description" type="text" name="description">
					<label for="description">Description</label>
				</div>
			</div>

			<div class="row">

				<button class="btn waves-effect waves-light" type="submit">
					Ajouter <i class="material-icons right">send</i>
				</button>

			</div>
		</form>
	</div>


</body>
<script>
	$(".button-collapse").sideNav();
</script>
</html>