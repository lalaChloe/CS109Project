package view;


import chessComponent.*;
import model.*;
import controller.ClickController;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static view.ChessGameFrame.*;

/**
 * 这个类表示棋盘组建，其包含：
 * SquareComponent[][]: 4*8个方块格子组件
 */
public class Chessboard extends JComponent {

    static MusicPlayer player = new MusicPlayer("./src/b.wav");
    static MusicPlayer player1 = new MusicPlayer("./src/d.wav");
    static MusicPlayer player2 = new MusicPlayer("./src/d.wav");
    boolean f1=true;
    boolean f2=true;
    private static final int ROW_SIZE = 8;
    private static final int COL_SIZE = 4;

    private final SquareComponent[][] squareComponents = new SquareComponent[ROW_SIZE][COL_SIZE];
    //todo: you can change the initial player
    private ChessColor currentColor = ChessColor.RED;

    //all chessComponents in this chessboard are shared only one model controller
    public final ClickController clickController = new ClickController(this);
    private final int CHESS_SIZE;


    public Chessboard(int width, int height) {
        setLayout(null); // Use absolute layout.
        setSize(width + 2, height);
        CHESS_SIZE = (height - 6) / 8;
        SquareComponent.setSpacingLength(CHESS_SIZE / 12);
        System.out.printf("chessboard [%d * %d], chess size = %d\n", width, height, CHESS_SIZE);
        player1.over();
        player2.over();
        addmusic();
        initAllChessOnBoard();
    }

    private void addmusic() {
        player.setVolumn(6f).play();
    }

    public SquareComponent[][] getChessComponents() {
        return squareComponents;
    }

    public ChessColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(ChessColor currentColor) {
        this.currentColor = currentColor;
    }

    /**
     * 将SquareComponent 放置在 ChessBoard上。里面包含移除原有的component及放置新的component
     * @param squareComponent
     */
    public void putChessOnBoard(SquareComponent squareComponent) {
        int row = squareComponent.getChessboardPoint().getX(), col = squareComponent.getChessboardPoint().getY();
        if (squareComponents[row][col] != null) {
            remove(squareComponents[row][col]);
        }
        add(squareComponents[row][col] = squareComponent);
    }

    public void ChangeShownScore(){
//        ChessGameFrame.setRedScore(ChessGameFrame.getRedScore());
//        ChessGameFrame.setBlackScore(ChessGameFrame.getBlackScore());
        ChessGameFrame.getRedScoreLabel().setText(String.format("RED's SCORE: %d",ChessGameFrame.getRedScore()));
        ChessGameFrame.getBlackScoreLabel().setText(String.format("BLACK's SCORE: %d",ChessGameFrame.getBlackScore()));
    }
    public void ChangeShownDiedChess(){
        ChessGameFrame.getLabel1().setText(String.format("×%d",ChessGameFrame.getDiedRedGeneral()));
        ChessGameFrame.getLabel2().setText(String.format("×%d",ChessGameFrame.getDiedRedAdvisor()));
        ChessGameFrame.getLabel3().setText(String.format("×%d",ChessGameFrame.getDiedRedMinister()));
        ChessGameFrame.getLabel4().setText(String.format("×%d",ChessGameFrame.getDiedRedChariot()));
        ChessGameFrame.getLabel5().setText(String.format("×%d",ChessGameFrame.getDiedRedHorse()));
        ChessGameFrame.getLabel6().setText(String.format("×%d",ChessGameFrame.getDiedRedSoldier()));
        ChessGameFrame.getLabel7().setText(String.format("×%d",ChessGameFrame.getDiedRedCannon()));
        ChessGameFrame.getLabel8().setText(String.format("×%d",ChessGameFrame.getDiedBlackGeneral()));
        ChessGameFrame.getLabel9().setText(String.format("×%d",ChessGameFrame.getDiedBlackAdvisor()));
        ChessGameFrame.getLabel10().setText(String.format("×%d",ChessGameFrame.getDiedBlackMinister()));
        ChessGameFrame.getLabel11().setText(String.format("×%d",ChessGameFrame.getDiedBlackChariot()));
        ChessGameFrame.getLabel12().setText(String.format("×%d",ChessGameFrame.getDiedBlackHorse()));
        ChessGameFrame.getLabel13().setText(String.format("×%d",ChessGameFrame.getDiedBlackSoldier()));
        ChessGameFrame.getLabel14().setText(String.format("×%d",ChessGameFrame.getDiedBlackCannon()));

    }

