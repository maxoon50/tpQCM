<%@include file="./parts/head.jsp" %>

<%@include file="./menus/menuFormateur.jsp" %>

	
<div class="row">
	<div class="offset-s3 col s6" id="blockThemeTest">
		<h4>Thèmes</h4>
		<div class="row">
			<div class="input-field col s10">			
				<form method="post" action="${pageContext.request.contextPath}/formateur/accueil-formateur">
					<select name="theme">
					    <option value="666">Selectionnez le thème</option>
					    <c:forEach items="${ theme }" var="t">
					    	<option  value="${t.idTheme}">${ t.libelle }</option>
					    </c:forEach> 
					</select>
					<button class="btn waves-effect waves-light" type="submit" name="action">Afficher
					    <i class="material-icons right">send</i>
					</button>
				</form>
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
	
				</ul>
			</div>
			<div class="col s2">
				  <a href="${pageContext.request.contextPath}/formateur/ajouter-questions" class="btn-floating btn-large waves-effect waves-light red">Add</a>
			</div>
		</div>
	</div>
</div>







<%@include file="./parts/end.jsp" %>