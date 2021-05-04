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

@WebServlet("/cancelservlet")

public class Cancel_Servlet extends HttpServlet {                //取消订单接口类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = user.user_name;
        Cancel cancel = new Cancel();
        int resault = 0;
        try {
            resault = cancel.cancelbyusername(username);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (resault == 0) {
//验证成功，转向登录成功后的界面
            response.sendRedirect("my.jsp?error=fail");
        } else if(resault==1) {
//验证失败，转向登录界面，并传递一个参数，表示用户名错误
            response.sendRedirect("my.jsp?error=success");
        }
    }

}
