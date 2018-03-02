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

<!-- MDL for tabs pagination-->
<script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
<link rel="stylesheet"
      href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.red-purple.min.css" />

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 750px;
        height: 1100px;
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
            <% int count=1;
            ArrayList<String[]> filamentiBySegmentsNumber= BeanSegmento.selectFilamentsBySegmentsNumber(Integer.valueOf(request.getParameter("int1")),Integer.valueOf(request.getParameter("int2")));
            for(String[] g:filamentiBySegmentsNumber){
            System.out.println(Arrays.toString(g));
            }
            if (filamentiBySegmentsNumber!=null){%>

        <!-- MDL Fixed Layout Container -->
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header" style="margin-top: 160px">
            <!-- Header Container -->
            <header class="mdl-layout__header">
                <!-- Tab Bar Container , and Tab links -->
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
                    <a href="#page1" class="mdl-layout__tab is-active">pagina1</a>
                    <% for(int i=1;i<filamentiBySegmentsNumber.size();i++){%>
                    <% if(i%20==0){
                        count++;%>
                    <a href="#page<%=count%>" class="mdl-layout__tab">pagina<%=count%></a>
                    <%}
                    }%>
                </div>
            </header>

            <main class="mdl-layout__content">
                <!-- "is-active" class to set the default active tab -->
                <section class="mdl-layout__tab-panel is-active" id="page1">
                    <div class="page-content" style="margin-top: 25px">
                        <%for(int j=0;j<20;j++){%>
                        <p><%=Arrays.toString(filamentiBySegmentsNumber.get(j))%></p>
                        <%}%>
                    </div>
                </section>

                <% int init=20;
                    for (int k=2;k<count;k++){%>
                <section class="mdl-layout__tab-panel" id="page<%=k%>">
                    <div class="page-content" style="margin-top: 25px">
                        <%for(int w=init;w<init+20;w++){%>
                        <p><%=Arrays.toString(filamentiBySegmentsNumber.get(w))%></p>
                        <%}%>
                    </div>
                </section>
                <%init=init+20;
                }%>
            </main>
        </div>
            <%} else {%>
        <br>
        <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTA SPECIFICA RICERCA! </b></label><br><br><br>
            <%}%>
</div>

<jsp:include page="/Include/footerHome.jsp"/>