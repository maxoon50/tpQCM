	
	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/formateur/ajouter-questions">Finir le test</a></li>
	        <li>${sessionScope.user.prenom }</li>
	      </ul>
	    </div>
	</nav>