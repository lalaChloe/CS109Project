package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 这个类表示游戏窗体，窗体上包含：
 * 1 Chessboard: 棋盘
 * 2 JLabel:  标签
 * 3 JButton： 按钮
 */
public class ChessGameFrame extends JFrame {
    private final int WIDTH;
    private final int HEIGHT;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    private static JLabel statusLabel;
    private static JLabel redScoreLabel;
    private static JLabel blackScoreLabel;
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;
    private static JLabel label7;
    private static JLabel label8;
    private static JLabel label9;
    private static JLabel label10;
    private static JLabel label11;
    private static JLabel label12;
    private static JLabel label13;
    private static JLabel label14;



    private static int redScore;
    private static int blackScore;
    private static int diedRedGeneral;
    private static int diedBlackGeneral;
    private static int diedRedAdvisor;
    private static int diedBlackAdvisor;
    private static int diedRedMinister;
    private static int diedBlackMinister;
    private static int diedRedChariot;
    private static int diedBlackChariot;
    private static int diedRedHorse;
    private static int diedBlackHorse;
    private static int diedRedSoldier;
    private static int diedBlackSoldier;
    private static int diedRedCannon;
    private static int diedBlackCannon;

    public static int indexOfIfFirst=0;
    public static ArrayList<String> CurrentBoard=new ArrayList<>();

    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS109 Project Demo"); //设置标题
        this.WIDTH = width+288;//////////////////////////////////////////////////////////////////////////////////////////////
        this.HEIGHT = height;
        this.CHESSBOARD_SIZE = HEIGHT * 4 / 5;

        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null); // Center the window.
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addLoadButton();
        addChessboard();
        addLabel();
//        addHelloButton();

        addRedScoreLabel();
        addBlackScoreLabel();
        addReplayButton();
        //addchessboardbackground();
        addDiedRedPic();
        addDiedBlackPic();

        addRedGeneralLabel();
        addBlackGeneralLabel();
        addRedAdvisorLabel();
        addRedMinisterLabel();
        addRedChariotLabel();
        addRedHorseLabel();
        addRedSoldierLabel();
        addRedCannonLabel();
        addBlackAdvisorLabel();
        addBlackMinisterLabel();
        addBlackChariotLabel();
        addBlackHorseLabel();
        addBlackSoldierLabel();
        addBlackCannonLabel();
        addbackground();
    }


