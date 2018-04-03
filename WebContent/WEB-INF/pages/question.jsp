<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuTest.jsp" %>

<form method="post" action="${pageContext.request.contextPath}/candidat/question">
	<div class="row" >
		<div class="offset-s2 col s8" id="blockListeQuestion">
			<div class="row" >
				<div class="col s12">
					<div class="form-container mb-l" >		   	
						<h4 style="text-align: center">Question</h4>
						<p style="margin-top: 5vh;">${questionTirage.question.enonce}</p>			   
						
						<c:forEach items=" ${questionTirage.question.listeProp }" var="p" >
						<input id="bonneReponse" type="checkbox" name="prop-}" value="<c:out value="${p.idProposition}" />">
			    		<label for="bonneReponse">${p.enonce }</label>   		
			    		
			    				</c:forEach>		
					</div>
				</div>
			</div>
			<div class="row">
			 	<div class="offset-s1 col s3">
			 		<div class="offset-s1 col s3">
			 		<button  <c:if test="${numQuestion eq 0 }">disabled=true</c:if> class="btn waves-effect waves-light" type="submit" value="${ numQuestion-1}" name="question">Précedente
		    		<i class="material-icons right">arrow_back</i>
  					</button>
	 			</div>
			 	</div>
			 	<div class="offset-s1 col s3">
			 		<button class="btn waves-effect waves-light" type="submit" name="question">Marquer
		    			<i class="material-icons right">attach_file</i>
		  			</button>
			 	</div>
			 	<div class="offset-s1 col s3">
			 		<button class="btn waves-effect waves-light" type="submit" value="${ numQuestion+1}" name="question">Suivante
		    		<i class="material-icons right">arrow_forward</i>
  					</button>
	 			</div>
	 		</div> 
		</div>		
	 </div>
	 
	 <div class="row" >
		<div class="offset-s2 col s8" id="blockListeQuestion">
			<h4 style="text-align: center">Suivi Questionnaire</h4>
			<div class="row" >
				<div class="col s2">
					<div id="temoinQuestion" style="background-color: #78bd78;"></div>
				</div>
			</div>
		</div>
	</div>
	
</form> 	 	
	 
			  


<%@include file="./parts/end.jsp" %>
