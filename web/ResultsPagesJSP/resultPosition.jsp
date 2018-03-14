<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 07/03/18
  Time: 16.33
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- MDL for tabs pagination-->
<script src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
<link rel="stylesheet"
      href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.red-purple.min.css" />

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 1169px;
        height: 1300px;
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
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 4%">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA DISTANZA STELLE DA SPINA DORSALE</h2>
        </div>
        <!--fine titolo-->
            <% int count=1;
            ArrayList<String[]> val = BeanFilamento.searchDistance();

           /* for(String[] g:val){
            System.out.println(Arrays.toString(g));
            }
            */
            if (val!=null){%>

        <!-- MDL Fixed Layout Container -->
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header" style="margin-top: 160px">
            <!-- Header Container -->
            <header class="mdl-layout__header">
                <!-- Tab Bar Container , and Tab links -->
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
                    <a href="#page1" class="mdl-layout__tab is-active">pagina1</a>
                    <% for(int i=1;i<=val.size();i++){%>
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
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                        <thead>
                        <tr>
                            <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                            <th class="mdl-data-table__cell--non-numeric">IDFilamento</th>
                            <th class="mdl-data-table__cell--non-numeric">ID Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Nome </th>
                            <th class="mdl-data-table__cell--non-numeric">Flusso T</th>
                            <th class="mdl-data-table__cell--non-numeric">Lat Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Lon Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Lat dorsale</th>
                            <th class="mdl-data-table__cell--non-numeric">Lon dorsale</th>
                            <th class="mdl-data-table__cell--non-numeric">Distanza</th>
                        </tr>
                        </thead>
                        <tbody>
                        <div class="page-content" style="margin-top: 10px;margin-left: 25px">


                            <%
                                int num=0;
                                if(val.size()>=20){
                                    num=20;
                                }else {
                                    num=val.size();
                                }
                                for(int j=0;j<num;j++){
                                    String[] val1 = val.get(j);%>
                            <tr>
                                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[0]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[1]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[2]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[3]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[4]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[5]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[6]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[7]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[8]%></td>
                            </tr>
                            <%}%>
                        </div>
                        </tbody>
                    </table>
                </section>

                <% int init=20;
                    for (int k=2;k<=count;k++){%>
                <section class="mdl-layout__tab-panel" id="page<%=k%>">
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                        <thead>
                        <tr>
                            <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                            <th class="mdl-data-table__cell--non-numeric">ID Filamento</th>
                            <th class="mdl-data-table__cell--non-numeric">ID Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Nome </th>
                            <th class="mdl-data-table__cell--non-numeric">Flusso T</th>
                            <th class="mdl-data-table__cell--non-numeric">Lat Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Lon Stella</th>
                            <th class="mdl-data-table__cell--non-numeric">Lat dorsale</th>
                            <th class="mdl-data-table__cell--non-numeric">Lon dorsale</th>
                            <th class="mdl-data-table__cell--non-numeric">Distanza</th>
                        </tr>
                        </thead>
                        <tbody>
                        <div class="page-content" style="margin-top: 10px;margin-left: 25px">
                            <%  int num2=0;
                                if(val.size()-init>20){
                                num2 = 20;
                            }else{
                                num2 = val.size()-init;
                            }
                                for(int j=init;j<init+num2;j++){
                                String[] val1 = val.get(j);%>
                            <tr>
                                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[0]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[1]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[2]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[3]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[4]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[5]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[6]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[7]%></td>
                                <td class="mdl-data-table__cell--non-numeric"><%=val1[8]%></td>
                            </tr>
                            <%}%>
                        </div>
                        </tbody>
                    </table>
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
<%}
    else {%>
<jsp:forward page="../ResultsPagesJSP/resultError.jsp"/>
<%}%>