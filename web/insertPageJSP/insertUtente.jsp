<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 15/02/18
  Time: 14.39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()&&(BeanLogin.getTipoUtente().equals("Amministratore"))){%>

<jsp:useBean id="BeanRegistrazione" scope="session" class="Bean.BeanRegistrazione"/>
<jsp:setProperty property="*" name="BeanRegistrazione"/>

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


<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 1050px">
    <br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI UN NUOVO UTENTE</h2>
        </div>
        <form method="post" >
            <!-- inserimento nome -->
            <label style="margin-left: 30px;margin-top: 50px"><b> Inserisci Nome :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                <input class="mdl-textfield__input" type="text" id="sample1" name="nomeRegistrazione" required maxlength="20" >
                <label class="mdl-textfield__label" for="sample3" > Nome </label>
            </div>
            <br>
            <!-- inserimento cognome -->
            <label style="margin-left: 30px;margin-top: 50px"> <b>Inserisci Cognome :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                <input class="mdl-textfield__input" type="text" id="sample2" name="cognomeRegistrazione" required maxlength="20" >
                <label class="mdl-textfield__label" for="sample3"> Cognome </label>
            </div>
            <br>
            <!-- inserimento username -->
            <label style="margin-left: 30px;margin-top: 50px"> <b>Inserisci Username :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                <input class="mdl-textfield__input" type="text" id="sample3" name="usernameRegistrazione"required maxlength="20" minlength="6">
                <label class="mdl-textfield__label" for="sample3"> Username</label>
            </div>
            <br>
            <!-- inserimento password -->
            <label style="margin-left: 30px;margin-top: 50px"> <b>Inserisci Password :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                <input class="mdl-textfield__input" type="text" id="sample4" name="passwordRegistrazione" required maxlength="20" minlength="6">
                <label class="mdl-textfield__label" for="sample3"> Password </label>
            </div>
            <br>
            <!-- inserimento email -->
            <label style="margin-left: 30px;margin-top: 50px"><b> Inserisci Email :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                <input class="mdl-textfield__input" type="text" id="sample5" name="emailRegistrazione" required maxlength="30" minlength="6">
                <label class="mdl-textfield__label" for="sample3"> Email </label>
            </div>
            <br>
            <br>
            <!-- inserimento tipo utente -->
            <label style="margin-left: 30px;margin-top: 50px"><b> Seleziona il tipo utente :</b><br></label>
            <div class="input-field col s12" style="width: 500px;margin-left: 30px">
                <br>
                <select class="browser-default" style="width: 300px"  name="tipoRegistrazione" required>
                    <option value="Amministratore">Amministratore</option>
                    <option value="utenteRegistrato">Utente</option>
                </select>
                <br><br>
            </div>
            <!-- button conferma -->

            <%  if(request.getParameter("conferma")!= null){
                BeanRegistrazione.setUsername(request.getParameter("usernameRegistrazione"));
                BeanRegistrazione.setPassword(request.getParameter("passwordRegistrazione"));
                BeanRegistrazione.setNome(request.getParameter("nomeRegistrazione"));
                BeanRegistrazione.setCognome(request.getParameter("cognomeRegistrazione"));
                BeanRegistrazione.setEmail(request.getParameter("emailRegistrazione"));
                BeanRegistrazione.setTipoUtente(request.getParameter("tipoRegistrazione"));
                if(!BeanRegistrazione.insertNewUtente()){%>
            <br><b class="red-text" style=" color: #ff6244" >Errore inserimento dati! </b>
            <% }else{%>
            <jsp:forward page="/ResultsPagesJSP/resultCorrectInsert.jsp"/>
            <%}
            }%>

            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="conferma">
                Conferma
            </button>

            <img style=" margin-left: 210px;margin-bottom: 20px; width: 90px; height: 90px" src="/Images/img_alien2.png" >

        </form>
    </div>
    <br><br>
</div>

<!--footer-->
<jsp:include page="/Include/footerHome.jsp"/>

<%}
else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>
