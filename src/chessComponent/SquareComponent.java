package chessComponent;

import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;
import view.ChessGameFrame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * 这个类是一个抽象类，主要表示8*4棋盘上每个格子的棋子情况。
 * 有两个子类：
 * 1. EmptySlotComponent: 空棋子
 * 2. ChessComponent: 表示非空棋子
 */
public abstract class SquareComponent extends JComponent {

    private static final Color squareColor = new Color(250, 220, 190);
    protected static int spacingLength;
    protected static final Font CHESS_FONT = new Font("宋体", Font.BOLD, 36);

    /**
     * chessboardPoint: 表示8*4棋盘中，当前棋子在棋格对应的位置，如(0, 0), (1, 0)等等
     * chessColor: 表示这个棋子的颜色，有红色，黑色，无色三种
     * isReversal: 表示是否翻转
     * selected: 表示这个棋子是否被选中
     */
    private ChessboardPoint chessboardPoint;
    protected final ChessColor chessColor;
    protected boolean isReversal;

    public boolean isIfcanmove() {
        return ifcanmove;
    }

    public void setIfcanmove(boolean ifcanmove) {
        this.ifcanmove = ifcanmove;
    }

    protected boolean ifcanmove;
    public boolean isReversalcheat() {
        return isReversalcheat;
    }

    public void setReversalcheat(boolean reversalcheat) {
        isReversalcheat = reversalcheat;
    }

    protected boolean isReversalcheat;

    public boolean isIscheating() {
        return ischeating;
    }

    public void setIscheating(boolean ischeating) {
        this.ischeating = ischeating;
    }

    protected boolean ischeating;
    private boolean selected;
    protected int power;//power的绝对值大的可以吃掉power绝对值小的
    protected int score=0;
    /**
     * handle click event
     */
    private final ClickController clickController;

    protected SquareComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLocation(location);
        setSize(size, size);
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        this.selected = false;
        this.clickController = clickController;
        this.isReversal = false;
        this.isReversalcheat=false;
        this.ischeating=false;
        this.ifcanmove=false;
    }

    public boolean isReversal() {
        return isReversal;
    }

    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }

    public static void setSpacingLength(int spacingLength) {
        SquareComponent.spacingLength = spacingLength;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @param another 主要用于和另外一个棋子交换位置
     *                <br>
     *                调用时机是在移动棋子的时候，将操控的棋子和对应的空位置棋子(EmptySlotComponent)做交换
     */
    public void swapLocation(SquareComponent another) {
        ChessboardPoint chessboardPoint1 = getChessboardPoint(), chessboardPoint2 = another.getChessboardPoint();
        Point point1 = getLocation(), point2 = another.getLocation();
        setChessboardPoint(chessboardPoint2);
        setLocation(point2);
        another.setChessboardPoint(chessboardPoint1);
        another.setLocation(point1);
    }

    /**
     * @param e 响应鼠标监听事件
     *          <br>
     *          当接收到鼠标动作的时候，这个方法就会自动被调用，调用监听者的onClick方法，处理棋子的选中，移动等等行为。
     */
    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            System.out.printf("Click [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
            try {
                clickController.onClick(this);
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * @param chessboard  棋盘
     * @param destination 目标位置，如(0, 0), (0, 1)等等
     * @return this棋子对象的移动规则和当前位置(chessboardPoint)能否到达目标位置
     * <br>
     * 这个方法主要是检查移动的合法性，如果合法就返回true，反之是false。
     */
    //todo: Override this method for Cannon
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent destinationChess = chessboard[destination.getX()][destination.getY()];
        return destinationChess.isReversal|| destinationChess instanceof EmptySlotComponent;
        //todo: complete this method
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        System.out.printf("repaint chess [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
        g.setColor(squareColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
    }

//    public void checkIfSomePlayerIsWin(){
//        if (ChessGameFrame.getRedScore()>=10){
//         //   ChessGameFrame
//            this.setVisible(false);
//
//            System.out.println("Replay");
//
//            this.addWindowListener(new java.awt.event.WindowAdapter() {
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            ChessGameFrame mainFrame = new ChessGameFrame(WIDTH, HEIGHT);
//            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            mainFrame.setVisible(true);
//            JOptionPane.showMessageDialog(this, "红方赢，游戏重新开始！");
//        } else if (getBlackScore()>=10) {
//            this.setVisible(false);
//
//            System.out.println("Replay");
//
//            this.addWindowListener(new java.awt.event.WindowAdapter() {
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            ChessGameFrame mainFrame = new ChessGameFrame(WIDTH, HEIGHT);
//            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            mainFrame.setVisible(true);
//            JOptionPane.showMessageDialog(this, "黑方赢，游戏重新开始！");
//        }
//    }

    public int getPower() {
        return power;
    }

    public int getScore() {
        return score;
    }
}
