<nav>
    <div class="nav-wrapper">
      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="${pageContext.request.contextPath}/candidat/accueil">Tests</a></li>
        <li><a href="${pageContext.request.contextPath}/candidat/resultats">Mes Résultats</a></li>
      <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / déconnection</a></li>
      </ul>
    </div>
</nav>
