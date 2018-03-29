<%@include file="./parts/head.jsp" %>
<%@include file="./parts/menuResponsable.jsp" %>

<div class="flex mt-l">
	
	<c:if test="${!empty errors }">
	    <div class="errors-display">
		    <c:forEach items="${ errors }" var="e">
		    	<p>${ e }</p>
			</c:forEach> 
		 </div>
	</c:if>
</div>
	<div class="row">
		 <div class="input-field offset-s3 col s6" id="blockInscription">
		   	<form method="post" action="${pageContext.request.contextPath}/Inscription">
			    <h3>Inscription</h3>
				   <div class="row">
				     	<div class="col s4">
				          	<i class="material-icons ">account_circle</i>
				     	</div>
				        <div class="input-field col s8">
				          	<input name="nom" type="text" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Nom</label>
				        </div>
				    </div>
				    <div class="row">
				     	<div class="col s4">
				          	<i class="material-icons ">account_circle</i>
				     	</div>
				        <div class="input-field col s8">
				          	<input name="prenom" type="text" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Prenom</label>
				        </div>
				    </div>
				    <div class="row">
				     	<div class="col s4">
				          	<i class="material-icons ">mail_outline</i>
				       	</div>
				        <div class="input-field col s8">
				          	<input name="email" type="email" id="autocomplete-input" class="autocomplete">
				          	<label for="autocomplete-input">Email</label>
				        </div>
				    </div>
					<!-- <div class="row">
						<div class="col s4">
						    <i class="material-icons ">no_encryption</i>
						</div>
						<div class="input-field col s8">
						    <input name="password" type="text" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Mot de Passe</label>
						</div>
					</div> -->
					<div class="row">
						<div class="col s4">
						    <i class="material-icons ">fingerprint</i>
						</div>
						<div class="input-field col s8">
							<select id="inscr-select-profil" name="profil">
							   <option value="" disabled selected>Selectionnez le rôle</option>
							   <option  value="100">Stagiaire</option>
							   <option  value="101">Externe</option>
							</select>
						</div>
					</div>
					<div id="cache-promo" class="row hide">
						<div class="col s4">
						    <i class="material-icons ">group</i>
						</div>
						<div class="input-field col s8">
							<select id="inscr-select-promo" name="promo">
							   <option value="" disabled selected>Selectionnez la promo</option>
							   <c:forEach items="${codesPromo}" var="code">
    								<option value="${code}">${code}</option>
								</c:forEach>
							   <option value="autre">Autre</option>
							</select>
						</div>
					</div>
					<div class="row hide cache-new-promo">
						<div class="col s4">
						    <i class="material-icons ">keyboard_arrow_right</i>
						</div>
						<div class="input-field col s8">
						    <input name="codeNewPromo" type="text" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Code nouvelle promotion</label>
						</div>
					</div>
					<div class="row hide cache-new-promo">
						<div class="col s4">
						    <i class="material-icons ">keyboard_arrow_right</i>
						</div>
						<div class="input-field col s8">
						    <input name="nomNewPromo" type="text" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Libellé nouvelle promotion</label>
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