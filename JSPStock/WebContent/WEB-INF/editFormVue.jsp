<%@page import="fr.adaming.produits.Produit"%>
<%@page import="java.util.List"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html"%>

 <jsp:include page="head.jsp"/>

<body>

	<!-- Navbar deplace dans autre jsp -->
	<jsp:include page="navBar.jsp">
		<jsp:param value="${utilisateurConnecte}" name="utilisateurConnecte" />
		<jsp:param value="Edition" name="logo" />
	</jsp:include>

	<%
		Produit p = (Produit) request.getAttribute(Constante.PRODUIT);
	%>

	<!-- Id est passe deux fois, en disabled et en hidden pour etre vu par utilisateur (disabled) et transmis en formulaire(hidden) -->
	<div class="row">
		<form class="col s12"  method="post" action="edit">
			<div class="row">
			<div class="input-field col <%=Constante.COL_SIZE%>">
					<input disabled value="<%=p.getId()%>" type="text"
						class="validate" name="<%=Constante.ID%>"> <label for="id">ID</label>
				</div>
				<div class="input-field col <%=Constante.COL_SIZE%>">
					<input value="<%=p.getId()%>" type="hidden"
					 name="<%=Constante.ID%>"> <label for="id"></label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col <%=Constante.COL_SIZE%>">
					<input value="<%=p.getNom()%>" id="name" type="text"
						class="validate" name="<%=Constante.NAME%>"> <label for="name">Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col <%=Constante.COL_SIZE%>">
					<input value="<%=p.getDescription()%>" type="text" name="<%=Constante.DESCRIPTION%>">
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