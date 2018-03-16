<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 07/03/2018
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>


<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 454px;
        height: 500px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 70px;
    }
</style>
<!--fine definizione parametri-->

<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 4%" method="post">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI NUMERO DI STELLE PRESENTI IN UN FILAMENTO</h2>
        </div>
        <!--fine titolo-->
        <%ArrayList<String> val= BeanFilamento.searchStarsInFilament();
        if(val!=null){%>

        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
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
<jsp:include page="/Include/footerHome.jsp"/>
<%}
    else {%>
<jsp:forward page="../ResultsPagesJSP/resultError.jsp"/>
<%}%>