<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 21/02/18
  Time: 12.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanInserimentoCSV" scope="session" class="Bean.BeanInserimentoCSV"/>
<jsp:setProperty property="*" name="BeanInserimentoCSV"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<style>
    .demo-card-wide2.mdl-card {
        width:1000px;
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
                            <input class="mdl-textfield__input" type="number" min="0" id="sample1" name="nomeRegistrazione" required maxlength="20" >
                            <label class="mdl-textfield__label" for="sample1" >  </label>
                        </div>
                        <label style="margin-left: 30px;margin-top: 50px">%</label>
                        <br>

                        <div class="row">
                            <p>on one hand</p>
                            <div class="small-6 medium-2 columns">
                                <input type="number" id="sliderOutput3">
                            </div>
                            <div class="small-6 medium-2 columns">
                                <input type="number" id="sliderOutput4">
                            </div>
                            <div class="small-12 medium-8 columns">
                                <div class="slider" data-slider data-initial-start="20000" data-start="0" data-initial-end="75000" data-end="100000" data-step="1000">
                                    <span class="slider-handle" data-slider-handle role="slider" tabindex="1" aria-controls="sliderOutput3"></span>
                                    <span class="slider-fill" data-slider-fill></span>
                                    <span class="slider-handle" data-slider-handle role="slider" tabindex="1" aria-controls="sliderOutput4"></span>
                                </div>
                            </div>
                        </div>

                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="conferma2">
                            Conferma
                        </button>

                        <img style=" margin-left: 150px" src="../Images/alien2.png" >

                        <%  if(request.getParameter("conferma2")!= null){
                        %>
                        <%if(true){%>
                        <b class="red-text"> Errore inserimento dati! </b>
                        <% }else{%>
                        <jsp:forward page="/Home.jsp"/>
                        <%}
                        }%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).foundation();
</script>

<jsp:include page="/Include/footerHome.jsp"/>
