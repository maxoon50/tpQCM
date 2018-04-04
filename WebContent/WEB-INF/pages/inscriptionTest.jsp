<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuResponsable.jsp" %>

<div class="row">
		 <div class="input-field offset-s3 col s6" id="blockInscriptionEpreuve">
			<h3>Inscription aux épreuves</h3>
			 <c:if test = "${empty candidats  }">
         	
		
			
			<form method="get" action="${pageContext.request.contextPath}/responsable/inscriptionTest">		
				<select name="promotion" id="js-inscription-promotion">
					<option value="">Selectionnez la promotion</option>
					<option value="externe">Externe</option>
					<c:forEach items="${listeCodesPromo}" var="p" varStatus="loop">
						<option  value="${p}">${p}</option>
					</c:forEach> 
				</select>
			    <div class="row">
					<div class="col s4">
						<input type="submit" class="waves-effect waves-light btn-large" value="Rechercher Promotion">
					</div>
				</div>
			</form>	
				</c:if>
			
			
			<c:if test="${!empty candidats }">
			<form method="post" action="${pageContext.request.contextPath}/responsable/inscriptionTest">
				
				<select name="selectCandidats" multiple="multiple">
					<option value="">Selectionnez le(s) candidat(s) </option>
						<c:forEach items="${candidats}" var="cdt" >
							<option  value="${cdt.idUtilisateur }">${cdt.nom} ${cdt.prenom }</option>
						</c:forEach> 
				
				</select>
				
				
				<select name="test">
					<option value="">Selectionnez le test </option>
						<c:forEach items="${listeTests}" var="t" >
							<option  value="${t.idTest}">${t.libelle}</option>
						</c:forEach> 
				
				</select>
								
				<div class = "row">    
					 <div class="input-field">          
		               <label for="dateDebut"><br><br>Date de début de validité de l'épreuve</label>    
		               <input type = "date" class = "datepicker" id="dateDebut" name="dateDebut"/>    
		            </div>
	            </div> 
	            
				<div class = "row">
	               <div class="input-field">
	                   <input type = "date" class = "datepicker" id="dateFin" name="dateFin"/>
	                   <label for="dateFin"><br><br>Date de fin de validité de l'épreuve</label>    
	            	</div>
	            </div> 
	            <br>
	            <div class="row">
					<div class="offset-s4 col s4">
						<input type="submit" class="waves-effect waves-light btn-large" value="Inscrire au test">
					</div>
				</div>
			</form>	
			</c:if>			
				
					
			
		</div>
</div>



<%@include file="./parts/end.jsp" %>