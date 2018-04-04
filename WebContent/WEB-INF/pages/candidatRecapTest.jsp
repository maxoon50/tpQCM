<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menu.jsp" %>

<div class="row">
	<div class="offset-s3 col s6" >
		<div id="blockRecap">
			<div class="row">			
				<c:forEach items="${listeQuestion }" var="l">
					<div class="col s3">
						<a href="/candidat/question?id=${ l.idQuestion}" id="temoinQuestion" <c:if test="${l.estMarquee == true }">
							style="background-color: red"
							</c:if> style="text-align:center;background-color:green">	
							Question ${ l.idQuestion}
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


















<%@include file="./parts/end.jsp" %>