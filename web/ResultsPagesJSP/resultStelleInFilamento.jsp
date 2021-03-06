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
        width: 500px;
        height:300px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 70px;
    }
</style>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 600px">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 4%;margin-top: 50px;margin-bottom: -10px" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI NUMERO DI STELLE PRESENTI IN UN FILAMENTO</h2>
        </div>

        <%ArrayList<String> val= BeanFilamento.searchStarsInFilament();
        if(val!=null){%>

        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left:20px;margin-top:35px">
            <thead>
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <th class="mdl-data-table__cell--non-numeric">n°stelle trovate</th>
                <th class="mdl-data-table__cell--non-numeric">% Protostelle</th>
                <th class="mdl-data-table__cell--non-numeric">% Prestelle</th>
                <th class="mdl-data-table__cell--non-numeric">% Unbound</th>

            </tr>
            </thead>
            <tbody>

            <!-- Row 1 -->
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <td class="mdl-data-table__cell--non-numeric"><%=val.get(0)%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=val.get(1)%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=val.get(2)%></td>
                <td class="mdl-data-table__cell--non-numeric"><%=val.get(3)%></td>
            </tr>
            </tbody>
        </table>
    <%
    } else {%>
    <br>
    <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTO ID FILAMENTO! </b></label><br>
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
