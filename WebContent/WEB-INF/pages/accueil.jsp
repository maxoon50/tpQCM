<%@include file="./parts/head.jsp" %>

	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>

	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/candidat/accueil">Tests</a></li>
	        <li><a href="${pageContext.request.contextPath}/Resultat">Mes R�sultats</a></li>
	          <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / d�connection</a></li>
	      </ul>
	    </div>
	</nav>
	
	
<div class="row">
	<div class="input-field offset-s3 col s6" id="blockListeTest">
		<h3>Liste des tests</h3>	
		<table class="centered">
	        <thead>
	          <tr>
	              <th>Libell�</th>
	              <th>Descrition</th>
	              <th>Dur�e</th>
	              <th>D�buter Test</th>
	          </tr>
	        </thead>
	
	        <tbody>
	          	<tr>
	            	<td>ECF Java EE</td>
	            	<td>
	            		<a class="waves-effect waves-light btn modal-trigger" href="#modal1">Description</a>
						<div id="modal1" class="modal">
						    <div class="modal-content">
						      	<h4>Description</h4>
						      	<p>Texte descriptif</p>
						    </div>
						   	<div class="modal-footer">
						   		<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Fermer</a>
						    </div>
						 </div>
					</td>
	            	<td>2h00</td>
	            	<td>  
						<a href="" class="waves-effect waves-light btn red"><i class="material-icons left">access_time</i>D�buter</a>					</td>
	          	</tr>
	        </tbody>
	      </table>
     </div>  
</div>




<%@include file="./parts/end.jsp" %>