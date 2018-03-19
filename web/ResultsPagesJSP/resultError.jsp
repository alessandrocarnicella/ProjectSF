
<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 25/02/2018
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/Include/header.jsp"/>


<!-- definisco i parametri della card -->
<style>
    .demo-card-wide.mdl-card {
        width: 750px;
        height: 480px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height:640px;margin-bottom: -20px">
    <br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px" method="post" action="../login.jsp">
        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-top: 50px"><br>
            <h2 class="mdl-card__title-text" style="margin-left:80px;color: #e00009">Errore, accesso negato!</h2>
        </div>
        <!--fine titolo-->
        <img style=" margin-left: 40px;margin-top: 50px;width: 560px;height: 220px" src="/Images/img_accessoNegato.png" >

        <button class="waves-effect waves-light btn" name="comebacklogin" style="width: 200px;margin-left: 450px;margin-top: 20px" >
            torna al Login
        </button>

        <% if (request.getParameter("comebacklogin") != null){%>
        <jsp:forward page="/login.jsp"/>
        <%}%>
    </form>

</div>

<jsp:include page="/Include/footer.jsp"/>
