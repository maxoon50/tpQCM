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
	
<div class="row">
	<div class="offset-s3 col s6" id="blockThemeTest">
		<h4>Thèmes</h4>
		<div class="row">
			<div class="input-field col s8">			
				<form method="post" action="AccueilFormateur">
					<select>
					    <option value="" disabled selected>Selectionnez le thème</option>
					    <option value="1">Option 1</option>
					</select>
				</form>
			</div>
			<div class="col s4">
				<a id="logoAddTheme" href="" class="waves-effect waves-green btn"><i class="material-icons left">add_circle_outline</i>Ajouter</a>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="offset-s3 col s6" id="blockThemeTest">
		<h4>Questions</h4>
		<div class="row">
			<div class="input-field col s10">
				<ul class="collapsible">
				    <li>
				      <div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
				      <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
				    </li>
				    <li>
				      <div class="collapsible-header"><i class="material-icons">place</i>Second</div>
				      <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
				    </li>
				    <li>
				      <div class="collapsible-header"><i class="material-icons">whatshot</i>Third</div>
				      <div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
				    </li>
				  </ul>
			</div>
			<div class="col s2">
				  <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</div>







<%@include file="./parts/end.jsp" %>