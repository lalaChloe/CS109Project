package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGameFrameWin extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;


    public ChessGameFrameWin(int width,int height){
        setTitle("GAME OVER"); //设置标题
        this.WIDTH = width;
        this.HEIGHT = height;
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
        addLabel();
        addButton();
        addbackground();
    }
    private void addbackground() {
        ImageIcon picture=new ImageIcon("./src/d.jpg");
        JLabel label=new JLabel(picture);
        label.setLocation(0 , 0 );
        label.setSize(this.WIDTH,this.HEIGHT );
        add(label);
    }
    private void addLabel(){
        JLabel label = new JLabel("Click Here To Replay");
        label.setLocation(WIDTH /3, HEIGHT / 3 );
        label.setSize(240, 60);
        label.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label);
    }
    private void addButton() {
        JButton button = new JButton("Replay");
        button.addActionListener(new ButtonClickListener());
//        ChessGameFrame newMainFrame = new ChessGameFrame(720, 720);
        ChessGameFrame.setRedScore(0);
        ChessGameFrame.setBlackScore(0);
//        button.addActionListener((e) -> newMainFrame.setVisible(true));
        button.setLocation(WIDTH /3+10, HEIGHT / 3+60);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }
    public static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            ChessGameFrame.setRedScore(0);
            ChessGameFrame.setBlackScore(0);
            ChessGameFrame newMainFrame = new ChessGameFrame(720, 720);
            newMainFrame.setVisible(true);
        }
    }

}