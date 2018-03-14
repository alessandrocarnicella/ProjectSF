<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 13/03/18
  Time: 17.56
  To change this template use File | Settings | File Templates.
--%>
<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 650px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 80px;
    }
</style>
<!--fine definizione parametri-->

<jsp:include page="/Include/header.jsp"/>


<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1100px;">
    <form class="demo-card-wide mdl-card mdl-shadow--2dp"  style="margin-left: 10%" method="post" action="../login.jsp">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px"></div>
        <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #e00009">Errore, accesso negato!</h2>
        <div class="row">
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" name="aaa" style="width: 200px;margin-left: 30px;margin-top: 40px" >
                torna al Login
            </button>
            <img style=" margin-left: 80px" src="../Images/img_checkedInsert.png" >
        </div>

        <% if (request.getParameter("aaa") != null){%>
        <jsp:forward page="../login.jsp"/>
        <%}%>
    </form>

</div>
<jsp:include page="/Include/footer.jsp"/>