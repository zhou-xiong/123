<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/jquery/jquery-2.1.1.min.js"></script>
<link href="<%=request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<script type="text/javascript">
//添加
	function add(){
		var sid=prompt("输入编号");
		var sname=prompt("输入姓名");
		var sex=prompt("输入性别");
		var hobby=prompt("输入爱好");
		$.ajax({
			url:"add",
			type:"post",
			data:{"sid":sid,"sname":sname,"sex":sex,"hobby":hobby},
			dataType:"text",
			success:function(q){
				if(q=='ok'){
					location.href="list";
				}
			}
		})
	}
		//删除
		function remove(sid){
			location.href="remove?sid="+sid;
		}
		//修改
		$(function(){
			$("#form").hide();
		})
		function update(sid){
			$("#form").show();
			$.ajax({
				url:"sel",
				data:{"sid":sid},
				type:"post",
				dataType:"json",
				success:function(q){
					$("#sid").val(q.sid);
					$("#sname").val(q.sname);
					$("#sex").val(q.sex);
					$("#hobby").val(q.hobby);
				}
			})
		}
</script>
<body>
	<table class="table">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>爱好</td>
			<td>操作<button onclick="add()">添加</button></td>
		</tr>
		<c:forEach items="${list }" var="a">
			<tr>
				<td>${a.sid }</td>
				<td>${a.sname }</td>
				<td>${a.sex }</td>
				<td>${a.hobby }</td>
				<td>
					<button onclick="update(${a.sid})">修改</button>
					<button onclick="remove(${a.sid})">删除</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form id="form" action="update" method="post">
		编号<input name="sid" id="sid"><br>
		姓名<input name="sname" id="sname"><br>
		性别<input name="sex" id="sex"><br>
		爱好<input name="hobby" id="hobby"><br>
		<input type="submit" value="修改">
	</form>
</body>
</html>