<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 15/02/18
  Time: 14.39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<jsp:useBean id="BeanRegistrazione" scope="session" class="Bean.BeanRegistrazione"/>
<jsp:setProperty property="*" name="BeanRegistrazione"/>



<style>
    .demo-card-wide2.mdl-card {
        width: 600px;
        height: 700px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }

</style>

<br>
<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1000px;">
    <div class="mdl-grid">
        <div class="mdl-cell mdl-cell--6-col">
            <div  style=" margin-left: 20%;">
                <br><br><br><br><br>
                <div class="demo-card-wide2 mdl-card mdl-shadow--2dp">
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Registra utente</h2>
                    </div>
                    <form action="insertUtente.jsp">
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci Nome :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                            <input class="mdl-textfield__input" type="text" id="sample1" name="nomeRegistrazione" required maxlength="20" >
                            <label class="mdl-textfield__label" for="sample3" > Nome </label>
                        </div>
                        <br>
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci Cognome :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                            <input class="mdl-textfield__input" type="text" id="sample2" name="cognomeRegistrazione" required maxlength="20" >
                            <label class="mdl-textfield__label" for="sample3"> Cognome </label>
                        </div>
                        <br>
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci Username :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                            <input class="mdl-textfield__input" type="text" id="sample3" name="usernameRegistrazione"required maxlength="20" minlength="6">
                            <label class="mdl-textfield__label" for="sample3"> Username</label>
                        </div>
                        <br>
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci Password :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                            <input class="mdl-textfield__input" type="text" id="sample4" name="passwordRegistrazione" required maxlength="20" minlength="6">
                            <label class="mdl-textfield__label" for="sample3"> Password </label>
                        </div>
                        <br>
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci Email :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin-left: 30px; width: 500px">
                            <input class="mdl-textfield__input" type="text" id="sample5" name="emailRegistrazione" required maxlength="30" minlength="6">
                            <label class="mdl-textfield__label" for="sample3"> Email </label>
                        </div>
                        <br>
                        <br>
                        <label style="margin-left: 30px;margin-top: 50px"> Seleziona il tipo utente :<br></label>
                        <div class="input-field col s12" style="width: 500px;margin-left: 30px">
                            <br>
                            <select class="browser-default" style="width: 300px"  name="tipoRegistrazione" required>
                                <option value="Amministratore">Amministratore</option>
                                <option value="utenteRegistrato">Utente</option>
                            </select>
                            <br><br>
                        </div>

                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="conferma">
                            Conferma
                        </button>

                        <img style=" margin-left: 150px" src="../Images/alien2.png" >

                        <%  if(request.getParameter("conferma")!= null){
                            BeanRegistrazione.setUsername(request.getParameter("usernameRegistrazione"));
                            BeanRegistrazione.setPassword(request.getParameter("passwordRegistrazione"));
                            BeanRegistrazione.setNome(request.getParameter("nomeRegistrazione"));
                            BeanRegistrazione.setCognome(request.getParameter("cognomeRegistrazione"));
                            BeanRegistrazione.setEmail(request.getParameter("emailRegistrazione"));
                            BeanRegistrazione.setTipoUtente(request.getParameter("tipoRegistrazione"));
                            %>
                        <%if(!BeanRegistrazione.insertNewUtente()){%>
                        <b class="red-text"> Errore inserimento dati! </b>
                       <% }else{%>
                        <jsp:forward page="/Home.jsp"/>
                       <%}
                        }%>
                    </form>
                </div>
                <br><br>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/Include/footerHome.jsp"/>