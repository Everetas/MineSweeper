/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableDrawingStrategy;

import MineSweeper.PlayerTable;
/**
 *
 * @author Everetas.PC
 */
public class MinusDrawingStrategy implements TableDrawingStrategy {
    
    private final PlayerTable playerTable;

    public MinusDrawingStrategy(PlayerTable playerTable) {
        this.playerTable = playerTable;
    }
    
    @Override
    public boolean elementType(int Line, int Column) {
        return playerTable.isMinus(Line, Column);
    }

    @Override
    public void Draw() {
        System.out.print("-");
    }
}
