<nav>
    <div class="nav-wrapper">
      <img id="logo" src="${pageContext.request.contextPath}/images/ENIEcole.jpg"/>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="${pageContext.request.contextPath}/candidat/accueil">Tests</a></li>
        <li><a href="${pageContext.request.contextPath}/candidat/resultats">Mes R�sultats</a></li>
      <li><a href="${pageContext.request.contextPath}/logout">${sessionScope.user.prenom } / d�connection</a></li>
      </ul>
    </div>
</nav>
