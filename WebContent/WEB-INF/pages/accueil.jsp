<%@include file="./parts/head.jsp" %>

	<%@include file="./menus/menu.jsp" %>
	
	
<div class="row">
	<div class="input-field offset-s2 col s8" id="blockListeTest">
		<h3>Liste des tests</h3>	
		<table class="centered">
	        <thead>
	          <tr>
	              <th>Libellé</th>
	              <th>Descrition</th>
	              <th>Durée</th>
	              <th>Débuter Test</th>
	          </tr>
	        </thead>
	
	        <tbody>
	        	 <c:forEach items="${listeEpreuves}" var ="e" varStatus="loop">
	        	 <tr>
	            	<td>${listeTests[loop.index].libelle }</td>
	            	<td>
	            		<a class="waves-effect waves-light btn modal-trigger" href="#modal1">Description</a>
						<div id="modal-${loop.index }" class="modal"> 
						    <div class="modal-content">
						      	<h4>Description</h4>
						      	<p>${listeTests[loop.index].description }</p>
						    </div>
						   	<div class="modal-footer">
						   		<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Fermer</a>
						    </div>
						 </div>
					</td>
	            	<td>${listeTests[loop.index].duree }</td>
	            	<td>  
						<a href="${pageContext.request.contextPath}/candidat/epreuve-start?id=${e.idEpreuve }" class="waves-effect waves-light btn red"><i class="material-icons left">access_time</i>Débuter</a></td>
	          	</tr>
        	</c:forEach>
	          	
	        </tbody>
	      </table>
     </div>  
</div>




<%@include file="./parts/end.jsp" %>