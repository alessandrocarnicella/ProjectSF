<%--
  Created by IntelliJ IDEA.
  User: Manuel
  Date: 07/02/2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="Include/header.jsp"/>


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
                    <input type="text" placeholder="Enter Username" name="username" required>
                    <!--seconda riga:password-->
                    <label><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" required>
                    <br>
                    <br>
                    <!--bottone login-->
                    <button type="submit" style="background-color: #4CAF50;height: 10%;width: 30%">Login</button>
                </div>
            </div>
        </div>
    </form>

</div>


<jsp:include page="Include/footer.jsp"/>