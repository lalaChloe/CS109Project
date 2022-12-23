package chessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;
public class MinisterChessComponent extends ChessComponent {
    public MinisterChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=4;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "相";
        } else {
            name = "象";
        }
    }
    public MinisterChessComponent(int indexOfReversal, ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=4;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "相";
        } else {
            name = "象";
        }
        if (indexOfReversal==0){
            this.isReversal=false;
        } else if (indexOfReversal==1) {
            this.isReversal=true;
        }
    }
}
