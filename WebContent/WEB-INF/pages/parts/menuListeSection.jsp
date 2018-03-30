<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	         <li><a href="${pageContext.request.contextPath}/Inscription">Créer compte Candidat</a></li>
	        <li><a href="${pageContext.request.contextPath}/ModifierCandidat">Modifier/Supprimer compte</a></li>
	         <li><a href="${pageContext.request.contextPath}/Inscrire/promo">Inscrire une promo</a></li>
	        <li><a href="${pageContext.request.contextPath}/Inscrire/candidat">Inscrire un candidat</a></li>
	        <li><a href="${pageContext.request.contextPath}/resultats">Résultats</a></li>
	     	<li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / déconnection</a></li>
	      </ul>
	    </div>
	</nav>