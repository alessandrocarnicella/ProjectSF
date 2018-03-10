<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 07/03/18
  Time: 10.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanFilamento" scope="session" class="Bean.BeanFilamento"/>
<jsp:setProperty property="*" name="BeanFilamento"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<style>
    .demo-card-wide2.mdl-card {
        width: 600px;
        height: 500px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }

    .ex {
        padding: 2rem;
        border: 1px solid grey;
    }
    .separator {
        border: 1px solid grey;
        margin: 1rem 0;
    }
    p {
        display: block;
        width: 100%;
        text-align: center;
        font-size: .8rem;
        text-transform: uppercase;
        color: gray;
        text-decoration: underline;
        padding: 1rem 0;
    }

</style>



<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1000px;">
    <div class="mdl-grid">
        <div class="mdl-cell mdl-cell--6-col">
            <div  style=" margin-left: 20%;">
                <br><br><br><br><br>
                <div class="demo-card-wide2 mdl-card mdl-shadow--2dp">
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Ricerca posizione stelle ripsetto alla spina dorsale</h2>
                    </div>


                    <form >


                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci l'identificativo del filamento :</label>
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
                                        <span class = "mdl-radio__label"> Ordina per distanza crescente</span>
                                    </label>
                                </td>

                                <td>
                                    <label class = "mdl-radio mdl-js-radio mdl-js-ripple-effect" style="margin-left: 25px" for = "option2">
                                        <input type = "radio" id = "option2" name = "radio" value="ordflusso" class = "mdl-radio__button"  onclick="foo2();" required>
                                        <span class = "mdl-radio__label"> Ordina per flusso screscente</span>
                                    </label>
                                </td>
                            </tr>
                        </table>
                        <!--fine radiobutton-->
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="confermaidfilamento">
                            Conferma
                        </button>

                        <img style=" margin-left: 150px" src="../Images/img_alien2.png" >

                        <%  if(request.getParameter("confermaidfilamento")!= null) {
                            BeanFilamento.setIdFilamento(Integer.valueOf(request.getParameter("idfilamento")));
                             BeanFilamento.setOrdinamento(String.valueOf(request.getParameter("radio")));
                        %>

                        <jsp:forward page="../ResultsPagesJSP/resultPosition.jsp"/>
                        <%}%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/Include/footerHome.jsp"/>
