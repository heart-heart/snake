package practice.snake.hx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int lenth;// 蛇的长度
    int[] snakeX = new int[600];// 蛇的坐标x
    int[] snakeY = new int[500];// 蛇的坐标y
    String fx;
    boolean isStar = false;
    int foodx;
    int foody;
    Random random = new Random();

    Timer timer = new Timer(100, this);

    public GamePanel() {
        init();
        // 获取键盘的监听事件
        this.setFocusable(true);

        this.addKeyListener(this);
        timer.start();
    }

    // 蛇初始化
    public void init() {
        lenth = 3;
        fx = "R";
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        foodx = 25 + 25*random.nextInt(34);
        foody = 75 + 25*random.nextInt(24);
    }

    // 画板：化界面 画蛇
    @Override
    protected void paintComponent(Graphics g) { // g：画笔
        super.paintComponent(g);// 清屏
        Data.header.paintIcon(this, g, 18, 11);
        this.setBackground(Color.white);
        g.fillRect(18, 75, 850, 600);

        // 画一条静态的小蛇
        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i = 1; i < lenth; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        if (isStar == false) {
            // 画一个文字，String
            g.setColor(Color.white);// 设置画笔的颜色
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));// 设置字体
            g.drawString("按下空格开始", 300, 300);
        }
        Data.food.paintIcon(this, g, foodx,foody);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 键盘按下未释放
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_SPACE) {
            isStar = !isStar;
            repaint();// 重新绘制界面
        }

        //
        if (keycode == KeyEvent.VK_DOWN) {
            fx = "D";
        }else if(keycode == KeyEvent.VK_RIGHT){
            fx = "R";
        }else if(keycode == KeyEvent.VK_UP){
            fx = "U";
        }else if(keycode == KeyEvent.VK_LEFT){
            fx = "L";
        }


     }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果游戏处于开始状态
        if (isStar) {
            //右移
            for (int i = lenth-1; i > 0; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }            
            if (fx == "R") {
                
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0]>862) {
                    init();
                }
            }else if(fx == "L"){
                snakeX[0] = snakeX[0] -25;
                if (snakeX[0]<=0) {
                    init();
                }
            }else if(fx == "U"){
                snakeY[0] = snakeY[0] - 25;
                if (snakeY[0]<75) {
                    init();
                }
            }else if(fx == "D"){
                snakeY[0] = snakeY[0] +25;
                if (snakeY[0]>=675) {
                    init();
                }
            }
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                lenth++;    
                foodx = 25 + 25*random.nextInt(34);
                foody = 75 + 25*random.nextInt(24);        
            }
            repaint();   //刷新界面     
        }
        timer.start();//让时间动起来
        

    }
   

    @Override
    public void keyReleased(KeyEvent e) {
        // 释放某个键

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 键盘按下弹起

    }
    

    
    
}
