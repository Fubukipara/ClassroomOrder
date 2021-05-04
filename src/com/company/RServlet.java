package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rservlet")

public class RServlet extends HttpServlet {                                        //注册功能接口类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userkind_s = request.getParameter("userkind");     //获得用户角色
        int userkind =Integer.parseInt(userkind_s);
        String name = request.getParameter("name");                 //获得用户姓名
        String username = request.getParameter("username");        //获得账户名
        String pwd = request.getParameter("password");             //获得密码

        register Register = new register();                          //将相应参数传至注册函数
        int a = Register.registeract(name,username,pwd,userkind);

        if (a == 0) {
//验证成功，转向登录成功后的界面
            response.sendRedirect("register.jsp?error=success");
        } else if(a==1) {
            //返回报错，用户名已存在
            response.sendRedirect("register.jsp?error=username");

        }else if(a==2) {
            //注册失败
            response.sendRedirect("register.jsp?error=registererror");

        }

    }

}

