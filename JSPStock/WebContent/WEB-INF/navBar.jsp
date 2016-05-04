<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%
    String utilisateurConnecte = 
        (String) request.getParameter( Constante.KEY_CONNECTED_USER );
%>

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo">Gestion des Stocks</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<%
			if (!utilisateurConnecte.isEmpty()) {
				//Afficher formulaire connexion
		%>
		<ul class="right hide-on-med-and-down">
			<li><a href="logout">Log out</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="logout">Log out</a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a href="produit">Produits</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="produit">Produits</a></li>
		</ul>
		<%
			}
		%>
	</div>
</nav>