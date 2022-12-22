package controller;


import chessComponent.CannonChessComponent;
import chessComponent.SquareComponent;
import chessComponent.EmptySlotComponent;
import model.ChessColor;
import view.ChessGameFrame;
import view.Chessboard;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClickController {
    private final Chessboard chessboard;
    private SquareComponent first;

    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void onClick(SquareComponent squareComponent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        //判断第一次点击
        if (first == null) {
            if (!(squareComponent instanceof EmptySlotComponent)){
            if (handleFirst(squareComponent)) {
                squareComponent.setSelected(true);
                first = squareComponent;
                first.repaint();
            }
            }
        } else {//第二次
            if (first == squareComponent) { // 再次点击取消选取
                squareComponent.setSelected(false);
                SquareComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(squareComponent)) {
                //repaint in swap chess method.
                if (Math.abs(first.getPower())>=squareComponent.getPower()||first.getPower()-squareComponent.getPower()==-5){
                    chessboard.swapChessComponents(first, squareComponent);
                    //todo
                    chessboard.clickController.swapPlayer();
                    first.setSelected(false);
                    first = null;
                }
            }
        }
    }


    /**
     * @param squareComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(SquareComponent squareComponent) {
        if (!squareComponent.isReversal()) {
            if (ChessGameFrame.indexOfIfFirst!=0){
            squareComponent.setReversal(true);
            System.out.printf("onClick to reverse a chess [%d,%d]\n", squareComponent.getChessboardPoint().getX(), squareComponent.getChessboardPoint().getY());
            squareComponent.repaint();
            chessboard.clickController.swapPlayer();
            return false;
            }else {
                squareComponent.setReversal(true);
                System.out.printf("onClick to reverse a chess [%d,%d]\n", squareComponent.getChessboardPoint().getX(), squareComponent.getChessboardPoint().getY());
                squareComponent.repaint();
                if (squareComponent.getChessColor()==ChessColor.RED){
                    chessboard.setCurrentColor(ChessColor.BLACK);
                }else chessboard.setCurrentColor(ChessColor.RED);
                ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
                ChessGameFrame.indexOfIfFirst++;
            }
        }
        return squareComponent.getChessColor() == chessboard.getCurrentColor();
    }

    /**
     * @param squareComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(SquareComponent squareComponent) {

        //未翻开
        if (!squareComponent.isReversal()) {
            if (first instanceof CannonChessComponent){
                return first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
            }else if (!(squareComponent instanceof EmptySlotComponent)) {
                return false;//不是空的
            }
        }//翻开的
        return squareComponent.getChessColor() != chessboard.getCurrentColor() &&
                first.canMoveTo(chessboard.getChessComponents(), squareComponent.getChessboardPoint());
    }

    public void swapPlayer() {
        chessboard.setCurrentColor(chessboard.getCurrentColor() == ChessColor.BLACK ? ChessColor.RED : ChessColor.BLACK);
        ChessGameFrame.getStatusLabel().setText(String.format("%s's TURN", chessboard.getCurrentColor().getName()));
    }


//    public void checkIfSomePlayerIsWin(){
//        if (ChessGameFrame.getRedScore()>=10){
//            //   ChessGameFrame
//
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

}
