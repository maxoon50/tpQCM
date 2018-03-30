<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuResponsable.jsp" %>

<div class="row">
	<div class="offset-s2 col s8" id="blockSectionAjout">
		<h4>Cr�ation de Sections Test</h4>
		<form method="post" action="${pageContext.request.contextPath}/AjoutSection">
			<div class="row">
				<div class="input-field col s6">			
					<select name="theme" id="js-selection-theme">
					    <option value="666">Selectionnez le th�me</option>
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
					<button class="btn waves-effect waves-light" type="submit" name="action">G�n�rer
					    <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<form method="post" action="${pageContext.request.contextPath}/ListeSection">
	
	<div class="row">
		<div class="offset-s2 col s8" id="blockSectionAjout">
			<div class="row">
				<h4 style="text-align:center">Test</h4>
				<div class="">
					<div class="input-field col s12">
				          <textarea id="textarea1" class="materialize-textarea"></textarea>
				          <label for="textarea1">Libell�</label>
			        </div>
				</div>
			</div>
			<div class="row">
				<div class="offset-s4 col s4">
					<select>
				      <option value="" disabled selected>Dur�e du test</option>
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
								     			<a class="waves-effect waves-light btn"><i class="material-icons right">help_outline</i>${s.nbQuestionsATirer}</a>
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
					 <button class="btn waves-effect waves-light" type="submit" name="action">Cr�er Test
			    	<i class="material-icons right">send</i>
			  		</button>
		  		</div>
			</div>
		</div>
	</div>
</form>




<%@include file="./parts/end.jsp" %>