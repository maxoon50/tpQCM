<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>

<div class="row">
	<div class="offset-s3 col s6" >
		<div id="blockRecap">
			<div class="row">	
			<h3>Récapitulatif des questions</h3>		
				<c:forEach items="${listeQuestion }" var="l">
					<div class="col s3">
						<div  <c:if test="${l.estMarquee == true }">
								style="background-color: red"
								</c:if> style="text-align:center">
							<a href="${pageContext.request.contextPath}/candidat/question?id=${ l.numOrdre}"  class="waves-effect waves-light btn">
							
						 ${ l.numOrdre +1}
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


















<%@include file="./parts/end.jsp" %>