<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuLogin.jsp" %>

	
	
		<div class="row">
		    <div class="input-field offset-s4 col s4" id="blockLogin">
		    	<form method="post" action="${pageContext.request.contextPath}/login">
			    	<h3>Login</h3>
				    <div class="row  flex-align-vert">
				     	<div class="col s4  flex-align-vert">
				          	<i class="material-icons ">mail_outline</i>
				       	</div>
				        <div class="input-field col s8">
				          	<input name="email" type="email" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Email</label>
				        </div>
				    </div>
						 <div class="row  flex-align-vert">
						<div class="col s4  flex-align-vert">
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

				
				<c:if test="${!empty erreur}">
					<div class="alert alert-danger centerText" role="alert">
					  <strong>Erreur login / mot de passe incorrect(s)</strong>
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