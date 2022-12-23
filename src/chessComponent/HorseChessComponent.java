package chessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;
public class HorseChessComponent extends ChessComponent {
    public HorseChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=2;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "马";
        } else {
            name = "马";
        }
    }
    public HorseChessComponent(int indexOfReversal, ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=2;
        this.score=5;
        if (this.getChessColor() == ChessColor.RED) {
            name = "马";
        } else {
            name = "马";
        }
        if (indexOfReversal==0){
            this.isReversal=false;
        } else if (indexOfReversal==1) {
            this.isReversal=true;
        }
    }
}
