/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableDrawingStrategy;

import MineSweeper.Mines;
import MineSweeper.PlayerTable;

/**
 *
 * @author Everetas.PC
 */
public class TipsDrawingStrategy implements TableDrawingStrategy {
    
    private final PlayerTable playerTable;
    private final Mines mines;
    private int Line, Column;

    public TipsDrawingStrategy(PlayerTable playerTable, Mines mines) {
        this.playerTable = playerTable;
        this.mines = mines;
    }
    
    @Override
    public boolean elementType(int Line, int Column) {
        this.Line = Line;
        this.Column = Column;
        return playerTable.isTips(Line, Column);
    }

    @Override
    public void Draw() {
        System.out.print(mines.getTips(Line, Column));
    }
}
