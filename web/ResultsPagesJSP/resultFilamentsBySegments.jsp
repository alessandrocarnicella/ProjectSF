<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 25/02/2018
  Time: 16:59
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
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI DI UN FILAMENTO CON NUMERO DI SEGMENTI COMPRESO TRA <%=request.getParameter("int1")%> E <%=request.getParameter("int2")%></h2>
        </div>
        <!--fine titolo-->

        <% ArrayList<String> filamentiBySegmentsNumber= BeanSegmento.selectFilamentsBySegmentsNumber(Integer.valueOf(request.getParameter("int1")),Integer.valueOf(request.getParameter("int2")));
            System.out.println(filamentiBySegmentsNumber);%>

    </form>


</div>