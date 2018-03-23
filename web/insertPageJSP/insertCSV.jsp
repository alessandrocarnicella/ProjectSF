<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- controllo su utente loggato e tipo di utente -->
<%if (BeanLogin.getUtente()&&(BeanLogin.getTipoUtente().equals("Amministratore"))){%>

<jsp:useBean id="BeanInserimentoCSV" scope="session" class="Bean.BeanInserimentoCSV"/>
<jsp:setProperty property="*" name="BeanInserimentoCSV"/>

<!-- header -->
<jsp:include page="/Include/headerHome.jsp"/>
<!-- menu -->
<jsp:include page="/Include/menu.jsp"/>

<!-- CSS style -->
<style>
    .demo-card-wide.mdl-card {
        width: 600px;
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


<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 630px">
    <br><br><br><br><br>
    <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-top: 50px">

        <!--titolo della card-->
        <div class="mdl-card__title" style="margin-bottom: 50px">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0">INSERISCI CSV</h2>
        </div>

        <!-- inserimento CSV -->
        <form enctype="multipart/form-data" action="/upload" method="post" >
            <label style="margin-left: 30px"> <b>Il formato accettato è: tipo_Nomefile</b></label><br>
            <label style="margin-left: 30px"> <b>(ex. filamenti_Spitzer, stelle_Herschel ecc ) </b></label><br>
            <div class="file_input_div" style="margin-right:330px;margin-top:20px">
                <div class="file_input">
                    <label class="image_input_button mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-js-ripple-effect mdl-button--colored" onclick="foo4()">
                        <i class="material-icons">file_upload</i>
                        <input id="file_input_file" class="none" type="file" name="FileUpload" accept=".csv" />
                    </label>
                </div>
                <div id="file_input_text_div" class="mdl-textfield mdl-js-textfield textfield-demo">
                    <input class="file_input_text mdl-textfield__input" type="text" name="file_input_text" disabled readonly id="file_input_text" />
                    <label class="mdl-textfield__label" for="file_input_text"></label>
                </div>
            </div><br>

            <!-- button conferma inserimento CSV -->
            <button onclick="move();foo3()" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px"  type="submit" name="confermaCSV">
                Conferma
            </button>

            <!-- immagine inserimenti csv-->
            <img style=" margin-left: 150px;width: 90px;height: 100px" src="../Images/img_csv.png" >
            <br><br>
            <label id="caricamento" style="visibility: hidden;margin-left: 30px">Caricamento in corso...</label>
        </form><br><br>

        <!-- barra di caricamento -->
        <div style=" width:80%; height: 5px;margin-left: 50px;" id="myBar" class="mdl-progress mdl-js-progress"></div>
    </div><br><br>
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
            speed = 0.06;
        }
        if (input.value === 'scheletro_filamenti_Spitzer.csv'){
            speed = 0.05;
        }

        function frame() {
            if (width >= 95) {
                clearInterval(id);
            } else {
                width = width + speed;
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
<%
}
else {%>

    <!-- Pagina di errore per utente non loggato -->
    <jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%
}%>

