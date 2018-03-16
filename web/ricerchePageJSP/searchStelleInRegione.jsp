<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 06/03/18
  Time: 12.02
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanPosBaseAltezza" scope="session" class="Bean.BeanPosBaseAltezza"/>
<jsp:setProperty property="*" name="BeanPosBaseAltezza"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 850px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 80px;
    }
</style>
<!--fine definizione parametri-->


<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RICERCA STELLE IN REGIONE </h2>
        </div>
        <!--fine titolo-->

        <!--inserimento posizione spaziale-->
        <label style="margin-left: 30px"><b> Inserisci posizione spaziale :</b></label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="latS" step="0.0001" name="latS" required maxlength="20" required style="width: 100px">
            <label class="mdl-textfield__label" for="latS" > lat </label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="lonS" step="0.0001" name="lonS" required maxlength="20" required style="width: 100px">
            <label class="mdl-textfield__label" for="lonS" > lon </label>
        </div>
        <br>
        <!--fine inserimento-->
        <!--inserimento base della regione-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value1" id="div1" style="margin-left: 30px" required>
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci base della regione </b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number" min="0.01"  step="0.01" id="sample3" name="base">
            <label class="mdl-textfield__label" for="sample3"></label>
        </div>
        <!--fine inserimento-->
        <br><br>
        <!--inserimento altezza della regione-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value1"  id="div1" style="margin-left: 30px" required>
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci l'altezza della regione </b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number" min="0.01"  step="0.01" id="sample5" name="altezza">
            <label class="mdl-textfield__label" for="sample5"></label>
        </div>
        <!--fine inserimento-->
        <br><br>

        <br><br>
        <!--button-->
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="searchconfermaregione2" style="width: 200px;margin-left: 30px;margin-top: 50px">
                Effettua la ricerca
            </button>
            <img style=" margin-left: 150px" src="../Images/img_alien2.png" >
        </div>


        <% if(request.getParameter("searchconfermaregione2")!=null) {
            BeanPosBaseAltezza.setLonG(Float.valueOf(request.getParameter("lonS")));
            BeanPosBaseAltezza.setLatG(Float.valueOf(request.getParameter("latS")));
            BeanPosBaseAltezza.setBase(Float.valueOf(request.getParameter("base")));
            BeanPosBaseAltezza.setAltezza(Float.valueOf(request.getParameter("altezza")));
        %>

        <jsp:forward page="/ResultsPagesJSP/resultStelleRegione.jsp"/>

        <%}%>

    </form>

    <br><br><br><br><br>
</div>

<jsp:include page="/Include/footerHome.jsp"/>

<%}
    else {%>
<jsp:forward page="../ResultsPagesJSP/resultError.jsp"/>
<%}%>