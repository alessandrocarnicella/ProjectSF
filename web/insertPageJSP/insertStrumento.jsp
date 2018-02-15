<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 15/02/2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>
<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 600px;
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
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%">
        <!--titolo della card-->
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO STRUMENTO</h2>
        </div>
        <!--fine titolo-->
        <label style="margin-left: 30px;margin-top: 50px"> <b>Seleziona il satellite :</b></label>
        <!--select dei satellitti-->
        <div class="input-field col s12" style="width: 500px;margin-left: 30px">
            <br>
            <select class="browser-default" style="width: 300px">
                <option value="1">satellite1</option>
                <option value="2">satellite2</option>
                <option value="3">satellite3</option>
            </select>
            <br><br>
        </div>
        <!--fine select-->
        <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome strumento:</b></label>
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
        <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci lunghezza di banda:</b></label>
        <br><br>
        <!--inserimento della lunghezza-->
        <form action="#">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px">
                <input class="mdl-textfield__input" type="text" id="sample4" required>
                <label class="mdl-textfield__label" for="sample4"> lunghezza </label>
            </div>
        </form>
        <!--fine inserimento-->
        <!--button-->
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 40px">
            Conferma
        </button>
    </div>
    <br><br><br>
</div>


<jsp:include page="/Include/footerHome.jsp"/>

