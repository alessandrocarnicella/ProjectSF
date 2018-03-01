<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %><%--
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

        <% int count=0;
            ArrayList<String[]> filamentiBySegmentsNumber= BeanSegmento.selectFilamentsBySegmentsNumber(Integer.valueOf(request.getParameter("int1")),Integer.valueOf(request.getParameter("int2")));
            if (filamentiBySegmentsNumber!=null){

                for(String[] s:filamentiBySegmentsNumber){
                    System.out.println(Arrays.toString(s));
                }%>

        <main class = "mdl-layout__content" style="margin-top: 30px;">
            <div class = "mdl-tabs mdl-js-tabs">
                <div class = "mdl-tabs__tab-bar">
                    <% for(int i=0;i<filamentiBySegmentsNumber.size();i++){
                        if (i%20==0){
                            count++;%>

                    <a href = "<%=count%>" class = "mdl-tabs__tab is-active">pagina<%=count%></a>
                </div>
                <div class = "mdl-tabs__panel is-active" id = "<%=count%>" style="margin-left: 25px;margin-top: 25px">
                    <p>Tab 1 Content</p>
                </div>

            </div>

        </main>
        <%}
        }   } else {%>
        <br>
        <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTA SPECIFICA RICERCA! </b></label><br><br><br>
        <%}%>

    </form>


</div>