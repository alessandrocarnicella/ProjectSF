<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 07/03/2018
  Time: 16:35
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
        width: 570px;
        height: 440px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 70px;
    }
</style>
<!--fine definizione parametri-->

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 640px">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 4%;margin-bottom: -10px;margin-top: 50px" method="post">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI STELLE PRESENTI IN UN FILAMENTO IN BASE A UNA REGIONE </h2>
        </div>
        <!--fine titolo-->

        <% ArrayList<String> val= BeanPosBaseAltezza.searchStarsByRegion();
            if (val!=null){%>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--4dp" style="margin-left: 40px;margin-top: 30px">
            <thead>
            <tr>
                <th> n°stelle trovate</th>
                <th> % Protostelle</th>
                <th> % Prestelle</th>
                <th> % Unbound</th>
            </tr>
            </thead>
            <tbody>
            <!-- Row 1 -->
            <tr>
                <td><%=val.get(0)%></td>
                <td><%=val.get(1)%></td>
                <td><%=val.get(2)%></td>
                <td><%=val.get(3)%></td>
            </tr>
            </tbody>
        </table>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--4dp" style="margin-left: 30px;margin-top: 40px">
            <thead>
            <tr>
                <th> n°stelle NON trovate</th>
                <th> % Protostelle</th>
                <th> % Prestelle</th>
                <th> % Unbound</th>
            </tr>
            </thead>
            <tbody>
            <!-- Row 1 -->
            <tr>
                <td><%=val.get(4)%></td>
                <td><%=val.get(5)%></td>
                <td><%=val.get(6)%></td>
                <td><%=val.get(7)%></td>
            </tr>
            </tbody>
        </table>
        <%} else {%>
        <br>
        <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTO ID FILAMENTO! </b></label><br>
        <%}%>

    </form>
</div>
<jsp:include page="/Include/footerHome.jsp"/>
<%}
    else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>