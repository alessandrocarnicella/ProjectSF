<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanPosRaggioLato" scope="session" class="Bean.BeanPosRaggioLato"/>
<jsp:setProperty property="*" name="BeanPosRaggioLato"/>

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

<script>

    function foo() {
        document.getElementById('div1').style.visibility = 'visible';
        document.getElementById('div2').style.visibility='hidden';

    }

    function foo2() {

        document.getElementById('div1').style.visibility = 'hidden';
        document.getElementById('div2').style.visibility='visible';

    }

</script>



<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%" method="post">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RICERCA FILAMENTO IN REGIONE</h2>
        </div>
        <!--fine titolo-->

        <!--inserimento posizione spaziale-->
        <label style="margin-left: 30px"> <b>Inserisci posizione spaziale :</b></label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="latS" name="latS" step="0.0001" required maxlength="20" required style="width: 100px">
            <label class="mdl-textfield__label" for="latS" > lat </label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
            <input class="mdl-textfield__input" type="number"  id="lonS" name="lonS" step="0.0001" required maxlength="20" required style="width: 100px">
            <label class="mdl-textfield__label" for="lonS" > lon </label>
        </div>
        <br>
        <!--fine inserimento-->

        <!--radiobutton-->
        <table  style="margin-left: 25px;margin-top: 30px" >
            <tr>
                <td>
                    <label class = "mdl-radio mdl-js-radio" for = "option1">
                        <input type = "radio" id = "option1" name = "radio" value="radioid"  class = "mdl-radio__button" onclick="foo();" required>
                        <span class = "mdl-radio__label"><b> Ricerca in regione quadrata</b></span>
                    </label>
                </td>

                <td>
                    <label class = "mdl-radio mdl-js-radio mdl-js-ripple-effect" style="margin-left: 25px" for = "option2">
                        <input type = "radio" id = "option2" name = "radio" value="radionome"  class = "mdl-radio__button"  onclick="foo2();" required>
                        <span class = "mdl-radio__label"><b> Ricerca in regione circolare</b></span>
                    </label>
                </td>
            </tr>
        </table>
        <!--fine radiobutton->
            <!--inserimento dell'lato della regione-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value1" id="div1" style="margin-left: 30px;visibility: hidden">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci il lato della regione: </b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number" min="0.01" step="0.01" id="sample3" name="searchbylato">
            <label class="mdl-textfield__label" for="sample3"></label>
        </div>
        <!--fine inserimento-->
        <br><br>
        <!--inserimento del raggio della regione-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value2" id="div2" style="margin-left: 30px;visibility: hidden">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci il raggio della regione:</b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number" min="0.01" step="0.01" id="sample4" name="searchbyraggio">
            <label class="mdl-textfield__label" for="sample4"></label>
        </div>
        <!--fine inserimento-->
        <br><br>


        <br><br>

        <% if (request.getParameter("searchconfermaregione")!=null) {
                BeanPosRaggioLato.setLonG(Float.valueOf(request.getParameter("lonS")));
                BeanPosRaggioLato.setLatG(Float.valueOf(request.getParameter("latS")));
            if(!Objects.equals(request.getParameter("searchbylato"), "")){
                BeanPosRaggioLato.setLato(Float.valueOf(request.getParameter("searchbylato")));
                BeanPosRaggioLato.setRaggio(Float.valueOf(0));
        %>

        <jsp:forward page="/ResultsPagesJSP/resultFilamentsRegione.jsp"/>

        <%}

        else if (!Objects.equals(request.getParameter("searchbyraggio"), "")){

            BeanPosRaggioLato.setRaggio(Float.valueOf(request.getParameter("searchbyraggio")));
            BeanPosRaggioLato.setLato(Float.valueOf(0));
          %>

        <jsp:forward page="/ResultsPagesJSP/resultFilamentsRegione.jsp"/>

        <%}
        else { %>

        <b style="color: red;margin-left: 20px;margin-top: 10px"> Errore: devi inserire un valore per continuare la ricerca! </b>
        <%}
        }%>

        <!--button-->
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="searchconfermaregione" style="width: 200px;margin-left: 30px;margin-top: 50px">
                Effettua la ricerca
            </button>
            <img style=" margin-left: 140px;width: 135px;height: 135px" src="/Images/img_cerchioQuadrato.png" >
        </div>

    </form>

    <br><br><br><br><br>
</div>



<jsp:include page="/Include/footerHome.jsp"/>


<%}
    else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>