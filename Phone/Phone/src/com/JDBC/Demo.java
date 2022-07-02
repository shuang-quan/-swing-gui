package com.JDBC;

import com.User.User;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Demo {
    int index = 0;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet resuleSet = null;
    String str="";
    public void Select_one(int num, String name, TextArea textout) {//通过num判断查询什么
        try {
            con = JDBCUtil.getConnection();
            String sql=null;
            if(num==1){
                 sql= "select * from phone where name = ?";
            }else if(num == 2){
                sql= "select * from phone where sex = ?";
            }else if(num == 3 ){
                sql= "select * from phone where num = ?";
            }else{
                sql= "select * from phone";
            }
            ps = con.prepareStatement(sql);


                ps.setObject(1, name);

            resuleSet = ps.executeQuery();
            while(resuleSet.next()){
                String name1 = resuleSet.getString(1);
                String Sex=resuleSet.getString(2);
                String Num = resuleSet.getString(3);
                System.out.println(name1);
                str+=name1+" "+Sex+" "+Num+"\n";

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResourse(con,ps,resuleSet);
        }
        textout.setText(str);
        str = "";

    }
    //查询所有的信息
    public void Select_one(TextArea textout)  {
        try {
        con = JDBCUtil.getConnection();
        String sql="select * from phone";
        ps = con.prepareStatement(sql);
        resuleSet = ps.executeQuery();

        while(resuleSet.next()){
            String name1 = resuleSet.getString(1);
            String Sex=resuleSet.getString(2);
            String Num = resuleSet.getString(3);
            //System.out.println(name1);
            str+=name1+"\t\t"+Sex+"\t\t"+Num+"\n";
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeResourse(con,ps,resuleSet);

    }
        textout.setText(str);
        str = "";
    }

    public void Select_two(int num1,int num2,String a,String b,TextArea textout) throws Exception {
        try {
            con = JDBCUtil.getConnection();
            String sql =null;
            if(num1==1&&num2==2) {
                 sql = "select * from phone where name =? and sex =?";
            }else if(num1==1&&num2==3){
                sql = "select * from phone where name =? and num =?";
            }else if(num1==2&&num2==3){
                sql = "select * from phone where sex =? and num =?";
            }
            ps = con.prepareStatement(sql);
            ps.setObject(1, a);
            ps.setObject(2, b);
            resuleSet = ps.executeQuery();
            while(resuleSet.next()){
                String name1 = resuleSet.getString(1);
                String Sex=resuleSet.getString(2);
                String Num = resuleSet.getString(3);
                textout.setText(name1);
                textout.setText(Sex);
                textout.setText(Num);
                str+=name1+"\t\t"+Sex+"\t\t"+Num+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResourse(con,ps,resuleSet);
        }
        textout.setText(str);
        str = "";

    }
    public void Select_three(String name,String sex,String num,TextArea textout) {
        try {
            con = JDBCUtil.getConnection();
            String sql =null;

                sql = "select * from phone where name=? and sex =? and num =?";

            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, sex);
            ps.setObject(3, num);
            resuleSet = ps.executeQuery();
            while(resuleSet.next()){
                String name1 = resuleSet.getString(1);
                String Sex=resuleSet.getString(2);
                String Num = resuleSet.getString(3);
                textout.setText(name1);
                textout.setText(Sex);
                textout.setText(Num);
                str+=name1+"\t\t"+Sex+"\t\t"+Num+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResourse(con,ps,resuleSet);
        }
        textout.setText(str);
        str = "";
    }

    /**
     * 删除
     */
    public void Delete_one(String name,String sex,String num){
        try {
            con = JDBCUtil.getConnection();
            String sql =null;

            sql = "delete   from phone where name=? and sex =? and num =?";

            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, sex);
            ps.setObject(3, num);
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResourse(con,ps,resuleSet);
        }

    }
    public void add_one(String name,String sex,String num){
        try {
            con = JDBCUtil.getConnection();
            String sql =null;

            sql = "insert into phone values(?,?,?);";

            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            ps.setObject(2, sex);
            ps.setObject(3, num);
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResourse(con,ps,resuleSet);
        }

    }

    }


