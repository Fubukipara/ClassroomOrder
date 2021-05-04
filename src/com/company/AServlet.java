package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aservlet")

public class AServlet extends HttpServlet {              //管理员登录接口
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");       //获得用户名
        String pwd = request.getParameter("password");            //获得密码

        login Login = new login();
        int a = Login.aloginjudge(username,pwd);          //调用登录类中的函数判断账号密码正确性

        if (a == 0) {
            user.user_name=username;
            //验证成功，转向登录成功后的界面（这里暂时用空界面代替）
            request.getRequestDispatcher("test.jsp").forward(request, response);
        } else if(a==1) {
            //验证失败，转向登录界面，并传递一个参数error，其值为username，即用户名错误
            response.sendRedirect("index.jsp?error=username");
        }else if(a==2){
            //密码错误
            response.sendRedirect("index.jsp?error=pwd");
        }

    }

}
