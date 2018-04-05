<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>

<div class="row">
	<div class="offset-s3 col s6" >
		<div id="blockRecap">
		
			<h3>Récapitulatif des questions</h3>	
				<div class="row flex">		
				<c:forEach items="${listeQuestion }" var="l">
			
		
							<a href="${pageContext.request.contextPath}/candidat/question?id=${ l.numOrdre}"  class="waves-effect waves-light btn">
							
						 ${ l.numOrdre +1}
							</a>
		
				
				</c:forEach>
			</div>
		</div>
	</div>
</div>


















<%@include file="./parts/end.jsp" %>