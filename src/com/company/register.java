package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class register {          //注册类
    public int registeract(String name,String username,String pwd,int userkind) {
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

            if(userkind ==2 ||userkind ==3 ){      //当用户选择的角色是学生

                String sqlTest = "SELECT COUNT(*) FROM students Where StuID = '"+username+"'";   //首先判断用户名是否已存在

                r = stmt.executeQuery(sqlTest);

                while (r.next()) {

                    //若用户名已存在，则返回1提示用户名重复

                    if(Integer.parseInt(r.getString(1) )== 1){
                        return 1;
                    }
                }
                String SQL = "INSERT INTO students VALUES('" + username + "','" + name + "','" + pwd + "','" + String.valueOf(userkind) + "')";

                //5-执行向表中插入用户数据的sql语句
                stmt.execute(SQL);

                r = stmt.executeQuery(sqlTest);   //插入完后执行第一个sql语句查看是否插入成功

                while (r.next()) {

                    //若表中查找不到对应项，则插入失败，返回2提示注册失败

                    if(Integer.parseInt(r.getString(1) )== 0){
                        return 2;
                    }
                }
            }else{    //若用户选择的角色不是学生，则对老师表进行同样操作

                String sqlTest = "SELECT COUNT(*) FROM teachers Where TID = '"+username+"'";

                r = stmt.executeQuery(sqlTest);

                while (r.next()) {

                    if(Integer.parseInt(r.getString(1) )== 1){
                        return 1;
                    }
                }
                String SQL = "INSERT INTO teachers VALUES('" + username + "','" + name + "','" + pwd + "')";

                stmt.execute(SQL);

                r = stmt.executeQuery(sqlTest);

                while (r.next()) {

                    if(Integer.parseInt(r.getString(1) )== 0){
                        return 2;
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
