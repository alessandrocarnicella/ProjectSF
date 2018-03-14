<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 16/02/18
  Time: 10.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()&&(BeanLogin.getTipoUtente().equals("Amministratore"))){%>

<jsp:useBean id="BeanInserimentoCSV" scope="session" class="Bean.BeanInserimentoCSV"/>
<jsp:setProperty property="*" name="BeanInserimentoCSV"/>
<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide2.mdl-card {
        width: 600px;
        height: 400px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
    .file_input_div {
        margin: auto;
        width: 250px;
        height: 40px;
    }

    .file_input {
        float: left;
    }

    #file_input_text_div {
        width: 200px;
        margin-top: -8px;
        margin-left: 5px;
    }

    .none {
        display: none;
    }


    #myProgress {
        width: 100%;
        background-color: #ddd;
    }

    #myBar {
        width: 1%;
        height: 30px;
        background-color: #4CAF50;
    }
</style>

<div style="background: url(/Images/154876-OVJJF1-95.jpg);background-size: 1300px 1000px;">
    <div class="mdl-grid">
        <div class="mdl-cell mdl-cell--6-col">
            <div  style=" margin-left: 20%;">
                <br><br><br><br><br>
                <div class="demo-card-wide2 mdl-card mdl-shadow--2dp">
                    <!-- Titolo -->
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Inserisci CSV</h2>
                    </div>
                    <!-- inserimento CSV -->
                    <form enctype="multipart/form-data" action="/upload" method="post" >
                        <div class="file_input_div" style="margin-right:330px;margin-top:20px">
                            <div class="file_input">
                                <label class="image_input_button mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-js-ripple-effect mdl-button--colored">
                                    <i class="material-icons">file_upload</i>
                                    <input id="file_input_file" class="none" type="file" name="FileUpload" accept=".csv" />
                                </label>
                            </div>
                            <div id="file_input_text_div" class="mdl-textfield mdl-js-textfield textfield-demo">
                                <input class="file_input_text mdl-textfield__input" type="text" name="file_input_text" disabled readonly id="file_input_text" />
                                <label class="mdl-textfield__label" for="file_input_text"></label>
                            </div>
                        </div>
                        <br>
                        <!-- button conferma inserimento CSV -->
                        <button onclick="move();foo3()" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="confermaCSV">
                            Conferma
                        </button>
                        <img style=" margin-left: 150px" src="../Images/img_csv.png" >
                        <br><br>
                        <label id="caricamento" style="visibility: hidden;margin-left: 30px">Caricamento in corso...</label>
                    </form>
                    <br><br>
                    <div style=" width:80%; height: 5px;margin-left: 50px;" id="myBar" class="mdl-progress mdl-js-progress"></div>
                </div>
                <br><br>
            </div>
        </div>
    </div>
</div>

<!-- script JS -->
<script>

    var fileInputTextDiv = document.getElementById('file_input_text_div');
    var fileInput = document.getElementById('file_input_file');
    var fileInputText = document.getElementById('file_input_text');

    fileInput.addEventListener('change', changeInputText);
    fileInput.addEventListener('change', changeState);

    function changeInputText() {
        var str = fileInput.value;
        var i;
        if (str.lastIndexOf('\\')) {
            i = str.lastIndexOf('\\') + 1;
        } else if (str.lastIndexOf('/')) {
            i = str.lastIndexOf('/') + 1;
        }
        fileInputText.value = str.slice(i, str.length);
    }

    function changeState() {
        if (fileInputText.value.length != 0) {
            if (!fileInputTextDiv.classList.contains("is-focused")) {
                fileInputTextDiv.classList.add('is-focused');
            }
        } else {
            if (fileInputTextDiv.classList.contains("is-focused")) {
                fileInputTextDiv.classList.remove('is-focused');
            }
        }
    }


    function move() {
        var elem = document.getElementById("myBar");
        var width = 1;
        var id = setInterval(frame, 100);

        var input = document.getElementById("file_input_text");
        var speed = 0;

        if (input.value === 'stelle_Herschel.csv'){
            speed = 0.3;
        }
        if (input.value === 'contorni_filamenti_Herschel.csv'){
            speed = 0.05;
        }
        if (input.value ===  'contorni_filamenti_Spitzer.csv'){
            speed = 0.05;
        }
        if (input.value === 'filamenti_Herschel.csv'){
            speed = 1.6;
        }
        if (input.value === 'filamenti_Spitzer.csv'){
            speed = 1.6;
        }
        if (input.value ===  'scheletro_filamenti_Herschel.csv'){
            speed = 0.02;
        }
        if (input.value === 'scheletro_filamenti_Spitzer.csv'){
            speed = 0.01;
        }

        function frame() {



            if (width >= 95) {
                clearInterval(id);
            } else {
                width=width+speed;
                elem.MaterialProgress.setProgress(width);
                //elem.style.width = 100+'%';
            }
        }
    }

    function foo3() {
        document.getElementById('caricamento').style.visibility = 'visible';
    }
</script>

<!-- footer -->
<jsp:include page="/Include/footerHome.jsp"/>


<%}
else {%>
        <jsp:forward page="../ResultsPagesJSP/resultError.jsp"/>
<%}%>

