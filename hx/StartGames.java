package practice.snake.hx;
import javax.swing.JFrame;
public class StartGames{
    public static void main(String[] args){
        //绘制一个窗口
        JFrame jFrame = new JFrame("贪吃蛇小游戏");
        //设置窗口大小
        jFrame.setBounds(500, 200, 900, 720);

        jFrame.setResizable(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件

        //面板panel
        jFrame.add(new GamePanel());
        
        
           
        jFrame.setVisible(true);//让窗口能展示出来

        




    }
}
