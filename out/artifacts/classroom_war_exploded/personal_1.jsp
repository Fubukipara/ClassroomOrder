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
    <link rel="stylesheet" type="text/css" href="per_1.css">
    <title>我的预约</title>
</head>
<body>
<div id="header" style="background:rgba(0,0,0,0.8);height: 40px;opacity:0.7">
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
    <a href="personal.jsp"style="color:#F0F8FF">
        <li>
            <h3>个人中心</h3>
        </li>
    </a>
</div>
<div id="content" style="background-color:#F5F5F5;height: 640px;width: 100%;margin-left: 100px">
    <form action="pservlet" method="post">
        <div class="banner_con">
            <div class="list_block_media_list"style="width: 100%">
                <div class="item_row"style="border-bottom: 1px solid #cccccc;margin-top: 20px;margin-left:50px;width: 100%">
                    <div class="item_title_username"style="color: #4a4a4a;font-size: 150%">田盼盼</div>
                </div>
            </div>
            <div class="item_text_usercount"style="color: #4a4a4a;margin-left:50px;font-size:150% ">20181003466</div>
        </div>
        <div class="list-block-touch-top">
            <li><a class="item-list">
                <div class="item-inner">
                    <div class="item-text" >预约记录</div></div>

            </a></li>
            <li><a class="item-list">
                <div class="item-inner"><div class="item-text" >修改密码</div></div>

            </a></li>
            <li><a class="item-list">
                <div class="item-inner"><div class="item-text" >使用帮助</div></div>

            </a></li>
            <li><a class="item-list">
                <div class="item-inner"><div class="item-text" >退出</div></div>

            </a></li>
            <li><a class="item-list">
                <div class="item-inner"><div class="item-text" >注销</div></div>

            </a></li>

        </div>
    </form>
</div>

<div id="footer" style="background:rgba(0,0,0,0.8);clear:both;text-align:center;color:#F0F8FF;opacity:0.7">
    版权  404notfound.com</div>
</body>
</html>

