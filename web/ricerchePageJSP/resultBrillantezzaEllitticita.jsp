<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 21/02/18
  Time: 16.14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanBrillantezzaEllitticita" scope="session" class="Bean.BeanBrillantezzaEllitticita"/>
<jsp:setProperty property="*" name="BeanBrillantezzaEllitticita"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<style>
    .demo-card-wide2.mdl-card {
        width: 300px;
        height: 300px;
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
        <%for (int i =0 ; i<=20; i++){%>
        <div class="mdl-cell mdl-cell--4-col">
            <br><br><br>
            <div  style=" margin-left: 20%;">
                <div class="demo-card-wide2 mdl-card mdl-shadow--2dp">
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Filamento</h2>
                    </div>
                    <label style="margin-left: 30px"> Inserisci la  </label>
                    <label style="margin-left: 30px"> Inserisci ra  </label>
                    <label style="margin-left: 30px"> Inserisci la  </label>
                    <label style="margin-left: 30px"> Inserisci ra  </label>
                    <label style="margin-left: 30px"> Inserisci la  </label>
                    <label style="margin-left: 30px"> Inserisci ra  </label>
                    <label style="margin-left: 30px"> Inserisci la  </label>
                    <label style="margin-left: 30px"> Inserisci ra  </label>
                    <label style="margin-left: 30px"> Inserisci la  </label>

                    </form>
                </div>
            </div>
        </div>
        <%}%>

    </div>
</div>

<jsp:include page="/Include/footerHome.jsp"/>