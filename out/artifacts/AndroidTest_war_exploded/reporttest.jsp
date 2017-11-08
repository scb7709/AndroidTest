<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>报告测试</title>
    <%--   <link href="reporttest.css" rel="stylesheet">
       <script src="reporttest.js" type="text/javascript"></script>--%>
</head>
<body>
<center>

    <table border="1" width=500px cellspacing="0"
           cellpadding="0" height=500px>
        <tr align="center">
            <td style="text-align:center">
                <form method="POST" name="frmLogin" action="AndroidTestServlet" >
                    <input type="submit" value=" BMI" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="BMI"  >
                </form>
            </td>

        </tr>
        <tr align="center">
            <td style="text-align:center">
                <form method="POST" name="frmLogin" action="ReportTestServlet">
                    <input type="submit"  value="年龄" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="AGE"  >
                </form>
            </td>

        </tr>
        <tr align="center">
            <td>
                <form method="POST" name="frmLogin" action="ReportTestServlet">
                    <input type="submit"  value="收缩压" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="SBP"  >
                </form>
            </td>

        </tr>
        <tr align="center">
            <td>
                <form method="POST" name="frmLogin" action="ReportTestServlet">
                    <input type="submit"  value="吸烟" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="SMOKE"  >
                </form>
            </td>

        </tr>
        <tr align="center">
            <td>
                <form method="POST" name="frmLogin" action="ReportTestServlet">
                    <input type="submit"  value="糖尿病" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="DIABETES"  >
                </form>
            </td>

        </tr>
        <tr align="center">
            <td>
                <form method="POST" name="frmLogin" action="ReportTestServlet">
                    <input type="submit"  value="总胆固醇" style="width:200px ; height:50px ">
                    <input type="hidden" name="flag" value="CHOL"  >
                </form>
            </td>

        </tr>
    </table>

</center>


</body>
</html>