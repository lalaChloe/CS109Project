package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGameFrameWin extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    static MusicPlayer player = new MusicPlayer("D:\\IntelliJ IDEA Projects\\DarkChess3\\DarkChess2\\src\\a.wav");

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
        addmusic();
    }

    private void addmusic() {
        player.setVolumn(6f).play();
    }

    private void addbackground() {
        ImageIcon picture=new ImageIcon("D:\\IntelliJ IDEA Projects\\DarkChess3\\DarkChess2\\src\\d.jpg");
        JLabel label=new JLabel(picture);
        label.setLocation(0 , 0 );
        label.setSize(this.WIDTH,this.HEIGHT );
        add(label);
    }
    private void addLabel(){
        JLabel label = new JLabel("Click Here To Replay");
        label.setLocation(WIDTH /3-30, HEIGHT / 3);
        label.setSize(480, 60);
        label.setFont(new Font("Rockwell", Font.BOLD, 40));
        add(label);
    }
    private void addButton() {
        JButton button = new JButton("Replay");
        button.addActionListener(new ButtonClickListener());
//        ChessGameFrame newMainFrame = new ChessGameFrame(720, 720);
        Chessgamebegin.setCounter(0);
        ChessGameFrame.setRedScore(0);
        ChessGameFrame.setBlackScore(0);
        ChessGameFrame.setDiedBlackGeneral(0);
        ChessGameFrame.setDiedBlackAdvisor(0);
        ChessGameFrame.setDiedBlackMinister(0);
        ChessGameFrame.setDiedBlackChariot(0);
        ChessGameFrame.setDiedBlackHorse(0);
        ChessGameFrame.setDiedBlackSoldier(0);
        ChessGameFrame.setDiedBlackCannon(0);
        ChessGameFrame.setDiedRedGeneral(0);
        ChessGameFrame.setDiedRedAdvisor(0);
        ChessGameFrame.setDiedRedMinister(0);
        ChessGameFrame.setDiedRedChariot(0);
        ChessGameFrame.setDiedRedHorse(0);
        ChessGameFrame.setDiedRedSoldier(0);
        ChessGameFrame.setDiedRedCannon(0);
        ChessGameFrame.setIndexOfIfFirst(0);
        ChessGameFrame.CurrentBoard.clear();
//        button.addActionListener((e) -> newMainFrame.setVisible(true));
        button.setLocation(WIDTH /3+80, HEIGHT / 3+80);
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
            player.over();
        }
    }

}