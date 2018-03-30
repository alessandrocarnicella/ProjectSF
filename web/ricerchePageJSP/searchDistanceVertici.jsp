<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanScheletro" scope="session" class="Bean.BeanScheletro"/>
<jsp:setProperty property="*" name="BeanScheletro"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 450px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>


<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 690px"><br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">RICERCA DISTANZA VERTICI SEGMENTO</h2>
        </div>
        <form method="post">
            <label style="margin-left: 30px;margin-top: 50px"> <b>Inserisci l'identificativo del segmento :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 200px" >
                <input class="mdl-textfield__input" type="number" id="sample1" name="idsegmento" required max="20000000000" >
                <label class="mdl-textfield__label" for="sample1" >id segmento</label>
            </div>
            <br>

            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="confermaidsegmento">
                Conferma
            </button>

            <img style=" margin-left: 110px;width: 180px;height: 150px;margin-bottom: -80px;margin-top: 60px" src="/Images/img_distanzaVertici.png" >

            <%  if(request.getParameter("confermaidsegmento")!= null) {
                BeanScheletro.setIdSegmento(Integer.valueOf(request.getParameter("idsegmento")));
            %>

            <jsp:forward page="/ResultsPagesJSP/resultDistanceVertici.jsp"/>
            <%}%>
        </form>
    </div>
</div>
<!--footer-->
<jsp:include page="/Include/footerHome.jsp"/>
<%
}
else {%>
<!-- Pagina di errore per utente non loggato -->
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%
    }%>