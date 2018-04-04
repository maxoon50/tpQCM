<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuTest.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="nbreQuestions" value="${fn:length(sessionScope.epreuve.questionsTirage) }"></c:set>

<form method="post" action="${pageContext.request.contextPath}/candidat/question">
	<div class="row" >
		<div class="offset-s2 col s8" id="blockListeQuestion">
			<div class="row" >
				<div class="col s12">
					<div >		   	
						<h4 style="text-align: center">Question</h4>
						<p style="margin-top: 5vh;">${question.enonce}</p>			   
<input type="hidden" value ="${question.idQuestion}" name="idQuestion"/>

  <c:if test="${nbreQuestions eq numQuestion+1}">
 <input type="hidden" value ="true" name="lastQuestion"/>
  </c:if>

			 	<c:choose>
  <c:when test="${requestScope.question.uneReponse }">
	<c:forEach items="${requestScope.propositions}" var="a" varStatus="i">
						
						<p>
						<input id="bonneReponse-<c:out value="${a.idProposition}" />" type="radio" name="proposition-radio" value="<c:out value="${a.idProposition}" />">
			    		<label for="bonneReponse-<c:out value="${a.idProposition}" />"><c:out value="${a.enonce}" /></label>   		
			    		</p>
			    		
			   </c:forEach>	
  </c:when>

  <c:otherwise>
			<c:forEach items="${requestScope.propositions}" var="a" varStatus="i">
						
						<p>
						<input id="bonneReponse-<c:out value="${a.idProposition}" />" type="checkbox" name="proposition-${i.index}" value="<c:out value="${a.idProposition}" />">
			    		<label for="bonneReponse-<c:out value="${a.idProposition}" />"><c:out value="${a.enonce}" /></label>   		
			    		</p>
			    		
			   </c:forEach>	
  </c:otherwise>
</c:choose>

	
			   
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
			 	<c:choose>
  <c:when test="${nbreQuestions eq numQuestion+1}">
     			 		<button class="btn waves-effect waves-light" type="submit" value="${ numQuestion+1}" name="question">Finir le test
		    		<i class="material-icons right">arrow_forward</i>
  					</button>
  </c:when>

  <c:otherwise>
 	<button class="btn waves-effect waves-light" type="submit" value="${ numQuestion+1}" name="question">Suivante
		    		<i class="material-icons right">arrow_forward</i>
  					</button>
  </c:otherwise>
</c:choose>
	
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
