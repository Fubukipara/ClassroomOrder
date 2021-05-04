package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tservlet")

public class TServlet extends HttpServlet {                                       //教师登录类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");

        login Login = new login();
        int a = Login.tloginjudge(username,pwd);

        if (a == 0) {

            user.user_name=username;
//验证成功，转向登录成功后的界面
            request.getRequestDispatcher("order.jsp").forward(request, response);
        } else if(a==1) {
//验证失败，转向登录界面，并传递一个参数error，其值为yes
            response.sendRedirect("index.jsp?error=username");
        }else if(a==2){
            response.sendRedirect("index.jsp?error=pwd");
        }

    }

}
