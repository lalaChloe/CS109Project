package controller;

import view.ChessGameFrame;
import view.Chessboard;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 这个类主要完成由窗体上组件触发的动作。
 * 例如点击button等
 * ChessGameFrame中组件调用本类的对象，在本类中的方法里完成逻辑运算，将运算的结果传递至chessboard中绘制
 */
public class GameController {
    private final Chessboard chessboard;
    private final ChessGameFrame chessGameFrame;

    public GameController(Chessboard chessboard,ChessGameFrame chessGameFrame) {
        this.chessboard = chessboard;
        this.chessGameFrame=chessGameFrame;
    }

    public List<String> loadGameFromFile(String path) {
        try {
            String[] newBee=path.split("\\.");
            if (!newBee[1].equals("txt")){
                JOptionPane.showMessageDialog(chessGameFrame,"ERROR:101");
            }
            path="./src/"+path;
            List<String> chessData = Files.readAllLines(Path.of(path));
            chessboard.loadGame(chessData);
            return chessData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (HeadlessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
