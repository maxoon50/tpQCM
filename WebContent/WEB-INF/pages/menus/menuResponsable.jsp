	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/responsable/inscription">Créer compte</a></li>
	        <li><a href="${pageContext.request.contextPath}/responsable/resultat">Consulter les résultats</a></li>
	        <li><a href="${pageContext.request.contextPath}/responsable/inscriptionPromotion">Inscrire une promotion</a></li>
	       	<li><a href="${pageContext.request.contextPath}/responsable/inscriptionCandidat">Inscrire un candidat</a></li>
			 <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / déconnection</a></li>
	      </ul>
	    </div>
	</nav>
