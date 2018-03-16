<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 15/02/2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()&&(BeanLogin.getTipoUtente().equals("Amministratore"))){%>
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

<jsp:useBean id="BeanSatellite" scope="session" class="Bean.BeanSatellite"/>
<jsp:setProperty property="*" name="BeanSatellite"/>

<jsp:useBean id="BeanStrumento" scope="session" class="Bean.BeanStrumento"/>
<jsp:setProperty property="*" name="BeanStrumento"/>

<jsp:useBean id="BeanBanda" scope="session" class="Bean.BeanBanda"/>
<jsp:setProperty property="*" name="BeanBanda"/>

<jsp:useBean id="BeanMisurazione" scope="session" class="Bean.BeanMisurazione"/>
<jsp:setProperty property="*" name="BeanMisurazione"/>

<!--fine definizione parametri-->
<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%">
        <!--titolo della card-->
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO STRUMENTO</h2>
        </div>
        <!--fine titolo-->
        <label style="margin-left: 30px;margin-top: 50px"> <b>Seleziona il satellite :</b></label>
        <!--select dei satellitti-->
        <form method="post" >
            <div class="input-field col s12" style="width: 500px;margin-left: 30px">
                <br>
                <select class="browser-default" style="width: 300px" name="selectsatellite">
                    <%ArrayList<String> satelliti=BeanSatellite.selectSatelliti();
                        for(int i=0;i<satelliti.size();i++){%>
                    <option value=<%=satelliti.get(i)%>><%=satelliti.get(i)%></option>
                    <%}%>
                </select>
                <br><br>
            </div>
            <!--fine select-->
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome strumento:</b></label>
            <br><br>
            <!--inserimento del nome strumento-->

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="text" id="sample3" name="nomestrumento" required>
                <label class="mdl-textfield__label" for="sample3"> nome </label>
            </div>

            <!--fine inserimento-->
            <br><br>
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci lunghezza di banda:</b></label>
            <br><br>
            <!--inserimento della lunghezza-->

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="number" step="0.01"  id="sample4" name="lunghezzabanda" required>
                <label class="mdl-textfield__label" for="sample4"> lunghezza </label>
            </div>

            <!--fine inserimento-->
            <!--button-->
            <div>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="confermainsertstrum" style="width: 200px;margin-left: 30px;margin-top: 40px" >
                    Conferma
                </button>
                <img style=" margin-left: 180px;margin-bottom: 20px;width: 120px;height: 120px" src="../Images/img_settings.png" >
            </div>

            <%
                if (request.getParameter("confermainsertstrum")!=null){
                    BeanStrumento.setNomeSatellite(request.getParameter("selectsatellite"));
                    BeanStrumento.setNome(request.getParameter("nomestrumento"));

                    BeanBanda.setLunghezza(Float.valueOf(request.getParameter("lunghezzabanda")));
                    BeanMisurazione.setNomeStrumento(request.getParameter("nomestrumento"));
                    BeanMisurazione.setBanda(Float.valueOf(request.getParameter("lunghezzabanda")));
                    if(BeanStrumento.insertNewStrumento()&&BeanBanda.insertNewBanda()&&BeanMisurazione.insertNewMisurazione()){ %>
            <jsp:forward page="/ResultsPagesJSP/resultCorrectInsert.jsp"/>
            <%} else {%>
            <label style="color: red;text-align: right"> <b>Errore inserimento dati!</b> </label>
            <%}
            }%>
        </form>
    </div>
    <br><br><br>
</div>

<!-- footer -->
<jsp:include page="/Include/footerHome.jsp"/>
<%}
else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>
