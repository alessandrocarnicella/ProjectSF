<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>
<jsp:useBean id="BeanInserimentoCSV" scope="session" class="Bean.BeanInserimentoCSV"/>
<jsp:setProperty property="*" name="BeanInserimentoCSV"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 750px;
        height: 480px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 710px"><br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px;height:400px;width: 700px;" method="post" action="/Home.jsp">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 20px"><br>
            <h2 class="mdl-card__title-text" style="margin-left:30px;color: #25793d">L'inserimento dei dati è stato effettutato correttamente!</h2>
        </div>

        <!-- button ritorno home  -->
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="comebackhome" style="width: 200px;margin-left: 90px;margin-top: 80px" >
            torna alla Home
        </button>
        <div style=" margin-left: 500px;margin-bottom: 30px;width: 140px;height: 140px;">
            <img  src="/Images/img_checkedInsert.png" >
        </div>

        <% if (request.getParameter("comebackhome") != null){%>
        <jsp:forward page="/Home.jsp"/>
        <%}%>
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
