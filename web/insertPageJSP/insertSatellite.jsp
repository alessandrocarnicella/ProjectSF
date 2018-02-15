<%--
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
        height: 800px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->
<br><br><br><br><br><br><br>
<div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 20%">
    <!--titolo della card-->
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO SATELLITE</h2>
    </div>
    <!--fine titolo-->
    <label style="margin-left: 30px;margin-top: 50px"> <b>Seleziona l'agenzia associata:</b></label>
    <!--select delle agenzie associate-->
    <div class="input-field col s12" style="width: 500px;margin-left: 30px">
        <br>
        <select class="browser-default" style="width: 300px">
            <option value="1">agenzia1</option>
            <option value="2">agenzia2</option>
            <option value="3">agenzia3</option>
        </select>
        <br><br>
    </div>
    <!--fine select-->
    <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome satellite:</b></label>
    <br><br>
    <!--inserimento del nome strumento-->
    <form action="#">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
            <input class="mdl-textfield__input" type="text" id="sample3" required>
            <label class="mdl-textfield__label" for="sample3"> nome </label>
        </div>
    </form>
    <!--fine inserimento-->
    <br><br>
    <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data inizio:</b></label>
    <br><br>
    <form action="#">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
            <input class="mdl-textfield__input" type="text" id="sample4" required>
            <label class="mdl-textfield__label" for="sample4"> data inizio </label>
        </div>
    </form>
    <br><br>
    <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci data fine:</b></label>
    <br><br>
    <form action="#">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
            <input class="mdl-textfield__input" type="text" id="sample5" required>
            <label class="mdl-textfield__label" for="sample5"> data fine:  </label>
        </div>
    </form>
    <br><br>

    <!--button-->
    <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 40px">
        Conferma
    </button>


</div>

<jsp:include page="/Include/footerHome.jsp"/>