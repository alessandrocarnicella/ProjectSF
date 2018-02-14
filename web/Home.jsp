<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 09/02/18
  Time: 12.24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="Include/headerHome.jsp"/>

<!— Wide card with share menu button —>
<style>
    .demo-card-wide.mdl-card {
        width: 512px;
    }
    .demo-card-wide > .mdl-card__title {
        color: #fff;
        height: 176px;
        background: url('Images/img_logoLogin.jpg') center / cover;
    }
    .demo-card-wide > .mdl-card__menu {
        color: #fff;
    }
</style>

<div class="demo-card-wide mdl-card mdl-shadow--2dp">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">Welcome</h2>
    </div>
    <div class="mdl-card__supporting-text">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit.
        Mauris sagittis pellentesque lacus eleifend lacinia...
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Get Started
        </a>
    </div>
    <div class="mdl-card__menu">
        <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
            <i class="material-icons">share</i>
        </button>
    </div>
</div>


<jsp:include page="Include/footerHome.jsp"/>

