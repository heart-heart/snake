package practice.snake.hx;

import java.net.URL;

import javax.swing.ImageIcon;

public class Data {
    public static URL headerURL = Data.class.getResource("/practice/snake/static/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    //蛇头图片
    public static URL upURL = Data.class.getResource("/practice/snake/static/up.png");
    public static URL downURL = Data.class.getResource("/practice/snake/static/down.png");
    public static URL leftURL = Data.class.getResource("/practice/snake/static/left.png");
    public static URL rightURL = Data.class.getResource("/practice/snake/static/right.png");

    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    //蛇身
    public static URL bodyURL = Data.class.getResource("/practice/snake/static/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    //食物
    public static URL foodURL = Data.class.getResource("/practice/snake/static/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);
}
