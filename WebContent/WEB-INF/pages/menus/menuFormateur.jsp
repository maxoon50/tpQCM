
	
	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/formateur/accueil-formateur">Accueil</a></li>
	           <li><a href="${pageContext.request.contextPath}/formateur/ajout-section">Créer un test</a></li>
	        <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / déconnection</a></li>
	      </ul>
	    </div>
	</nav>