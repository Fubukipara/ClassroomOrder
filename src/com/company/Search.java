package com.company;

import java.sql.*;

public class Search {

    public String[] searchbyusername(String username) throws ClassNotFoundException {
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表
        String[] res = new String[20];
        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;

            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();


            String sqlTest = "SELECT COUNT(*) FROM orders Where userID = '"+username+"'";   //首先判断order是否已存在

            r = stmt.executeQuery(sqlTest);

            while (r.next()) {

                //若用户名不存在，则返回无
                    if(Integer.parseInt(r.getString(1) )== 0){
                        res[0]="无";
                        res[1]="无";
                        res[2]="无";
                        return res;
                    }
                }
            String SQL = "SELECT orderID FROM orders Where userID = '"+username+"'";


            r = stmt.executeQuery(SQL);

            while (r.next()) {

                res[0]=r.getString(1);

                    }
            SQL = "SELECT Stime FROM orders Where userID = '" +username+ "'";


            r = stmt.executeQuery(SQL);

            while (r.next()) {

                res[1]=r.getString(1);

            }
            SQL = "SELECT Etime FROM orders Where userID = '" +username+ "'";


            r = stmt.executeQuery(SQL);

            while (r.next()) {

                res[2]=r.getString(1);

            }
                } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;

    }
}
