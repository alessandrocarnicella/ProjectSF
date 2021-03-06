<%@ page import="Entity.Filamento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>

<jsp:useBean id="BeanBrillantezzaEllitticita" scope="session" class="Bean.BeanBrillantezzaEllitticita"/>
<jsp:setProperty property="*" name="BeanBrillantezzaEllitticita"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 1050px;
        height: 1230px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height:1470px"><br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px;margin-bottom: -10px" method="post">

        <!-- titolo della card -->
        <div class="mdl-card__title" style="margin-top:10px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA PER CONTRASTO ED ELLITTICITA'</h2>
        </div>
         <% int count=1;
            ArrayList<Filamento> filamenti= BeanBrillantezzaEllitticita.selectFilamentoFromBean();
            if (filamenti!=null){%>

        <!-- MDL Fixed Layout Container -->
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header" style="margin-top: 140px">

            <!-- Header Container -->
            <header class="mdl-layout__header">

                <!-- Tab Bar Container , and Tab links -->
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
                    <a href="#page1" class="mdl-layout__tab is-active">pagina1</a>
                    <% if(filamenti.size()>20){
                            for(int i=1;i<=filamenti.size();i++){%>
                    <%          if(i%20==0){
                                    count++;%>
                                    <a href="#page<%=count%>" class="mdl-layout__tab">pagina<%=count%></a>
                    <%          }
                            }
                        }%>
                </div>
            </header>

            <main class="mdl-layout__content">

                <!-- "is-active" class to set the default active tab -->
                <section class="mdl-layout__tab-panel is-active" id="page1">
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left: 20px">
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

                        <div class="page-content" style="margin-top: 10px;margin-left: 25px">
                            <%
                                int num=0;
                                if(filamenti.size()>=20){
                                    num=20;
                                }else {
                                    num=filamenti.size();
                                }
                                for(int j=0;j<num;j++){%>
                                <tr>
                                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getIdFilamento()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNome()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getFlussoTotale()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getDensitaMedia()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getTemperaturaMedia()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getEllitticita()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getContrasto()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNomeSatellite()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNomeStrumento()%></td>
                                </tr>
                            <%  }%>
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

                        <div class="page-content" style="margin-top: 10px;margin-left: 25px">
                            <%int num2=0;
                                if(filamenti.size()-init>20){
                                    num2 = 20;
                                }else{
                                    num2 = filamenti.size()-init;
                                }
                                for(int j=init;j<init+num2;j++){%>
                                <tr>
                                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getIdFilamento()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNome()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getFlussoTotale()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getDensitaMedia()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getTemperaturaMedia()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getEllitticita()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getContrasto()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNomeSatellite()%></td>
                                    <td class="mdl-data-table__cell--non-numeric"><%=filamenti.get(j).getNomeStrumento()%></td>
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

<!--footer-->
<jsp:include page="/Include/footerHome.jsp"/>
<%
}
else {%>
    <!-- Pagina di errore per utente non loggato -->
    <jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%
}%>