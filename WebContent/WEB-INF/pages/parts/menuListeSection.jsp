<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	         <li><a href="${pageContext.request.contextPath}/Inscription">Cr�er compte Candidat</a></li>
	        <li><a href="${pageContext.request.contextPath}/ModifierCandidat">Modifier/Supprimer compte</a></li>
	         <li><a href="${pageContext.request.contextPath}/Inscrire/promo">Inscrire une promo</a></li>
	        <li><a href="${pageContext.request.contextPath}/Inscrire/candidat">Inscrire un candidat</a></li>
	        <li><a href="${pageContext.request.contextPath}/resultats">R�sultats</a></li>
	     	<li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / d�connection</a></li>
	      </ul>
	    </div>
	</nav>