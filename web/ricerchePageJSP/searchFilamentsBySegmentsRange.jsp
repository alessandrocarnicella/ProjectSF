<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 25/02/2018
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanSegmento" scope="session" class="Bean.BeanSegmento"/>
<jsp:setProperty property="*" name="BeanSegmento"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 750px;
        height: 650px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->

<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RICERCA DI UN FILAMENTO IN BASE AL NUMERO DEI SUOI SEGMENTI IN UN RANGE PREFISSATO </h2>
        </div>
        <!--fine titolo-->

        <!--inserimento del primo intero di range-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px;margin-top: 30px;width: 500px">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci il numero di segmenti minimo (compreso)</b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number"  id="sample3" name="int1" required min="3">
            <label class="mdl-textfield__label"  for="sample3"></label>
        </div>
        <!--fine inserimento-->
        <br><br>
        <!--inserimento del secondo intero di range-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px;margin-top: 20px;width: 500px">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci il numero di segmenti massimo (non compreso)</b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number"  id="sample4" name="int2" required>
            <label class="mdl-textfield__label" for="sample4"></label>
        </div>
        <!--fine inserimento-->

        <br><br>
        <!--button-->
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="searchconfermasegmentsfilament" style="width: 200px;margin-left: 30px;margin-top: 50px">
                Effettua la ricerca
            </button>
            <img style=" margin-left: 150px" src="../Images/alien2.png" >
        </div>

        <% if (request.getParameter("searchconfermasegmentsfilament")!=null){
            if (BeanSegmento.controlloMinMax(Integer.valueOf(request.getParameter("int1")),Integer.valueOf(request.getParameter("int2")))){%>

        <jsp:forward page="/ResultsPagesJSP/resultFilamentsBySegments.jsp"/>

        <% }else{ %>

        <b style="color: #ff5516;margin-left: 20px;margin-top: 20px"> Errore inserimento max e min! </b>
        
        <%}}%>

    </form>

</div>