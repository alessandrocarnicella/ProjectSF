<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 09/02/18
  Time: 12.24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- header -->
<jsp:include page="Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="Include/menu.jsp"/>

<style>
    .demo-card-wide2.mdl-card {
        width: 400px;
        height: 550px;
        background-color:rgba(255, 255, 255, 0.93);

    }
    .demo-card-wide.mdl-card__title {
        height: 100px;
        background-color:rgb(255, 255, 255);
    }

    .demo-card-wide > .mdl-card__menu {
        color: transparent;
    }
    .demo-card-wide.mdl-card {
        width: 290px;
        height: 230px;
        background-color:rgba(255, 255, 255, 0.93);
    }
</style>

<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1000px;">
    <div class="mdl-grid">
        <div class="mdl-cell mdl-cell--6-col">
            <div  style=" margin-left: 20%;">
                <br><br><br><br><br>
                <!-- Card con dati del Profilo Utente -->
                <div class="demo-card-wide2 mdl-card mdl-shadow--2dp">
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Welcome <%=BeanLogin.getUsername()%></h2>
                    </div>

                    <div class="row" style="margin-top: 35px">
                        <label style="margin-left: 30px;font-size: medium"> <b>User Name:</b> <%=BeanLogin.getUsername()%> </label>
                    </div>
                    <div class="row" style="margin-top: 39px">
                        <label style="margin-left: 30px;font-size: medium"> <b>Nome:</b> <%=BeanLogin.getNome()%> </label>
                    </div>
                    <div class="row" style="margin-top: 30px">
                        <label style="margin-left: 30px;font-size: medium"> <b>Cognome:</b> <%=BeanLogin.getCognome()%> </label>
                    </div>
                    <div class="row" style="margin-top: 30px">
                        <label style="margin-left: 30px;font-size: medium"> <b>Email:</b> <%=BeanLogin.getEmail()%> </label>
                    </div>
                    <div class="row" style="margin-top: 30px">
                        <label style="margin-left: 30px;font-size: medium"> <b>Tipo Utente:</b> <%=BeanLogin.getTipoUtente()%> </label>
                    </div>
                </div>
            </div>
        </div>

        <div class="mdl-cell mdl-cell--6-col">
            <div class="mdl-grid">
                <!-- Card con img -->
                <div class="mdl-cell mdl-cell--4-col" style="margin-right: 120px">
                    <br><br><br><br><br>
                    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                        <img style="margin-left:10px;margin-top:10px;width: 270px;height: 210px;" src="Images/img_logoLogin.jpg" >
                    </div>
                </div>
                <!--Card con img!-->
                <div class="mdl-cell mdl-cell--4-col">
                    <br><br><br><br><br>
                    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                        <img style="width: 270px;height: 210px" src="Images/img_esa.png" >
                    </div>
                </div>
            </div>

            <div class="mdl-grid">
                <!-- Card con img -->
                <div class="mdl-cell mdl-cell--4-col" style="margin-right: 120px">
                    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                        <img style="margin-left:10px;margin-top:10px;width: 270px;height: 210px" src="Images/img_nasa.png" >
                    </div>
                    <br><br>
                </div>
                <!-- Card con img -->
                <div class="mdl-cell mdl-cell--4-col">
                    <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                        <img style="margin-left:10px;margin-top:10px;width: 270px;height: 210px;" src="Images/img_tvg.png" >
                    </div>
                    <br><br>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- foother -->
<jsp:include page="Include/footerHome.jsp"/>

