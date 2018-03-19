<%@ page import="Entity.Filamento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>

<jsp:useBean id="BeanPosRaggioLato" scope="session" class="Bean.BeanPosRaggioLato"/>
<jsp:setProperty property="*" name="BeanPosRaggioLato"/>


<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 1021px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp"  style="margin-left: 10%" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA PER REGIONE </h2>
        </div>
        <!--fine titolo-->

        <%ArrayList<Filamento> val= BeanPosRaggioLato.selectFilamentoFromBean();%>
        <%if (val!=null){%>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
            <thead>
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <th class="mdl-data-table__cell--non-numeric">ID Filamento</th>
                <th class="mdl-data-table__cell--non-numeric">Nome</th>
                <th class="mdl-data-table__cell--non-numeric">Flusso T</th>
                <th class="mdl-data-table__cell--non-numeric">Densita M</th>
                <th class="mdl-data-table__cell--non-numeric">Temeperatura M</th>
                <th class="mdl-data-table__cell--non-numeric">Ellitticità</th>
                <th class="mdl-data-table__cell--non-numeric">Contrasto</th>
                <th class="mdl-data-table__cell--non-numeric">Satellite</th>
                <th class="mdl-data-table__cell--non-numeric">Strumento</th>
            </tr>
            </thead>
            <tbody>


            <% for(Filamento f:val){%>
            <!-- Row 1 -->
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <td class="mdl-data-table__cell--non-numeric"><%=f.getIdFilamento()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getNome()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getFlussoTotale()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getDensitaMedia()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getTemperaturaMedia()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getEllitticita()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getContrasto()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getNomeSatellite()%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=f.getNomeStrumento()%></td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </form>
    <%} else {%>
    <br>
    <div style="height: 500px">
    <label style="margin-left: 30px;margin-top: 30px; color: #ff6244;margin-bottom: 100px"> <b> NON ESISTONO RISULTATI PER QUESTA SPECIFICA RICERCA! </b></label><br><br><br>
    </div>
        <%}%>
</div>


<jsp:include page="/Include/footerHome.jsp"/>
<%}
    else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>