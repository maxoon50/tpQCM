<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>

<div class="row">
	<div class="offset-s3 col s6" >
		<div id="blockRecap">
			<div class="row">			
				<c:forEach items="${listeQuestion }" var="l">
					<div class="col s3">
						<div id="temoin" <c:if test="${l.estMarquee == true }">
								style="background-color: red"
								</c:if> style="text-align:center;background-color:#b6ecb6">
							<a href="${pageContext.request.contextPath}/candidat/question?id=${ l.numOrdre}" >
								Question ${ l.idQuestion}
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


















<%@include file="./parts/end.jsp" %>