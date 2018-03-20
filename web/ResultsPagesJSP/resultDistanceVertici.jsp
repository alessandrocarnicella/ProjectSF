<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: alessandro
  Date: 21/02/18
  Time: 16.14
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="BeanLogin" scope="session" class="Bean.BeanLogin"/>
<jsp:setProperty property="*" name="BeanLogin"/>

<%if (BeanLogin.getUtente()){%>
<jsp:useBean id="BeanScheletro" scope="session" class="Bean.BeanScheletro"/>
<jsp:setProperty property="*" name="BeanScheletro"/>

<jsp:include page="/Include/headerHome.jsp"/>
<jsp:include page="/Include/menu.jsp"/>


<style>
    .demo-card-wide.mdl-card {
        width: 960px;
        height: 300px;
        background-color:rgba(255, 255, 255, 0.93);
    }
    .demo-card-wide > .mdl-card__title {
        color: #0c2121;
        height: 100px;
    }
</style>
<!--fine definizione parametri-->



<div style="background: url(/Images/img_sfondo.jpg);background-size: 1300px 1100px;height: 530px">
    <br><br><br><br><br>
    <form class="demo-card-wide mdl-card mdl-shadow--2dp" style="margin-left: 10%;margin-bottom: -10px;margin-top: 50px" method="post">
        <!--titolo della card-->
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text" style="margin-left: 20px;color: #1441e0"> RISULTATI RICERCA DISTANZA VERTICI'</h2>
        </div>
        <!--fine titolo-->
        <%ArrayList<String> result = BeanScheletro.resultDistanceVertici();
            if (result!=null){
                System.out.println(result);%>

        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left: 25px">
            <thead>
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <th class="mdl-data-table__cell--non-numeric">ID Filamento</th>
                <th class="mdl-data-table__cell--non-numeric">ID Segmento</th>
                <th class="mdl-data-table__cell--non-numeric">N prog</th>
                <th class="mdl-data-table__cell--non-numeric">Lat vertice1</th>
                <th class="mdl-data-table__cell--non-numeric">Lon vertice2</th>
                <th class="mdl-data-table__cell--non-numeric">Lat punto</th>
                <th class="mdl-data-table__cell--non-numeric">Lon punto</th>
                <th class="mdl-data-table__cell--non-numeric">Distanza</th>
            </tr>
            </thead>
            <tbody>

            <div class="page-content" style="margin-top: 10px;margin-left: 25px">

                <tr>
                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(0)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(1)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(2)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(3)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(4)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(5)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(6)%></td>

                    <%  double lonv = Double.valueOf(result.get(3));
                        double latv = Double.valueOf(result.get(4));
                        double lonp = Double.valueOf(result.get(5));
                        double latp = Double.valueOf(result.get(6));
                        double distance = Math.sqrt(((lonv-lonp)*(lonv-lonp)+(latv-latp)*(latv-latp)));
                    %>

                    <td class="mdl-data-table__cell--non-numeric"><%=distance%></td>
                </tr>
                <tr>
                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(7)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(8)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(9)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(10)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(11)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(12)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(13)%></td>
                    <%  double lonv1 = Double.valueOf(result.get(10));
                        double latv1 = Double.valueOf(result.get(11));
                        double lonp1 = Double.valueOf(result.get(12));
                        double latp1 = Double.valueOf(result.get(13));
                        double distance1 = Math.sqrt(((lonv1-lonp1)*(lonv1-lonp1)+(latv1-latp1)*(latv1-latp1)));
                    %>
                    <td class="mdl-data-table__cell--non-numeric"><%=distance1%></td>
                </tr>
            </div>
            </tbody>
        </table>

        <% if(result.size()>14){%>
        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left: 25px">
            <thead>
            <tr>
                <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                <th class="mdl-data-table__cell--non-numeric">ID Filamento</th>
                <th class="mdl-data-table__cell--non-numeric">ID Segmento</th>
                <th class="mdl-data-table__cell--non-numeric">N prog</th>
                <th class="mdl-data-table__cell--non-numeric">Lat vertice1</th>
                <th class="mdl-data-table__cell--non-numeric">Lon vertice2</th>
                <th class="mdl-data-table__cell--non-numeric">Lat punto</th>
                <th class="mdl-data-table__cell--non-numeric">Lon punto</th>
                <th class="mdl-data-table__cell--non-numeric">Distanza</th>
            </tr>
            </thead>
            <tbody>

            <div class="page-content" style="margin-top: 10px;margin-left: 25px">

                <tr>
                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(14)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(15)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(16)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(17)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(18)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(19)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(20)%></td>

                    <%  double lonv3 = Double.valueOf(result.get(17));
                        double latv3 = Double.valueOf(result.get(18));
                        double lonp3 = Double.valueOf(result.get(19));
                        double latp3 = Double.valueOf(result.get(20));
                        double distance3 = Math.sqrt(((lonv3-lonp3)*(lonv3-lonp3)+(latv3-latp3)*(latv3-latp3)));
                    %>

                    <td class="mdl-data-table__cell--non-numeric"><%=distance3%></td>
                </tr>
                <tr>
                    <!-- class "mdl-data-table__cell--non-numeric", align values to left -->
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(21)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(22)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(23)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(24)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(25)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(26)%></td>
                    <td class="mdl-data-table__cell--non-numeric"><%=result.get(27)%></td>
                    <%  double lonv2 = Double.valueOf(result.get(24));
                        double latv2 = Double.valueOf(result.get(25));
                        double lonp2 = Double.valueOf(result.get(26));
                        double latp2 = Double.valueOf(result.get(27));
                        double distance2 = Math.sqrt(((lonv2-lonp2)*(lonv2-lonp2)+(latv2-latp2)*(latv2-latp2)));
                    %>
                    <td class="mdl-data-table__cell--non-numeric"><%=distance2%></td>
                </tr>
            </div>
            </tbody>
        </table>
        <%}%>


        <%} else {%>
        <br>
        <label style="margin-left: 30px;margin-top: 30px; color: #ff6244"> <b> NON ESISTONO RISULTATI PER QUESTA SPECIFICA RICERCA! </b></label><br><br><br>
        <%}%>
    </form>
</div>

<jsp:include page="/Include/footerHome.jsp"/>
<%}
else {%>
<jsp:forward page="/ResultsPagesJSP/resultError.jsp"/>
<%}%>