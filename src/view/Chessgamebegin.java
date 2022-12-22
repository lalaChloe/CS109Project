package view;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Chessgamebegin extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;

    static MusicPlayer player = new MusicPlayer("./src/a.wav");
    public Chessgamebegin(int width, int height) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        setTitle("GAME Star"); //设置标题
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
        ImageIcon picture=new ImageIcon("./src/d.jpg");
        JLabel label=new JLabel(picture);
        label.setLocation(0 , 0 );
        label.setSize(this.WIDTH,this.HEIGHT );
        add(label);
    }

    private void addLabel() {
        JLabel label = new JLabel("Click Here To Start");
        label.setLocation(WIDTH/4 -10, HEIGHT/4-10 );
        label.setSize(420, 120);
        label.setFont(new Font("Rockwell", Font.BOLD, 40));
        add(label);
    }

    private void addButton() {
        JButton button = new JButton("Start");
        button.addActionListener(new ButtonClickListener());
        button.setLocation(WIDTH /3+20, HEIGHT / 3+60);
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
            player.setVolumn(6f).over();
        }
    }
}
