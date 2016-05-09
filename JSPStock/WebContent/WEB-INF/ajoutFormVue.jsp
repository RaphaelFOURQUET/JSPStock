<%@ page import="fr.adaming.produits.Produit"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

<jsp:include page="head.jsp"/>
 
<body>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Ajout" name="logo" />
	</jsp:include>

	<%
		Produit p = (Produit) request.getAttribute("produit");
		//int freeIndex = (int) request.getAttribute("freeIndex");
	%>
	
	<%-- <div class="row">
				<div class="<%=Constante.COL_SIZE%>">
					<input disabled value="<%=freeIndex%>" type="text" class="validate"
						name="<%=Constante.ID%>"> <label>ID</label>
				</div>
				<div class="<%=Constante.COL_SIZE%>">
					<input value="<%=freeIndex%>" type="hidden" name="<%=Constante.ID%>">
				</div>
			</div> --%>

	<!-- Id est passe deux fois, en disabled et en hidden pour etre vu par utilisateur (disabled) et transmis en formulaire(hidden) -->
	<div class="row">
		<form class="col s12" method="post" action="ajout">
			<div class="row">
				<div class="<%=Constante.COL_SIZE%>">
					<input placeholder="name" id="name" type="text" class="validate"
						name="<%=Constante.NAME%>"> <label>Name</label>
				</div>
			</div>
			<div class="row">
				<div class="<%=Constante.COL_SIZE%>">
					<input placeholder="description" type="text" name="<%=Constante.DESCRIPTION%>">
					<label>Description</label>
				</div>
			</div>
			<div class="row">

				<button class="<%=Constante.BUTTON_COLOR %>" type="submit">
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