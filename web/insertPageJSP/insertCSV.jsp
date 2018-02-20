<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 16/02/18
  Time: 10.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="BeanInserimentoCSV" scope="session" class="Bean.BeanInserimentoCSV"/>
<jsp:setProperty property="*" name="BeanInserimentoCSV"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<style>
    .demo-card-wide2.mdl-card {
        width: 600px;
        height: 500px;
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
                    <div class="demo-card-wide mdl-card__title">
                        <h2 class="mdl-card__title-text">Inserisci CSV</h2>
                    </div>


                    <form enctype="multipart/form-data" action="/upload" method="post" >

                        <div class="file_input_div">
                            <div class="file_input">
                                <label class="image_input_button mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-js-ripple-effect mdl-button--colored">
                                    <i class="material-icons">file_upload</i>
                                    <input id="file_input_file" class="none" type="file" name="FileUpload" accept=".csv" />
                                </label>
                            </div>
                            <div id="file_input_text_div" class="mdl-textfield mdl-js-textfield textfield-demo">
                                <input class="file_input_text mdl-textfield__input" type="text" disabled readonly id="file_input_text" />
                                <label class="mdl-textfield__label" for="file_input_text"></label>
                            </div>
                        </div>
                        <br>

                        <button onclick="move()" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored" style="width: 200px;margin-left: 30px;margin-top: 50px" type="submit" name="confermaCSV">
                            Conferma
                        </button>
                        <img style=" margin-left: 150px" src="../Images/alien2.png" >
                    </form>

                    <br><br>
                    <div style=" width:80%; height: 5px;margin-left: 50px;" id="myBar" class="mdl-progress mdl-js-progress"></div>

                </div>
                <br><br>
            </div>
        </div>
    </div>
</div>




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
        function frame() {
            if (width >= 100) {
                clearInterval(id);
            } else {
                width++;
                elem.MaterialProgress.setProgress(width);
                //elem.style.width = 100+'%';
            }
        }
    }
</script>



<jsp:include page="/Include/footerHome.jsp"/>


