	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/responsable/inscription">Cr�er compte candidat</a></li>
	        <li><a href="${pageContext.request.contextPath}/responsable/resultat">Consulter les r�sultats</a></li>
	        <li><a href="${pageContext.request.contextPath}/responsable/inscriptionTest">Inscrire aux Tests</a></li>
	      	 <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / d�connection</a></li>
	      </ul>
	    </div>
	</nav>
