<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- controllo su utente loggato e tipo di utente -->
<%if (BeanLogin.getUtente() && (BeanLogin.getTipoUtente().equals("Amministratore"))){%>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
            width: 600px;
            background-color:rgba(255, 255, 255, 0.93);
        }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>

<jsp:useBean id="BeanAgenzia" scope="session" class="Bean.BeanAgenzia"/>
<jsp:setProperty property="*" name="BeanAgenzia"/>
<jsp:useBean id="BeanSatellite" scope="session" class="Bean.BeanSatellite"/>
<jsp:setProperty property="*" name="BeanSatellite"/>


<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 980px">
    <br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px">

        <!-- titolo della card -->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO SATELLITE</h2>
        </div>
        <form method="post" >

            <!-- fine titolo -->
            <label style="margin-left: 30px"> <b>Seleziona l'agenzia associata:</b></label>

            <!-- select delle agenzie associate -->
            <div class="input-field col s12" style="width: 500px;margin-left: 30px">
                <br>
                <select class="browser-default" style="width: 300px" name="selectagenzia" required>
                    <% ArrayList<String> agenzie = BeanAgenzia.selectAgenzie();
                        for(int i = 0; i < agenzie.size(); i++){%>
                            <option value=<%=agenzie.get(i)%>> <%=agenzie.get(i)%> </option>
                    <%  }%>
                </select><br><br>
            </div>

            <!-- inserimento del nome satellite -->
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome satellite:</b></label><br><br>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="text" name="nomesatellite" id="sample3" required>
                <label class="mdl-textfield__label" for="sample3"> nome </label>
            </div><br><br>

            <!-- inserimento data inizio -->
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data inizio:</b></label><br><br>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="date" name="datainizio" id="sample4" required>
                <label class="mdl-textfield__label" for="sample4"></label>
            </div><br><br>

            <!-- inserimento data fine -->
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data fine:</b></label><br><br>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="date"  name="datafine" id="sample5" required>
                <label class="mdl-textfield__label" for="sample5"></label>
            </div>

            <%
                if (request.getParameter("confermainsertsat") != null){
                    BeanSatellite.setNomeAgenzia(request.getParameter("selectagenzia"));
                    BeanSatellite.setNome(request.getParameter("nomesatellite"));
                    BeanSatellite.setDataInizio(Date.valueOf(request.getParameter("datainizio")));
                    BeanSatellite.setDataFine(Date.valueOf(request.getParameter("datafine")));
                    if(BeanSatellite.ControlloData(Date.valueOf(request.getParameter("datainizio")),Date.valueOf(request.getParameter("datafine")))){
                        if(BeanSatellite.insertNewSatellite()){ %>
                            <br><br>
                            <jsp:forward page="/ResultsPagesJSP/resultCorrectInsert.jsp"/>
            <%          }else{%>
                            <br><br>
                            <label style="color: red; margin-left: 20px" > <b>Errore inserimento dati!</b> </label>
            <%          }
                    }else {%>
                        <br><br>
                        <label style="color: red; margin-left: 20px"> <b>Errore inserimento data!</b> </label>
            <%      }

                }%>

            <!--button-->
            <div>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="confermainsertsat" style="width: 200px;margin-left: 30px;margin-top: 50px">
                    Conferma
                </button>
                <img style=" margin-left: 180px;margin-bottom: 20px;width: 110px;height: 110px" src="../Images/img_satellite.png" >
            </div>
        </form><br><br>
    </div><br><br><br>
</div>

<!-- footer -->
<jsp:include page="/Include/footerHome.jsp"/>

<%
}
else {%>
    <!-- pagina di errore per utente non loggato -->
    <jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%
}%>

