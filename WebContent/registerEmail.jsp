<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String message = "";
		String msg =(String) request.getAttribute("msg");
		if(msg != null){
			message = msg;
		}
	%>
	<div style="width: 400px; height: 700px;margin: 0 auto">
        <h3>注册新账号</h3>
        <p><strong>名字</strong></p>
        <form method="post" action="/Training/RegisterEmailServlet">
            <input type="text"   value="真实姓名和邮箱昵称" onfocus="if(this.value == '真实姓名和邮箱昵称'){
            this.value = ''}" onblur="if (this.value==''){this.value='真实姓名和邮箱昵称'}" name="name" style="height: 25px;width: 250px;">
            <br />
            <input  type="radio" name="way" style="margin-top: 15px;"  value="phone"> 用手机号注册
            <input  type="radio" name="way" value="email" checked="checked" > 用Email注册
            <br />
            <div name="phone">
            <input type="text" value="输入邮箱" onfocus="if(this.value == '输入邮箱'){
            this.value = ''}" onblur="if (this.value==''){this.value='输入邮箱'}" name="email" style="height: 25px;width: 250px;margin-top: 15px" >
             <font color="red"><b><%=message %></b></font>
            <br />
            <p><strong>密码：</strong></p>
                <input type="text"  name="password" style="width: 250px;height: 25px" value="请输入6-16位密码" onfocus="if(this.value == '请输入6-16位密码'){
            this.value = '';type='password'}" onblur="if (this.value==''){this.value='请输入6-16位密码';this.type = 'text'}">
                <br />
            <input type="checkbox" name="agree" style="margin-top: 15px;">我已同意（服务条款）
            <input type="submit" value="注册" style="width: 70px; height: 30px;background-color: #ff4400;margin-left: 10px;border-radius: 5px">
            </div>
        </form>
        </div>
</body>
</html>