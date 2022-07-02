package com.Main;

import com.JDBC.Demo;
import com.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("通讯录");
    }
}

class MyFrame extends Frame {
    private JButton button1;//查询
    private JButton button2;//删除

    private JButton button3;//添加
    private Demo demo;//数据库接口
    private TextField text1;//文本框1
    private TextField text2;//文本框2
    private TextField text3;//文本框3

    //输出框
    private TextArea textout;

    //对象数组
    public User[] user;
    public int index=0;
    /**
     * private 的初始化
      */
    public void init(){
        demo = new Demo();
        button1 = new JButton("查询");
        button2 = new JButton("删除");
        button3 =new JButton("添加");
        text1 = new TextField(5);
        text2 = new TextField(5);
        text3 = new TextField(15);
        textout =new TextArea();


    }
    public MyFrame(String name){
        setTitle(name);
        //布局
        Panel panel = new Panel();
        Panel panel1 = new Panel();
        JLabel label1 = new JLabel("姓名:");
        JLabel label2 = new JLabel("性别:");
        JLabel label3 = new JLabel("电话:");
        //设置布局
        setLayout(new FlowLayout());
        //坐标
        setBounds(300,300,600,600);
        //背景颜色
        //panel设置坐标
        //panel.setBounds(50,50,400,400);
        //初始化
        add(panel);
        init();
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(label3);
        panel.add(text3);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        //面板二
        add(panel1);
        panel1.add(textout);


        //pack();
        setVisible(true);
        this.addAction();


    }

    /**
     * 事件监听
     */
    public void addAction(){
        //窗口关闭
        addWindowListener(new WindowAdapter() {//
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        button1.addMouseListener(new MouseAdapter() {//查询

            @Override
            public void mouseClicked(MouseEvent e) {

                String name = null;
                String sex = null;
                String num = null;
                name = text1.getText();
                sex = text2.getText();
                num = text3.getText();

                if (name.length()==0&&sex.length()==0&&num.length()==0) {//全空
                    try {
                        demo.Select_one( textout);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (name.length()!=0 && (sex.length()==0 && num.length()==0)) {//3个中一个不为空
                    demo.Select_one(1, name,textout);
                } else if (name.length()==0 && (sex.length()!=0  && num.length()==0)) {
                   demo.Select_one(2, sex,textout);
                } else if (name.length()==0 && (sex.length()==0 && num.length()!=0)) {
                    demo.Select_one(3, num,textout);
                } else if (name.length()!=0 && sex .length()!=0 && num.length()==0) {//3个中一个为空
                    try {
                        demo.Select_two(1, 2, name, sex,textout);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (name.length()!=0 && sex .length()==0 && num.length()!=0) {
                    try {
                        demo.Select_two(1, 3, name, num,textout);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if ((name.length()==0 && sex .length()!=0 && num.length()!=0)) {
                    try {
                        demo.Select_two(2, 3, sex, num,textout);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }else if((name.length()!=0 && sex .length()!=0 && num.length()!=0)){
                    try {
                        demo.Select_three(name,sex, num,textout);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }

        });//button2.addMouseListener()

        /**
         * 删除
         *
         */
        button2.addMouseListener(new MouseAdapter() {//删除
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = null;
                String sex = null;
                String num = null;
                name = text1.getText();
                sex = text2.getText();
                num = text3.getText();

                    demo.Delete_one(name,sex,num);

            }
        });
        button3.addMouseListener(new MouseAdapter() {//添加
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = null;
                String sex = null;
                String num = null;
                name = text1.getText();
                sex = text2.getText();
                num = text3.getText();

                demo.add_one(name,sex,num);
            }
        });
    }

}
