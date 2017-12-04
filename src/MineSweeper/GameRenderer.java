/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeper;

import TableDrawingStrategy.MineDrawingStrategy;
import TableDrawingStrategy.MinusDrawingStrategy;
import TableDrawingStrategy.TableDrawingStrategy;
import TableDrawingStrategy.TipsDrawingStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Everetas.PC
 */
public class GameRenderer {
    
    private final Mines mines;
    private final List<TableDrawingStrategy> drawingStrategies = new ArrayList<>();

        
    public GameRenderer(Mines mines, PlayerTable playerTable){
        this.mines = mines;
        
        drawingStrategies.add(new MinusDrawingStrategy(playerTable));
        drawingStrategies.add(new MineDrawingStrategy(playerTable));
        drawingStrategies.add(new TipsDrawingStrategy(playerTable, mines));
    }
    
    public void showGameTable() {
        System.out.println("\nLines");
        for(int line = mines.getMines().length -1; line >= 0; line--) {
            System.out.print(line);
            for(int column = 0; column <= mines.getMines().length - 1; column++) {
                System.out.print("\t");
                drawElement(line, column);
            }
            System.out.println();
        }
        System.out.print("Columns");
        for(int column = 0; column <= mines.getMines().length - 1; column++) {
            System.out.print(column + "\t");
        }
        System.out.println();
    }
    
    private void drawElement(int x, int y) {
        for(TableDrawingStrategy strategy : drawingStrategies) {
            if(strategy.elementType(x, y)) {
                strategy.Draw();
                return;
            }
        }
    }
}
