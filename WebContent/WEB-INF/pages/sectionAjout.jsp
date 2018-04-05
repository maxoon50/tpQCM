<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuFormateur.jsp" %>
<div class="row">
	<div class="offset-s4 col s4" >
		<c:if test="${!empty  success}" ><div id="success-display">Création du test ${ test.libelle } réussie</div></c:if>
	</div>
</div>
<div class="row">
	<div class="offset-s2 col s8" id="blockSectionAjout">
		<h4>Création de Sections Test</h4>
		<form method="post" action="${pageContext.request.contextPath}/formateur/ajout-section">
			<div class="row">
				<div class="input-field col s6">			
					<select name="theme" id="js-selection-theme">
					    <option value="666">Selectionnez le thème</option>
					    <c:forEach items="${ theme }" var="t">
					    	<option  value="${t.idTheme}">${ t.libelle }</option>
					    </c:forEach> 
					</select>
				</div>
				<div class="input-field col s6">
						<p class="range-field">						
						 	<input id="js-nbre-questions-max"
							 	 <c:forEach items="${themes }" var="t"> 
							 	 data-${t.key }="${ t.value }" 
							 	 </c:forEach>
						 	 name="nbQuestion" type="range" id="test5" min="0" max="${ t.value }" />						
						</p>	
				</div>
			</div>
			<div class="row">
				<div class="offset-s4 col s4">
					
					<button class="btn waves-effect waves-light" type="submit" name="action">Ajouter
					    <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<form method="post" action="${pageContext.request.contextPath}/formateur/test-recapitulatif">
	
	<div class="row">
		<div class="offset-s2 col s8" id="blockSectionAjout">
			<div class="row">
				<h4 style="text-align:center">Test</h4>
				<div class="">
					<div class="input-field col s12">
				          <textarea name="libelleTest" id="textarea1" class="materialize-textarea"></textarea>
				          <label for="textarea1">Libellé</label>
			        </div>
				</div>
			</div>
			<div class="row">
				<div class="offset-s4 col s4">
					<select name="dureeTest">
				      <option value="" disabled selected>Durée du test</option>
				      <option value="1">1 heure</option>
				      <option value="2">2 heures</option>
				      <option value="3">3 heures</option>
				      <option value="4">4 heures</option>
				      <option value="5">5 heures</option>
				    </select>
				</div>
			
			</div>
			<h4 style="text-align:center">Sections du Test</h4>
			<div class="row">
				<c:if test="${!empty sessionScope.sections}">
					<c:forEach items="${sessionScope.sections }" var="s">
						<div class="col s4">
							<div class="card" id="cardSection">
							    <div class="card-content">
							    	<h5 style="text-align:center"><c:out value="${s.theme }"></c:out></h5>
							    	<div class="row">
							    		<div class="offset-s2 col 8"> 		
								    		<p class="range-field">		
								    			<div class="card-panel teal #f1f8e9 light-green lighten-5">${s.nbQuestionsATirer} Question(s)</div>			    	
								     		</p>
								     	</div>
								   	</div>
								</div>
							</div>
						</div>
					</c:forEach>

				</c:if>
			</div>
			<div class="row">
				<div class="offset-s4 col s4">
					 <button class="btn waves-effect waves-light" type="submit" name="action">Créer Test
			    	<i class="material-icons right">send</i>
			  		</button>
		  		</div>
			</div>
		</div>
	</div>
</form>




<%@include file="./parts/end.jsp" %>