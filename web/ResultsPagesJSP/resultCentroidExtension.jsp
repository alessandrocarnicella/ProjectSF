<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 800px;
        height: 600px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 840px"><br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp"  style="margin-left: 10%;margin-top: 50px" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA PER FILAMENTO </h2>
        </div>
        <!--fine titolo-->

        <!-- Simple Textfield -->
        <%ArrayList<String> val=BeanFilamento.selectForIdOrNameFilCentroidExtension();
        if (val!=null){%>

        <div class="row">
            <label style="margin-left: 30px;margin-top: 30px"> <b> POSIZIONE DEL CENTROIDE DEL CONTORNO :</b></label><br><br><br>
            <label style="margin-left: 30px"> <b style="color:#1c9d32">long :</b> <%=val.get(0)%> </label>
            <label style="margin-left: 20px"> <b style="color:#1c9d32">latg :</b> <%=val.get(1)%> </label>
        </div>

        <div style="margin-top: 60px">
            <label style="margin-left: 30px;margin-top: 30px"> <b> ESTENSIONE DEL CONTORNO :</b></label><br><br><br>
            <label style="margin-left: 30px"> <b style="color:#1c9d32">distanza posizioni long :</b> <%=val.get(7)%> </label>
            <label style="margin-left: 20px"> <b style="color:#1c9d32">distanza posizioni latg :</b> <%=val.get(8)%> </label>
        </div>

        <div class="row" style="margin-top: 60px">
            <label style="margin-left: 30px;margin-top: 30px"> <b> NUMERO DEI SEGMENTI DEL FILAMENTO :</b></label><br><br><br>
            <label style="margin-left: 30px"> <b style="color:#1c9d32"> segementi presenti :</b> <%=val.get(6)%> </label>
        </div>

    </form>
    <%} else {%>
    <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTA SPECIFICA RICERCA! </b></label><br><br><br>
    <%}%>
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