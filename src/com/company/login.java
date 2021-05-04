package com.company;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class login {             //登录类
    public int loginjudge(String username,String pwd){                  //学生登录判断函数
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表

        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;

            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "SELECT COUNT(*) FROM students Where StuID = '"+username+"'and Spassword = '"+ pwd+"'";

            r = stmt.executeQuery(sqlTest);      //执行sql语句并返回结果集

            while (r.next()) {

                if (Integer.parseInt(r.getString(1) )== 1) {
                    //若符合用户名和密码的项存在，即结果集为1，则返回0，登录成功
                    return 0;
                }else{
                    //若登录失败，首先查看用户名在表中是否存在

                    String sqlTest1 = "SELECT COUNT(*) FROM students Where StuID = '"+username+"'";

                    r = stmt.executeQuery(sqlTest1);

                    while (r.next()) {
                        //用户名不存在，则返回1提示用户名错误
                        if (Integer.parseInt(r.getString(1) )== 0) {
                            return 1;
                        }else{
                            //用户名正确，则密码错误
                            return 2;
                        }
                    }

                }
            }


        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (r != null)
                try {
                    r.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
        return 0;

    }
    public int tloginjudge(String username,String pwd){           //教师登录函数
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表

        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;

            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "SELECT COUNT(*) FROM teachers Where TID = '"+username+"'and Tpassword = '"+ pwd+"'";

            r = stmt.executeQuery(sqlTest);

            while (r.next()) {

                if (Integer.parseInt(r.getString(1) )== 1) {
                    return 0;
                }else{

                    String sqlTest1 = "SELECT COUNT(*) FROM teachers Where TID = '"+username+"'";

                    r = stmt.executeQuery(sqlTest1);

                    while (r.next()) {

                        if (Integer.parseInt(r.getString(1) )== 0) {
                            return 1;
                        }else{
                            return 2;
                        }
                    }

                }
            }


        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (r != null)
                try {
                    r.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
        return 0;

    }

    public int aloginjudge(String username, String pwd) {        //管理员登录函数
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=orderSystem;user=sa;password=123456";//sa身份连接

        // Declare the JDBC objects.
        Connection con = null;  //会话连接
        Statement stmt = null;  //用于执行静态SQL语句并返回其生成的结果的对象。
        ResultSet r = null;  //数据库结果集的数据表

        try {
            //1-注册驱动器,驱动管理器类加载SQLServerDriver类的静态方法，如果没有添加这个驱动，则创建这个驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;

            //2-与数据源获得连接
            con = DriverManager.getConnection(url);

            //3-创建一个Statement对象，用于将SQL语句发送到数据库
            stmt = con.createStatement();

            String sqlTest = "SELECT COUNT(*) FROM adms Where AID = '"+username+"'and Apassword = '"+ pwd+"'";

            r = stmt.executeQuery(sqlTest);

            while (r.next()) {

                if (Integer.parseInt(r.getString(1) )== 1) {
                    return 0;
                }else{

                    String sqlTest1 = "SELECT COUNT(*) FROM adms Where TID = '"+username+"'";

                    r = stmt.executeQuery(sqlTest1);

                    while (r.next()) {

                        if (Integer.parseInt(r.getString(1) )== 0) {
                            return 1;
                        }else{
                            return 2;
                        }
                    }

                }
            }


        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (r != null)
                try {
                    r.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
        return 0;

    }
}
