<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.BeanPosRaggioLato" %>
<%@ page import="Entity.Filamento" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="BeanPosRaggioLato" scope="session" class="Bean.BeanPosRaggioLato"/>
<jsp:setProperty property="*" name="BeanPosRaggioLato"/>


<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 800px;

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
    <form class="demo-card-wide mdl-card mdl-shadow--2dp"  style="margin-left: 10%">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA PER REGIONE </h2>
        </div>
        <!--fine titolo-->
            <%ArrayList<Filamento> val= BeanPosRaggioLato.selectFilamentoFromBean();%>
           <% for(Filamento f:val){%>
                    <p><%=f%></p>
                    <br>
               <% }%>

    </form>
</div>


<jsp:include page="/Include/footerHome.jsp"/>