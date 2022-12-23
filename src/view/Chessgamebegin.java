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
    private static JLabel timeLabel;
    private static int counter=0;

    static MusicPlayer player = new MusicPlayer("D:\\IntelliJ IDEA Projects\\DarkChess3\\DarkChess2\\src\\a.wav");
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
        addTimeLabel();
        addButton();
        addbackground();
        addmusic();
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Chessgamebegin.counter = counter;
    }

    private void addmusic() {
        player.setVolumn(6f).play();
    }
    private void addTimeLabel() {

        timeLabel = new JLabel("");
        timeLabel.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10+420+20+80);/////////////////////////////////////////////////////////////
        timeLabel.setSize(200, 60);
        timeLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        Timer timer = new Timer(1000, new ActionListener() {
            //            int count = 0;
            public void actionPerformed(ActionEvent e) {
//                count++;
                setCounter(getCounter()+1);
                int minute=getCounter()/60;
                int second=getCounter()%60;
//                Integer.toString(getCounter())
                timeLabel.setText("");
            }
        });
        timer.start();
        add(timeLabel);
    }

    private void addbackground() {
        ImageIcon picture=new ImageIcon("D:\\IntelliJ IDEA Projects\\DarkChess3\\DarkChess2\\src\\d.jpg");
        JLabel label=new JLabel(picture);
        label.setLocation(0 , 0 );
        label.setSize(this.WIDTH,this.HEIGHT );
        add(label);
    }

    private void addLabel() {
        JLabel label = new JLabel("Click Here To Start");
        label.setLocation(WIDTH/3-10 , HEIGHT/4+30 );
        label.setSize(420, 120);
        label.setFont(new Font("Rockwell", Font.BOLD, 40));
        add(label);
    }

    private void addButton() {
        JButton button = new JButton("Start");
        button.addActionListener(new ButtonClickListener());
        button.setLocation(WIDTH /2-80, HEIGHT / 3+80);
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
            setCounter(0);
        }
    }
}
