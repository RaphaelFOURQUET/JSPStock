<%@page import="fr.adaming.panier.PanierID"%>
<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	
	<!-- Importation de JSTL Core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String utilisateurConnecte = 
        (String) request.getParameter( Constante.KEY_CONNECTED_USER );
	String logo = 
			(String) request.getParameter(Constante.LOGO);
%>

<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo"><%= logo %></a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<%
			if (!utilisateurConnecte.isEmpty()) {
				//recuperer la presence de commandes ?
				Boolean possessCommande = (Boolean) request.getSession().getAttribute("possessCommande");
				//Afficher formulaire connexion
		%>
		<ul class="right hide-on-med-and-down">
			<li><a href="produit">Produits</a></li>
			<c:if test="${possessCommande}">
				<li><a href="commande">Commande(s)</a></li>
			</c:if>
			<li><a href="logout">Log out</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="produit">Produits</a></li>
			<c:if test="${possessCommande}">
				<li><a href="commande">Commande(s)</a></li>
			</c:if>
			<li><a href="logout">Log out</a></li>
		</ul>
		<% } %>
	</div>
</nav>