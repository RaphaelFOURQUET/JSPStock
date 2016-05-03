<%@ page import="fr.adaming.constante.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%
    String utilisateurConnecte = 
        (String) request.getParameter( Constante.KEY_CONNECTED_USER );
%>

<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo">Logo</a> <a href="#"
			data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<%
			//System.out.println("utilisateurConnecte : "+utilisateurConnecte);
			//System.out.println("null cast to string : "+(String)null);
			if (!utilisateurConnecte.isEmpty()) {
				//Afficher formulaire connexion
		%>
		<ul class="right hide-on-med-and-down">
			<li><a href="logout">Log out</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="logout">Log out</a></li>
		</ul>
		<%
			}
		%>
	</div>
</nav>