<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 14/02/18
  Time: 22.55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>


<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header" style="background-color: #0f90cc">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title"><h4>ProjectSF</h4></span>
            <div class="mdl-layout-spacer"></div>
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="../Home.jsp" style="font-size: large">Home</a>
                <a class="mdl-navigation__link" href="../login.jsp" style="font-size: large">Logout</a>
            </nav>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title" style="font-size: large">Menu</span>
        <nav class="mdl-navigation">
            <%if(BeanLogin.getTipoUtente().equals("Amministratore")){%>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertUtente.jsp" style="font-size: medium">Registra utente</a>
            <a class="mdl-navigation__link" href=../insertPageJSP/insertCSV.jsp style="font-size: medium">Inserisci CSV</a>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertSatellite.jsp#" style="font-size: medium">Inserisci dati satellite</a>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertStrumento.jsp" style="font-size: medium">inserisci dati strumenti</a>
            <%}%>
            <a class="mdl-navigation__link" href="#" style="font-size: medium">Query varie</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/ricercaBrillantezzaEllitticita.jsp" style="font-size: medium">Ricerca Filamento per contrasto ed ellitticita</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchesCentroidExtension.jsp" style="font-size: medium">Ricerca Centroide ed Estensione per Filamento</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchFilamentsBySegmentsRange.jsp" style="font-size: medium">Ricerca un Filamento in base al suo numero di segmenti </a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchesRegione.jsp" style="font-size: medium">Ricerca un Filamento in base alla regione </a>
        </nav>
    </div>
</div>