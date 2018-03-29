<%@include file="./parts/head.jsp" %>

<%@include file="./menus/menuFormateur.jsp" %>


	<div class="flex mt-l">
	
	<c:if test="${!empty errors }">
	    <div class="errors-display">
		    <c:forEach items="${ errors }" var="e">
		    				    	<p>${ e }</p>
					    </c:forEach> 
		 </div>
	</c:if>
	
	
<div class="form-container mb-l">
		   	<form method="post" action="${pageContext.request.contextPath}/formateur/ajouter-questions">
			    <h3 class="m-m">Ajouter une question</h3>
					   <div class="row">    
			    		  <div class="input-field  offset-s2 col s8">
			    		  					<select name="theme">
					    <option disabled selected>Thème de la question :</option>
					    <c:forEach items="${ themes }" var="t">
					    	<option  value="${t.idTheme}">${ t.libelle }</option>
					    </c:forEach> 
					</select>

		 		</div>
  			</div>
				   <div class="row question-cont flex-align-vert">

			
				        <div class="input-field col s9">
				          	<input name="question" type="text" id="question" class="autocomplete">
				          	<label for="question">Question</label>
				        </div>
	        <div class=" col s3">
				        <input id="uneReponse" type="checkbox" name="uneReponse">
    					<label for="uneReponse">une seule réponse</label>
				   		 </div>
				    </div>
				        <div class="row flex-align-vert ">
				        				          <div class="input-field col s6">
    						<p>Nombre de points </p>
     				   </div>

				          <div class="input-field col s4">
    <p class="range-field">

      <input type="range" id="test5" min="1" max="5" name="points"/>
    </p>
        </div>
</div>
				    <div class="row flex-align-vert ">

				        <div class="input-field col s9">
				          	<input name="reponse1" type="text" id="reponse1" class="autocomplete">
				          	<label for="reponse1">Réponse 1 </label>
				        </div>
				        <div class=" col s3">
				        <input id="bonneReponse1" type="checkbox" name="bonneReponse1">
    					<label for="bonneReponse1">Bonne réponse</label>
				   		 </div>
				   		 </div>
				    <div class="row flex-align-vert">
		
				        <div class="input-field col s9">
				          	<input name="reponse2" type="text" id="reponse2" class="autocomplete">
				          	<label for="reponse2">Réponse 2 </label>
				        </div>
				        	        <div class=" col s3">
				        <input id="bonneReponse2" type="checkbox"  name="bonneReponse2">
    					<label for="bonneReponse2">Bonne réponse</label>
				   		 </div>
				    </div>
					<div class="row flex-align-vert">

						<div class="input-field col s9">
						    <input name="reponse3" type="text" id="reponse3" class="autocomplete">
						    <label for="reponse3">Réponse 3 </label>
						</div>
								        	        <div class=" col s3">
				        <input id="bonneReponse3" type="checkbox"  name="bonneReponse3">
    					<label for="bonneReponse3">Bonne réponse</label>
				   		 </div>
					</div>
				  <div class="row flex-align-vert">
		
				        <div class="input-field col s9">
				          	<input name="reponse4" type="text" id="reponse4" class="autocomplete">
				          	<label for="reponse4">Réponse 4 </label>
				        </div>
				        						        	        <div class=" col s3">
				        <input id="bonneReponse4" type="checkbox"  name="bonneReponse4">
    					<label for="bonneReponse4">Bonne réponse</label>
				   		 </div>
				    </div>
				
					<div class="row">
						<div class="offset-s4 col s4">
							<input type="submit" class="waves-effect waves-light btn-large" value="Envoyer">
						</div>
					</div>

				</form> 
</div>


</div>







<%@include file="./parts/end.jsp" %>