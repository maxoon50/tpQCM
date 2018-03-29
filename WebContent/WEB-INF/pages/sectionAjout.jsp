<%@include file="./parts/head.jsp" %>

	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <h5 id="bonjour" >Bonjour (Nom Prénom)</h5>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/formateur/ajouter-questions">Ajouter Question</a></li>
	      </ul>
	    </div>
	</nav>

<div class="row">
	<div class="offset-s2 col s8" id="blockSectionAjout">
		<h4>Création de Sections Test</h4>
		<form method="post" action="${pageContext.request.contextPath}/AjoutSection">
			<div class="row">
				<div class="input-field col s6">			
					<select name="theme" id="js-selection-theme">
					    <option disabled selected>Selectionnez le thème</option>
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
						 	  name="nbSection" type="range" id="test5" min="0" max="${ t.value }" />
							
						</p>	
				</div>
			</div>
			<div class="row">
				<div class="offset-s4 col s4">
					<button class="btn waves-effect waves-light" type="submit" name="action">Générer
					    <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="offset-s2 col s8" id="blockSectionAjout">
		<h4 style="text-align:center">Sections du Test</h4>
		<div class="row">
			<div class="col s4">
				<div class="card" id="cardSection">
				    <div class="card-content">
				    	<h5 style="text-align:center">Nom du Thème</h5>
				    	<div class="row">
				    		<div class="col s2">
				    			<i class="material-icons right">help_outline</i>
				    		</div>
				    		<div class="col s10"> 		
					    		<p class="range-field">					    	
					      			<input placeholder="Nombre de Questions" name="nbQuestion" type="range" id="test5" min="0" max="15" />
					     		</p>
					     	</div>
					   	</div>
					</div>
				</div>
		  	</div>
		</div>
	</div>
</div>




<%@include file="./parts/end.jsp" %>