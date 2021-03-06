<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanSegmento" scope="session" class="Bean.BeanSegmento"/>
<jsp:setProperty property="*" name="BeanSegmento"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
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

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 890px"><br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RICERCA DI UN FILAMENTO IN BASE AL NUMERO DEI SUOI SEGMENTI IN UN RANGE PREFISSATO </h2>
        </div>

        <!--inserimento del primo intero di range-->
        <label style="margin-left: 30px;margin-top: 50px"><b> Inserisci il numero di segmenti minimo (compreso): </b></label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="sample3" name="int1" required min="3" max="90000">
            <label class="mdl-textfield__label"  for="sample3"></label>
        </div><br><br>

        <!--inserimento del secondo intero di range-->
        <label style="margin-left: 30px;margin-top: 50px"><b>Inserisci il numero di segmenti massimo (non compreso):</b></label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="sample4" name="int2" required min="3" max="90000">
            <label class="mdl-textfield__label" for="sample4"></label>
        </div><br><br>

        <!--button-->
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="searchconfermasegmentsfilament" style="width: 200px;margin-left: 30px;margin-top: 50px">
                Effettua la ricerca
            </button>
            <img style=" margin-left: 280px;width: 120px;height: 120px" src="/Images/img_numeroSegmentiFilamento.png" >
        </div>

        <%if (request.getParameter("searchconfermasegmentsfilament")!=null){
                if (BeanSegmento.controlloMinMax(Integer.valueOf(request.getParameter("int1")),Integer.valueOf(request.getParameter("int2")))){%>
                <jsp:forward page="/ResultsPagesJSP/resultFilamentsBySegments.jsp"/>

            <%  }else{ %>

                <b style="color: #ff5516;margin-left: 20px;margin-top: 20px"> Errore inserimento max e min! </b>

        <%      }
        }%>
    </form>
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