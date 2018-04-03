<%@include file="./parts/head.jsp" %>
<%@include file="./menus/menuResponsable.jsp" %>

<div class="row">
		 <div class="input-field offset-s3 col s6" id="blockInscriptionEpreuve">
			<h3>Inscription aux épreuves</h3>
			 <c:if test = "${flashMessage !=null }">
         		<p><c:out value = "${flashMessage}"/><p>
			</c:if>
			<form>		
			<select name="promotion" id="js-inscription-promotion">
				<option value="">Selectionnez la promotion</option>
				<c:forEach items="${listeCodesPromo}" var="p" varStatus="loop">
					<option  value="${p}}">${p}</option>
				</c:forEach> 
			</select>
			
			<select name="test">
				<option value="">Selectionnez le test </option>
					<c:forEach items="${listeTests}" var="t" >
						<option  value="${t.idTest }">${t.libelle}</option>
					</c:forEach> 
			
			</select>
			
			<div class = "row">    
				 <div class="input-field">          
	               <label for="dateDebut">Date de début de validité de l'épreuve</label>              
	               <input type = "date" class = "datepicker" id="dateDebut" name="dateDebut"/>    
	            </div>
            </div> 
            
			<div class = "row">
               <div class="input-field">
                   <input type = "date" class = "datepicker" id="dateFin" name="dateFin"/>
                   <label for="dateFin">Date de fin de validité de l'épreuve</label>    
            	</div>
            </div> 
            
            <div class="row">
						<div class="offset-s4 col s4">
							<input type="submit" class="waves-effect waves-light btn-large" value="Inscrire">
						</div>
					</div>
			</form>	
				
					
			
		</div>
</div>



<%@include file="./parts/end.jsp" %>