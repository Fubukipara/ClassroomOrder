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

@WebServlet("/searchservlet")

public class Search_Servlet extends HttpServlet {                //搜索接口类
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = user.user_name;
        Search search = new Search();
        String[] resault = new String[10];
        try {
            resault = search.searchbyusername(username);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("orderID", resault[0]);
        request.setAttribute("Stime", resault[1]);
        request.setAttribute("Etime", resault[2]);
        request.getRequestDispatcher("/my.jsp").forward(request, response);



    }

}