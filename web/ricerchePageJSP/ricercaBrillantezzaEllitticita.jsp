<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 21/02/18
  Time: 12.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanBrillantezzaEllitticita" scope="session" class="Bean.BeanBrillantezzaEllitticita"/>
<jsp:setProperty property="*" name="BeanBrillantezzaEllitticita"/>

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
                        <h2 class="mdl-card__title-text">Ricerca Filamento per contrasto ed ellitticita</h2>
                    </div>


                    <form >
                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci la Percentuale di Brillantezza :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
                            <input class="mdl-textfield__input" type="number" min="0" max="100" id="sample1" name="nomeRegistrazione" required maxlength="20" >
                            <label class="mdl-textfield__label" for="sample1" >  </label>
                        </div>
                        <label style="margin-left: 30px;margin-top: 50px">%</label>
                        <br>

                        <label style="margin-left: 30px;margin-top: 50px"> Inserisci range Ellitticita :</label>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
                            <input class="mdl-textfield__input" type="number" min="1" max="9" id="min" name="min" required maxlength="20" required>
                            <label class="mdl-textfield__label" for="min" > min </label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"   style="margin-left: 30px; width: 50px" >
                            <input class="mdl-textfield__input" type="number" min="1" max="9" id="max" name="max" required maxlength="20" required>
                            <label class="mdl-textfield__label" for="max" > max </label>
                        </div>
                        <br>

                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="conferma2">
                            Conferma
                        </button>

                        <img style=" margin-left: 150px" src="../Images/alien2.png" >

                        <%  if(request.getParameter("conferma2")!= null){
                                float min = Float.valueOf(request.getParameter("min"));
                                float max = Float.valueOf(request.getParameter("max"));
                                if(BeanBrillantezzaEllitticita.ControlloMinMax(min,max)){
                                    BeanBrillantezzaEllitticita.setMinEllitticita(Float.valueOf(request.getParameter("min")));
                                    BeanBrillantezzaEllitticita.setMaxEllitticita(Float.valueOf(request.getParameter("max")));
                                    BeanBrillantezzaEllitticita.setBrillantezza(Float.valueOf(request.getParameter("nomeRegistrazione")));
                                    BeanBrillantezzaEllitticita.electFilamentoFromBean();
                        %>

                                    <jsp:forward page="../ricerchePageJSP/resultBrillantezzaEllitticita.jsp"/><%
                                } else{%>
                                    <br>
                                    <b class="red-text"> Errore inserimento max e min! </b><%
                                }
                            }%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/Include/footerHome.jsp"/>
