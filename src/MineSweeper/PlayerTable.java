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
public class PlayerTable {
    
    private final char[][] GameTable;
    private final Mines mines;
    
    public PlayerTable(Mines mines) {
        GameTable = new char[][] {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };
        this.mines = mines;
    }
    
    public void setNumberTipsOnGameTable(int Line, int Column){
        for(int i = -1; i <= 1; i++)
            for(int j = -1; j <= 1; j++) {
                if(Line == 0 && i == -1)
                    i = 0;
                if(Line == mines.getMines().length - 1 && i == 1)
                    break;
                if(Column == 0 && j == -1)
                    j = 0;
                if(Column == mines.getMines().length - 1 && j == 1)
                    break;
                if(mines.getMines()[Line+i][Column+j] != -1)
                     GameTable[Line+i][Column+j] = Character.forDigit(mines.getMines()[Line+i][Column+j], 10);
            }
    }
    
    public void setMinesOnGameTable() {
        for(int i = 0; i <= mines.getMines().length - 1; i++)
            for(int j = 0; j <= mines.getMines().length - 1; j++)
                if(mines.getMines()[i][j] == -1)
                    GameTable[i][j] = '*';
    }

    public char[][] getGameTable() {
        return GameTable;
    }
    
    public boolean isMinus(int Line, int Column) {
        return GameTable[Line][Column] == '-';
    }
    
    public boolean isMine(int Line, int Column) {
        return GameTable[Line][Column] == '*';
    }
    
    public boolean isTips(int Line, int Column) {
        return GameTable[Line][Column] == '0' || GameTable[Line][Column] == '1' || 
                GameTable[Line][Column] == '2' || GameTable[Line][Column] == '3' || 
                GameTable[Line][Column] == '4' || GameTable[Line][Column] == '5' || 
                GameTable[Line][Column] == '6' || GameTable[Line][Column] == '7' || 
                GameTable[Line][Column] == '8' || GameTable[Line][Column] == '9';
    }
}
