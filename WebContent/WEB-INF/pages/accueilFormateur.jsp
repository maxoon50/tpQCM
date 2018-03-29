<%@include file="./parts/head.jsp" %>

	<nav>
	    <div class="nav-wrapper">
	      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
	      <ul id="nav-mobile" class="right hide-on-med-and-down">
	        <li><a href="${pageContext.request.contextPath}/Accueil">Tests</a></li>
	        <li><a href="${pageContext.request.contextPath}/Resultat">Mes R�sultats</a></li>
  <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / d�connection</a></li>
	      </ul>
	    </div>
	</nav>
	
<div class="row">
	<div class="offset-s3 col s6" id="blockThemeTest">
		<h4>Th�mes</h4>
		<div class="row">
			<div class="input-field col s10">			
				<form method="post" action="${pageContext.request.contextPath}/AccueilFormateur">
					<select name="theme">
					    <option disabled selected>Selectionnez le th�me</option>
					    <c:forEach items="${ theme }" var="t">
					    	<option  value="${t.idTheme}">${ t.libelle }</option>
					    </c:forEach> 
					</select>
					<button class="btn waves-effect waves-light" type="submit" name="action">G�n�rer
					    <i class="material-icons right">send</i>
					</button>
				</form>
			</div>
			<div class="col s2">
				  <a href="" class="btn-floating btn-large waves-effect waves-light red">Add</a>
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
					<c:if test="${!empty questions}">
						<c:forEach items="${questions }" var="q">
						    <li>				    	
						      <div class="collapsible-header"><i class="material-icons">help_outline</i>${q.enonce }</div>
						      <div class="collapsible-body">
							      <span>
							      	<c:forEach items="${q.getListeProp() }" var="p">
							      		${p.enonce }<br>
							      	</c:forEach>
							      </span>
							  </div>
						    </li>
						</c:forEach>
					</c:if>
					<c:if test="${empty questions}">
						<li>				    	
						   <div class="collapsible-header"><i class="material-icons">help_outline</i>Question</div>
						   <div class="collapsible-body"><span>R�ponse</span></div>
						</li>
					</c:if>
				</ul>
			</div>
			<div class="col s2">
				  <a class="btn-floating btn-large waves-effect waves-light red">Add</a>
			</div>
		</div>
	</div>
</div>







<%@include file="./parts/end.jsp" %>