<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>

	
	
		<div class="row">
		    <div class="input-field offset-s4 col s4" id="blockLogin">
		    	<form method="post" action="${pageContext.request.contextPath}/login">
			    	<h3>Login</h3>
				    <div class="row">
				     	<div class="col s4">
				          	<i class="material-icons ">mail_outline</i>
				       	</div>
				        <div class="input-field col s8">
				          	<input name="email" type="email" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Email</label>
				        </div>
				    </div>
					<div class="row">
						<div class="col s4">
						    <i class="material-icons ">no_encryption</i>
						</div>
						<div class="input-field col s8">
						    <input name="password" type="password" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Mot de Passe</label>
						</div>
					</div>
					<div class="row">
						<div class="offset-s4 col s4">
							<input type="submit" class="waves-effect waves-light btn-large" value="Envoyer">
						</div>
					</div>
				</form> 
				<div>
				<c:if test="${!empty erreur}">Erreur classique</c:if>
				
				<c:if test="${!empty erreur}">
					<div class="alert alert-danger" role="alert">
					  <strong>Erreur!</strong>
					  <ul>
					  	<c:forEach var="code" items="${erreur}">
					  		<li>${LecteurMessage.getMessageErreur(code)}</li>
					  	</c:forEach>
			  			</ul>
					</div>
				</c:if>
				
				</div>
			</div>
	 	</div>




<%@include file="./parts/end.jsp" %>