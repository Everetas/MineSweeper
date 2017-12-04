/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeper;

/**
 *
 * @author Everetas.PC
 */
public class GameLogic {
    
    private final Mines mines;
    private final PlayerTable playerTable;
    
    public GameLogic(Mines mines, PlayerTable playerTable) {
        this.mines = mines;
        this.playerTable = playerTable;
    }
    
    public boolean checkInput(int Line, int Column) {
        if(((Line <= mines.getMines().length - 1 && Line >= 0) && (Column <= mines.getMines().length - 1 && Column >= 0)))
            if(playerTable.getGameTable()[Line][Column] != '-') {
                System.out.println("This field is already chosen");
                return false;
            }
        if(Line < 0 || Line > mines.getMines().length - 1 || Column < 0 || Column > mines.getMines().length - 1) {
            System.out.println("Choose a number between 0 and " + (mines.getMines().length - 1));
            return false;
        }
        return true;
    }
    
    public boolean gameLost(int Line, int Column) {
        if(mines.mineOrNot(Line, Column) == -1) {
            return true;
        } else return false;
    }
    
    public boolean gameWin() {
        int minesCalc = 0;
        for(int l = 0; l <= mines.getMines().length - 1; l++)
            for(int c = 0; c <= mines.getMines().length - 1; c++)
                if(playerTable.getGameTable()[l][c]=='-')
                    minesCalc++;
        if(minesCalc == mines.getMines().length) {
            return true;
        } else return false;
    }
}
