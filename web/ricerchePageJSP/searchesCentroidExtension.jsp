<%@ page import="com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 21/02/2018
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 650px;
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
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RICERCA CENTROIDE, ESTENSIONE E N° SEGMENTI PER FILAMENTO </h2>
        </div>
        <!--fine titolo-->

        <!--radiobutton-->
        <table  style="margin-left: 25px;margin-top: 30px" >
            <tr>
                <td>
                    <label class = "mdl-radio mdl-js-radio" for = "option1">
                        <input type = "radio" id = "option1" name = "radio" value="radioid" class = "mdl-radio__button" onclick="foo();" required>
                        <span class = "mdl-radio__label"> Ricerca per id filamento</span>
                    </label>
                </td>

                <td>
                    <label class = "mdl-radio mdl-js-radio mdl-js-ripple-effect" style="margin-left: 25px" for = "option2">
                        <input type = "radio" id = "option2" name = "radio" value="radionome" class = "mdl-radio__button"  onclick="foo2();" required>
                        <span class = "mdl-radio__label"> Ricerca per nome filamento</span>
                    </label>
                </td>
            </tr>
        </table>
        <!--fine radiobutton->
            <!--inserimento dell'id del filamento-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value1" id="div1" style="margin-left: 30px;visibility: hidden">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci id del filamento</b></label>
            <br><br>
            <input class="mdl-textfield__input" type="number"  id="sample3" name="searchbyidfil">
            <label class="mdl-textfield__label" for="sample3"></label>
        </div>
        <!--fine inserimento-->
        <br><br>
        <!--inserimento del nome del filamento-->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" value="value2" id="div2" style="margin-left: 30px;visibility: hidden">
            <label style="margin-left: 30px;margin-top: 30px"> <b>Inserisci nome del filamento:</b></label>
            <br><br>
            <input class="mdl-textfield__input" type="text"  id="sample4" name="searchbynamefil">
            <label class="mdl-textfield__label" for="sample4"></label>
        </div>
        <!--fine inserimento-->

        <br><br>
        <!--button-->
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="searchconfermacentroidextension" style="width: 200px;margin-left: 30px;margin-top: 50px">
                Effettua la ricerca
            </button>
            <img style=" margin-left: 150px" src="../Images/alien2.png" >
        </div>


        <% if (request.getParameter("searchconfermacentroidextension")!=null) {

            if(!Objects.equals(request.getParameter("searchbynamefil"), "")){
                BeanFilamento.setNome(request.getParameter("searchbynamefil"));
                BeanFilamento.setIdFilamento(-1);
                // l'ho impostato settato a -1 in modo da non trovare mai un id corrispondente
                //da intendere come un null
                System.out.println(BeanFilamento.getNome()); %>

        <jsp:forward page="/ResultsPagesJSP/resultCentroidExtension.jsp"/>

        <%}

            else if (!Objects.equals(request.getParameter("searchbyidfil"), "")){

                BeanFilamento.setIdFilamento(Integer.valueOf(request.getParameter("searchbyidfil")));
                BeanFilamento.setNome(null);
                System.out.println(BeanFilamento.getIdFilamento());%>

        <jsp:forward page="/ResultsPagesJSP/resultCentroidExtension.jsp"/>

        <%}
        else { %>

        <b style="color: red;margin-left: 20px;margin-top: 10px"> Errore: devi inserire un valore per continuare la ricerca! </b>
        <%}
        }%>

    </form>

    <br><br><br><br><br>
</div>



<jsp:include page="/Include/footerHome.jsp"/>