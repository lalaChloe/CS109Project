package controller;

import model.ChessColor;
import view.ChessGameFrame;
import view.Chessboard;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
//            path="./src/"+path;
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
    public void regretOperation(){
        chessboard.regret();
    }
    public void saveGameToFile(String fileName){
        String text = "This is a sample text.";

        try {
            // Create a new BufferedWriter object
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            // Write the text to the file
            writer.write(ChessGameFrame.CurrentBoard.get(ChessGameFrame.CurrentBoard.size()-1));
            writer.newLine();
            if (chessboard.getCurrentColor()== ChessColor.RED){
                writer.write("R");
            } else if (chessboard.getCurrentColor()==ChessColor.BLACK) {
                writer.write("B");
            }
            writer.newLine();
            writer.write(String.format("%d",ChessGameFrame.getRedScore()));
            writer.newLine();
            writer.write(String.format("%d",ChessGameFrame.getBlackScore()));
            for (int i=0;i<ChessGameFrame.CurrentBoard.size();i++){
                writer.newLine();
                writer.write(ChessGameFrame.CurrentBoard.get(i));
            }

            // Close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
