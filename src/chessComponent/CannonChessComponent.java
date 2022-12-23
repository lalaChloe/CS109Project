package chessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;
public class CannonChessComponent extends ChessComponent {
    public CannonChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=-100;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "炮";
        } else {
            name = "炮";
        }
    }
    public CannonChessComponent(int indexOfReversal, ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=-100;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "炮";
        } else {
            name = "炮";
        }
        if (indexOfReversal==0){
            this.isReversal=false;
        } else if (indexOfReversal==1) {
            this.isReversal=true;
        }
    }

    @Override
    public boolean canMoveTo(SquareComponent[][] chessboard, ChessboardPoint destination) {
        SquareComponent destinationChess = chessboard[destination.getX()][destination.getY()];
/*        (Math.abs(destination.getX()-this.getChessboardPoint().getX())<=1&&destination.getY()==this.getChessboardPoint().getY())
||(Math.abs(destination.getY()-this.getChessboardPoint().getY())<=1&&destination.getX()==this.getChessboardPoint().getX())*/
        boolean goIsOk=false;
        int thisX=this.getChessboardPoint().getX();
        int thisY=this.getChessboardPoint().getY();
        int predestination1X=-1;
        int predestination1Y=-1;
        int predestination2X=-1;
        int predestination2Y=-1;
        int predestination3X=-1;
        int predestination3Y=-1;
        int predestination4X=-1;
        int predestination4Y=-1;

        if (thisX>1){  //上面的可到的点
            int mediumXorY=-1;
            boolean mediumXorYExist=false;
            for (int i=thisX-1;i>=1;i--){
                if (!(chessboard[i][thisY] instanceof EmptySlotComponent)){
                    mediumXorY=i;
                    mediumXorYExist=true;
                    break;
                }
            }
            if (mediumXorYExist){
                for (int j=mediumXorY-1;j>=0;j--){
                    if (!(chessboard[j][thisY] instanceof EmptySlotComponent)){
                        predestination1Y=thisY;
                        predestination1X=j;
                        break;
                    }
                }
            }
        }
        if (thisX<6){//下面的可到的点
            int mediumXorY=-1;
            boolean mediumXorYExist=false;
            for (int i=thisX+1;i<=6;i++){
                if (!(chessboard[i][thisY] instanceof EmptySlotComponent)){
                    mediumXorY=i;
                    mediumXorYExist=true;
                    break;
                }
            }
            if (mediumXorYExist){
                for (int j=mediumXorY+1;j<=7;j++){
                    if (!(chessboard[j][thisY] instanceof EmptySlotComponent)){
                        predestination2Y=thisY;
                        predestination2X=j;
                        break;
                    }
                }
            }
        }
        if (thisY>1){//左边的的可到的点
            int mediumXorY=-1;
            boolean mediumXorYExist=false;
            for (int i=thisY-1;i>=1;i--){
                if (!(chessboard[thisX][i] instanceof EmptySlotComponent)){
                    mediumXorY=i;
                    mediumXorYExist=true;
                    break;
                }
            }
            if (mediumXorYExist){
                for (int j=mediumXorY-1;j>=0;j--){
                    if (!(chessboard[thisX][j] instanceof EmptySlotComponent)){
                        predestination3Y=j;
                        predestination3X=thisX;
                        break;
                    }
                }
            }
        }
        if (thisY<2){//右边的可到的点
            int mediumXorY=-1;
            boolean mediumXorYExist=false;
            for (int i=thisY+1;i<=2;i++){
                if (!(chessboard[thisX][i] instanceof EmptySlotComponent)){
                    mediumXorY=i;
                    mediumXorYExist=true;
                    break;
                }
            }
            if (mediumXorYExist){
                for (int j=mediumXorY+1;j<=3;j++){
                    if (!(chessboard[thisX][j] instanceof EmptySlotComponent)){
                        predestination4Y=j;
                        predestination4X=thisX;
                        break;
                    }
                }
            }
        }

        if ((destination.getX()==predestination1X&&destination.getY()==predestination1Y)
                ||(destination.getX()==predestination2X&&destination.getY()==predestination2Y)
                ||(destination.getX()==predestination3X&&destination.getY()==predestination3Y)
                ||(destination.getX()==predestination4X&&destination.getY()==predestination4Y)){
            goIsOk=true;
        }

        if (goIsOk){
            return  !(destinationChess instanceof EmptySlotComponent);
        }else return false;
    }
}
