<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<!-- untente non loggato -->
<%BeanLogin.setUtente(false);%>

<!-- header-->
<jsp:include page="Include/header.jsp"/>

<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1200px;height: 550px;margin-bottom: -20px">
    <div class="container" style="height: 10%;width: 10%;margin-left: 70%;margin-bottom: -20px">
        <form method="post" >
            <div class="row">
                <div class="col s12 m6" style="width: 200%;height: 20%; margin-top: 50px">
                    <div class="card-panel">

                        <!-- immagine -->
                        <img src="Images/img_logoLogin.jpg" style="width: 55%;height: 65%;margin-left: 25%"><br><br><br>

                        <!-- prima riga:username -->
                        <label><b>Username</b></label>
                        <input type="text" placeholder="Enter Username" name="username" required maxlength="20" minlength="6">

                        <!-- seconda riga:password -->
                        <label><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" required maxlength="20" minlength="6"><br>

                        <!-- insrimento dati in bean  -->
                        <% if(request.getParameter("verify")!= null){
                                BeanLogin.setUsername(request.getParameter("username"));
                                BeanLogin.setPassword(request.getParameter("password"));

                                //eseguo il metodo verify per controllare se l'utente è già presente nel DB
                                boolean utenteTrovato = BeanLogin.verifyLogin();

                                //se l'utente è presente, allora procedo alla pagina Home.jsp altrimenti rieffettuo il Login
                                if (utenteTrovato == true) { %>
                                    <jsp:forward page="Home.jsp"/>
                        <%      } else{ %>
                                    <b class="red-text"> Errore inserimento dati! </b><br><br>
                        <%      }
                        }%>

                        <!-- bottone login -->
                        <button class="waves-effect waves-light btn" type="submit" name="verify"style="height: 32px;width: 100px;margin-top: 15px">Login</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- footer-->
<jsp:include page="Include/footer.jsp"/>