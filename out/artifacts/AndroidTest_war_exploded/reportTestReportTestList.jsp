<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2017/11/3
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.* " %>
<%@ page import="enity.ReportTest" %>
<%
    //HttpSession sessio = request.getSession(); //获取session
    List<ReportTest> list = (List<ReportTest>) session.getAttribute("reportTestReportTestList");
    String flag = (String) session.getAttribute("flag");
    switch (flag) {
        case "AGE":
            flag = "年龄";
            break;
        case "SMOKE":
            flag = "吸烟";
            break;
        case "SBP":
            flag = "收缩压";
            break;
        case "CHOL":
            flag = "总胆固醇";
            break;
        case "DIABETES":
            flag = "糖尿病";
            break;
    }
    int size = list.size();
    System.out.println(flag + "  " + size);
%>

<html>
<head>
    <title><%=flag + " "%>的测试结果</title>
</head>
<body>
<table width="800" align="center" border="1" cellspacing="0"
       cellpadding="0">
    <tr align="center" height="50px">
        <td>序号</td>
        <td>性别</td>
        <td><%=flag%>
        </td>
        <td>预期分数</td>
        <td>实际分数</td>
        <td>是否一致</td>

    </tr>

    <%
        for (int i = 0; i < size; i++) {
            ReportTest reportTest = list.get(i);
    %>
    <tr align="center" height="25px">

        <td><%=(i + 1)%>
        </td>
        <td><%=reportTest.grade%>
        </td>
        <td><%=reportTest.getFlag(flag, reportTest.flag)%>
        </td>
        <td><%=reportTest.expectgrade%>
        </td>
        <td><%=reportTest.realitygrade%>
        </td>
        <td><%=reportTest.fit%>
        </td>
    </tr>
    <%

        }
    %>
</table>
</body>
</html>
