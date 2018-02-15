<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 15/02/2018
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>

<!-- Wide card with share menu button -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
        height: 600px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }

</style>

<br><br><br><br><br><br><br>

<div class="demo-card-wide mdl-card mdl-shadow--2dp">
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text">INSERISCI UN NUOVO STRUMENTO</h2>
        <!-- Select with floating label and arrow -->
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height">
            <input type="text" value="" class="mdl-textfield__input" id="sample5" readonly>
            <input type="hidden" value="" name="sample5">
            <i class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
            <label for="sample5" class="mdl-textfield__label">Country</label>
            <ul for="sample5" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                <li class="mdl-menu__item" data-val="BY">Belarus</li>
                <li class="mdl-menu__item" data-val="BR">Brazil</li>
                <li class="mdl-menu__item" data-val="ES">Estonia</li>
                <li class="mdl-menu__item" data-val="FI">Finland</li>
                <li class="mdl-menu__item" data-val="FR">France</li>
                <li class="mdl-menu__item" data-val="DE">Germany</li>
                <li class="mdl-menu__item" data-val="PL">Poland</li>
                <li class="mdl-menu__item" data-val="RU">Russia</li>
            </ul>
        </div>
    </div>

</div>


<jsp:include page="/Include/footerHome.jsp"/>