    /**
     * 交换chess1 chess2的位置
     * @param chess1
     * @param chess2
     */
    public void swapChessComponents(SquareComponent chess1, SquareComponent chess2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        if (!(chess2 instanceof EmptySlotComponent)) {
            //吃子开始，写坟场
            //吃子结束
            remove(chess2);

            if (chess2.getChessColor()==ChessColor.BLACK){
                if (chess2 instanceof GeneralChessComponent){
                    ChessGameFrame.setDiedBlackGeneral(ChessGameFrame.getDiedBlackGeneral()+1);
                } else if (chess2 instanceof AdvisorChessComponent) {
                    ChessGameFrame.setDiedBlackAdvisor(ChessGameFrame.getDiedBlackAdvisor()+1);
                } else if (chess2 instanceof MinisterChessComponent) {
                    ChessGameFrame.setDiedBlackMinister(ChessGameFrame.getDiedBlackMinister()+1);
                }else if (chess2 instanceof ChariotChessComponent) {
                    ChessGameFrame.setDiedBlackChariot(ChessGameFrame.getDiedBlackChariot()+1);
                }else if (chess2 instanceof HorseChessComponent) {
                    ChessGameFrame.setDiedBlackHorse(ChessGameFrame.getDiedBlackHorse()+1);
                }else if (chess2 instanceof SoldierChessComponent) {
                    ChessGameFrame.setDiedBlackSoldier(ChessGameFrame.getDiedBlackSoldier()+1);
                }else if (chess2 instanceof CannonChessComponent) {
                    ChessGameFrame.setDiedBlackCannon(ChessGameFrame.getDiedBlackCannon()+1);
                }

                ChessGameFrame.setRedScore(getRedScore()+chess2.getScore());
            //计分
            }else if (chess2.getChessColor()==ChessColor.RED){
                if (chess2 instanceof GeneralChessComponent){
                    ChessGameFrame.setDiedRedGeneral(ChessGameFrame.getDiedRedGeneral()+1);
                } else if (chess2 instanceof AdvisorChessComponent) {
                    ChessGameFrame.setDiedRedAdvisor(ChessGameFrame.getDiedRedAdvisor()+1);
                } else if (chess2 instanceof MinisterChessComponent) {
                    ChessGameFrame.setDiedRedMinister(ChessGameFrame.getDiedRedMinister()+1);
                }else if (chess2 instanceof ChariotChessComponent) {
                    ChessGameFrame.setDiedRedChariot(ChessGameFrame.getDiedRedChariot()+1);
                }else if (chess2 instanceof HorseChessComponent) {
                    ChessGameFrame.setDiedRedHorse(ChessGameFrame.getDiedRedHorse()+1);
                }else if (chess2 instanceof SoldierChessComponent) {
                    ChessGameFrame.setDiedRedSoldier(ChessGameFrame.getDiedRedSoldier()+1);
                }else if (chess2 instanceof CannonChessComponent) {
                    ChessGameFrame.setDiedRedCannon(ChessGameFrame.getDiedRedCannon()+1);
                }

                ChessGameFrame.setBlackScore(getBlackScore()+chess2.getScore());
            }

            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        squareComponents[row1][col1] = chess1;
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        squareComponents[row2][col2] = chess2;

        ChangeShownScore();
        ChangeShownDiedChess();

        if ((getRedScore()>=20||getBlackScore()>=20)&&f1){
            f1=false;
            player.over();
            player1.setVolumn(6f).play();
        }
        if ((getRedScore()>=40||getBlackScore()>=40)&&f2){
            f2=false;
            player1.over();
            player2.setVolumn(6f).play();
        }
        if (getRedScore()>=1){
            player2.over();
            System.out.println("Replay");
            JOptionPane.showMessageDialog(this, "红方赢！");
            ChessGameFrameWin mainFrame = new ChessGameFrameWin(720, 720);
            mainFrame.setVisible(true);

        }

        if (getBlackScore()>=1) {
            player2.over();
            System.out.println("Replay");
            JOptionPane.showMessageDialog(this, "黑方赢！");
            ChessGameFrameWin mainFrame = new ChessGameFrameWin(720, 720);
            mainFrame.setVisible(true);

        }

        //只重新绘制chess1 chess2，其他不变
        chess1.repaint();
        chess2.repaint();
    }

    //FIXME:   Initialize chessboard for testing only.
    private void initAllChessOnBoard() {

        Random random = new Random();
        int GeneralRed=1;
        int GeneralBlack=1;
        int AdvisorRed=2;
        int AdvisorBlack=2;
        int MinisterRed=2;
        int MinisterBlack=2;
        int ChariotRed=2;
        int ChariotBlack=2;
        int HorseRed=2;
        int HorseBLack=2;
        int SoldierRed=5;
        int SoldierBlack=5;
        int CannonRed=2;
        int CanonBlack=2;

        int counter=0;

        for (int i = 0; i < squareComponents.length; i++) {
            for (int j = 0; j < squareComponents[i].length; j++) {
                //ChessColor color = random.nextInt(2) == 0 ? ChessColor.RED : ChessColor.BLACK;
                boolean chosen = false;
                SquareComponent squareComponent = null;
                int x = random.nextInt(30);
                if (x == 0 && GeneralRed != 0) {
                    squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    GeneralRed--;
                    counter++;
                    chosen = true;
                } else if (x == 1 && GeneralBlack != 0) {
                    squareComponent = new GeneralChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    GeneralBlack--;
                    counter++;
                    chosen = true;
                } else if ((x==2||x==3) && AdvisorRed != 0) {
                    squareComponent = new AdvisorChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    AdvisorRed--;
                    counter++;
                    chosen = true;
                } else if ((x==4||x==5) && AdvisorBlack != 0) {
                    squareComponent = new AdvisorChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    AdvisorBlack--;
                    counter++;
                    chosen = true;
                } else if ((x==6||x==7) && MinisterRed != 0) {
                    squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    MinisterRed--;
                    counter++;
                    chosen = true;
                } else if ((x==8||x==9) && MinisterBlack != 0) {
                    squareComponent = new MinisterChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    MinisterBlack--;
                    counter++;
                    chosen = true;
                } else if ((x==10||x==11) && ChariotRed != 0) {
                    squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    ChariotRed--;
                    counter++;
                    chosen = true;
                } else if ((x==12||x==13) && ChariotBlack != 0) {
                    squareComponent = new ChariotChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    ChariotBlack--;
                    counter++;
                    chosen = true;
                } else if ((x==14||x==15) && HorseRed != 0) {
                    squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    HorseRed--;
                    counter++;
                    chosen = true;
                } else if ((x==16||x==17) && HorseBLack != 0) {
                    squareComponent = new HorseChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    HorseBLack--;
                    counter++;
                    chosen = true;
                } else if ((x==18||x==19||x==20||x==21) && SoldierRed != 0) {
                    squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    SoldierRed--;
                    counter++;
                    chosen = true;
                } else if ((x==22||x==23||x==24||x==25) && SoldierBlack != 0) {
                    squareComponent = new SoldierChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    SoldierBlack--;
                    counter++;
                    chosen = true;
                } else if ((x==26||x==27) && CannonRed != 0) {
                    squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);
                    CannonRed--;
                    counter++;
                    chosen = true;
                } else if ((x==28||x==29) && CanonBlack != 0) {
                    squareComponent = new CannonChessComponent(new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);
                    CanonBlack--;
                    counter++;
                    chosen = true;
                }

                if (chosen) {
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);
                }else if (counter!=32){
                    if (j!=0){
                    j--;
                }else {i--;j=squareComponents[i].length-1;}
                }else break;
            }
        }
    }
    private void loadChessOnBoard(String[] chessS){
        int counter=0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++,counter++) {
                char a=chessS[counter].charAt(0);
                char b=chessS[counter].charAt(1);
                SquareComponent squareComponent = null;
                if (b=='0'){
                    switch (a){
                        case '1':{remove(squareComponents[i][j]);squareComponent=new GeneralChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '2':{remove(squareComponents[i][j]);squareComponent=new AdvisorChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '3':{remove(squareComponents[i][j]);squareComponent=new MinisterChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '4':{remove(squareComponents[i][j]);squareComponent=new ChariotChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '5':{remove(squareComponents[i][j]);squareComponent=new HorseChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '6':{remove(squareComponents[i][j]);squareComponent=new SoldierChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '7':{remove(squareComponents[i][j]);squareComponent=new CannonChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '8':{remove(squareComponents[i][j]);squareComponent=new GeneralChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case '9':{remove(squareComponents[i][j]);squareComponent=new AdvisorChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case '0':{remove(squareComponents[i][j]);squareComponent=new MinisterChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'a':{remove(squareComponents[i][j]);squareComponent=new ChariotChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'b':{remove(squareComponents[i][j]);squareComponent=new HorseChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'c':{remove(squareComponents[i][j]);squareComponent=new SoldierChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'd':{remove(squareComponents[i][j]);squareComponent=new CannonChessComponent(0,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'x':{remove(squareComponents[i][j]);squareComponent=new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE);break;}
                        default:
                            System.out.println("shit");
                    }
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);
                    squareComponent.repaint();
                } else if (b=='1') {
                    switch (a){
                        case '1':{remove(squareComponents[i][j]);squareComponent=new GeneralChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '2':{remove(squareComponents[i][j]);squareComponent=new AdvisorChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '3':{remove(squareComponents[i][j]);squareComponent=new MinisterChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '4':{remove(squareComponents[i][j]);squareComponent=new ChariotChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '5':{remove(squareComponents[i][j]);squareComponent=new HorseChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '6':{remove(squareComponents[i][j]);squareComponent=new SoldierChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '7':{remove(squareComponents[i][j]);squareComponent=new CannonChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.RED, clickController, CHESS_SIZE);break;}
                        case '8':{remove(squareComponents[i][j]);squareComponent=new GeneralChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case '9':{remove(squareComponents[i][j]);squareComponent=new AdvisorChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case '0':{remove(squareComponents[i][j]);squareComponent=new MinisterChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'a':{remove(squareComponents[i][j]);squareComponent=new ChariotChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'b':{remove(squareComponents[i][j]);squareComponent=new HorseChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'c':{remove(squareComponents[i][j]);squareComponent=new SoldierChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'd':{remove(squareComponents[i][j]);squareComponent=new CannonChessComponent(1,new ChessboardPoint(i, j), calculatePoint(i, j), ChessColor.BLACK, clickController, CHESS_SIZE);break;}
                        case 'x':{remove(squareComponents[i][j]);squareComponent=new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE);break;}
                        default:
                            System.out.println("shit");
                    }
                    squareComponent.setVisible(true);
                    putChessOnBoard(squareComponent);
                    squareComponent.repaint();
                }
            }
        }
    }

    /**
     * 绘制棋盘格子
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    /**
     * 将棋盘上行列坐标映射成Swing组件的Point
     * @param row 棋盘上的行
     * @param col 棋盘上的列
     * @return
     */
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE + 3, row * CHESS_SIZE + 3);
    }

    /**
     * 通过GameController调用该方法
     * @param chessData
     */
    public void loadGame(List<String> chessData) {
        String[] chessS =chessData.get(0).split(" ");
        boolean checkBoardForm=true;
        boolean checkChessNumIsOk=true;
        int num1=0;int num2=0;int num3=0;int num4=0;int num5=0;int num6=0;int num7=0;int num8=0;int num9=0;int num0=0;int numA=0;int numB=0;int numC=0;int numD=0;
        if (chessS.length!=32){
            JOptionPane.showMessageDialog(this,"ERROR:102");
            checkBoardForm=false;
        } else  {
            for (int i=0;i<32;i++){
                char a=chessS[i].charAt(0);
                switch (a){
                    case '1':num1++;break;
                    case '2':num2++;break;
                    case '3':num3++;break;
                    case '4':num4++;break;
                    case '5':num5++;break;
                    case '6':num6++;break;
                    case '7':num7++;break;
                    case '8':num8++;break;
                    case '9':num9++;break;
                    case '0':num0++;break;
                    case 'a':numA++;break;
                    case 'b':numB++;break;
                    case 'c':numC++;break;
                    case 'd':numD++;break;
                    default:checkChessNumIsOk=false;break;
                }
            }
            if (num1>1||num2>2||num3>2||num4>2||num5>2||num6>5||num7>2||num8>1||num9>2||num0>2||numA>2||numB>2||numC>5||numD>2)checkChessNumIsOk=false;
            if (!checkChessNumIsOk)JOptionPane.showMessageDialog(this,"ERROR:103");
        }
        String currentPlayer=chessData.get(1);
        char[] secondLine=currentPlayer.toCharArray();
        boolean checkCurrentPlayerExist=true;
        if (secondLine.length!=1)checkCurrentPlayerExist=false;
        if (secondLine[0]!='R'&&secondLine[0]!='B')checkCurrentPlayerExist=false;
        if (!checkCurrentPlayerExist)JOptionPane.showMessageDialog(this,"ERROR:104");


        if (checkChessNumIsOk&&checkCurrentPlayerExist&&checkBoardForm){
            loadChessOnBoard(chessS);
            if (secondLine[0]=='R')setCurrentColor(ChessColor.RED);
            if (secondLine[0]=='B')setCurrentColor(ChessColor.BLACK);
            int redScore=Integer.parseInt(chessData.get(2));
            int blackScore=Integer.parseInt(chessData.get(3));
            ChessGameFrame.setRedScore(redScore);
            ChessGameFrame.setBlackScore(blackScore);
        }
//        chessData.forEach(System.out::println);
    }
}
