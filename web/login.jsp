<%@ page import="Entity.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 07/02/2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="Include/header.jsp"/>
<jsp:useBean id="BeanUtente" scope="session" class="Bean.BeanUtente"/>
<jsp:setProperty property="*" name="BeanUtente"/>


<div class="container" style="height: 10%;width: 10%;margin-left: 70%">
    <form>
        <div class="row">
            <div class="col s12 m6" style="width: 200%;height: 20%; margin-top: 10%">
                <div class="card-panel">
                    <!--immagine-->
                    <img src="Images/img_logoLogin.jpg" style="width: 55%;height: 65%;margin-left: 25%" alt="Avatar" class="avatar">
                    <br>
                    <br>
                    <br>
                    <!--prima riga:username-->
                    <label><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="username" required maxlength="20" minlength="6">
                    <!--seconda riga:password-->
                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required maxlength="20" minlength="6">
                    <br>
                    <%
                        if(request.getParameter("verify")!= null){
                            BeanUtente.setUsername(request.getParameter("username"));
                            BeanUtente.setPassword(request.getParameter("password"));
                            //eseguo il metodo verify per controllare se l'utente è già presente nel DB
                            boolean utenteTrovato = BeanUtente.verifyLogin();
                            //se l'utente è presente, allora procedo alla pagina Home.jsp altrimenti rieffettuo il Login
                            if (utenteTrovato == true) { %>
                    <jsp:forward page="Home.jsp"/>
                    <% } else{ %>

                    <b class="red-text"> Errore inserimento dati! </b>
                    <br>
                    <br>

                    <% }
                    } %>
                    <!--bottone login-->
                    <button type="submit" name="verify" style="background-color: #4CAF50;height: 10%;width: 30%">Login</button>
                </div>
            </div>
        </div>
    </form>

</div>

<jsp:include page="Include/footer.jsp"/>