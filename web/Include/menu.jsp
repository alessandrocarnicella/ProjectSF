<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header" style="background-color:#2b66b5">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title"><h4>ProjectSF</h4></span>
            <div class="mdl-layout-spacer"></div>
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="../Home.jsp" style="font-size: large">Home</a>
                <a class="mdl-navigation__link" href="../login.jsp" style="font-size: large">Logout</a>
            </nav>
        </div>
    </header>

    <!-- menu -->
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title" style="font-size: large">Menu</span>
        <nav class="mdl-navigation">

            <!-- menu ( visisbile solo all'amministratore ) -->
            <%if(BeanLogin.getTipoUtente().equals("Amministratore")){%>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertUtente.jsp" style="font-size: medium">Registra utente</a>
            <a class="mdl-navigation__link" href=../insertPageJSP/insertCSV.jsp style="font-size: medium">Inserisci CSV</a>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertSatellite.jsp#" style="font-size: medium">Inserisci dati satellite</a>
            <a class="mdl-navigation__link" href="../insertPageJSP/insertStrumento.jsp" style="font-size: medium">Inserisci dati strumenti</a>
            <%}%>

            <!-- menu ( visibile a tutti gli utenti loggati) -->
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchesCentroidExtension.jsp" style="font-size: medium">Ricerca centroide ed estensione per filamento</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchBrillantezzaEllitticita.jsp" style="font-size: medium">Ricerca filamento per brillanza ed ellitticita'</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchFilamentsBySegmentsRange.jsp" style="font-size: medium">Ricerca un filamento in base al suo numero di segmenti </a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchesRegione.jsp" style="font-size: medium">Ricerca un filamento in base alla regione </a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchStelleinFilamento.jsp" style="font-size: medium">Ricerca stelle contenute in un filamento</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchStelleInRegione.jsp" style="font-size: medium">Ricerca stelle in base alla regione</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchDistanceVertici.jsp" style="font-size: medium">Ricerca distanza vertici segmento</a>
            <a class="mdl-navigation__link" href="../ricerchePageJSP/searchPosition.jsp" style="font-size: medium">Ricerca posizione stella rispetto a spina dorsale</a>
        </nav>
    </div>
</div>