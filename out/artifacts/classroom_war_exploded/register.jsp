<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/19
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<meta name="content-type" content="text/html; charset=UTF-8">
<head>

    <meta charset="UTF-8">

    <title >注册</title>

    <link rel="stylesheet" href="login_two.css">

    <script type="text/javascript" charset="utf-8" src="//g.alicdn.com/sd/ncpc/nc.js?t=2015052012"></script>

</head>
<body>
<div class="control">
    <div class="content">
        <form action="rservlet" method="post">
            <div style="display: block;">
                <select name="userkind" class="selectpicker" title ="角色">
                    <option value="1">教师</option>
                    <option value="2">低年级学生</option>
                    <option value="3">高年级学生</option>
                </select><br>

                <input  name="name" type="text" placeholder="姓名" />

                <input  name="username" type="text" placeholder="用户名" />

                <input name="password" type="password" id="password1" placeholder="密码" />

                <input name="password1" type="password" id="password2" placeholder="确认密码" onkeyup="validate()"/><span id="tip"></span>
                <br/>
                <button id="bottom-text" type="button"></button>
                <input type="submit" id="submit" value="注册">
                <button type="hh"></button>
                <button type="button" onClick="window.location.href = 'index.jsp'" >返回</button>
            </div>
        </form>
    </div>
</div>

 <!--No-Captcha渲染的位置，其中 class 中必须包含 nc-container-->

<div id="your-dom-id" class="nc-container" style="position:absolute;left:618px;top:487px"></div>

<!--判断两次输入的密码是否一致-->
<script>
    function validate() {
        const pw1 = document.getElementById("password1").value;
        const pw2 = document.getElementById("password2").value;
        if(pw1 !== pw2) {
            document.getElementById("tip").innerHTML="<font color='red'>两次密码不同</font>";
            document.getElementById("submit").disabled = true;
        }else{
            document.getElementById("tip").innerHTML="<font color='red'></font>";
            document.getElementById("submit").disabled = false;
        }
    }
</script>

<script type="text/javascript">

    <!--简单的滑块拖动验证码-->

    var nc_token = ["CF_APP_1", (new Date()).getTime(), Math.random()].join(':');
    var NC_Opt =
        {
            renderTo: "#your-dom-id",
            appkey: "CF_APP_1",
            scene: "register",
            token: nc_token,
            customWidth: 300,
            trans:{"key1":"code0"},
            elementID: ["usernameID"],
            is_Opt: 0,
            language: "cn",
            isEnabled: true,
            timeout: 3000,
            times:5,
            apimap: {
                // 'analyze': '//a.com/nocaptcha/analyze.jsonp',
                // 'get_captcha': '//b.com/get_captcha/ver3',
                // 'get_captcha': '//pin3.aliyun.com/get_captcha/ver3'
                // 'get_img': '//c.com/get_img',
                // 'checkcode': '//d.com/captcha/checkcode.jsonp',
                // 'umid_Url': '//e.com/security/umscript/3.2.1/um.js',
                // 'uab_Url': '//aeu.alicdn.com/js/uac/909.js',
                // 'umid_serUrl': 'https://g.com/service/um.json'
            },
            callback: function (data) {
                window.console && console.log(nc_token)
                window.console && console.log(data.csessionid)
                window.console && console.log(data.sig)
            }
        }
    var nc = new noCaptcha(NC_Opt)
    nc.upLang('cn', {
        _startTEXT: "请按住滑块，拖动到最右边",
        _yesTEXT: "验证通过",
        _error300: "哎呀，出错了，点击<a href=\"javascript:__nc.reset()\">刷新</a>再来一次",
        _errorNetwork: "网络不给力，请<a href=\"javascript:__nc.reset()\">点击刷新</a>",
    })
</script>

</body>
</html>

<script>
    //取出传回来的参数error并与yes比较
    var errori ='<%=request.getParameter("error")%>';
    if(errori=='username'){
        alert("用户名已存在!");
    }else if(errori=='success'){
        alert("注册成功!点击返回回到登录界面");
    }else if(errori=='registererror'){
        alert("注册失败!");
    }
</script>

