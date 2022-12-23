package chessComponent;
import controller.ClickController;
import model.ChessColor;
import model.ChessboardPoint;

import java.awt.*;
public class GeneralChessComponent extends ChessComponent {
    public GeneralChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=6;
        this.score=30;
        if (this.getChessColor() == ChessColor.RED) {
            name = "帅";
        } else {
            name = "将";
        }
    }
    public GeneralChessComponent(int indexOfReversal, ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        this.power=6;
        this.score=30;
        if (this.getChessColor() == ChessColor.RED) {
            name = "帅";
        } else {
            name = "将";
        }
        if (indexOfReversal==0){
            this.isReversal=false;
        } else if (indexOfReversal==1) {
            this.isReversal=true;
        }
    }
}
