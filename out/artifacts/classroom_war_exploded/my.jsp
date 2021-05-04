<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/4/21
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的预约</title>

    <link rel="stylesheet" href="order_two.css">
</head>
<body>
<div id="header" style="background: rgba(0,0,0,0.8);height: 40px;opacity:0.7">
    <h1 style="text-align: center;color:#F0F8FF">学校辅导室预约系统</h1>

</div>
<div id="menu"style="background: rgba(0,0,0,0.8);height: 640px;width: 100px;float: left;opacity:0.7">
    <br/>
    <a href="order.jsp"style="color:#F0F8FF">
        <li>
            <h3>资源预约</h3>
        </li>
    </a>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <a href="my.jsp"style="color:#F0F8FF">
        <li>
            <h3>我的预约</h3>
        </li>
    </a>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <a href="personal_1.jsp"style="color:#F0F8FF">
        <li>
            <h3>个人中心</h3>
        </li>
    </a>
</div>
<div id="content" style="background-color:#F5F5F5;height: 640px;width: 1400px;float: left;">

</div>

<div class="box">
    <div class="content">
        <div style="display: block;">
            <form action="searchservlet" method="post">
            <input type="submit" value="查询">
            </form>
            <button type="hh"></button>
            <form action="cancelservlet" method="post">
            <input type="submit" value="取消预约">
            </form>
        </div>

    </div>
</div>

<%
    String yy_id= (String) request.getAttribute("orderID");
    String start_time= (String) request.getAttribute("Stime");
    String end_time= (String) request.getAttribute("Etime");
%>

<div class="control">
    <div class="content">
            <div style="display: block;">
                <p>预约号</p>
                <input  name="username" type="text" placeholder="预约号" value = "<%=yy_id%>"/>
                <p>开始时间</p>
                <input  name="username" type="text" placeholder="开始" value = "<%=start_time%>"/>
                <p>结束时间</p>
                <input name="username" type="text" placeholder="结束" value = "<%=end_time%>"/>
                <br/>
            </div>

    </div>
</div>

<div id="footer" style="background:rgba(0,0,0,0.8);clear:both;text-align:center;color:#F0F8FF;opacity:0.7">
    版权  404notfound.com</div>
</body>
</html>
<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='fail'){
        alert("取消订单失败!");
    }else if(errori=='success'){
        alert("取消成功!");
    }
</script>
