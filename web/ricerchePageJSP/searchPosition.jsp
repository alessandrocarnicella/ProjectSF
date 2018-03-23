<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- Controllo su utente loggato -->
<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height:500px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 500px;height: 740px"><br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">RICERCA POSIZIONE STELLE RISPETTO ALLA SPINA DORSALE </h2>
        </div>

        <form method="post">
            <label style="margin-left: 30px;margin-top: 50px"><b> Inserisci l'identificativo del filamento :</b></label>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 200px" >
                <input class="mdl-textfield__input" type="number" id="sample1" name="idfilamento" required maxlength="20" >
                <label class="mdl-textfield__label" for="sample1" >id filamento</label>
            </div>
            <br>

            <!--radiobutton-->
            <table  style="margin-left: 25px;margin-top: 30px" >
                <tr>
                    <td>
                        <label class = "mdl-radio mdl-js-radio" for = "option1">
                            <input type = "radio" id = "option1" name = "radio" value="orddistanza" class = "mdl-radio__button" onclick="foo();" required>
                            <span class = "mdl-radio__label"><b> Ordina per distanza crescente</b></span>
                        </label>
                    </td>

                    <td>
                        <label class = "mdl-radio mdl-js-radio mdl-js-ripple-effect" style="margin-left: 25px" for = "option2">
                            <input type = "radio" id = "option2" name = "radio" value="ordflusso" class = "mdl-radio__button"  onclick="foo2();" required>
                            <span class = "mdl-radio__label"><b> Ordina per flusso screscente</b></span>
                        </label>
                    </td>
                </tr>
            </table>

            <!--button-->
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="confermaidfilamento">
                Conferma
            </button>
            <img style=" margin-left: 130px;margin-top: 60px;width: 150px;height: 130px" src="/Images/img_distanzaSpinaDorsale.png" >

            <%  if(request.getParameter("confermaidfilamento")!= null) {
                    BeanFilamento.setIdFilamento(Integer.valueOf(request.getParameter("idfilamento")));
                    BeanFilamento.setOrdinamento(String.valueOf(request.getParameter("radio")));%>
                    <jsp:forward page="/ResultsPagesJSP/resultPosition.jsp"/>
            <%  }%>
        </form>
    </div>
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