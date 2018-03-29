<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>


	<div class="row">
		 <div class="input-field offset-s3 col s6" id="blockInscription">
		   	<form method="post" action="Inscription">
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
					<div class="row">
						<div class="col s4">
						    <i class="material-icons ">no_encryption</i>
						</div>
						<div class="input-field col s8">
						    <input name="password" type="text" id="autocomplete-input" class="autocomplete">
						    <label for="autocomplete-input">Mot de Passe</label>
						</div>
					</div>
					<div class="row">
						<div class="col s4">
						    <i class="material-icons ">fingerprint</i>
						</div>
						<div class="input-field col s8">
							<select name="role">
							   <option value="" disabled selected>Selectionnez le rôle</option>
							   <option  value="1">Option 1</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col s4">
						    <i class="material-icons ">group</i>
						</div>
						<div class="input-field col s8">
							<select name="promo">
							   <option value="" disabled selected>Selectionnez la promo</option>
							   <option value="1">Option 1</option>
							</select>
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