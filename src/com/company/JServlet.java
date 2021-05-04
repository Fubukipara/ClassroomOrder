package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserPrincipal;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sservlet")

public class JServlet extends HttpServlet {                //学生登录接口类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");          //获得用户名和密码
        String pwd = request.getParameter("password");

        login Login = new login();
        int a = Login.loginjudge(username,pwd);

        if (a == 0) {
//验证成功，转向登录成功后的界面
            user.user_name=username;

            request.getRequestDispatcher("order.jsp").forward(request, response);
        } else if(a==1) {
//验证失败，转向登录界面，并传递一个参数，表示用户名错误
            response.sendRedirect("index.jsp?error=username");
        }else if(a==2){
            //密码错误
            response.sendRedirect("index.jsp?error=pwd");
        }

        }

    }
