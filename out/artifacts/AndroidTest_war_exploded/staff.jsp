<%@ page language="java" import="java.util.*"
	import="javax.servlet.http.HttpSession" import="enity.Staff"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%
	HttpSession sessio = request.getSession(); //获取session
	Object obj = session.getAttribute("stafflist");
	List<Staff> stafflist = (List<Staff>) session.getAttribute("stafflist");
	String name = (String) session.getAttribute("name");
	int size = stafflist.size();
	System.out.println(name + "  " + size);
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
	<table width="1000" align="center" border="1" cellspacing="0"
		cellpadding="0">
		<tr align="center" valign="center" height="80px">
			<td>员工</td>
			<td>上传打卡记录</td>
			<td><a href="AddStaff.jsp?name=" <%=name%>> 员工录入</td>
		</tr>

		<%
			for (int i = 0; i < size; i++) {
		%>
		<tr align="center"  height="50px">



			<td><a href="/PunchCard/PunchcardrecordServlet?name=<%=stafflist.get(i).name%>">
					<%=stafflist.get(i).name%></td>



			<td  valign="middle">

				<form id="file_form" action="excelServlet"
					enctype="multipart/form-data" method="post">
					<input type="file" name="file" id="file_input" />
					<input type="submit" value="打卡记录上传" id='upFile-btn'  onclick="return commit()">
				</form>

			</td>

			<td  valign="middle">

				<form method="POST" action="deletelstaffServlet">

					<input type="hidden" name="name" value=<%=stafflist.get(i).name%> />
					<input type="submit" value="删除">
				</form>

			</td>


		</tr>

		<%
			}
		%>


	</table>

	<%--<script type="text/javascript">

        function commit(){
            var fileName = document.file_form.file.value;


        }
            $(function() {

			$("#file_form").submit(
				function() {
					//首先验证文件格式
					var fileName = $('#file_input').val();
					if (fileName === '') {
						alert('请选择文件');
						return false;
					}
					var fileType = (fileName.substring(fileName
							.lastIndexOf(".") + 1, fileName.length))
						.toLowerCase();
					if (fileType !== 'xls' && fileType !== 'xlsx') {
						alert('文件格式不正确，excel文件！');
						return false;
					}

					$("#file_form").ajaxSubmit({
						dataType : "json",
						success : function(data, textStatus) {
							if (data['result'] === 'OK') {
								console.log('上传文件成功');
							} else {
								console.log('文件格式错误');
							}
							return false;
						}
					});
					return false;
				});

		});
	</script>--%>
</body>
</html>
