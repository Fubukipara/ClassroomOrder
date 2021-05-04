<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<meta name="content-type" content="text/html; charset=UTF-8">
<head>

    <meta charset="UTF-8">

    <title >预约</title>

    <link rel="stylesheet" href="login_two.css">

    <script src="page.js"></script>

</head>
<body>
<div class="control">
    <div class="item">
        <div class="active">学生</div><div>教师</div><div>管理员</div>
    </div>
    <div class="content">

            <div style="display: block;">
                <p>账号</p>
                <input  name="username" type="text" placeholder="用户名" />
                <p>密码</p>
                <input name="password" type="password" placeholder="密码" />
                <br/>
                <label></label>
                <input type="submit" value="登录">
                <button type="hh"></button>
                <button type="button" onClick="window.location.href = 'register.jsp'" >注册</button>
            </div>



    </div>
</div>

</body>
</html>