//    private void addchessboardbackground() {
//        ImageIcon picture=new ImageIcon("E:\\e.jpg");
//        JLabel label=new JLabel(picture);
//        label.setLocation(0 , 0 );
//        label.setSize(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE );
//        add(label);
//    }

    private void addbackground() {
        ImageIcon picture=new ImageIcon("./src/d.jpg");
        JLabel label=new JLabel(picture);
        label.setLocation(0,0);
        label.setSize(this.WIDTH,this.HEIGHT );
        add(label);
    }
    private void addDiedRedPic() {
        ImageIcon icon = new ImageIcon("./src/x.jpg");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(CHESSBOARD_SIZE / 8, CHESSBOARD_SIZE*7/8 ,Image.SCALE_DEFAULT );
        icon = new ImageIcon(newImage);

        JLabel label=new JLabel(icon);
        label.setLocation(HEIGHT / 10+144+288+72, HEIGHT / 10);
        label.setSize(CHESSBOARD_SIZE / 8, CHESSBOARD_SIZE*7/8 );
        add(label);
    }
    private void addDiedBlackPic() {
        ImageIcon icon = new ImageIcon("./src/y.jpg");
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(CHESSBOARD_SIZE / 8, CHESSBOARD_SIZE*7/8 , Image.SCALE_DEFAULT);
        icon = new ImageIcon(newImage);

        JLabel label=new JLabel(icon);
        label.setLocation(HEIGHT / 10, HEIGHT / 10);
        label.setSize(CHESSBOARD_SIZE / 8, CHESSBOARD_SIZE*7/8 );
        add(label);
    }

    private void addRedGeneralLabel() {
        label1= new JLabel("×0");
        label1.setLocation(HEIGHT / 10+72, HEIGHT / 10-12);/////////////////////////////////////////////////////////////
        label1.setSize(200, 60);
        label1.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label1);
    }
    private void addRedAdvisorLabel() {
        label2= new JLabel("×0");
        label2.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+72);/////////////////////////////////////////////////////////////
        label2.setSize(200, 60);
        label2.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label2);
    }
    private void addRedMinisterLabel() {
        label3= new JLabel("×0");
        label3.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+144);/////////////////////////////////////////////////////////////
        label3.setSize(200, 60);
        label3.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label3);
    }
    private void addRedChariotLabel() {
        label4 = new JLabel("×0");
        label4.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+216);/////////////////////////////////////////////////////////////
        label4.setSize(200, 60);
        label4.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label4);
    }
    private void addRedHorseLabel() {
        label5 = new JLabel("×0");
        label5.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+288);/////////////////////////////////////////////////////////////
        label5.setSize(200, 60);
        label5.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label5);
    }
    private void addRedSoldierLabel() {
        label6 = new JLabel("×0");
        label6.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+360);/////////////////////////////////////////////////////////////
        label6.setSize(200, 60);
        label6.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label6);
    }
    private void addRedCannonLabel() {
        label7 = new JLabel("×0");
        label7.setLocation(HEIGHT / 10+72, HEIGHT / 10-12+432);/////////////////////////////////////////////////////////////
        label7.setSize(200, 60);
        label7.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label7);
    }

    private void addBlackGeneralLabel() {
        label8 = new JLabel("×0");
        label8.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12);/////////////////////////////////////////////////////////////
        label8.setSize(200, 60);
        label8.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label8);
    }
    private void addBlackAdvisorLabel() {
        label9 = new JLabel("×0");
        label9.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+72);/////////////////////////////////////////////////////////////
        label9.setSize(200, 60);
        label9.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label9);
    }
    private void addBlackMinisterLabel() {
        label10 = new JLabel("×0");
        label10.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+144);/////////////////////////////////////////////////////////////
        label10.setSize(200, 60);
        label10.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label10);
    }
    private void addBlackChariotLabel() {
        label11 = new JLabel("×0");
        label11.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+216);/////////////////////////////////////////////////////////////
        label11.setSize(200, 60);
        label11.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label11);
    }
    private void addBlackHorseLabel() {
        label12 = new JLabel("×0");
        label12.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+288);/////////////////////////////////////////////////////////////
        label12.setSize(200, 60);
        label12.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label12);
    }
    private void addBlackSoldierLabel() {
        label13 = new JLabel("×0");
        label13.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+360);/////////////////////////////////////////////////////////////
        label13.setSize(200, 60);
        label13.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label13);
    }
    private void addBlackCannonLabel() {
        label14 = new JLabel("×0");
        label14.setLocation(HEIGHT / 10+144+288+72+72, HEIGHT / 10-12+432);/////////////////////////////////////////////////////////////
        label14.setSize(200, 60);
        label14.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(label14);
    }
    /**HEIGHT / 10+144+288, HEIGHT / 10
     * 在游戏窗体中添加棋盘Image.SCALE_DEFAULT
     */
    private void addChessboard() {
        Chessboard chessboard = new Chessboard(CHESSBOARD_SIZE / 2, CHESSBOARD_SIZE);
        ChessGameFrame.CurrentBoard.add(chessboard.turnChessToIndex());
        gameController = new GameController(chessboard,this);
        chessboard.setLocation(HEIGHT / 10+144, HEIGHT / 10);///////////////////////////////////////////////////////////////////////
        add(chessboard);
    }

    /**
     * 在游戏窗体中添加标签
     */
    private void addLabel() {
        statusLabel = new JLabel("Let's play!");
        statusLabel.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10);/////////////////////////////////////////////////////////////
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    public static JLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * 在游戏窗体中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Game Settings");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(WIDTH * 3 / 5, HEIGHT / 10 + 20);
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }


    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10 + 240);////////////////////////////////////////////////////////////////
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.LIGHT_GRAY);
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            String path = JOptionPane.showInputDialog(this, "Input Path here");
            gameController.loadGameFromFile(path);
        });
    }
    private void addRedScoreLabel() {
        redScoreLabel = new JLabel("RED's SCORE: "+getRedScore());
        redScoreLabel.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10+340+20);////////////////////////////////////////////////////
        redScoreLabel.setSize(200, 60);
        redScoreLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(redScoreLabel);
    }

    public static JLabel getRedScoreLabel() {
        return redScoreLabel;
    }

    private void addBlackScoreLabel() {
        blackScoreLabel = new JLabel("BLACK's SCORE: "+getBlackScore());
        blackScoreLabel.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10+420+20);/////////////////////////////////////////////////////
        blackScoreLabel.setSize(200, 60);
        blackScoreLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(blackScoreLabel);
    }

    public static JLabel getBlackScoreLabel() {
        return blackScoreLabel;
    }

    public static void setRedScore(int redScore) {
        ChessGameFrame.redScore = redScore;
    }

    public static void setBlackScore(int blackScore) {
        ChessGameFrame.blackScore = blackScore;
    }

    public static int getRedScore() {
        return redScore;
    }

    public static int getBlackScore() {
        return blackScore;
    }


    private void addReplayButton() {
        JButton button = new JButton("Replay");
        button.addActionListener((e) -> {
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
            setIndexOfIfFirst(0);
            ChessGameFrame.CurrentBoard.clear();
            this.setVisible(false);
            System.out.println("Replay");

            this.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            ChessGameFrame mainFrame = new ChessGameFrame(720, 720);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
            JOptionPane.showMessageDialog(this, "游戏重新开始！");
        });

        button.setLocation((WIDTH-288) * 3 / 5+288, HEIGHT / 10 + 120);//////////////////////////////////////////////////////////////////////
        button.setSize(180, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        button.setBackground(Color.lightGray);
        add(button);
    }



    public void checkIfSomePlayerIsWin(){
        if (getRedScore()>=10){
            this.setVisible(false);

            System.out.println("Replay");

            this.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            ChessGameFrame mainFrame = new ChessGameFrame(WIDTH, HEIGHT);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
            JOptionPane.showMessageDialog(this, "红方赢，游戏重新开始！");
        } else if (getBlackScore()>=10) {
            this.setVisible(false);

            System.out.println("Replay");

            this.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            ChessGameFrame mainFrame = new ChessGameFrame(WIDTH, HEIGHT);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
            JOptionPane.showMessageDialog(this, "黑方赢，游戏重新开始！");
        }
    }

    public void showMessage(){
        JOptionPane.showMessageDialog(this,"格式错误");
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getCHESSBOARD_SIZE() {
        return CHESSBOARD_SIZE;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public static void setStatusLabel(JLabel statusLabel) {
        ChessGameFrame.statusLabel = statusLabel;
    }

    public static void setRedScoreLabel(JLabel redScoreLabel) {
        ChessGameFrame.redScoreLabel = redScoreLabel;
    }

    public static void setBlackScoreLabel(JLabel blackScoreLabel) {
        ChessGameFrame.blackScoreLabel = blackScoreLabel;
    }

    public static int getDiedRedGeneral() {
        return diedRedGeneral;
    }

    public static void setDiedRedGeneral(int diedRedGeneral) {
        ChessGameFrame.diedRedGeneral = diedRedGeneral;
    }

    public static int getDiedBlackGeneral() {
        return diedBlackGeneral;
    }

    public static void setDiedBlackGeneral(int diedBlackGeneral) {
        ChessGameFrame.diedBlackGeneral = diedBlackGeneral;
    }

    public static int getDiedRedAdvisor() {
        return diedRedAdvisor;
    }

    public static void setDiedRedAdvisor(int diedRedAdvisor) {
        ChessGameFrame.diedRedAdvisor = diedRedAdvisor;
    }

    public static int getDiedBlackAdvisor() {
        return diedBlackAdvisor;
    }

    public static void setDiedBlackAdvisor(int diedBlackAdvisor) {
        ChessGameFrame.diedBlackAdvisor = diedBlackAdvisor;
    }

    public static int getDiedRedMinister() {
        return diedRedMinister;
    }

    public static void setDiedRedMinister(int diedRedMinister) {
        ChessGameFrame.diedRedMinister = diedRedMinister;
    }

    public static int getDiedBlackMinister() {
        return diedBlackMinister;
    }

    public static void setDiedBlackMinister(int diedBlackMinister) {
        ChessGameFrame.diedBlackMinister = diedBlackMinister;
    }

    public static int getDiedRedChariot() {
        return diedRedChariot;
    }

    public static void setDiedRedChariot(int diedRedChariot) {
        ChessGameFrame.diedRedChariot = diedRedChariot;
    }

    public static int getDiedBlackChariot() {
        return diedBlackChariot;
    }

    public static void setDiedBlackChariot(int diedBlackChariot) {
        ChessGameFrame.diedBlackChariot = diedBlackChariot;
    }

    public static int getDiedRedHorse() {
        return diedRedHorse;
    }

    public static void setDiedRedHorse(int diedRedHorse) {
        ChessGameFrame.diedRedHorse = diedRedHorse;
    }

    public static int getDiedBlackHorse() {
        return diedBlackHorse;
    }

    public static void setDiedBlackHorse(int diedBlackHorse) {
        ChessGameFrame.diedBlackHorse = diedBlackHorse;
    }

    public static int getDiedRedSoldier() {
        return diedRedSoldier;
    }

    public static void setDiedRedSoldier(int diedRedSoldier) {
        ChessGameFrame.diedRedSoldier = diedRedSoldier;
    }

    public static int getDiedBlackSoldier() {
        return diedBlackSoldier;
    }

    public static void setDiedBlackSoldier(int diedBlackSoldier) {
        ChessGameFrame.diedBlackSoldier = diedBlackSoldier;
    }

    public static int getDiedRedCannon() {
        return diedRedCannon;
    }

    public static void setDiedRedCannon(int diedRedCannon) {
        ChessGameFrame.diedRedCannon = diedRedCannon;
    }

    public static int getDiedBlackCannon() {
        return diedBlackCannon;
    }

    public static void setDiedBlackCannon(int diedBlackCannon) {
        ChessGameFrame.diedBlackCannon = diedBlackCannon;
    }

    public static JLabel getLabel1() {
        return label1;
    }

    public static JLabel getLabel2() {
        return label2;
    }

    public static JLabel getLabel3() {
        return label3;
    }

    public static JLabel getLabel4() {
        return label4;
    }

    public static JLabel getLabel5() {
        return label5;
    }

    public static JLabel getLabel6() {
        return label6;
    }

    public static JLabel getLabel7() {
        return label7;
    }

    public static JLabel getLabel8() {
        return label8;
    }

    public static JLabel getLabel9() {
        return label9;
    }

    public static JLabel getLabel10() {
        return label10;
    }

    public static JLabel getLabel11() {
        return label11;
    }

    public static JLabel getLabel12() {
        return label12;
    }

    public static JLabel getLabel13() {
        return label13;
    }

    public static JLabel getLabel14() {
        return label14;
    }

    public static int getIndexOfIfFirst() {
        return indexOfIfFirst;
    }

    public static void setIndexOfIfFirst(int indexOfIfFirst) {
        ChessGameFrame.indexOfIfFirst = indexOfIfFirst;
    }
}


/*
* MVC
* model:后端
* view:前端
* controller：将前端数据传输给后端计算，返还数值给前端
*
*
* */
