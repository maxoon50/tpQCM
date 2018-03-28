<%@include file="./parts/head.jsp" %>

	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <h5 id="bonjour" >Bonjour (Nom Prénom)</h5>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/Accueil">Tests</a></li>
	        <li><a href="${pageContext.request.contextPath}/Resultat">Mes Résultats</a></li>
	      </ul>
	    </div>
	</nav>
	<div class="flex mt-l">
<div class="form-container">
		   	<form method="post" action="Inscription">
			    <h3>Ajouter une question</h3>
					   <div class="row">    
			    		  <div class="input-field  offset-s2 col s8">
   							 <select>
     						 <option value="" disabled selected>Thème de la question</option>
    					 	 <option value="1">Option 1</option>
  			  			  	<option value="2">Option 2</option>
		     				 <option value="3">Option 3</option>
					    </select>
   						 <label>Thème</label>
		 		</div>
  			</div>
				   <div class="row">

				     	<div class="col s2">
				          	<i class="material-icons ">control_point</i>
				     	</div>
				        <div class="input-field col s10">
				          	<input name="nom" type="text" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Question</label>
				        </div>

				    </div>

				    <div class="row">

				        <div class="input-field col s9">
				          	<input name="reponse1" type="text" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Réponse 1 </label>
				        </div>
				        <div class=" col s3">
				        <input id="bonneReponse1" type="checkbox">
    					<label for="bonneReponse1">Bonne réponse</label>
				   		 </div>
				    <div class="row">
		
				        <div class="input-field col s9">
				          	<input name="reponse2" type="email" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Réponse 2 </label>
				        </div>
				        	        <div class=" col s3">
				        <input id="bonneReponse2" type="checkbox">
    					<label for="bonneReponse2">Bonne réponse</label>
				   		 </div>
				    </div>
					<div class="row">

						<div class="input-field col s9">
						    <input name="reponse3" type="text" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Réponse 3 </label>
						</div>
								        	        <div class=" col s3">
				        <input id="bonneReponse3" type="checkbox">
    					<label for="bonneReponse3">Bonne réponse</label>
				   		 </div>
					</div>
				  <div class="row">
		
				        <div class="input-field col s9">
				          	<input name="reponse4" type="email" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Réponse 4 </label>
				        </div>
				        						        	        <div class=" col s3">
				        <input id="bonneReponse4" type="checkbox">
    					<label for="bonneReponse4">Bonne réponse</label>
				   		 </div>
				    </div>
				
					<div class="row">
						<div class="offset-s4 col s4">
							<input type="submit" class="waves-effect waves-light btn-large" value="Envoyer">
						</div>
					</div>
</div>
				</form> 
</div>


</div>







<%@include file="./parts/end.jsp" %>