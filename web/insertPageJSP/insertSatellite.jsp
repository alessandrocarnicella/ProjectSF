<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.ParseException" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 15/02/2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>
<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 850px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->

<jsp:useBean id="BeanAgenzia" scope="session" class="Bean.BeanAgenzia"/>
<jsp:setProperty property="*" name="BeanAgenzia"/>
<jsp:useBean id="BeanSatellite" scope="session" class="Bean.BeanSatellite"/>
<jsp:setProperty property="*" name="BeanSatellite"/>


<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO SATELLITE</h2>
        </div>
        <form method="post" action="insertSatellite.jsp">
            <!--fine titolo-->
            <label style="margin-left: 30px"> <b>Seleziona l'agenzia associata:</b></label>
            <!--select delle agenzie associate-->
            <div class="input-field col s12" style="width: 500px;margin-left: 30px">
                <br>
                <select class="browser-default" style="width: 300px" name="selectagenzia" required>
                    <% ArrayList<String> agenzie = BeanAgenzia.selectAgenzie();
                        for(int i=0; i<agenzie.size();i++){%>
                    <option value=<%=agenzie.get(i)%>> <%=agenzie.get(i)%> </option>
                    <%}%>
                </select>
                <br><br>
            </div>
            <!--fine select-->
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome satellite:</b></label>
            <br><br>
            <!--inserimento del nome satellite-->

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="text" name="nomesatellite" id="sample3" required>
                <label class="mdl-textfield__label" for="sample3"> nome </label>
            </div>

            <!--fine inserimento-->
            <br><br>
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data inizio:</b></label>
            <br><br>
            <!--inserimento data inizio-->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="date" name="datainizio" id="sample4" required>
                <label class="mdl-textfield__label" for="sample4"></label>
            </div>
            <!--fine inserimento-->
            <br><br>
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data fine:</b></label>
            <br><br>
            <!-- inserimento data fine-->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="date" name="datafine" id="sample5" required>
                <label class="mdl-textfield__label" for="sample5"></label>
            </div>
            <!--fine inserimento-->
            <!--button-->
            <div>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="confermainsertsat" style="width: 200px;margin-left: 30px;margin-top: 50px">
                    Conferma
                </button>
                <img style=" margin-left: 150px" src="../Images/alien2.png" >
            </div>

            <%
                if (request.getParameter("confermainsertsat")!=null){

                    BeanSatellite.setNomeAgenzia(request.getParameter("selectagenzia"));
                    BeanSatellite.setNome(request.getParameter("nomesatellite"));
                    BeanSatellite.setDataInizio(Date.valueOf(request.getParameter("datainizio")));
                    BeanSatellite.setDataFine(Date.valueOf(request.getParameter("datafine")));
                    if(BeanSatellite.insertNewSatellite()){ %>
            <br><br>
            <label style="color: green" > <b>Satellite inserito correttamente!</b> </label>
            <%} else {%>
            <br><br>
            <label style="color: red"> <b>Errore inserimento dati!</b> </label>
            <%}
            }%>

        </form>
        <br><br>
    </div>
    <br><br><br>
</div>


<jsp:include page="/Include/footerHome.jsp"/>